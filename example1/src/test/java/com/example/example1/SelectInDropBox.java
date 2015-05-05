package com.example.example1;


import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectInDropBox {
 // на примере https://events.developerforce.com/signup
	@Test
	public void test() throws InterruptedException {
		
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		//wait for page load
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get("https://events.developerforce.com/signup");
		
		WebElement element = driver.findElement(By.id("job_role"));
		
		//Assign Select object
		Select dropDown = new Select(element);
		
		//Select value by text
		
		dropDown.selectByVisibleText("Administrator");
		Thread.sleep(3000);
		
		//get drop box size
		int listSize = dropDown.getOptions().size();
		// Select last value by index
		dropDown.selectByIndex(listSize-1);
		
		List<WebElement> jobRole = element.findElements(By.tagName("option"));
			for(int i=0; i<listSize; i++){
			String value = jobRole.get(i).getText();
			System.out.println(value);
		
			}
			
		//dropDown.selectByIndex(1);
		}

}
