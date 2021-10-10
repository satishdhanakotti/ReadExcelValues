package Repository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ObjectRepo {

	public WebDriver driver;

	public ObjectRepo(WebDriver driver) {
		this.driver = driver;
	}

	// Login
	By userName = By.xpath("//*[@id='user_name']");
	By password = By.xpath("//*[@id='password']");
	By login = By.xpath("/html/body/section/div/div/div/div[2]/div/div/form[1]/div/div[3]/button");

	// ShipFrom Clear
	By Clear = By.xpath("//*[@id='fromClearId']");

	// ShipFrom
	By SF_companyName = By.xpath("//*[@id='shipFromCompanyId']");
	By SF_Address1 = By.xpath("//*[@id='shipFromAddress1Id']");
	By SF_Zip = By.xpath("//*[@id='shipFromPostalCodeId']");
	By SF_Phone = By.xpath("//*[@id='shipFromPhoneId']");
	By SF_Email = By.xpath("//*[@id='shipFromEmailAddressId']");
	By SF_Attention = By.xpath("//*[@id='shipFromAttentionId']");
	By SF_Instruction = By.xpath("//*[@id='shipFromInstructionId']");

	// ShipTo
	By ST_companyName = By.xpath("//*[@id='shipToCompanyId']");
	By ST_Address1 = By.xpath("//*[@id='shipToAddress1Id']");
	By ST_Zip = By.xpath("//*[@id='shipToPostalCodeId']");
	By ST_Phone = By.xpath("//*[@id='shipToPhoneId']");
	By ST_Email = By.xpath("//*[@id='shipToEmailAddressId']");
	By ST_Attention = By.xpath("//*[@id='shipToAttentionId']");
	By ST_Instruction = By.xpath("//*[@id='shipToInstructionId']");

	// Packages
	By Weight = By.xpath("//*[@id='packageTableId']/tbody/tr/td[2]/div/input");
	By Length = By.xpath("//*[@id='packageTableId']/tbody/tr/td[3]/div/input");
	By Width = By.xpath("//*[@id='packageTableId']/tbody/tr/td[4]/div/input");
	By Height = By.xpath("//*[@id='packageTableId']/tbody/tr/td[5]/div/input");
	
	//GetRates
	By GetRates = By.xpath("//*[@id='getRatesId']");

	// UserName
	public WebElement userName() {
		return driver.findElement(userName);
	}

	// Password
	public WebElement password() {
		return driver.findElement(password);
	}

	// Login
	public WebElement login() {
		return driver.findElement(login);
	}

	// Cookies
	By Cookies = By.xpath("//*[@id='acceptcookie']");

	// Accept Cookies
	public WebElement cookies() {
		return driver.findElement(Cookies);
	}

	// Ship From Clear
	public WebElement SF_Clear() {
		// TODO Auto-generated method stub
		return driver.findElement(Clear);
	}

	// SF_CompanyName
	public WebElement SF_companyName() {
		return driver.findElement(SF_companyName);
	}

	// SF_Address1
	public WebElement SF_address1() {
		return driver.findElement(SF_Address1);
	}

	// SF_Zip
	public WebElement SF_zip() {
		return driver.findElement(SF_Zip);
	}

	// SF_Phone#
	public WebElement SF_phone() {
		return driver.findElement(SF_Phone);
	}

	// SF_Email
	public WebElement SF_email() {
		return driver.findElement(SF_Email);
	}

	// SF_Attention
	public WebElement SF_attention() {
		return driver.findElement(SF_Attention);
	}

	// SF_Instruction
	public WebElement SF_instruction() {
		return driver.findElement(SF_Instruction);
	}

	// ST_CompanyName
	public WebElement ST_companyName() {
		return driver.findElement(ST_companyName);
	}

	// ST_Address1
	public WebElement ST_address1() {
		return driver.findElement(ST_Address1);
	}

	// ST_Zip
	public WebElement ST_zip() {
		return driver.findElement(ST_Zip);
	}

	// ST_Phone#
	public WebElement ST_phone() {
		return driver.findElement(ST_Phone);
	}

	// ST_Email
	public WebElement ST_email() {
		return driver.findElement(ST_Email);
	}

	// ST_Attention
	public WebElement ST_attention() {
		return driver.findElement(ST_Attention);
	}

	// ST_Instruction
	public WebElement ST_instruction() {
		return driver.findElement(ST_Instruction);
	}

	// Weight
	public WebElement Weight() {
		return driver.findElement(Weight);
	}

	// Length
	public WebElement Length() {
		return driver.findElement(Length);
	}

	// Width
	public WebElement Width() {
		return driver.findElement(Width);
	}

	// Height
	public WebElement Height() {
		return driver.findElement(Height);
	}
	
	// Get Rates
	public WebElement GetRates() {
		return driver.findElement(GetRates);
	}

}