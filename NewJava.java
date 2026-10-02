import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class NewJava {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String userName = "";
		String pwd = "";
		FileInputStream file = new FileInputStream("C://WorkSpace//ExcelFileData//src//main//resources//data.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		int row = sheet.getLastRowNum();
		System.out.println("The Value is" + row);
		for (int i = 0; i < row; i++) {
			Row rowdata = sheet.getRow(i);
			String cellvalue = rowdata.getCell(0).getStringCellValue().trim();
			System.out.println("Cell Value is" + cellvalue);
			if (cellvalue.equalsIgnoreCase("TC002")) {
				userName = rowdata.getCell(1).getStringCellValue().trim();
				pwd = rowdata.getCell(2).getStringCellValue().trim();
				break;
			}

		}

		System.out.println("User Name is----->" + userName);
		System.out.println("Password is---->" + pwd);
	}

}
