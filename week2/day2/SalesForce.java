package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SalesForce {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();

		driver.get("https://www.salesforce.com/in/form/signup/freetrial-sales/?d=70130000000Enyk");

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.name("UserFirstName")).sendKeys("Swetha");
		driver.findElement(By.name("UserLastName")).sendKeys("S");
		driver.findElement(By.name("UserEmail")).sendKeys("swetha@gwt.com");

		Select jobTitle = new Select(driver.findElement(By.name("UserTitle")));
		jobTitle.selectByVisibleText("Operations Manager");

		driver.findElement(By.name("CompanyName")).sendKeys("GWT");
		
		Select employees = new Select(driver.findElement(By.name("CompanyEmployees")));
		employees.selectByValue("1600");

		driver.findElement(By.name("UserPhone")).sendKeys("8188752415");
		
		Select country = new Select(driver.findElement(By.name("CompanyCountry")));
		country.selectByVisibleText("India");
		
		WebElement ele = driver.findElement(By.xpath("(//div[@class='checkbox-ui'])[1]"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", ele);
		
		driver.findElement(By.xpath("//button[text()='start my free trial']"));
		driver.close();

	}

}
