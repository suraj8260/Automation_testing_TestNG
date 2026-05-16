package poiapiexplanation;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

//Excel---->WorkBook---->Sheets---->Row---->Cell

public class WritingDataIntoExcel {

    public static void main(String[] args) throws IOException {
        
        FileOutputStream file = new FileOutputStream(System.getProperty("user.dir") + "//testdata//Book2.xlsx");

        XSSFWorkbook workBook = new XSSFWorkbook();
        XSSFSheet sheet = workBook.createSheet("Sheet1");

        // Creating first row
        XSSFRow row0 = sheet.createRow(0);

        XSSFCell cell00 = row0.createCell(0);
        cell00.setCellValue("Name");

        XSSFCell cell01 = row0.createCell(1);
        cell01.setCellValue("Age");

        XSSFCell cell02 = row0.createCell(2);
        cell02.setCellValue("City");

        // Creating second row
        XSSFRow row1 = sheet.createRow(1);

        XSSFCell cell10 = row1.createCell(0);
        cell10.setCellValue("Rahul");

        XSSFCell cell11 = row1.createCell(1);
        cell11.setCellValue(25);

        XSSFCell cell12 = row1.createCell(2);
        cell12.setCellValue("Bangalore");

        // Creating third row
        XSSFRow row2 = sheet.createRow(2);

        XSSFCell cell20 = row2.createCell(0);
        cell20.setCellValue("Anjali");

        XSSFCell cell21 = row2.createCell(1);
        cell21.setCellValue(23);

        XSSFCell cell22 = row2.createCell(2);
        cell22.setCellValue("Mysore");

        // Writing data into excel file
        workBook.write(file);

        // Closing workbook and file
        workBook.close();
        file.close();

        System.out.println("Data written successfully...");
    }
}