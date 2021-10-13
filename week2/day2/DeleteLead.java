package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteLead {

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
		driver.findElement(By.xpath("//span[text()='Phone']")).click();
		driver.findElement(By.name("phoneAreaCode")).sendKeys("91");
		driver.findElement(By.name("phoneNumber")).sendKeys("8189952415");
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		WebElement firstElement = driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a"));
		String text = firstElement.getText();
		firstElement.click();
		driver.findElement(By.className("subMenuButtonDangerous")).click();
		driver.findElement(By.xpath("//a[text()='Find Leads']")).click();
		driver.findElement(By.xpath("//input[@name='id']")).sendKeys(text);
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		String text2 = driver.findElement(By.xpath("//div[text()='No records to display']")).getText();
		if(text2.contains("No records to display")) {
			System.out.println("Successfully Deleted Lead id: "+text);
		}else {
			System.out.println("Error in deletion");
		}
		driver.close();		
	}

}
