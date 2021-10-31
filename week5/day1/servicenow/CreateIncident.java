package week5.day1;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class CreateIncident extends ServiceNowBase {
	
	@Test
	public void runCreateIncident() {
	
	driver.findElement(By.id("sysverb_new")).click();
	driver.findElement(By.xpath("(//span[@class='icon icon-search'])[1]")).click();
	Set<String> winHandles = driver.getWindowHandles();
	List<String> winList = new ArrayList<String>(winHandles);
	driver.switchTo().window(winList.get(1));
	driver.findElement(By.xpath("//a[text()='Bridget Knightly']")).click();
	driver.switchTo().window(winList.get(0));
	driver.switchTo().frame("gsft_main");
	driver.findElement(By.id("incident.short_description")).sendKeys("Testing Automation script");
	String incidentNumber = driver.findElement(By.id("incident.number")).getAttribute("value");
	driver.findElement(By.id("sysverb_insert_bottom")).click();
	driver.findElement(By.xpath("//input[@class='form-control']")).sendKeys(incidentNumber,Keys.ENTER);
	
	//Verify the incident is created successful and take snapshot of the created incident
	String text = driver.findElement(By.xpath("//a[@class='linked formlink']")).getText();
	if(text.equals(incidentNumber)) {
		System.out.println("Incident "+ text+" created Successfully");
	}else
		System.out.println("Failed to create Incident");
	
	}
}
