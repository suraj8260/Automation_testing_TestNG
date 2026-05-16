package poiapiexplanation;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

// Excel ---> Workbook ---> Sheets ---> Row ---> Cell

public class WritingDataIntoExcelUserInput {

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        FileOutputStream file = new FileOutputStream(
                System.getProperty("user.dir") + "//testdata//Book3.xlsx");

        XSSFWorkbook workBook = new XSSFWorkbook();
        XSSFSheet sheet = workBook.createSheet("Sheet1");

        // Taking number of rows from user
        System.out.print("Enter number of rows: ");
        int rows = sc.nextInt();

        System.out.print("Enter number of cells: ");
        int cells = sc.nextInt();

        sc.nextLine(); // consume leftover newline ONLY ONCE

        // Outer loop for rows
        for (int row = 0; row < rows; row++) {

            XSSFRow currentRow = sheet.createRow(row);

            // Inner loop for cells
            for (int cell = 0; cell < cells; cell++) {

                XSSFCell currentCell = currentRow.createCell(cell);

                System.out.print("Enter data for row " + row + " cell " + cell + " : ");

                String data = sc.nextLine();

                currentCell.setCellValue(data);
            }
        }

        // Writing data into excel
        workBook.write(file);

        // Closing resources
        workBook.close();
        file.close();
        sc.close();

        System.out.println("Data written successfully...");
    }
}