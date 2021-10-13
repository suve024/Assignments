package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateLead {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.id("username")).sendKeys("Demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();

		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Create Lead")).click();

		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("GWT");
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Swetha");
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("S");
		driver.findElement(By.id("createLeadForm_firstNameLocal")).sendKeys("Swe");
		driver.findElement(By.id("createLeadForm_lastNameLocal")).sendKeys("S");
		driver.findElement(By.id("createLeadForm_personalTitle")).sendKeys("Ms.");
		driver.findElement(By.id("createLeadForm_generalProfTitle")).sendKeys("Programmer Analyst");
		driver.findElement(By.id("createLeadForm_birthDate")).sendKeys("7/29/95");
		driver.findElement(By.id("createLeadForm_departmentName")).sendKeys("IT");
		driver.findElement(By.id("createLeadForm_annualRevenue")).sendKeys("5000000");
		driver.findElement(By.id("createLeadForm_numberEmployees")).sendKeys("50000");
		driver.findElement(By.id("createLeadForm_sicCode")).sendKeys("7374");
		driver.findElement(By.id("createLeadForm_tickerSymbol")).sendKeys("AXP^");
		driver.findElement(By.id("createLeadForm_description")).sendKeys("Demo");
		driver.findElement(By.id("createLeadForm_importantNote")).sendKeys("New Lead");

		// contact information
		driver.findElement(By.id("createLeadForm_primaryPhoneAreaCode")).sendKeys("+91");
		driver.findElement(By.id("createLeadForm_primaryPhoneNumber")).sendKeys("8189952415");
		driver.findElement(By.id("createLeadForm_primaryPhoneExtension")).sendKeys("91");
		driver.findElement(By.id("createLeadForm_primaryPhoneAskForName")).sendKeys("Swetha");
		driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("swetha@gmail.com");
		driver.findElement(By.id("createLeadForm_primaryWebUrl")).sendKeys("https://www.google.com/");

		// Primary address
		driver.findElement(By.id("createLeadForm_generalToName")).sendKeys("Swetha");
		driver.findElement(By.id("createLeadForm_generalAttnName")).sendKeys("Swe");
		driver.findElement(By.id("createLeadForm_generalAddress1")).sendKeys("No.54, Gandhi Nagar");
		driver.findElement(By.id("createLeadForm_generalAddress2")).sendKeys("K.G.Road");
		driver.findElement(By.id("createLeadForm_generalCity")).sendKeys("Bangalore");
		driver.findElement(By.id("createLeadForm_generalPostalCode")).sendKeys("560009");
		driver.findElement(By.id("createLeadForm_generalPostalCodeExt")).sendKeys("560009");

		WebElement stateElement = driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));
		Select opt = new Select(stateElement);
		opt.selectByVisibleText("Indiana");

		String firstName = driver.findElement(By.id("createLeadForm_firstName")).getAttribute("value");

		System.out.println("First Name is : " + firstName);

		driver.findElement(By.name("submitButton")).click();
		System.out.println("The title is : " + driver.getTitle());
		if (driver.getTitle().contains("View Lead")) {
			System.out.println("The Title contains the word View Lead");
		} else {
			System.out.println("The Title does not contain the word View Lead ");
		}
		driver.findElement(By.linkText("Logout")).click();
		driver.close();
	}

}
