package BaseClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.TreeMap;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {
	
	public static FileInputStream fis;
	public static Properties prop;
	public static WebDriver driver;
	public static FileInputStream excel;
	public static File file;
	public static XSSFSheet sheet;
	public static XSSFWorkbook wb;
	public static Row row;
	public static Cell cell;
	
	public static WebDriver Browser() throws IOException {
		
		fis = new FileInputStream("C:\\Users\\Satish\\eclipse-workspace\\ReadExcel\\ExcelRead_08102021\\src\\main\\java\\Resources\\Config.properties");
		prop = new Properties();
		prop.load(fis);
		
		System.setProperty(prop.getProperty("key"), prop.getProperty("path"));
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
	
	public static List<Map<String,String>> getExcelData(int num) throws IOException {
		List<Map<String,String>> testDataAllRows = null;
	    Map<String,String> testData = null;
		
		file = new File("C:\\Users\\Satish\\eclipse-workspace\\ReadExcel\\ExcelRead_08102021\\src\\main\\java\\Resources\\Soluship_User_Inputs.xlsx");
		excel = new FileInputStream(file);
		wb = new XSSFWorkbook(excel);
		sheet = wb.getSheetAt(num);
		wb.close();

		int lastRow = sheet.getLastRowNum();
		int lastColumn = sheet.getRow(0).getLastCellNum();
		
		List<String> list = new ArrayList<String>();
		
		for(int i=0; i<lastColumn; i++) {
			row = sheet.getRow(0);
			cell = row.getCell(i);
			String rowHeader = cell.getStringCellValue().trim();
			list.add(rowHeader);
			//System.out.println(rowHeader);
		}
		testDataAllRows = new ArrayList<Map<String,String>>();
		for(int j=1; j<lastRow+1; j++) {
			row = sheet.getRow(j);
			testData = new TreeMap<String,String>(String.CASE_INSENSITIVE_ORDER);
			//System.out.println(j);
			
			for(int k=0; k<lastColumn; k++) {
				Cell cell = row.getCell(k);
				String columnValues = cell.getStringCellValue().trim();
				testData.put((String) list.get(k), columnValues);
				//System.out.println(columnValues);
			}
			testDataAllRows.add(testData);
		}
		
		return testDataAllRows;
	}
	
	public void getScreenshots(String MethodName, WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File srcFile = ts.getScreenshotAs(OutputType.FILE);
		String Path = System.getProperty("user.dir")+"\\reports\\"+MethodName+".png";
		FileUtils.copyFile(srcFile, new File(Path));
	}
}
