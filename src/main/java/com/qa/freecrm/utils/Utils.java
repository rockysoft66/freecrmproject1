package com.qa.freecrm.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.mongodb.util.Util;
import com.qa.freecrm.pages.Base;

public class Utils extends Base {
	
	public static  Object[][] testdata(String sheetname){
		XSSFWorkbook wb =null; 
		FileInputStream ip=null;
		 
		try {
			 ip = new FileInputStream("C:\\Users\\dssri\\Desktop\\TestData22.xlsx");
			 try {
				wb = new XSSFWorkbook(ip);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			
		}
		XSSFSheet ws=	wb.getSheet(sheetname);
		Object[][] data = new Object[ws.getLastRowNum()][ws.getRow(0).getLastCellNum()];
		System.out.println("Total Row count= "+ws.getLastRowNum());
		System.out.println("Total column count= "+ws.getRow(0).getLastCellNum());
		for(int i=0; i<ws.getLastRowNum();i++) {
			
			for (int j=0 ; j<ws.getRow(0).getLastCellNum();j++) {
				
				data[i][j]=	ws.getRow(i+1).getCell(j).toString();
				
			}
			
		}
		return data;
	}
	
	public static void takeasshots(String MethodName) {
		
		
		File sourcefile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(sourcefile, new File("C:\\Users\\dssri\\eclipse-workspace\\project\\screenshots\\"+ MethodName+System.currentTimeMillis()+".jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
