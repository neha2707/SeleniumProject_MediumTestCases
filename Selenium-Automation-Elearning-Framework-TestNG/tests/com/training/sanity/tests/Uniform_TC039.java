package com.training.sanity.tests;

import static org.testng.Assert.assertTrue;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.UniformAccountPOM;
import com.training.pom.UniformAdminDashboardPOM;
import com.training.pom.UniformAdminLoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class Uniform_TC039 {
	
				private WebDriver driver;
				private String adminUrl;
				private UniformAdminLoginPOM uniformadminloginPOM;
				private UniformAdminDashboardPOM uniformadmindashboardPOM;
				private static Properties properties;
				private ScreenShot screenShot;
				

				@BeforeClass
				public static void setUpBeforeClass() throws IOException {
					properties = new Properties();
					FileInputStream inStream = new FileInputStream("./resources/others.properties");
					properties.load(inStream);
				}

				@BeforeMethod
				public void setUp() throws Exception {
					driver = DriverFactory.getDriver(DriverNames.CHROME);
					uniformadminloginPOM = new UniformAdminLoginPOM(driver); 
					uniformadmindashboardPOM = new UniformAdminDashboardPOM(driver);
					adminUrl = properties.getProperty("adminURL");
					screenShot = new ScreenShot(driver); 
					// open the browser 
					driver.get(adminUrl);
				}
				
				@AfterMethod
				public void tearDown() throws Exception {
					Thread.sleep(1000);
					driver.quit();
				}
				
				@Test
				public void validLoginTest() throws InterruptedException {
					
					uniformadminloginPOM.sendUsername("admin");
					uniformadminloginPOM.sendPassword("admin@123");
					uniformadminloginPOM.login();
					Thread.sleep(1000);
					//String ErrMess = uniformadminloginPOM.ValidateErrorMessage();
					//System.out.println(ErrMess);
					//assertTrue(ErrMess.contains("No Match"));
					
					//uniformadminloginPOM.clickaccountDropdown();
					
					WebElement Catalog = driver.findElement(By.xpath("//i[@class='fa fa-tags fa-fw']"));
					WebElement Catgories=driver.findElement(By.xpath("//a[contains(text(),'Categories')]"));
					
					Actions cata = new Actions(driver);
					cata.moveToElement(Catalog).click(Catgories).build().perform();
					
					Thread.sleep(1000);
					uniformadmindashboardPOM.clickCheckBox();
					uniformadmindashboardPOM.editCategory();
					uniformadmindashboardPOM.sendtagName("3Test Edited");
					uniformadmindashboardPOM.sendtagDesc("3Test Edited");
					uniformadmindashboardPOM.save();
					
					screenShot.captureScreenShot("First");
					
					String sucMess=uniformadmindashboardPOM.succMessage();
					System.out.println(sucMess);
					assertTrue(sucMess.contains("Success"));
				
								
					
				}

}
