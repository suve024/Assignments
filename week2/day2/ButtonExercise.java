package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ButtonExercise {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://leafground.com/pages/Button.html");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//Click button to travel home page
		driver.findElement(By.id("home")).click();
		driver.findElement(By.xpath("//img[@alt='Buttons']")).click();
		
		//Find position of button (x,y)
		System.out.println(driver.findElement(By.id("position")).getLocation());
		
		//Find button color
		System.out.println(driver.findElement(By.id("color")).getCssValue("background-color"));
		
		//Find the height and width
		System.out.println(driver.findElement(By.id("color")).getSize());
		
		driver.close();
	}

}
