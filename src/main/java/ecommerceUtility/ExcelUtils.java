package ecommerceUtility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

    public static Object[][] getExcelData(String filePath, String sheetName) throws IOException {

        FileInputStream fis = new FileInputStream(filePath);   // read excel file
        XSSFWorkbook workbook = new XSSFWorkbook(fis);        // load workbook
        XSSFSheet sheet = workbook.getSheet(sheetName);       // get sheet

        
        
        
        int row = sheet.getPhysicalNumberOfRows();       // total rows
        int cell = sheet.getRow(1).getPhysicalNumberOfCells(); // total columns

        Object[][] data = new Object[row - 1][cell]; // 2D array for DataProvider

        for (int i = 0; i < row - 1; i++)
        {
            XSSFRow rows = sheet.getRow(i + 1);   // skip header row
            XSSFCell cells = rows.getCell(0);     // product name column
            data[i][0] = cells.getStringCellValue();
        }

        workbook.close();
        fis.close();

        return data;
    }
}
