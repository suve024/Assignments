package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FaceBook {

	public static void main(String[] args) {

		// Step 1: Download and set the path
		WebDriverManager.chromedriver().setup();

		// Step 2: Launch the chromebrowser
		ChromeDriver driver = new ChromeDriver();

		// Step 3: Load the URL https://en-gb.facebook.com/
		driver.get("https://en-gb.facebook.com/");

		// Step 4: Maximize the window
		driver.manage().window().maximize();

		// Step 5: Add implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// Step 6: Click on Create New Account button
		driver.findElement(By.xpath("//a[text()='Create New Account']")).click();

		// Step 7: Enter the first name
		driver.findElement(By.name("firstname")).sendKeys("Swetha");

		// Step 8: Enter the last name
		driver.findElement(By.name("lastname")).sendKeys("S");

		// Step 9: Enter the mobile number
		driver.findElement(By.name("reg_email__")).sendKeys("8188752415");

		// Step 10: Enter the password
		driver.findElement(By.id("password_step_input")).sendKeys("A4f7G2_jhc");

		// Step 11: Handle all the three drop downs
		Select day = new Select(driver.findElement(By.id("day")));
		day.selectByIndex(10);

		Select month = new Select(driver.findElement(By.id("month")));
		month.selectByVisibleText("Jul");

		Select year = new Select(driver.findElement(By.id("year")));
		year.selectByValue("1994");

		// Step 12: Select the radio button "Female"
		driver.findElement(By.xpath("(//input[@name='sex'])[1]")).click();

		driver.close();
	}

}
