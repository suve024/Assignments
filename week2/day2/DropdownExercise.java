package week2.day2;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropdownExercise {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://leafground.com/pages/Dropdown.html");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//Select training program using Index
		Select dropdown = new Select(driver.findElement(By.id("dropdown1")));
		List<WebElement> opt = dropdown.getOptions();
		int size = opt.size();
		dropdown.selectByIndex(size - 2);
		
		//Select training program using Text
		Select dropdown2 = new Select(driver.findElement(By.name("dropdown2")));
		dropdown2.selectByVisibleText("Selenium");
		
		//Select training program using Value
		Select dropdown3 = new Select(driver.findElement(By.id("dropdown3")));
		dropdown3.selectByValue("2");
		
		//Get the number of dropdown options
		Select dropdown4 = new Select(driver.findElement(By.className("dropdown")));
		List<WebElement> opt1 = dropdown4.getOptions();
		System.out.println("Number of dropdown options available : "+ opt1.size());
		
		//Use sendKeys to select
		driver.findElement(By.xpath("//div[@class='example'][5]/select")).sendKeys("Loadrunner");
		
		//Select your programs
		Select dropdown5 = new Select(driver.findElement(By.xpath("//div[@class='example'][6]/select")));
		dropdown5.selectByIndex(2);
		dropdown5.selectByIndex(4);
		
	}

}
