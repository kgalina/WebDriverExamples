package com.example.example1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Assert;
import org.junit.Test;

public class CheckOpenPage {
	
	@Test
	 public void open(){
		//нужно предворительно скачать chromedriver и указать путь к нему		
		System.setProperty("webdriver.chrome.driver", "/home/kotik/bin/lib/chromedriver");
		WebDriver driver = new ChromeDriver();
		
			
	        driver.get("http://book.theautomatedtester.co.uk/chapter2");
	        String expected = "Selenium: Beginners Guide";
	       // System.out.println(driver.getTitle());
	       
	        Assert.assertEquals(expected, driver.getTitle());
		
}
}
   
    
    