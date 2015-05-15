package com.example.example1;

import static org.junit.Assert.*;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.HasInputDevices;
import org.openqa.selenium.interactions.Keyboard;

public class KeyBoardActionsAndWindowHandle {
// Update web page via F5, open new page CRTL+SHIFT+P, get "yandex.ru" on new page
	@Test
	public void test() throws InterruptedException {
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get("http://www.google.com");
		Thread.sleep(4000);
		
		//Assign Keyboard object
		Keyboard keyboard = ((HasInputDevices)driver).getKeyboard();
		
		//Update page via F5
		keyboard.pressKey(Keys.F5);
		Thread.sleep(4000);
		
		//Open new window
		keyboard.sendKeys(Keys.CONTROL, Keys.SHIFT, "P");
		
		//Get the handle of parent window
		String handle = driver.getWindowHandle();
		
		//Get all the window handles
		Set<String> handles = driver.getWindowHandles();
		
		/*int hndl = handles.size();
		System.out.println(hndl);*/
		
		for(String hnd:handles){ //loop through each handle
			//check if the handle is not parentKK
			if(!hnd.equals(handle)){
				driver.switchTo().window(hnd);	//change the control to second window
			}
		
		}
		
		
		driver.get("http://www.yandex.ru");
		assertEquals("Яндекс", driver.getTitle());
		assertEquals("http://www.yandex.ua/", driver.getCurrentUrl());
		
		driver.switchTo().window(handle);
		driver.close();
		
		
	}

}
