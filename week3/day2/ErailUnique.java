package week3.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ErailUnique {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		ChromeOptions option = new ChromeOptions();
		option.addArguments("incognito");
		ChromeDriver driver = new ChromeDriver(option);
		driver.manage().window().maximize();		
		driver.get("https://erail.in/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.id("chkSelectDateOnly")).click();
		driver.findElement(By.id("txtStationFrom")).clear();
		driver.findElement(By.id("txtStationFrom")).sendKeys("Chennai");
		Thread.sleep(1000);
		List<WebElement> options =driver.findElements(By.xpath("//div[@class='autocomplete'] /div"));
		for (WebElement webElement1 : options) {
			if(webElement1.getAttribute("title").equalsIgnoreCase("Mgr Chennai Ctr")) {
				webElement1.click();
				break;
			}
		}
		driver.findElement(By.id("txtStationTo")).clear();
		driver.findElement(By.id("txtStationTo")).sendKeys("Bengaluru");
		Thread.sleep(1000);
		List<WebElement> options1 =driver.findElements(By.xpath("//div[@class='autocomplete'] /div"));
		for (WebElement webElement2 : options1) {
			if(webElement2.getAttribute("title").equalsIgnoreCase("Ksr Bengaluru")) {
				webElement2.click();
				break;
			}
		}
		Thread.sleep(2000);
		List<WebElement> element = driver.findElements(By.xpath("//a[contains(@title,'number')]/following::a[1]"));
		List<String> list1 = new ArrayList<String>();
		for (WebElement webElement : element) {
			String attribute = webElement.getAttribute("title");
			list1.add(attribute);
		}
		
		System.out.println("Size of list: " +list1.size());
		Set<String> strSet = new HashSet<String>();
		for (int i = 0; i < list1.size(); i++) {
			strSet.addAll(list1);
		}
		System.out.println("Unique Train names: "+ strSet);
		System.out.println("Size of unique set: " + strSet.size());
		driver.close();
	}

}
