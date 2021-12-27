package com.mystore.dataprovider;

import org.testng.annotations.DataProvider;

import com.mystore.utils.NewExcelLibrary;

public class DataProviders {

	NewExcelLibrary obj = new NewExcelLibrary();
	
	
	@DataProvider(name="credentials")
	public Object[][] getEmail() {
		
		int rows = obj.getRowCount("Credentials");
		int column = obj.getColumnCount("Credentials");
		
		int actrows=rows-1;
		
		Object[][] data = new Object[actrows][column];
		
		for (int i = 0; i < actrows; i++) {
			for (int j = 0; j < column; j++) {
				data[i][j] = obj.getCellData("Credentials", j, i+2);
			}
		}
		return data;
	}
}
