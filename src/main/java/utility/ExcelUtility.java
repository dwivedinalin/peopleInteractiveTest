package utility;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ExcelUtility {

    public static List<HashMap<String, String>> data(String filepath, String sheetName) {
        List<HashMap<String, String>> mydata = new ArrayList<HashMap<String, String>>();
        try {
            FileInputStream fs = new FileInputStream(filepath);

            HSSFWorkbook workbook = new HSSFWorkbook(fs);
            HSSFSheet sheet = workbook.getSheet(sheetName);

            Row HeaderRow = sheet.getRow(0);


            for (int i = 1; i < sheet.getPhysicalNumberOfRows(); i++) {
                int num_of_rows = sheet.getPhysicalNumberOfRows();
                HSSFRow currentRow = sheet.getRow(i);
                HashMap<String, String> currentHash = new HashMap<String, String>();

                for (int j = 0; j < currentRow.getPhysicalNumberOfCells(); j++) {
                    Cell currentCell = currentRow.getCell(j);

                    switch (currentCell.getCellType()) {
                        case Cell.CELL_TYPE_STRING: {
                            System.out.print(currentCell.getStringCellValue() + "\t");
                            currentHash.put(HeaderRow.getCell(j).getStringCellValue(), currentCell.getStringCellValue());
                            break;
                        }
                        case Cell.CELL_TYPE_NUMERIC: {
                            if (HSSFDateUtil.isCellDateFormatted(currentCell)) {
                                System.out.print(currentCell.getDateCellValue() + "\t");
                                currentHash.put(HeaderRow.getCell(j).getStringCellValue(), currentCell.getDateCellValue().toString());
                            } else {
                                System.out.print(currentCell.getNumericCellValue() + "\t");
                                currentHash.put(HeaderRow.getCell(j).getStringCellValue(), new Double(currentCell.getNumericCellValue()).toString());
                            }
                        }
                    }
                }
                mydata.add(currentHash);
            }
            fs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mydata;
    }
}
