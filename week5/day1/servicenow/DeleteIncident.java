package week5.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class DeleteIncident extends ServiceNowBase {
	
	@Test
	public void runDeleteIncident() throws InterruptedException {
		
		String incident ="INC0010005";
		driver.findElement(By.xpath("(//input[@class='form-control'])[1]")).sendKeys(incident,Keys.ENTER);
		driver.findElement(By.cssSelector("a.linked.formlink")).click();
		driver.findElement(By.id("sysverb_delete")).click();
		driver.findElement(By.id("ok_button")).click();
		
		Thread.sleep(1000);
		WebElement webTable = driver.findElement(By.className("list2_body"));
		WebElement tableRows = webTable.findElement(By.tagName("tr"));
		String text = tableRows.findElement(By.tagName("td")).getText();		
		if(text.equals("No records to display")) {
			System.out.println("Indicent "+incident+" is succesfully deleted");
		}else
			System.out.println("Failed to delete incident");
		
	}
		
		
}
