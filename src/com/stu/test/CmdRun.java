package com.stu.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CmdRun {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Process p = Runtime.getRuntime().exec("cmd /c adb shell top -m 5 -d 1 -n 5 |findstr com.storm.smart");
		BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream(),"GBK"));
		String line = null;
		while((line = reader.readLine()) != null){
			System.out.println(line);
		}
		System.out.println("1");
	}

}
