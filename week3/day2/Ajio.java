package week3.day2;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Ajio {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.ajio.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.name("searchVal")).sendKeys("bags",Keys.ENTER);
		driver.findElement(By.xpath("//label[@for='Men']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//label[contains(@for,'Fashion Bags')]")).click();
		System.out.println("*************");
		System.out.println("Total number of items: "+driver.findElement(By.xpath("//div[@class='length']")).getText());
		List<WebElement> brandList = driver.findElements(By.xpath("//div[@class='brand']"));
		System.out.println("*************");
		System.out.println("Brands List: ");
		for (WebElement webElement : brandList) {
			System.out.println(webElement.getText());
		}
		
		List<WebElement> bagNameList = driver.findElements(By.xpath("//div[@class='name']"));
		System.out.println("*************");
		System.out.println("Bags Name : ");
		for (WebElement webElement1 : bagNameList) {
			System.out.println(webElement1.getText());
		}
		driver.close();
	}
}
