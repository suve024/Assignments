package week4.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnResizable {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://jqueryui.com/resizable/");

		driver.switchTo().frame(0);
		
		WebElement ele = driver.findElement(By.xpath("//div[@id='resizable']/div[3]"));
		
		Actions builder = new Actions(driver);
		builder.dragAndDropBy(ele, -10, -50).perform();
	}

}
