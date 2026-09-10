package com.enterprise.utils;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtils implements AutoCloseable{
	private final Workbook workbook;
	private Sheet sheet;
	private final DataFormatter formatter = new DataFormatter();
	
	public ExcelUtils(String filePath) {

	    try (FileInputStream file = new FileInputStream(filePath)) {

	        workbook = WorkbookFactory.create(file);

	    } catch (IOException e) {

	        throw new RuntimeException(
	                "Unable to open Excel file: " + filePath,e);

	    }

	}
	public void setSheet(String sheetName) {
		sheet=workbook.getSheet(sheetName);
		if(sheet==null) {
			throw new RuntimeException("Sheet not found:"+sheetName);
		}
	}
	public int getRowCount() {

	    return sheet.getPhysicalNumberOfRows();

	}
	public int getColumnCount() {

	    return sheet.getRow(0).getPhysicalNumberOfCells();

	}
	
	public String getCellData(int row, int column) {
		
		if(sheet.getRow(row)==null || sheet.getRow(row).getCell(column)==null) {
			return "";
		}

	    return formatter.formatCellValue(sheet.getRow(row).getCell(column));
	}
	public Object[][] getSheetData() {

	    int rows = getRowCount();

	    int columns = getColumnCount();

	    Object[][] data =new Object[rows - 1][columns];

	    for (int i = 1; i < rows; i++) {

	        for (int j = 0; j < columns; j++) {

	            data[i - 1][j] =getCellData(i, j);

	        }

	    }

	    return data;

	}

	@Override
	public void close() throws IOException {

	    if (workbook != null) {

	        workbook.close();

	    }

	}
}
