package com.stu.test;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Logger;

import javax.imageio.ImageIO;

public class ImageTest {
	int times = 0;
	int timesX = 50;
	int timesY = 365;	
	int[] cpu_Str = new int[6]; 
	
	private void creatImage(int[] intY){
		int[] intX = {0,10,20,30,40,50};
//		int[] intY = {30,40,55,35,20,30};
		BufferedImage image = new BufferedImage(600,400, BufferedImage.TYPE_INT_RGB);
		Graphics2D g2d = (Graphics2D) image.getGraphics();
		g2d.setColor(Color.PINK);
		g2d.fillRect(0, 0, 600,400);
		g2d.setColor(Color.BLACK);
		g2d.drawLine(50, 350, 550, 350);
		g2d.drawLine(50, 50, 50, 350);
		g2d.drawString("time(s)", 530, 380);
		g2d.drawString("cpu", 20, 50);
		System.out.println("kaishifor");
		for(int i=0;i<6;i++){
			System.out.println(times);
			g2d.drawString(Integer.toString(times), timesX, timesY);
			times += 10;
			timesX += 100;
		}
		for(int i=1;i<intX.length;i++){
			g2d.drawLine(intX[i-1]*10+50, 250-intY[i-1]*3, intX[i]*10+50, 250-intY[i]*3);
		}
		g2d.dispose();
		
		try {
			ImageIO.write(image, "png", new File("D:/test.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private int[] cmdAdb(){
		String cmdStr = " adb shell top -m 5 -d 1 -n 5";
		String cmdFind = " |findstr com.storm.smart";
		String adb = "adb shell top -m 5 -d 2 -n 6 |grep com.storm.smart";
		
		int i = 0;
		System.out.println(adb);
		try {
			Process p = Runtime.getRuntime().exec(adb);
			try {
				Thread.sleep(7000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
			String line = null;

			while((line = reader.readLine()) != null){
				System.out.println(line);
				String[] cpu = line.split("\\s+");
				System.out.println("Start");
				if(cpu.length != 1){	
					cpu_Str[i] =Integer.parseInt(cpu[2].substring(0,cpu[2].length()-1));
					System.out.println(cpu[2]);
					System.out.println(cpu.length);		
					i++;
				}
				
			}
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int j=0;j<cpu_Str.length;j++){
			System.out.println(cpu_Str[j]);
		}
		return cpu_Str;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ImageTest imageTest = new ImageTest();
		imageTest.creatImage(imageTest.cmdAdb());
//		imageTest.cmdAdb();		
		System.out.println("end");
		
	}

}
