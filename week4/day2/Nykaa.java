package week4.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Nykaa {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.nykaa.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		Actions builder = new Actions(driver);
		builder.moveToElement(driver.findElement(By.xpath("//a[text()='brands']"))).perform();
		driver.findElement(By.id("brandSearchBox")).sendKeys("L'Oreal Paris", Keys.ENTER);
		driver.findElement(By.linkText("L'Oreal Paris")).click();

		if (driver.getTitle().contains("L'Oreal Paris")) {
			System.out.println("Verified Title contains L'Oreal Paris");
		} else
			System.out.println("Wrong Page");

		driver.findElement(By.className("sort-name")).click();
		driver.findElement(By.xpath("//span[text()='customer top rated']")).click();

		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[text()='Category']")).click();
		driver.findElement(By.xpath("//span[text()='Hair']")).click();
		driver.findElement(By.xpath("//span[text()='Hair Care']")).click();
		driver.findElement(By.xpath("//span[text()='Shampoo']")).click();

		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[text()='Concern']")).click();
		driver.findElement(By.xpath("//span[text()='Color Protection']")).click();
		List<WebElement> filter = driver.findElements(By.className("filter-value"));
		for (WebElement webElement : filter) {
			String text = webElement.getText();
			if (text.contains("Shampoo")) {
				System.out.println("Filter is applied with Shampoo");
				break;
			}
		}

		driver.findElement(By.xpath("//div[contains(text(),'Paris Colour Protect Shampoo')]")).click();

		Set<String> winHandles = driver.getWindowHandles();
		List<String> winList = new ArrayList<String>(winHandles);
		driver.switchTo().window(winList.get(1));

		Select size = new Select(driver.findElement(By.tagName("Select")));
		size.selectByValue("0");

		String mrp = driver.findElement(By.xpath("//span[text()='MRP:']/following-sibling::span")).getText();
		System.out.println("MRP: " + mrp);

		driver.findElement(By.xpath("//span[text()='ADD TO BAG']")).click();

		driver.findElement(By.className("cart-count")).click();

		driver.switchTo().frame(0);

		String GrandTotal = driver.findElement(By.xpath("//div[contains(@class,'value medium-strong')]")).getText();
		System.out.println("Grand Total: " + GrandTotal);

		driver.findElement(By.xpath("//span[text()='Proceed']")).click();

		driver.switchTo().defaultContent();

		driver.findElement(By.xpath("//button[contains(text(),'GUEST')]")).click();

		String GrandT = driver.findElement(By.xpath("//div[contains(@class,'grand-total')]//span")).getText();

		if (GrandTotal.contains(GrandT)) {
			System.out.println("GrandTotal Matches: " + GrandT);
		} else {
			System.out.println("Not Matched");
		}

		driver.quit();
	}

}
