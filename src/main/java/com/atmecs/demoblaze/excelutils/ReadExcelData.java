package com.atmecs.demoblaze.excelutils;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.atmecs.demoblaze.constants.Constants;

public class ReadExcelData {

	public static void readdata() throws Exception {

		File file = new File(Constants.Excel_file);
		FileInputStream fileInput = new FileInputStream(file);

		XSSFWorkbook workbook = new XSSFWorkbook(fileInput);
		XSSFSheet sheet = workbook.getSheet("Sheet1");

	}
}
