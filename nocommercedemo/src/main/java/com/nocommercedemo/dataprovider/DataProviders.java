package com.nocommercedemo.dataprovider;

import java.io.IOException;

import org.testng.annotations.DataProvider;

import com.nocommercedemo.utility.NewExcelLibrary;

public class DataProviders {

	@DataProvider(name = "registrationdetails")
	String[][] getData1() {
		String path = "C:\\Users\\hp\\Desktop\\practice.xlsx";

		try {
			int rownum = NewExcelLibrary.getRowCount(path, "Registrationdata");
			int colcount = NewExcelLibrary.getCellCount(path, "Registrationdata", 1);
			String registrationdata[][] = new String[rownum - 1][colcount]; // Exclude header row

			// Start from index 1 to skip header row
			for (int i = 1; i < rownum; i++) {
				for (int j = 0; j < colcount; j++) {
					registrationdata[i - 1][j] = NewExcelLibrary.getCellData(path, "Registrationdata", i, j);
				}
			}
			return registrationdata;
		} catch (IOException e) {
			e.printStackTrace();
			return null; // or handle the exception appropriately
		}
	}

	@DataProvider(name = "newmyaccountdetails")
	String[][] getData2() {
		String path = "C:\\Users\\hp\\Desktop\\practice.xlsx";

		try {
			int rownum = NewExcelLibrary.getRowCount(path, "NewMyAccountdetails");
			int colcount = NewExcelLibrary.getCellCount(path, "NewMyAccountdetails", 1);
			String myaccountdeatils[][] = new String[rownum - 1][colcount];
			for (int i = 1; i < rownum; i++) {
				for (int j = 0; j < colcount; j++) {
					myaccountdeatils[i - 1][j] = NewExcelLibrary.getCellData(path, "NewMyAccountdetails", i, j);
				}
			}
			return myaccountdeatils;
		} catch (IOException e) {
			e.printStackTrace();
			return null; // or handle the exception appropriately
		}
	}

	@DataProvider(name = "billingpagedetails")
	String[][] getData3() {
		String path = "C:\\Users\\hp\\Desktop\\practice.xlsx";

		try {
			int rownum = NewExcelLibrary.getRowCount(path, "BillingPage");
			int colcount = NewExcelLibrary.getCellCount(path, "BillingPage", 1);
			String Billingpagedeatils[][] = new String[rownum - 1][colcount];
			for (int i = 1; i < rownum; i++) {
				for (int j = 0; j < colcount; j++) {
					Billingpagedeatils[i - 1][j] = NewExcelLibrary.getCellData(path, "BillingPage", i, j);
				}
			}
			return Billingpagedeatils;
		} catch (IOException e) {
			e.printStackTrace();
			return null; // or handle the exception appropriately
		}
	}

}
