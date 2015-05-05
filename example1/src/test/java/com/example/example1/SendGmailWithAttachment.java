package com.example.example1;



import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SendGmailWithAttachment {

	@Test
	public void test() throws InterruptedException, AWTException {
		
		WebDriver driver = new FirefoxDriver();
		driver.get("http://www.gmail.com");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		driver.findElement(By.id("Email")).sendKeys("testviawebdriver@gmail.com");
		driver.findElement(By.id("Passwd")).sendKeys("9663096630");
		driver.findElement(By.id("signIn")).click();
		Thread.sleep(4000);
		//click on НАПИСАТЬ and add the to mail id, and subject
        driver.findElement(By.xpath("//div[contains(text(), 'НАПИСАТЬ')]")).click();
        
        driver.findElement(By.xpath("//form[1]//textarea[1]")).sendKeys("testviawebdriver@gmail.com");
        //fill subject field
        driver.findElement(By.xpath("//div[@class='aoD az6']//input[@class='aoT']")).sendKeys("mail from WebDriver");
        
        //fill mailBody
        WebElement frame1 = driver.findElement(By.cssSelector("div[class='Am Al editable LW-avf']"));
        frame1.click();
        frame1.sendKeys("Я к вам пишу – чего же боле?" + '\n'+ "Что я могу еще сказать?" + '\n' + "Лишь только файлик переслать");
        
        Thread.sleep(3000);
        //click on attachment icon
        driver.findElement(By.xpath("//div[@class='a1 aaA aMZ']")).click();
     
      
        StringSelection ss = new StringSelection("/home/kotik/learn/Deit.sql");
        //upload  file via RobotClass
       //attach  path where file is located.
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
        Robot robot = new Robot();
        Thread.sleep(5000);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_V);
        Thread.sleep(6000);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(10000);
       
        //Click on send
        driver.findElement(By.xpath("//div[text()='Отправить']")).click();
       
      
      //  driver.close();
		
		
	}

}