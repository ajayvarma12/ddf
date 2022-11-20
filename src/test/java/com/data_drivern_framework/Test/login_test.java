package com.data_drivern_framework.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;
import page.login_page;

public class login_test {
	public static WebDriver driver;
public login_page lb;
	@BeforeClass

	public void initBrowser() {
		
		

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
lb=new login_page(driver);
		
		
	}

	@Test(dataProvider="testdata")
	public void enterCred(String user, String pass) {

	lb.takecred(user, pass);
		
	}

	@DataProvider(name = "testdata")
	public Object[][] readfile() throws IOException {

		String filepath = System.getProperty("user.dir") + "\\test_data.xlsx";

		FileInputStream fis = new FileInputStream(filepath);

		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sh = wb.getSheet("Sheet1");
		int rows = sh.getLastRowNum();
		int cols = sh.getRow(1).getLastCellNum();
		
		
		Object[][] value = new Object[rows][cols];

		
		for (int i = 0; i <rows; i++) {

			XSSFRow rw = sh.getRow(i);
			for (int j = 0; j <cols; j++) {

				XSSFCell cl = rw.getCell(j);
				DataFormatter df = new DataFormatter();
				String data = df.formatCellValue(cl);
				value[i][j] = data;

			}

		}
		
		wb.close();
		fis.close();
return value;
	}

}
