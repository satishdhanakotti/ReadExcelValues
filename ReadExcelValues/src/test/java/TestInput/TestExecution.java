package TestInput;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import BaseClass.Base;
import Repository.ObjectRepo;

public class TestExecution extends Base {

	public WebDriver driver;

	List<Map<String, String>> testData;
	public ObjectRepo repo;

	@Test(priority = 1)
	public void InitilizeBrowser() throws IOException {

		driver = Browser();
		driver.get(prop.getProperty("url"));

		testData = getExcelData(0);

		repo = new ObjectRepo(driver);
		
		repo.userName().sendKeys(testData.get(0).get("UserName"));
		repo.password().sendKeys(testData.get(0).get("Password"));
		Assert.fail();
		repo.login().click();

		// Cookies
		repo.cookies().click();

	}

	@Test (dependsOnMethods = {"InitilizeBrowser"})
	public void ShipFrom() throws IOException, InterruptedException {
		testData = getExcelData(1);
		//repo.SF_Clear().click();
		Thread.sleep(3000);
		repo.SF_companyName().sendKeys(testData.get(0).get("CompanyName"));
		repo.SF_address1().sendKeys(testData.get(0).get("Address1"));
		repo.SF_zip().sendKeys(testData.get(0).get("PostalCode"));
		Thread.sleep(2000);
		repo.SF_phone().sendKeys(testData.get(0).get("Phone#"));
		// repo.SF_email().sendKeys(testData.get(0).get("Email"));
		repo.SF_attention().sendKeys(testData.get(0).get("Attention"));
		repo.SF_instruction().sendKeys(testData.get(0).get("Instruction"));
		Thread.sleep(2000);
		Actions act = new Actions(driver);
		act.sendKeys(Keys.PAGE_DOWN).build().perform();
	}

	@Test (dependsOnMethods = {"ShipFrom"})
	public void ShipTo() throws IOException, InterruptedException {

		testData = getExcelData(1);
		repo.ST_companyName().sendKeys(testData.get(1).get("CompanyName"));
		repo.ST_address1().sendKeys(testData.get(1).get("Address1"));
		repo.ST_zip().sendKeys(testData.get(1).get("PostalCode"));
		Thread.sleep(2000);
		repo.ST_phone().sendKeys(testData.get(1).get("Phone#"));
		// repo.ST_email().sendKeys(testData.get(1).get("Email"));
		repo.ST_attention().sendKeys(testData.get(1).get("Attention"));
		repo.ST_instruction().sendKeys(testData.get(1).get("Instruction"));

	}

	@Test(dependsOnMethods = {"ShipTo"})
	public void Packages() throws IOException {

		testData = getExcelData(2);

		repo.Weight().sendKeys(testData.get(0).get("Weight"));
		repo.Length().sendKeys(testData.get(0).get("Length"));
		repo.Width().sendKeys(testData.get(0).get("Width"));
		repo.Height().sendKeys(testData.get(0).get("Height"));

	}

	@Test(dependsOnMethods = {"Packages"})
	public void GetRates() {

		repo.GetRates().click();

	}

}