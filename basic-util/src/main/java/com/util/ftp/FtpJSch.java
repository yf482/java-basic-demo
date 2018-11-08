package com.util.ftp;

import com.jcraft.jsch.*;
import org.apache.commons.lang.StringUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;
import java.util.Vector;

public class FtpJSch {

    public FtpJSch(String host, int port, String user, String password) {
        this.host = host;
        this.port = port;
        this.user = user;
        this.password = password;
    }

    private ChannelSftp sftp = null;
    //主机ip
    private String host;
    //端口
    private int port;
    //账号
    private String user;
    //密码
    private String password;
    //上传地址
    private String directory;
    //下载目录
    private String saveFile;

    public ChannelSftp getSftp() {
        return sftp;
    }

    public void setSftp(ChannelSftp sftp) {
        sftp = sftp;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getDirectory() {
        return directory;
    }

    public void setDirectory(String directory) {
        this.directory = directory;
    }

    public String getSaveFile() {
        return saveFile;
    }

    public void setSaveFile(String saveFile) {
        this.saveFile = saveFile;
    }

    public void getConnect() throws JSchException {
        JSch jsch = new JSch();
        //获取sshSession  账号-ip-端口
        Session sshSession = jsch.getSession(this.user, host, port);
        //添加密码
        sshSession.setPassword(password);
        Properties sshConfig = new Properties();
        //严格主机密钥检查
        sshConfig.put("StrictHostKeyChecking", "no");
        sshSession.setConfig(sshConfig);
        //开启sshSession链接
        sshSession.connect();
        //获取sftp通道
        Channel channel = sshSession.openChannel("sftp");
        //开启
        channel.connect();
        sftp = (ChannelSftp) channel;
    }

    public void disconnect() {
        if (sftp.isConnected()) {
            sftp.disconnect();
        }
    }

    /**
     * @param uploadFile 上传文件的路径
     * @return 服务器上文件名
     */
    public String upload(String uploadFile, String fileName) {
        File file = null;
        try {
            sftp.cd(directory);
            file = new File(uploadFile);
            if (!file.exists()) {
                return null;
            }
            if (StringUtils.isBlank(fileName)) {
                //文件名是 随机数加文件名的后5位
                fileName = file.getName();
//                fileName = UUID.randomUUID().toString() + file.getName().substring(file.getName().length() - 5);
            }
            sftp.put(new FileInputStream(file), fileName);
            return fileName;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 下载文件
     */
    public void download(String downloadFileName) {
        try {
            sftp.cd(directory);
            File file = new File(saveFile);
            sftp.get(downloadFileName, new FileOutputStream(file));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * 删除文件
     *
     * @param deleteFile 要删除的文件名字
     */
    public void delete(String deleteFile) {
        try {
            sftp.cd(directory);
            sftp.rm(deleteFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 列出目录下的文件
     *
     * @param directory 要列出的目录
     * @return
     * @throws SftpException
     */
    public Vector listFiles(String directory)
            throws SftpException {
        return sftp.ls(directory);
    }

}