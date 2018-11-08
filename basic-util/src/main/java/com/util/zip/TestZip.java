package com.util.zip;

/**
 * @author v_wbyfli
 * @version V1.0
 * @date 2018-08-08 15:05
 */

public class TestZip {
    public static void main(String[] args)
    {
        ZipCompressUtil zipCom = new ZipCompressUtil("D:\\test.zip","d:\\shortcuttools.postman_collection.json");
        try
        {
            zipCom.zip();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
