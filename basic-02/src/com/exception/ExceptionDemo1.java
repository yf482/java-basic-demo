package com.exception;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ExceptionDemo1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public void readFile3(String file)
	{
		BufferedReader reader = null;
		Connection conn = null;

		try{
			reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));

			conn = DriverManager.getConnection("");
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try {
				reader.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
/*
 * 1.从异常角度来说这样严格的程序确实是万无一失，所有异常都能捕获
 * 但站在程序员的角度来说，万一出现了异常却不能分辨到底是什么引起的。是IO还是JDBC
 * 上面的例子是一个反例，实际中一定清楚认识。
 * 2.我们希望程序发生异常时候尽可能提供意外的信息，包括发生的位置、描述、和原因等。那样才能更清楚的解决问题。
 * 而不是简单的e.printStackTrace();
 * 3.try block写的简短，不要什么东西都仍在这里，尽可能对可能发生异常的位置进行try catch  尽可能为每个异常做try catch
 *
 *
 * */
