import java.util.HashMap;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.util.Map;

public class ReadNewData {

	public static Map getTestData(String tcid) throws IOException

	{
		#Added
		Map dataset = new HashMap();
		String username = "";
		String pwd = "";
		FileInputStream fs = new FileInputStream("C://WorkSpace//ExcelFileData//src//main//resources//data.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fs);
		XSSFSheet newsheet = workbook.getSheet("Sheet1");
		int rownum = newsheet.getLastRowNum();
		System.out.println("tcid"+tcid.trim());
		System.out.println(rownum);
		for (int i = 1; i <=rownum; i++) {
			Row row = newsheet.getRow(i);

			String name = row.getCell(0).getStringCellValue().trim();
			System.out.println("The Name is--->"+name);
			

			if (name.equalsIgnoreCase(tcid)) {
				username = row.getCell(1).getStringCellValue().trim();
				pwd = row.getCell(2).getStringCellValue().trim();
				break;
			}
			
			
		}

		dataset.put("uName", username);
		dataset.put("pwd", pwd);
        System.out.println("uName---->"+username);
        System.out.println("uName---->"+pwd);
		return dataset;

	}

	public static void main(String args[]) throws IOException {
		Map rsultData = getTestData("TC001");
		System.out.println("The user Name is" + rsultData.get("uName"));
		System.out.println("The user Name is" + rsultData.get("pwd"));

	}

}
