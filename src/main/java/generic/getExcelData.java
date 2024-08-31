package generic;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class getExcelData {
	
	/* method to read data from excel*/
	public static String getData(String location, String sn, int r, int c) {
		try {
			FileInputStream f1= new FileInputStream(location);
			Workbook book = WorkbookFactory.create(f1);
			Cell cell = book.getSheet(sn).getRow(r).getCell(c);
			String data = "";
			switch (cell.getCellType()) {
			case STRING: 
				data=cell.getStringCellValue();
				break;
			case NUMERIC:
				data= String.valueOf((long)cell.getNumericCellValue());
				break;
			case BOOLEAN:
				data = String.valueOf(cell.getBooleanCellValue());
				break;
			case BLANK:
	            data = "";
	            break;
			default:
				data = null;
				break;
			}
			return data;
		} catch (Exception e) {
			e.printStackTrace();
	        return null;
		}
	}
	
	/* method to write data into excel*/
	public static void writeData(String location, String sn, String result, int row) {
		try {
			int colCount = getColsCount(location, sn, row);
			FileInputStream f1= new FileInputStream(location);
			Workbook book = WorkbookFactory.create(f1);
			book.getSheet(sn).getRow(row).createCell(colCount).setCellValue(result);
			f1.close();
			FileOutputStream f2 = new FileOutputStream(location);
			book.write(f2);
	        f2.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	/* method to get row count of a sheet*/
	public static int getRowCount(String location, String sn) {
		try {
			FileInputStream fi = new FileInputStream(location);
			Workbook book = WorkbookFactory.create(fi);
			Sheet cloudteslaSignupSheet = book.getSheet(sn);
			int rowCount = cloudteslaSignupSheet.getLastRowNum();
			return rowCount;
		} catch (Exception e) {
			return 0;
		}
		
	}
	
	/* method to get row count of a row*/
	public static int getColsCount(String location, String sn, int row) {
		try {
			FileInputStream fi = new FileInputStream(location);
			Workbook book = WorkbookFactory.create(fi);
			Sheet cloudteslaSignupSheet = book.getSheet(sn);
			int closCount = cloudteslaSignupSheet.getRow(row).getLastCellNum();
			return closCount;
		} catch (Exception e) {
			return 0;
		}
		
	}
}