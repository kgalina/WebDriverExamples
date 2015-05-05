package com.example.example1;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class ValuesFromDropDown {

	@Test
public void workWithDropDown() throws InterruptedException {
		
		WebDriver driver = new FirefoxDriver();
		
		driver.get("http://www.facebook.com"); //на примере facebook.com
		driver.manage().window().maximize();
		
		driver.findElement(By.linkText("English (US)")).click();
		
		//System.out.println(driver.findElements(By.linkText("English (US)")).size());
		
	/*WebElement monthDrop = driver.findElement(By.id("month"));
		
		List<WebElement> months = monthDrop.findElements(By.tagName("option"));
		for(int i=0; i<months.size(); i++){
			String value = months.get(i).getText();
			System.out.println(value);
		}*/
		
		driver.findElement(By.id("u_0_1")).sendKeys("Victor");
		driver.findElement(By.id("u_0_3")).sendKeys("Ralkin");
		driver.findElement(By.id("u_0_5")).sendKeys("vralkin@mail.ru");
		driver.findElement(By.id("u_0_8")).sendKeys("vralkin@mail.ru");
		driver.findElement(By.id("u_0_a")).sendKeys("azsxdcfv");
		
		Select monthDropDown = new Select(driver.findElement(By.id("month")));
		monthDropDown.selectByValue("4"); // select "apr" in dropdown
		
		Select dayDropDown = new Select(driver.findElement(By.id("day")));
		dayDropDown.selectByValue("30"); // select "31" in dropdown
		
		Select yearDropDown = new Select(driver.findElement(By.id("year")));
		yearDropDown.selectByValue("1998"); // select "1998" in dropdown
		
		driver.findElement(By.id("u_0_e")).click();
		
		driver.findElement(By.id("u_0_i")).click();
		
		
		Thread.sleep(4000);
		//driver.close();
		
	}

}