package utilities;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;

public class excelReader {

        private static XSSFSheet mSheet;
        static configReader configReader;

        public excelReader() {
        }

        public void readExcelFile() {
            configReader = new configReader();
            if (mSheet != null) {
                return;
            }
            File src = new File(configReader.getExcelPath());

            try {
                FileInputStream file = new FileInputStream(src);

                XSSFWorkbook wb = new XSSFWorkbook(file);

                mSheet = wb.getSheetAt(0);

            } catch (Exception ex) {
                System.out.println("You got: " + ex);
            }
        }

        public static String GetCellValue(int row, int column) {
            if (mSheet == null) {
                return "";
            }
            XSSFCell cell = mSheet.getRow(row).getCell(column);
            return cell.getStringCellValue();
        }
    }

