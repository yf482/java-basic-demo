package com.util.ftp;


import org.apache.commons.lang.StringUtils;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;
import org.apache.log4j.Logger;

import java.io.*;

/**
* @author v_wbyfli
* @date 2018/8/8 17:24
* @version V1.0
*/
public class FtpUtil {

    private static Logger logger = Logger.getLogger(FtpUtil.class);
    /**
     * 获取ftp连接
     *
     * @param ftp
     * @return
     * @throws Exception
     */
    public static FTPClient connectFtp(Ftp ftp) throws Exception {
        FTPClient ftpClient = new FTPClient();
        int reply;
        if (ftp.getPort() == null) {
            ftpClient.connect(ftp.getIpAddr(), 21);
        } else {
            ftpClient.connect(ftp.getIpAddr(), ftp.getPort());
        }
        ftpClient.setDataTimeout(60000);
        ftpClient.setConnectTimeout(60000);
        ftpClient.login(ftp.getUserName(), ftp.getPwd());
        ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
        reply = ftpClient.getReplyCode();
        if (!FTPReply.isPositiveCompletion(reply)) {
            ftpClient.disconnect();
            logger.error("ftp server is disconnect");
            return null;
        }
        if(StringUtils.isNotBlank(ftp.getPath())){
            ftpClient.changeWorkingDirectory(ftp.getPath());
            logger.info("ftp server change working path");
        }
        return ftpClient;
    }

    /**
     * 关闭ftp连接
     */
    public static void closeFtp(FTPClient ftpClient) {
        if (ftpClient != null && ftpClient.isConnected()) {
            try {
                ftpClient.logout();
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                try {
                    ftpClient.disconnect();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    /**
     * ftp上传文件
     *
     * @param file
     * @throws Exception
     */
    public static void upload(FTPClient ftpClient, File file) throws Exception {
        if (file.isDirectory()) {
            ftpClient.makeDirectory(file.getName());
            ftpClient.changeWorkingDirectory(file.getName());
            String[] files = file.list();
            for (String fstr : files) {
                File file1 = new File(file.getPath() + "/" + fstr);
                if (file1.isDirectory()) {
                    upload(ftpClient,file1);
                    ftpClient.changeToParentDirectory();
                }else{
                    File file2 = new File(file.getPath() + "/" + fstr);
                    FileInputStream input = new FileInputStream(file2);
                    ftpClient.storeFile(file2.getName(), input);
                    input.close();
                }
            }
        } else {
            File file2 = new File(file.getPath());
            FileInputStream input = new FileInputStream(file2);
            ftpClient.storeFile(file2.getName(), input);
            input.close();
        }
    }

    public static void uploadToPath(FTPClient ftpClient,String path, File file) throws Exception {
        logger.info(" upload ftp path : " + path + " , " + file.getName());
        if(StringUtils.isNotBlank(path)){
            if(ftpClient.makeDirectory(path)){
                logger.info("create dir is success");
            }
            if(ftpClient.changeWorkingDirectory(path)){
                logger.info("changeWorkingDirectory  is success");
            }
            upload(ftpClient,file);
        }
    }


    /**
     * 下载链接配置
     *
     * @param ftpClient
     * @param localBaseDir  本地目录
     * @param remoteBaseDir 远程目录
     * @throws Exception
     */
    public static void startDown(FTPClient ftpClient , String localBaseDir, String remoteBaseDir) throws Exception {
        try {
            FTPFile[] files = null;
            boolean changedir = ftpClient.changeWorkingDirectory(remoteBaseDir);
            if (changedir) {
                ftpClient.setControlEncoding("GBK");
                files = ftpClient.listFiles();
                for (int i = 0; i < files.length; i++) {
                    try {
                        downloadFile(ftpClient,files[i], localBaseDir, remoteBaseDir);
                    } catch (Exception e) {
                        logger.error(e);
                        logger.error("<" + files[i].getName() + ">下载失败");
                    }
                }
            }
        } catch (Exception e) {
            logger.error("下载过程中出现异常",e);
        }
    }


    /**
     * 下载FTP文件
     * 当你需要下载FTP文件的时候，调用此方法
     * 根据<b>获取的文件名，本地地址，远程地址</b>进行下载
     *
     * @param ftpFile
     * @param relativeLocalPath
     * @param relativeRemotePath
     */
    private static void downloadFile(FTPClient ftpClient,FTPFile ftpFile, String relativeLocalPath, String relativeRemotePath) {
        if (ftpFile.isFile()) {
            if (ftpFile.getName().indexOf("?") == -1) {
                OutputStream outputStream = null;
                try {
                    File locaFile = new File(relativeLocalPath + ftpFile.getName());
                    //判断文件是否存在，存在则返回
                    if (locaFile.exists()) {
                        return;
                    } else {
                        outputStream = new FileOutputStream(relativeLocalPath + ftpFile.getName());
                        ftpClient.retrieveFile(ftpFile.getName(), outputStream);
                        outputStream.flush();
                        outputStream.close();
                    }
                } catch (Exception e) {
                    logger.error(e);
                } finally {
                    try {
                        if (outputStream != null) {
                            outputStream.close();
                        }
                    } catch (IOException e) {
                        logger.error("输出文件流异常");
                    }
                }
            }
        } else {
            String newlocalRelatePath = relativeLocalPath + ftpFile.getName();
            String newRemote = new String(relativeRemotePath + ftpFile.getName().toString());
            File fl = new File(newlocalRelatePath);
            if (!fl.exists()) {
                fl.mkdirs();
            }
            try {
                newlocalRelatePath = newlocalRelatePath + '/';
                newRemote = newRemote + "/";
                String currentWorkDir = ftpFile.getName().toString();
                boolean changedir = ftpClient.changeWorkingDirectory(currentWorkDir);
                if (changedir) {
                    FTPFile[] files = null;
                    files = ftpClient.listFiles();
                    for (int i = 0; i < files.length; i++) {
                        downloadFile(ftpClient,files[i], newlocalRelatePath, newRemote);
                    }
                }
                if (changedir) {
                    ftpClient.changeToParentDirectory();
                }
            } catch (Exception e) {
                logger.error(e);
            }
        }
    }

    /**
     * 下载ftp服务器文件
     * @param ftpClient
     * @param ftpPath
     * @param localPath
     * @param fileName
     */
    public static void downloadFtpFile(FTPClient ftpClient,String ftpPath, String localPath,String fileName) {
        try {
            // 中文支持
            ftpClient.setControlEncoding("UTF-8");
            ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
            ftpClient.enterLocalPassiveMode();
            ftpClient.changeWorkingDirectory(ftpPath);
            File localFile = new File(localPath + File.separatorChar + fileName);
            OutputStream os = new FileOutputStream(localFile);
            ftpClient.retrieveFile(fileName, os);
            os.close();
        } catch (IOException e) {
            System.out.println("没有找到" + ftpPath + "文件");
            e.printStackTrace();
        }
    }


}