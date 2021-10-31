package week5.day1;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class AssignIncident extends ServiceNowBase {
	
	@Test
	public void runAssignIncident() {
		
		String incident ="INC0010005";
		driver.findElement(By.xpath("(//input[@class='form-control'])[1]")).sendKeys(incident,Keys.ENTER);
		
		driver.findElement(By.cssSelector("a.linked.formlink")).click();
		driver.findElement(By.id("lookup.incident.assignment_group")).click();
		Set<String> groupLookUp = driver.getWindowHandles();
		List<String> winList = new ArrayList<String>(groupLookUp);
		driver.switchTo().window(winList.get(1));
		driver.findElement(By.xpath("(//input[@placeholder='Search'])[1]")).sendKeys("Software",Keys.ENTER);
		driver.findElement(By.xpath("//a[text()='Software']")).click();
		driver.switchTo().window(winList.get(0));
		driver.switchTo().frame("gsft_main");
		driver.findElement(By.id("lookup.incident.assigned_to")).click();
		Set<String> assignedLookUp = driver.getWindowHandles();
		List<String> winList1 = new ArrayList<String>(assignedLookUp);
		driver.switchTo().window(winList1.get(1));
		driver.findElement(By.xpath("//a[text()='David Loo']")).click();
		driver.switchTo().window(winList1.get(0));
		driver.switchTo().frame("gsft_main");
		driver.findElement(By.xpath("//textarea[@id='activity-stream-textarea']")).sendKeys("Assigned to Software group");
		driver.findElement(By.id("sysverb_update_bottom")).click();
		
		WebElement webTable = driver.findElement(By.className("list2_body"));
		List<WebElement> tableRows = webTable.findElements(By.tagName("tr"));
		WebElement row1 = tableRows.get(0);
		List<WebElement> tableCol = row1.findElements(By.tagName("td"));
		String assignmentGroup = tableCol.get(9).getText();
		String assignedTo = tableCol.get(10).getText();
		if(assignmentGroup.equals("Software")) {
			System.out.println("assignment Group: "+assignmentGroup);
		}else
			System.out.println("Failed to Update assignment Group");
		if(assignedTo.equals("David Loo")) {
			System.out.println("Assigned to: "+assignedTo);
		}else
			System.out.println("Failed to assign");
	}
		
		
}
