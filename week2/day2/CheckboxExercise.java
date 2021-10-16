package week2.day2;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckboxExercise {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://leafground.com/pages/checkbox.html");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//To select the languages
		driver.findElement(By.xpath("//div[contains(text(),'Java')]/input")).click();
		driver.findElement(By.xpath("//div[contains(text(),'SQL')]/input")).click();
		driver.findElement(By.xpath("//div[contains(text(),'C++')]/input")).click();
		
		//Confirm Selenium is checked
		 WebElement checked = driver.findElement(By.xpath("//div[contains(text(),'Selenium')]/input"));
		 boolean selected = checked.isSelected();
		 if(selected == true) {
			System.out.println("Is Checked");
		}else {
			System.out.println("Not Checked");
		}
		 
		 //DeSelect only checked
		 List<WebElement> selected2 = driver.findElements(By.xpath("//div[contains(text(),'Selected')]/input"));
		 int size1 = selected2.size();
		 for (int j = 0; j < size1; j++) {
				if(selected2.get(j).isSelected()) {
					selected2.get(j).click();
				}else {
					System.out.println("Not checked");
				}
			}
		 
		 //Select all below checkboxes
		 List<WebElement> findElement = driver.findElements(By.xpath("//div[contains(text(),'Option')]/input"));
		 int size = findElement.size();
		 for (int i = 0; i < size; i++) {
			findElement.get(i).click();
		}
	}

}
