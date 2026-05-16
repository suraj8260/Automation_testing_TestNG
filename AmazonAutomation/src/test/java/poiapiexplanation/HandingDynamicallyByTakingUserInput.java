package poiapiexplanation;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class HandingDynamicallyByTakingUserInput {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet();

		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter the No of Row: ");
		int noOfRow = sc.nextInt();
		System.out.print("Enter the No of Cell: ");
		int noOfCell = sc.nextInt();
		
		for(int row = 0; row <= noOfRow; row++) {
			XSSFRow currentRow = sheet.createRow(row);
			for(int cell = 0; cell <= noOfCell; cell++) {
				XSSFCell currentCell = currentRow.createCell(cell);
				currentCell.setCellValue(sc.next());
			}
		}
		
        FileOutputStream file = new FileOutputStream(System.getProperty("user.dir") + "//testdata//DynamicFile.xlsx");

        workbook.write(file);
        workbook.close();
        file.close();
	}

}
