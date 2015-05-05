package com.example.example1;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Locators {

	@Test
	public void test() {
		WebDriver driver = new FirefoxDriver();

		driver.get("http://www.indeed.co.uk");
		
		//driver.findElement(By.name("q")).sendKeys("Selenium");
		//driver.findElement(By.linkText("Post your CV")).click();
		//driver.findElement(By.partialLinkText("your CV")).click(); //поиск ссылки по содержащему указанный текст
		
		
		//Assert.assertEquals("Find Jobs", driver.findElement(By.cssSelector("input.input_submit")).getAttribute("value"));
	/*	String searchButton = driver.findElement(By.cssSelector("input.input_submit")).getAttribute("value");
		Assert.assertEquals("Find Jobs", searchButton);*/
		
		System.out.println(
				driver.findElements(By.tagName("a")).size()); // кол-во веб-элементов (в этом примере кол-во ссылок на странице)
		System.out.println(
				driver.findElement(By.tagName("a")).getText()); //поиск первого веб-элемента, соответвующего описанию
	
		System.out.println(
				driver.findElements(By.className("input_text")).size() ); 
		
			
	}
	

}
