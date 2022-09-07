package org.test;

import org.base.BaseClass;
import org.openqa.selenium.By;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Task extends BaseClass {

	public static void main(String[] args) {
		
		launchBrowser("chrome");
		driver.manage().window().maximize();
		implicitlywait(10);
		urlLaunch("https://www.flipkart.com/");
		
		
		
	}
}
