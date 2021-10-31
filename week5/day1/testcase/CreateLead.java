package testcase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class CreateLead extends BaseClass {

	@Test
	public void runCreateLead() {

		driver.findElement(By.linkText("Create Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("GWT");
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Sruthi");
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("R");
		driver.findElement(By.id("createLeadForm_generalProfTitle")).sendKeys("Programmer Analyst");
		driver.findElement(By.id("createLeadForm_departmentName")).sendKeys("IT");
		driver.findElement(By.id("createLeadForm_annualRevenue")).sendKeys("5000000");
		driver.findElement(By.id("createLeadForm_numberEmployees")).sendKeys("50000");
		driver.findElement(By.id("createLeadForm_sicCode")).sendKeys("7374");
		driver.findElement(By.id("createLeadForm_tickerSymbol")).sendKeys("AXP^");
		driver.findElement(By.id("createLeadForm_description")).sendKeys("Demo");
		driver.findElement(By.id("createLeadForm_importantNote")).sendKeys("New Lead");

		// contact information
		driver.findElement(By.id("createLeadForm_primaryPhoneNumber")).sendKeys("8989952415");
		driver.findElement(By.id("createLeadForm_primaryPhoneExtension")).sendKeys("91");
		driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("sruthi@gmail.com");
		driver.findElement(By.id("createLeadForm_primaryWebUrl")).sendKeys("https://www.google.com/");

		// Primary address
		driver.findElement(By.id("createLeadForm_generalAddress1")).sendKeys("No.54, Gandhi Nagar");
		driver.findElement(By.id("createLeadForm_generalAddress2")).sendKeys("K.G.Road");
		driver.findElement(By.id("createLeadForm_generalCity")).sendKeys("Bangalore");
		driver.findElement(By.id("createLeadForm_generalPostalCode")).sendKeys("560009");
		driver.findElement(By.id("createLeadForm_generalPostalCodeExt")).sendKeys("560009");
		// createLeadForm_generalCountryGeoId

		WebElement stateElement = driver.findElement(By.id("createLeadForm_generalCountryGeoId"));
		Select opt = new Select(stateElement);
		opt.selectByValue("IND");
		driver.findElement(By.name("submitButton")).click();
		System.out.println("The title is : " + driver.getTitle());
		if (driver.getTitle().contains("View Lead")) {
			System.out.println("The Title contains the word View Lead");
		} else {
			System.out.println("The Title does not contain the word View Lead ");
		}

	}

}
