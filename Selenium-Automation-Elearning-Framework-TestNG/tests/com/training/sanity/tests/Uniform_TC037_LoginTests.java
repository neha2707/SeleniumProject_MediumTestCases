package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.UniformAccountPOM;
import com.training.pom.UniformAdminLoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;


public class Uniform_TC037_LoginTests {


		private WebDriver driver;
		private String adminUrl;
		private UniformAdminLoginPOM uniformadminloginPOM;
		//private UniformAccountPOM uniformaccountPOM;
		private static Properties properties;
		private ScreenShot screenShot;
		private String expTxt = "Password confirmation does not match password!";

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
			uniformadminloginPOM.sendPassword("admin@12");
			uniformadminloginPOM.login();
			Thread.sleep(1000);
			String ErrMess = uniformadminloginPOM.ValidateErrorMessage();
			System.out.println(ErrMess);
			assertTrue(ErrMess.contains("No Match"));
			
			//uniformadminloginPOM.clickaccountDropdown();
			
			/*Actions drpdwn = new Actions(driver);
			uniformloginPOM.clickaccountDropdown();
			Action selectobject = drpdwn.moveToElement(uniformloginPOM.loginOption.click()).build();
			selectobject.perform(); */
			
			/*Thread.sleep(3000);
			uniformadminloginPOM.clickloginOption();
			uniformadminloginPOM.sendUserName("neha.gupta1@in.ibm.com");
			uniformadminloginPOM.sendPassword("test123");
			uniformadminloginPOM.clickLoginBtn(); */
			
			/*loginPOM.sendUserName("admin");
			loginPOM.sendPassword("admin@123");
			loginPOM.clickLoginBtn(); */
			
			/*Thread.sleep(3000);
			uniformadminloginPOM.clickChangePwd();
			uniformadminloginPOM.sendPasswrd("test123");
			uniformadminloginPOM.sendConfirmPassword("test1234");
			uniformadminloginPOM.clickContBtn();
			
			screenShot.captureScreenShot("First");
			
			String actTxt = driver.findElement(By.xpath ("//div[@class='text-danger']")).getText();
			Assert.assertEquals(expTxt, actTxt);	
			System.out.println("Password Mismatch");
			
			*/
			
		}

		private void assertTrue(boolean contains) {
			// TODO Auto-generated method stub
			
		}


	

}
