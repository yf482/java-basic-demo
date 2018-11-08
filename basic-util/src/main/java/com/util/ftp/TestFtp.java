package com.util.ftp;

import com.jcraft.jsch.JSchException;
import org.apache.commons.net.ftp.FTPClient;
import org.junit.Test;

import java.io.File;
import java.io.UnsupportedEncodingException;

/**
 * @author v_wbyfli
 * @version V1.0
 * @date 2018-08-08 15:05
 */

public class TestFtp {

    @Test
    public void test() throws Exception {
        Ftp f = new Ftp();
        f.setIpAddr("10.107.103.176");
        f.setPort(7777);
        f.setUserName("ftpuser");
        f.setPwd("ftp@777");
        f.setPath("/recon-file/cft");
        FTPClient ftpClient = FtpUtil.connectFtp(f);
        if (ftpClient != null) {
            File file = new File("E:\\mock\\新建文件夹\\BPPAY_20170905_11");
//            File file = new File("E:\\mock\\新建文件夹");
            //把文件上传在ftp上
            FtpUtil.upload(ftpClient, file);
            FtpUtil.downloadFtpFile(ftpClient, "/recon-file/cft/", "e:/", "BPPAY_20170905_11");
            FtpUtil.closeFtp(ftpClient);
            //下载ftp文件测试
            System.out.println("ok");
        }
    }

    @Test
    public void test2() throws Exception {
        Ftp f = new Ftp();
        f.setIpAddr("10.107.103.176");
        f.setPort(7777);
        f.setUserName("ftpuser");
        f.setPwd("ftp@777");
        FTPClient ftpClient = FtpUtil.connectFtp(f);
        if (ftpClient != null) {
            File file = new File("E:\\mock\\BPPAY_20170905_11 .zip");
            //把文件上传在ftp上
            String path = "/recon-file/cft/test";
            FtpUtil.uploadToPath(ftpClient,path, file);
//            FtpUtil.downloadFtpFile(ftpClient, "/recon-file/cft/", "e:/", "BPPAY_20170905_11");
            FtpUtil.closeFtp(ftpClient);
            //下载ftp文件测试
            System.out.println("ok");
        }
    }

    @Test
    public void testSftp() throws Exception {
        Ftp f = new Ftp();
        f.setIpAddr("10.255.34.110");
        f.setPort(36000);
        f.setUserName("atugao");
        f.setPwd("Tms3.21");
        FTPClient ftpClient = FtpUtil.connectFtp(f);
        if (ftpClient != null) {
            File file = new File("E:\\mock\\BPPAY_20170905_11 .zip");
            //把文件上传在ftp上
            String path = "/data/ci/";
            FtpUtil.uploadToPath(ftpClient,path, file);
            FtpUtil.closeFtp(ftpClient);
            //下载ftp文件测试
            System.out.println("ok");
        }
    }

    @Test
    public void TestSftp2(){
        String host = "192.168.107.10";
        int port = 36000;
        String user = "atugao";
        String password = "Tms3.21";
        FtpJSch ftpJSch = new FtpJSch(host,port,user,password);
        try {
            ftpJSch.getConnect();
        } catch (JSchException e) {
            e.printStackTrace();
            return ;
        }
        ftpJSch.setDirectory("/data/ci");
        ftpJSch.setSaveFile("E:\\mock\\test111 .zip");
        String uploadFile ="E:\\mock\\BPPAY_20170905_11 .zip";
        File file = new File(uploadFile);
        String fileName = file.getName();
        ftpJSch.upload(uploadFile,fileName);


        ftpJSch.disconnect();
    }

    @Test
    public void testStr() throws UnsupportedEncodingException {
        String str = "abc你好";
        byte [] bytes = str.getBytes();
        System.out.println("bytes = " + bytes);
        byte [] bytes2 = str.getBytes("gbk");
        System.out.println("bytes2 = " + bytes2);

    }
}
