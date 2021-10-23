package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeContact {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.id("username")).sendKeys("Demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		driver.findElement(By.xpath("//a[text()='Merge Contacts']")).click();
		driver.findElement(By.xpath("//table[@id='widget_ComboBox_partyIdFrom']/following::a[1]")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> winList = new ArrayList<String>(windowHandles);
		
		//switch to new window
		driver.switchTo().window(winList.get(1));
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
		
		//switch back to main window
		driver.switchTo().window(winList.get(0));
		
		driver.findElement(By.xpath("//table[@id='widget_ComboBox_partyIdFrom']/following::a[2]")).click();
		Set<String> windowHandles1 = driver.getWindowHandles();
		List<String> winList1 = new ArrayList<String>(windowHandles1);
		
		//switch to new window
		driver.switchTo().window(winList1.get(1));
		
		driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[2]")).click();
		
		//switch back to main window
		driver.switchTo().window(winList1.get(0));
		driver.findElement(By.xpath("//a[text()='Merge']")).click();
		
		//Accept alert
		Alert alert = driver.switchTo().alert();
		alert.accept();
		
		//Verify the title of the page
		String title = driver.getTitle();		
		if(title.contains("View Contact")) {
			System.out.println("Title is : "+title+" \nMerge contact Successfull");
		}else
			System.out.println("Failed to Merge contact");	
		
		driver.close();
		
	}

}
