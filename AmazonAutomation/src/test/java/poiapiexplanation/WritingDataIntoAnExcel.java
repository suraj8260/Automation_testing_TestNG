package poiapiexplanation;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WritingDataIntoAnExcel {

	public static void main(String[] args) throws IOException {
		
		XSSFWorkbook workbook = new XSSFWorkbook();
		
		XSSFSheet sheet = workbook.createSheet("TestData");
		
		XSSFRow row = sheet.createRow(0);
		row.createCell(0).setCellValue("Language");
		row.createCell(1).setCellValue("Quantity");
		row.createCell(2).setCellValue("Price");
		
		XSSFRow row1 = sheet.createRow(1);
		row1.createCell(0).setCellValue("Python");
		row1.createCell(1).setCellValue(24);
		row1.createCell(2).setCellValue(200.45);
		
		XSSFRow row2 = sheet.createRow(2);
		row2.createCell(0).setCellValue("Java");
		row2.createCell(1).setCellValue(29);
		row2.createCell(2).setCellValue(300.45);
		
		XSSFRow row3 = sheet.createRow(3);
		row3.createCell(0).setCellValue("Js");
		row3.createCell(1).setCellValue(45);
		row3.createCell(2).setCellValue(400.45);
		
		XSSFRow roww = sheet.createRow(6);					// This is for a specific Row
		XSSFCell cells = roww.createCell(6);				// This is for a specific Row
		cells.setCellValue("Hello World!");					// This is for a specific Row
		
        FileOutputStream file = new FileOutputStream(System.getProperty("user.dir") + "//testdata//Myfile.xlsx");
		
		workbook.write(file);
		workbook.close();
		file.close();
	}

}
