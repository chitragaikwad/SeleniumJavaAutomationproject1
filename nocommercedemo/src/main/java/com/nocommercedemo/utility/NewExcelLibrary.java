package com.nocommercedemo.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class NewExcelLibrary {

	public static FileInputStream fi;
	public static FileOutputStream fo;
	public static XSSFWorkbook wb;
	public static XSSFSheet ws;
	public static XSSFRow row;
	public static XSSFCell cell;

	public static int getRowCount(String xlfile, String xlsheet) throws IOException {
		fi = new FileInputStream(xlfile);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(xlsheet);
		int rowcount = ws.getLastRowNum() + 1;
		wb.close();
		fi.close();
		return rowcount;
	}

	public static int getCellCount(String xlfile, String xlsheet, int rownum) throws IOException {
		fi = new FileInputStream(xlfile);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(xlsheet);
		row = ws.getRow(rownum);
		int cellcount = row.getLastCellNum();
		wb.close();
		fi.close();
		return cellcount;
	}

	public static String getCellData(String xlfile, String xlsheet, int rownum, int colnum)
			throws FileNotFoundException, IOException {
		try (FileInputStream fi = new FileInputStream(xlfile); XSSFWorkbook wb = new XSSFWorkbook(fi)) {
			XSSFSheet ws = wb.getSheet(xlsheet);
			if (ws != null) {
				XSSFRow row = ws.getRow(rownum);
				if (row != null) {
					XSSFCell cell = row.getCell(colnum);
					if (cell != null)

					{
						DataFormatter formatter = new DataFormatter();
						return formatter.formatCellValue(cell);
					} else {
						System.out.println("Cell at row " + rownum + " and column " + colnum + " is null");
					}
				} else {
					System.out.println("Row " + rownum + " is null");
				}
			} else {
				System.out.println("Sheet '" + xlsheet + "' not found in file '" + xlfile + "'");
			}
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		return ""; // or handle the null case appropriately
	}

	public static void setCellData(String xlfile, String xlsheet, int rownum, int colnum, String data)
			throws IOException {
		fi = new FileInputStream(xlfile);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(xlsheet);
		row = ws.getRow(rownum);
		cell = row.createCell(colnum);
		cell.setCellValue(data);
		fo = new FileOutputStream(xlfile);
		wb.write(fo);
		wb.close();
		fi.close();
		fo.close();
	}

}
