package org.demo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MobileList {
	
public static void main(String[] args) throws InterruptedException {
	
	WebDriverManager.edgedriver().setup();
			
	WebDriver driver = new EdgeDriver();
			
	driver.manage().window().maximize();
	
	driver.get("https://www.amazon.com/");
	
	Thread.sleep(2000);
	
	WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
	
	searchBox.sendKeys("Iphone 15 pro max",Keys.ENTER);
	
    List<WebElement> iphoneList = driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
     
	List<WebElement> priceList = driver.findElements(By.xpath("//span[@class='a-price-whole']"));
	
	for(int i=0; i<iphoneList.size(); i++) {
		
		WebElement phoneName = iphoneList.get(i);
		
		String phone = phoneName.getText();
		
		WebElement priceName = priceList.get(i);
		
		String price = priceName.getText();
		
		System.out.println("PhoneName : "+phone+" "+"Price : "+price);
	}
		
	}
}
