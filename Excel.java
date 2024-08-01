package org.demo;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel {
	
	public static void main(String[] args) throws IOException {
		
	File f = new File ("C:\\Users\\Avila Theresa\\Desktop\\Excel.xlsx");
	
	FileInputStream file = new FileInputStream(f);
	
	Workbook book = new XSSFWorkbook(file);
	
	Sheet sheet = book.getSheet("Sheet1");
	
	for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
		
		Row row = sheet.getRow(i);
		
		for (int j = 0; j < row.getPhysicalNumberOfCells(); j++) {
			
			Cell cell = row.getCell(j);
			
			CellType cellType = cell.getCellType();
			
			switch (cellType) {
			
			case STRING:
				
				String stringCellValue = cell.getStringCellValue();
				
				System.out.print(stringCellValue+"\t");	
				
				break;
				
			case NUMERIC:
				
				if (DateUtil.isCellDateFormatted(cell)) {
					
					Date dateCellValue = cell.getDateCellValue();
					
					SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
					
					String format = simpleDateFormat.format(dateCellValue);
					
					System.out.print(format+"\t");
					
				} else {
					
		double numericCellValue = cell.getNumericCellValue();
		
		BigDecimal valueOf = BigDecimal.valueOf(numericCellValue);
		
		String string = valueOf.toString();
		
		System.out.print(string+"\t");
		
				}
				
				break;
				
			default:
				
				System.out.println("invalid");
				
				break;
			}
			
		}
		
		System.out.println();
	}
	
	}
	
}
