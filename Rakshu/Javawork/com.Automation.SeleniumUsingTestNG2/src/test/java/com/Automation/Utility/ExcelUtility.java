package com.Automation.Utility;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelUtility {
	
	// Method to read data from Excel file
			public static String readDataFromXl(String filePath, String sheetname, int rowIndex, int cellIndex)
					throws IOException {
				System.out.println("started to read single data from "+ filePath);
				FileInputStream file = new FileInputStream(new File(filePath));
				Workbook workbook = new XSSFWorkbook(file);
				Sheet sheet = workbook.getSheet(sheetname); // Assuming data is in the first sheet
				return sheet.getRow(rowIndex).getCell(cellIndex).toString();

			}

			// Method to read data from Excel file and return as a List of Lists
			public static List<List<String>> readAllDataFromXl(String filePath, String sheetName) {
				List<List<String>> allData = new ArrayList<>();
				
				return allData;
			}
			
			public static Object[][] readAllDataFromXlToArray(String filePath, String sheetName) {
				Object[][] data =null;
				Workbook workbook=null;
				FileInputStream file=null;
				
				try {
					file = new FileInputStream(new File(filePath));
					workbook = WorkbookFactory.create(file);
					Sheet sheet = workbook.getSheet(sheetName);
					int rows = sheet.getPhysicalNumberOfRows();
				    int cols = sheet.getRow(0).getLastCellNum();
				    data = new Object[rows][cols];
				    for (int i = 0; i < rows; i++) {
			            Row row = sheet.getRow(i);
			            for (int j = 0; j < cols; j++) {
			                Cell cell = row.getCell(j);
			                data[i][j]=cell.toString();
			            }
				    }
				}
				catch (Exception e) {
					System.out.println("excpetion caught while reading data from xlsx sheet");
					e.printStackTrace();
				}
				finally {
					try {
						workbook.close();
						file.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
					return data;
			}

			// Method to write data to Excel file
			public static void writeExcelFile(String filePath, Object[][] data) {
				
			}
	
	

}
