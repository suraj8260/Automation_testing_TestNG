package poiapiexplanation;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

//Excel---->WorkBook---->Sheets---->Row---->Cell

public class ReadingDataFromExcel {

    public static void main(String[] args) throws IOException {
        
        FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "//testdata//Book1.xlsx");
     
        XSSFWorkbook workBook = new XSSFWorkbook(file); 
        XSSFSheet sheet = workBook.getSheet("Sheet1");
        int firstRowNumber = sheet.getLastRowNum();
        short totalCells = sheet.getRow(2).getLastCellNum();
        
     // Extracting the total number of cells from the first row
        System.out.println("No of rows: " + firstRowNumber);
        System.out.println("No of Cells: " + totalCells);

        // Outer loop to iterate through each row
        for(int row = 0; row <= firstRowNumber; row++) {
            XSSFRow currentRow = sheet.getRow(row);

            // Inner loop to iterate through each cell in the current row
            for(int cell = 0; cell < totalCells; cell++) {
                XSSFCell currentCell = currentRow.getCell(cell);
                
                // Printing the cell content as a String
                System.out.printf("%-20s", currentCell.toString());
            }
            System.out.println();
        }

        // Closing the workbook and the file stream to free memory
        workBook.close();
        file.close();
    }
}