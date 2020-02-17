package com.offlineweb.www;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class Ido {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","/Users/sivaprakash/eclipse-workspace/chromedriver");
		WebDriver dr = new ChromeDriver();
		dr.get("https://klqa.veri5digital.com/dummy-app/#/index/");
		JavascriptExecutor js = (JavascriptExecutor) dr;
		dr.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS) ;
//		dr.manage().window().maximize();
		 
		dr.findElement(By.id("clientCode")).clear();
		WebElement ClientCode = dr.findElement(By.id("clientCode"));
		ClientCode.sendKeys("Cl99");
		dr.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS) ;
		dr.findElement(By.id("apiKey")).clear();
		WebElement ApiKey = dr.findElement(By.id("apiKey"));
		ApiKey.sendKeys("newapi3");
		dr.findElement(By.id("otpRequired")).clear();
		WebElement OtpStatus = dr.findElement(By.id("otpRequired"));
		OtpStatus.sendKeys("N");
		dr.findElement(By.className("buttons")).click();
		dr.findElement(By.id("btn-pay")).click();
		Thread.sleep(2000);
		
		
		Thread.sleep(2000);
		WebElement IDO = dr.findElement(By.xpath("//h5[contains(text(),\"UIDAI_XML I'll do it myself\")]"));
		IDO.click();
		
		
		/* Scroll down
    	js.executeScript("window.scrollTo(0, document.body.scrollHeight)"); */
		
		
		
		WebElement Proceed = dr.findElement(By.xpath("//button[@class='btn btn-block kl-button']"));
		Proceed.click();  
		Thread.sleep(3000);
		 
		 //Closing the window
		ArrayList<String> tabs = new ArrayList<String>(dr.getWindowHandles());
		dr.switchTo().window(tabs.get(1));
		dr.close();
		dr.switchTo().window(tabs.get(0));
		
		Thread.sleep(2000);
		
		// File upload
	    String ClaimZIP = "/Users/sivaprakash/Offline_Aadhaar/offlineaadhaar20191119054710944.xml";
		dr.findElement(By.xpath("//input[@id='file1']")).sendKeys(ClaimZIP);
		Thread.sleep(1000);
		
		
		// Clicking checkbox
		WebElement consent = dr.findElement(By.xpath("/html/body/app-root/div/app-main/div/app-upload-file/div/div/div/form/div/div[4]/label/input"));
		JavascriptExecutor executor = (JavascriptExecutor)dr;
		executor.executeScript("arguments[0].click();", consent);
		Thread.sleep(2000);

		dr.findElement(By.xpath("/html/body/app-root/div/app-main/div/app-upload-file/div/div/div/form/button")).click();
		Thread.sleep(6000);
		
		WebElement ApiKey2 = dr.findElement(By.xpath("//*[@id=\"apiKey\"]"));
		ApiKey2.sendKeys("newapi3");
		WebElement ClientCode2 = dr.findElement(By.xpath("//*[@id=\"clientCode\"]"));
		ClientCode2.sendKeys("Cl99");
		WebElement FetchKYCData = dr.findElement(By.xpath("//*[@id=\"btn-pay\"]"));
		FetchKYCData.click();


	}

}
