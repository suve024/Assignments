package week2.day2;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LinkExercise {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://leafground.com/pages/Link.html");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//Go to Home Page
		driver.findElement(By.xpath("(//a[contains(@href,'home')])[2]")).click();
		driver.findElement(By.xpath("//img[@alt='Link']")).click();
		
		//Find where am supposed to go without clicking me?
		System.out.println(driver.findElement(By.xpath("//a[contains(@href,'Button')]")).getAttribute("href"));
		
		//Verify if link is broken?
		String url = driver.findElement(By.xpath("//a[text()='Verify am I broken?']")).getAttribute("href");
		
		if(url == null || url.isEmpty()) {
			System.out.println("URL is empty");
		}
		
		try {
		HttpURLConnection urlconnection = (HttpURLConnection) (new URL(url).openConnection());
		urlconnection.setRequestMethod("HEAD");
        
		urlconnection.connect();
        
        int respCode = urlconnection.getResponseCode();
        if(respCode >= 400){
            System.out.println(url+" is a broken link");
        }
        else{
            System.out.println(url+" is a valid link");
        }
		} catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
		
		//Interact with same link name
		driver.findElement(By.xpath("(//a[contains(@href,'home')])[3]")).click();
		driver.findElement(By.xpath("//img[@alt='Link']")).click();
		
		//How many links are available in this page?
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("Number of links available in this page is :"+links.size());
		driver.close();
	}

}
