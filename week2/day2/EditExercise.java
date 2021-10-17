package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditExercise {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://leafground.com/pages/Edit.html");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// Enter your email address
		driver.findElement(By.id("email")).sendKeys("swetha@gmail.com");

		// Append a text and press keyboard tab
		driver.findElement(By.xpath("//*[@id='contentblock']/section/div[2]/div/div/input")).sendKeys(" Testleaf", Keys.TAB);


		// Get default text entered
		String attribute = driver.findElement(By.name("username")).getAttribute("value");
		System.out.println("Default text entered is : " + attribute);

		// Clear the text
		driver.findElement(By.xpath("(//input[@name='username'])[2]")).clear();

		// Confirm that edit field is disabled
		boolean enabled = driver.findElement(By.xpath("//input[@disabled='true']")).isEnabled();
		if (!enabled) {
			System.out.println("Edit field is disabled");
		} else {
			System.out.println("Field is editable");
		}
	}

}
