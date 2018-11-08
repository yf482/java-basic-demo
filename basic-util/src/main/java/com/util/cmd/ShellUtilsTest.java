package com.util.cmd;


import static org.junit.Assert.*;

public class ShellUtilsTest {
    @org.junit.Test
    public void execCommand() throws Exception {
        ShellUtils.CommandResult commandResult = ShellUtils.execCommand("dir d:/");
        System.out.println("commandResult = " + commandResult);
    }

    @org.junit.Test
    public void execCommand1() throws Exception {
    }

    @org.junit.Test
    public void execCommand2() throws Exception {
    }

    @org.junit.Test
    public void execCommand3() throws Exception {
    }

    @org.junit.Test
    public void execShell() throws Exception {
    }

    @org.junit.Test
    public void callShell() throws Exception {
    }


}
