package com.util.csv;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

/**
 * 对账管理下载对账文件，生成.csv文件方法
 * @author gxy
 * @date 2016-3-4下午02:11:10
 */
/**
 * 文件操作
 */
public class CSVUtil {
    /**
     * 生成位csv文件
     * @param exportData
     * 			源数据List
     * @param map
     * 			csv文件的列表头map
     * @param outPutPath
     * 			文件路径
     * @param fileName
     * 			文件名称
     * @return
     * @date 2016-3-4下午02:49:33
     */
    @SuppressWarnings("unchecked")
    public static File createCSVFile(List exportData, LinkedHashMap map, String outPutPath,String fileName){
        File csvFile = null;
        BufferedWriter csvFileOutputStream = null;
        try {
            File file = new File(outPutPath);
            if (!file.exists()) {
                file.mkdir();
            }
            //定义文件名格式并创建
            csvFile = File.createTempFile(fileName, ".com.util.csv", new File(outPutPath));
//			//给文件重命名
//			if(csvFile.exists()){
//				System.out.println("传入的fileName是"+fileName);
//				csvFile.renameTo(new File("c:\\Users\\Administrator\\Desktop\\"+fileName+".com.util.csv"));
//				System.out.println("csvFile1：" + csvFile);
//			}
//			String ss = "1,2,3,4\r\n";
//
            System.out.println("csvFile：" + csvFile);
            // UTF-8使正确读取分隔符","
            csvFileOutputStream = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(csvFile), "gbk"), 1024);
            System.out.println("csvFileOutputStream：" + csvFileOutputStream);
            // 写入文件头部
            for(Iterator propertyIterator = map.entrySet().iterator(); propertyIterator.hasNext();){

                Map.Entry propertyEntry = (Map.Entry) propertyIterator.next();
                csvFileOutputStream.write("" + (String) propertyEntry.getValue() != null ? (String) propertyEntry.getValue() : "" + "");
                if(propertyIterator.hasNext()) {
                    csvFileOutputStream.write(",");
                }
            }
            csvFileOutputStream.newLine();
            // 写入文件内容
            for (Iterator iterator = exportData.iterator(); iterator.hasNext();) {
                Object row = (Object) iterator.next();
                for (Iterator propertyIterator = map.entrySet().iterator(); propertyIterator.hasNext();){
                    Map.Entry propertyEntry = (Map.Entry) propertyIterator.next();
                    csvFileOutputStream.write((String) BeanUtils.getProperty(row,(String) propertyEntry.getKey()));
                    if (propertyIterator.hasNext()) {
                        csvFileOutputStream.write(",");
                    }
                }
                if(iterator.hasNext()){
                    csvFileOutputStream.newLine();
                }
            }
            csvFileOutputStream.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            try {
                csvFileOutputStream.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return csvFile;
    }


    /**
     *     下载文件
     * @param response
     * @param csvFilePath
     * 			文件路径
     * @param fileName
     * 			文件名称
     * @throws IOException
     * @date 2016-3-4下午03:10:13
     */
    public static void exportFile(HttpServletResponse response, String csvFilePath, String fileName)
            throws IOException {
        response.setContentType("application/com.util.csv;charset=UTF-8");
        response.setHeader("Content-Disposition","attachment; filename=" + URLEncoder.encode(fileName, "UTF-8"));
        InputStream in = null;
        OutputStream out = null;
        try {
            in = new FileInputStream(csvFilePath);
            int len = 0;
            byte[] buffer = new byte[1024];
            response.setCharacterEncoding("UTF-8");
            out = response.getOutputStream();
            while ((len = in.read(buffer)) > 0) {
                out.write(new byte[] { (byte) 0xEF, (byte) 0xBB, (byte) 0xBF });
                out.write(buffer, 0, len);
            }
        } catch (FileNotFoundException e) {
            System.out.println(e);
        } finally{
            if(in != null||out!=null){
                try {
                    out.close();//解决冲突问题
                    in.close();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    /**
     * 删除该目录filePath下的所有文件
     * @param filePath
     *       文件目录路径
     */
    public static void deleteFiles(String filePath) {
        File file = new File(filePath);
        if (file.exists()) {
            File[] files = file.listFiles();
            for (int i = 0; i < files.length; i++) {
                if (files[i].isFile()) {
                    files[i].delete();
                }
            }
        }
    }

    /**
     * 删除单个文件
     * @param filePath
     * 文件目录路径
     * @param fileName
     * 文件名称
     *
     */
    public static void deleteFile(String filePath, String fileName) {
        File file = new File(filePath);
        if (file.exists()) {
            File[] files = file.listFiles();
            for (int i = 0; i < files.length; i++) {
                if (files[i].isFile()) {
                    if (files[i].getName().equals(fileName)) {
                        files[i].delete();
                        return;
                    }
                }
            }
        }
    }

    /**
     * 测试数据
     * @param args
     * @date 2016-3-4下午03:06:03
     */
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        List exportData = new ArrayList<Map>();
        Map row1 = new LinkedHashMap<String, String>();
        row1.put("1", "11");
        row1.put("2", "12");
        row1.put("3", "13");
        row1.put("4", "14");
        exportData.add(row1);
        row1 = new LinkedHashMap<String, String>();
        row1.put("1", "21");
        row1.put("2", "22");
        row1.put("3", "23");
        row1.put("4", "24");
        exportData.add(row1);
        LinkedHashMap map = new LinkedHashMap();
        map.put("1", "第一列");
        map.put("2", "第二列");
        map.put("3", "第三列");
        map.put("4", "第四列");
        String path = "d:/";
        String fileName = "文件导出";
        File file = CSVUtil.createCSVFile(exportData, map, path, fileName);
        String fileName2 = file.getName();
        System.out.println("文件名称：" + fileName2);
    }
}