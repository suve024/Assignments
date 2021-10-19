package week2.day2;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ImageExercise {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://leafground.com/pages/Image.html");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// Click on this image to go home page
		driver.findElement(By.xpath("//img[contains(@src,'home')]")).click();
		driver.findElement(By.xpath("//img[@alt='Images']")).click();

		// Verify if Image is Broken
		String img = driver.findElement(By.xpath("//label[contains(text(),'Broken')]/following::img[1]"))
				.getAttribute("src");
		if (img != null) {
			try {
				HttpURLConnection urlconnection = (HttpURLConnection) (new URL(img).openConnection());
				int respCode;

				respCode = urlconnection.getResponseCode();

				if (respCode != 200) {
					System.out.println(img + " is broken.");

				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		//Click me using Keyboard or Mouse
		driver.findElement(By.xpath("//label[contains(text(),'Key')]/following::img")).click();
		driver.close();

	}
}
