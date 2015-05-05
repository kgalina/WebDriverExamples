package com.example.example1;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class IndusTest {

	@Test
	public void indeedJobSearch() throws InterruptedException {
		
		WebDriver driver = new FirefoxDriver();

		
		driver.get("http://www.indeed.co.uk");
		driver.findElement(By.id("what")).sendKeys("Selenium");
		Thread.sleep(2000);
		driver.findElement(By.id("where")).clear();
		Thread.sleep(2000);
		driver.findElement(By.id("where")).sendKeys("London");
		Thread.sleep(2000);
		driver.findElement(By.id("fj")).click();
		
		
		driver.findElement(By.id("searchCount")).getText();
		
		
		System.out.println(driver.findElement(By.id("searchCount")).getText());
		Assert.assertEquals("Selenium Jobs, vacancies in London | Indeed.co.uk", driver.getTitle());
		
		driver.close();
		
	}

}
