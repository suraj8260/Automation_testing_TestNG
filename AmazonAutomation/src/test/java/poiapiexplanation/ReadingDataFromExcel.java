package poiapiexplanation;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

//Excel---->WorkBook---->Sheets---->Row---->Cell

public class ReadingDataFromExcel {

    public static void main(String[] args) throws IOException {
        
        FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "//testdata//Book1.xlsx");
     
        XSSFWorkbook workBook = new XSSFWorkbook(file);
    }
}