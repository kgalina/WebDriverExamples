package com.example.example1;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SimpleTest {
	/* переход к URL, поиск по css, очистить поле, ввести значение в поле, проверить страницу по её title,
	проверить что выводится текст-заголовок на странице с результатами поиска */
	@Test
	public void openAndSearch() throws InterruptedException{
	WebDriver driver = new FirefoxDriver();
	driver.manage().window().maximize(); //раскрыть окно браузера на весь экран
	driver.get("http://rozetka.com.ua/");
	
	WebElement searchField = driver.findElement(By.cssSelector(".header-search-input-text.passive"));
	searchField.clear();
	searchField.sendKeys("золотые серьги");
	
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	
	WebElement searchButton = driver.findElement(By.cssSelector(".btn-link-i"));
	searchButton.click();
	
	String expectedTitle = "Результаты поиска";
	Assert.assertEquals(expectedTitle, driver.getTitle());
	
	
	
	WebElement searchResultTitleText = driver.findElement(By.cssSelector(".search-result-title-text"));
	String expectedTitleText = "золотые серьги";
	Assert.assertEquals(expectedTitleText, searchResultTitleText.getText());
	
	Thread.sleep(5000); // 1000 милисекунд = 1 секунда. Пауза процесса перед выполнением закрытия браузера
	driver.close();
	
	}
	
	
	
}
