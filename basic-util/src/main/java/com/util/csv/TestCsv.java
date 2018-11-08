package com.util.csv;

import com.csvreader.CsvWriter;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.File;
import java.nio.charset.Charset;
import java.sql.*;

/**
 * @author v_wbyfli
 * @version V1.0
 * @date 2018-08-13 21:17
 */

public class TestCsv {

    private static final Logger logger = LoggerFactory.getLogger(TestCsv.class);

    private static char SEPARATOR = ',';

    @Test
    public  void testStr (){
        String startTime = "2018-08-13 19:04:31";
        String dd = startTime.replaceAll("[-|\\:|\\s*]","");
        System.out.println("dd = " + dd);
    }


    @Test
    public void test(){

        // 驱动程序名
        String driver = "com.mysql.jdbc.Driver";
        // URL指向要访问的数据库名scutcs
        String url = "jdbc:mysql://10.107.103.176:3306/epccmaindb?relaxAutoCommit=true&amp;autoReconnect=true&amp;zeroDateTimeBehavior=convertToNull";
        // MySQL配置时的用户名
        String user = "att";
        // MySQL配置时的密码
        String password = "badman#2018";
        try {
            // 加载驱动程序
            Class.forName(driver);
            // 连续数据库
            Connection conn = DriverManager.getConnection(url, user, password);

            String filePath = "d:/test.com.util.csv";
            // 判断文件是否存在,存在则删除,然后创建新表格
            File tmp = new File(filePath);
            if (tmp.exists()) {
                if (tmp.delete()) {
                    logger.info(filePath + "文件重复");
                }
            }
            // 创建CSV写对象
            CsvWriter csvWriter = new CsvWriter(filePath, SEPARATOR, Charset.forName("GBK"));
            // 数据查询开始
            String sql = "select * from lqj_act_bill where 1=1 AND TIMEDIFF(create_time,'2018-08-13 11:11:11')>0  AND TIMEDIFF(create_time,'2018-08-13 20:41:11')<0  ";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            // 获取结果集表头
            ResultSetMetaData md = resultSet.getMetaData();
            int columnCount = md.getColumnCount();
            logger.debug("返回结果字段个数:" + columnCount);

            String [] columnName = new String[columnCount];
            for (int i = 1; i <= columnCount; i++) {
//                JSONObject object = new JSONObject();
//                object.put("col", md.getColumnName(i));
                columnName[i-1] = md.getColumnName(i);
            }

// 获取表头数组
//            int columnSize = columnName.size();
//            String[] columnNameList = ListUtil.getListFromJSONArray(columnName);
//            String[] columnNameList = Arrays.
            csvWriter.writeRecord(columnName);
// 数据记录数
            int i = 0;
// 临时数据存储
            StringBuffer stringBuffer = new StringBuffer();
            while (resultSet.next()) {
                // 记录号
                i++;
                // 依据列名获取各列值
                for (int j = 1; j <= columnName.length; j++) {
                    String value = resultSet.getString(j);
                    //创建列
                    stringBuffer.append(value);
                    if (j != columnName.length) {
                        stringBuffer.append(",");
                    }
                }
                String buffer_string = stringBuffer.toString();
                String[] content = buffer_string.split(",");
                csvWriter.writeRecord(content);
                stringBuffer.setLength(0);
            }
// 文件输出
            csvWriter.flush();
            csvWriter.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
