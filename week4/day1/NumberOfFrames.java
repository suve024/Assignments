package week4.day1;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NumberOfFrames {

	public static void main(String[] args) throws IOException {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/frame.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		WebElement frame1 = driver.findElement(By.xpath("(//div[@id='wrapframe']/iframe)[1]"));
		driver.switchTo().frame(frame1);
		
		//screenshot of the click me button of first frame
		WebElement button1 = driver.findElement(By.id("Click"));
		File src = button1.getScreenshotAs(OutputType.FILE);
		File des = new File("./snap/pic1.png");
		FileUtils.copyFile(src, des);
		
		driver.switchTo().defaultContent();
		//the count of the frames visible to the main page
		List<WebElement> findFrames = driver.findElements(By.tagName("iframe"));
		System.out.println("Number of frames visible to the main page : "+ findFrames.size());
		
		driver.close();
	}

}
