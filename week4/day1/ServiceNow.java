package week4.day1;

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
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ServiceNow {

	public static void main(String[] args) throws IOException {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://dev63446.service-now.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.switchTo().frame("gsft_main");
		driver.findElement(By.id("user_name")).sendKeys("admin");
		driver.findElement(By.id("user_password")).sendKeys("G00dlu@k3#8");
		driver.findElement(By.id("sysverb_login")).click();
		driver.findElement(By.id("filter")).sendKeys("incident");
		driver.findElement(By.xpath("(//div[text()='All'])[2]")).click();
		driver.switchTo().frame("gsft_main");
		
		//Create new Incident
		driver.findElement(By.id("sysverb_new")).click();
		driver.findElement(By.xpath("(//span[@class='icon icon-search'])[1]")).click();
		Set<String> winHandles = driver.getWindowHandles();
		List<String> winList = new ArrayList<String>(winHandles);
		driver.switchTo().window(winList.get(1));
		driver.findElement(By.xpath("//a[text()='Abel Tuter']")).click();
		driver.switchTo().window(winList.get(0));
		driver.switchTo().frame("gsft_main");
		driver.findElement(By.id("incident.short_description")).sendKeys("Automation Testing");
		String incidentNumber = driver.findElement(By.id("incident.number")).getAttribute("value");
		driver.findElement(By.id("sysverb_insert_bottom")).click();
		driver.findElement(By.xpath("//input[@class='form-control']")).sendKeys(incidentNumber,Keys.ENTER);
		
		//Verify the incident is created successful and take snapshot of the created incident
		String text = driver.findElement(By.xpath("//a[@class='linked formlink']")).getText();
		if(text.contains(incidentNumber)) {
			System.out.println("Incident "+ text+" created Successfully");
			File src = driver.getScreenshotAs(OutputType.FILE);
			File des = new File("./snap/incident.png");
			FileUtils.copyFile(src, des);
		}else
			System.out.println("Failed to create Incident");
		
		driver.close();
		
	}

}
