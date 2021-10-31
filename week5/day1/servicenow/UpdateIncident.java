package week5.day1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class UpdateIncident extends ServiceNowBase {
	
	@Test
	public void runUpdateIncident() {
		
		String incident ="INC0010005";
		driver.findElement(By.xpath("(//input[@class='form-control'])[1]")).sendKeys(incident,Keys.ENTER);
		driver.findElement(By.cssSelector("a.linked.formlink")).click();
		Select urgency = new Select(driver.findElement(By.id("incident.urgency")));
		urgency.selectByValue("1");
		Select state1 = new Select(driver.findElement(By.id("incident.state")));
		state1.selectByVisibleText("In Progress");
		
		driver.findElement(By.xpath("//textarea[@placeholder='Work notes']")).sendKeys("Work In progress");
		driver.findElement(By.id("sysverb_update_bottom")).click();
		
		WebElement webTable = driver.findElement(By.className("list2_body"));
		List<WebElement> tableRows = webTable.findElements(By.tagName("tr"));
		WebElement row1 = tableRows.get(0);
		List<WebElement> tableCol = row1.findElements(By.tagName("td"));
		String priority = tableCol.get(6).getText();
		String changedState = tableCol.get(7).getText();
		if(changedState.equals("In Progress")) {
			System.out.println("State is Updated: "+changedState);
		}else
			System.out.println("Failed to Update State");
		if(priority.equals("3 - Moderate")) {
			System.out.println("Priority is Updated: "+priority);
		}else
			System.out.println("Failed to Update Priority");
	}
		
		
}
