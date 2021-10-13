package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DuplicateLead {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.id("username")).sendKeys("Demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.xpath("//a[text()='Find Leads']")).click();
		driver.findElement(By.xpath("//span[text()='Email']")).click();
		driver.findElement(By.name("emailAddress")).sendKeys("swetha@gmail.com");
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		WebElement firstElement = driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-firstName']/a"));
		String text = firstElement.getText();
		firstElement.click();
		driver.findElement(By.linkText("Duplicate Lead")).click();
		if (driver.getTitle().contains("Duplicate Lead")) {
			System.out.println("The Title of the page is : " + driver.getTitle());
		} else {
			System.out.println("failed");
		}
		driver.findElement(By.name("submitButton")).click();
		String attribute = driver.findElement(By.id("viewLead_firstName_sp")).getText();
		if (attribute.contains(text)) {
			System.out.println("Duplicate Lead is Successfull");
		} else {
			System.out.println("Failed to Duplicate Lead");
		}
		driver.close();
	}

}
