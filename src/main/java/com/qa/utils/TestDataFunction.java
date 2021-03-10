package com.qa.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TestDataFunction {
	//static FileInputStream file;
	//static XSSFWorkbook workbook;
	//static XSSFSheet sheet;
	public static DataFormatter formatter= new DataFormatter();
	
	public String[][] readAllExcel(String fileName, String sheetName) throws IOException{
//		List<List<String>> cellData = new ArrayList<List<String>>(); 
		FileInputStream fi = new FileInputStream(fileName);
		XSSFWorkbook wb = new XSSFWorkbook(fi);
		XSSFSheet sh = wb.getSheet(sheetName);// get my sheet from workbook
		XSSFRow Row = sh.getRow(0);// get my Row which start from 0�� ///Dheeraj
		int RowNum = sh.getPhysicalNumberOfRows();// count my number of Rows
		int ColNum = Row.getLastCellNum(); // get last ColNum
		String Data[][] = new String[RowNum - 1][ColNum]; // pass my� count data in array
		for (int i = 0; i < RowNum - 1; i++) // Loop work for Rows
		{
			XSSFRow row = sh.getRow(i + 1);
			for (int j = 0; j < ColNum; j++) // Loop work for colNum
			{
				if(new DataFormatter().formatCellValue(row.getCell(0)).toUpperCase().equals("NO")) 
					continue; 
				
				if (row == null)
					Data[i][j] = "";
				else {
					XSSFCell cell = row.getCell(j);
					if (cell == null)
						Data[i][j] = ""; // if it get Null value it pass no data
					else {
						String value = formatter.formatCellValue(cell);
						Data[i][j] = value; // This formatter get my all values as string i.e integer, float all type
											// data value
					}
				}
			}
		}
		
		int rNum = getSheetRowCount( sh);
		int cNum = Row.getLastCellNum();
		String dataSet[][] = new String[rNum][cNum];
		
		for (int i = 0,k=0; i < Data.length; i++) // Loop work for Rows
		{
			
			if(Data[i][0] != null )  {
				if (!(Data[i][0].equals("null"))) {
				    for (int j = 0; j < ColNum; j++) // Loop work for colNum
					dataSet[k][j] = Data[i][j];
				//k++;
				
				}
				k++;
			}
		}
		
		System.out.println("Actual excel sheet row count: " + Data.length + " Filtered sheet row count:"+rNum );
		
		return dataSet;

	}

	private int getSheetRowCount(XSSFSheet sh) {
		// TODO Auto-generated method stub
		XSSFRow row = null;
		int rCount = 0;
		int RowNum = sh.getPhysicalNumberOfRows();
		for (int i = 0; i < RowNum ; i++) // Loop work for Rows
		{
			row = sh.getRow(i);;			
			if(new DataFormatter().formatCellValue(row.getCell(0)).toUpperCase().equals("YES")) 
				rCount++;			
		}
		return rCount;
	}

}
