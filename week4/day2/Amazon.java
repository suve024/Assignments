package week4.day2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazon {

	public static void main(String[] args) throws IOException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://www.amazon.in/");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		String search ="oneplus 9 pro";
		
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys(search,Keys.ENTER);
		
		String price1 = driver.findElement(By.className("a-price-whole")).getText();
		WebElement rating = driver.findElement(By.className("a-icon-alt"));
		
		System.out.println(rating.getText());
		
		Actions builder = new Actions(driver);
		builder.moveToElement(rating).click().perform();
		
		//% of reviews have 5 stars
		String percentageOfRating = driver.findElement(By.xpath("//table[@id='histogramTable']//tr[1]/td[3]//a")).getText();
		System.out.println("Reviews that have 5 stars: "+percentageOfRating);
		
		driver.findElement(By.xpath("(//div[@class='a-section a-spacing-none']/h2/a)[1]")).click();
		
		Set<String> winHandles = driver.getWindowHandles();
		List<String> winList = new ArrayList<String>(winHandles);
		driver.switchTo().window(winList.get(1));
		
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File des = new File("./snap/amazon.png");
		FileUtils.copyFile(src, des);
		
		driver.findElement(By.id("add-to-cart-button")).click();
		
		String subTotal = driver.findElement(By.xpath("//b[text()='Cart subtotal']/following::span[2]")).getText();

		if(subTotal.contains(price1)) {
			System.out.println("SubTotal is Correct");
		}else {
			System.out.println("SubTotal is Incorrect");
		}
		driver.quit();
	}

}
