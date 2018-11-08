package com.util.excel;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PoiExeclUtil {

    private static final Logger logger = LoggerFactory.getLogger(PoiExeclUtil.class);

    public static boolean validateExcel(String filePath) {
        String errorInfo;
        /** 检查文件名是否为空或者是否是Excel格式的文件 */
        if (filePath == null || !(isExcel2003(filePath) || isExcel2007(filePath))) {
            errorInfo = "文件名不是excel格式";
            return false;
        }
        /** 检查文件是否存在 */
        File file = new File(filePath);
        if (file == null || !file.exists()) {
            errorInfo = "文件不存在";
            return false;
        }
        return true;
    }

    /**
     * 数据写入excel  xlsx
     * @param dataList
     * @param finalXlsxPath
     */
    public static boolean writeDataListExcel(List<List<String> >dataList,String finalXlsxPath){
        OutputStream out = null;
        try {
            // 创建Excel文档
            Workbook workBook = new XSSFWorkbook();
            // sheet 对应一个工作页
            Sheet sheet = workBook.createSheet("sheet1");
             //往Excel中写新数据
            for (int j = 0; j < dataList.size(); j++) {
                // 创建一行：从第二行开始，跳过属性列
                Row row = sheet.createRow(j);
                List<String> colDataList = dataList.get(j);
                if(j == 0 ){
                    for(int i =0 ;i<colDataList.size();i++){
                        int width = colDataList.get(i).getBytes().length*256;
                        sheet.setColumnWidth(i,width);
                    }
                }
                if(j == 1 ){
                    for(int i =0 ;i<colDataList.size();i++){
                        int firstRowWith =  sheet.getColumnWidth(i) ;
                        int width = colDataList.get(i).getBytes().length*128*3;
                        if(width > firstRowWith){
                            sheet.setColumnWidth(i,width);
                        }
                    }
                }
                for (int k = 0; k < colDataList.size(); k++) {
                    Cell cell = row.createCell(k);
                    cell.setCellType(CellType.STRING.getCode());
                    cell.setCellValue(colDataList.get(k));
                }
            }
            // 创建文件输出流，准备输出电子表格：这个必须有，否则你在sheet上做的任何操作都不会有效
            out =  new FileOutputStream(finalXlsxPath);
            workBook.write(out);
            logger.info("excel数据导出成功,file: " + finalXlsxPath);
            return true;
        } catch (Exception e) {
            logger.error(e.toString(),e);
            return false;
        } finally{
            try {
                if(out != null){
                    out.flush();
                    out.close();
                }
            } catch (IOException e) {
                logger.error(e.toString(),e);
            }
        }
    }

    /**
     *
     * @param filePath
     * @return
     */
    public static List<List<String>> readFile(String filePath) {
        List<List<String>> dataLst = new ArrayList<List<String>>();
        InputStream is = null;
        try {
            /** 验证文件是否合法 */
            if (!validateExcel(filePath)) {
                return null;
            }
            /** 判断文件的类型，是2003还是2007 */
            boolean isExcel2003 = true;
            if (isExcel2007(filePath)) {
                isExcel2003 = false;
            }
            /** 调用本类提供的根据流读取的方法 */
            File file = new File(filePath);
            is = new FileInputStream(file);
            dataLst = readExcel(is, isExcel2003);
            is.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    is = null;
                    e.printStackTrace();
                }
            }
        }
        return dataLst;
    }

    /**
     *
     * @param isExcel2003
     * @return
     */
    public static List<List<String>> readFileInputString(InputStream is,boolean isExcel2003) {
        List<List<String>> dataLst = new ArrayList<List<String>>();
        try {
            dataLst = readExcel(is, isExcel2003);
            is.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    is = null;
                    e.printStackTrace();
                }
            }
        }
        return dataLst;
    }

    /**
     *
     * @param inputStream
     * @param isExcel2003
     * @return
     */
    public static List<List<String>> readExcel(InputStream inputStream, boolean isExcel2003) {
        List<List<String>> dataLst = null;
        try {
            /** 根据版本选择创建Workbook的方式 */
            Workbook wb = null;
            if (isExcel2003) {
                wb = new HSSFWorkbook(inputStream);
            } else {
                wb = new XSSFWorkbook(inputStream);
            }
            dataLst = readWorkBook(wb);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dataLst;
    }

    /**
     *
     * @param wb
     * @return
     */
    private static List<List<String>> readWorkBook(Workbook wb) {
        /** 总行数 */
        int totalRows = 0;
        /** 总列数 */
        int totalCells = 0;
        /** 错误信息 */
        List<List<String>> dataLst = new ArrayList<List<String>>();
        /** 得到第一个shell */
        Sheet sheet = wb.getSheetAt(0);
        /** 得到Excel的行数 */
        totalRows = sheet.getPhysicalNumberOfRows();
        /** 得到Excel的列数 */
//        if (totalRows >= 1 && sheet.getRow(0) != null) {
//            totalCells = sheet.getRow(0).getPhysicalNumberOfCells();
//        }
        // 循环Excel的行
        for (int r = 0; r < totalRows; r++) {
            Row row = sheet.getRow(r);
            if (row == null) {
                continue;
            }
            totalCells = sheet.getRow(r).getPhysicalNumberOfCells();
            List<String> rowLst = new ArrayList<String>();
            // 循环Excel的列
            for (int c = 0; c < totalCells; c++) {
                Cell cell = row.getCell(c);
                String cellValue = "";
                if (null != cell) {
                    // 以下是判断数据的类型
                    switch (cell.getCellType()) {
                        case HSSFCell.CELL_TYPE_NUMERIC:
                            // 数字
                            cell.setCellType(HSSFCell.CELL_TYPE_STRING);
                            cellValue = cell.getStringCellValue();
                            break;
                        case HSSFCell.CELL_TYPE_STRING:
                            // 字符串
                            cellValue = cell.getStringCellValue();
                            break;
                        case HSSFCell.CELL_TYPE_BOOLEAN:
                            // Boolean
                            cellValue = cell.getBooleanCellValue() + "";
                            break;
                        case HSSFCell.CELL_TYPE_FORMULA:
                            // 公式
                            cellValue = cell.getCellFormula() + "";
                            break;
                        case HSSFCell.CELL_TYPE_BLANK:
                            // 空值
                            cellValue = "";
                            break;
                        case HSSFCell.CELL_TYPE_ERROR:
                            // 故障
                            cellValue = "非法字符";
                            break;
                        default:
                            cellValue = "未知类型";
                            break;
                    }
                }
                rowLst.add(cellValue);
            }
            dataLst.add(rowLst);
        }
        return dataLst;
    }

    public static boolean isExcel2003(String filePath) {
        return filePath.matches("^.+\\.(?i)(xls)$");
    }
    public static boolean isExcel2007(String filePath) {
        return filePath.matches("^.+\\.(?i)(xlsx)$");
    }


}
