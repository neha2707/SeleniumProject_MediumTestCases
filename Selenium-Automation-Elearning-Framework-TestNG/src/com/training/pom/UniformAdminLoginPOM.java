package com.training.pom;


	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;

	public class UniformAdminLoginPOM {
		private WebDriver driver; 
		
		public UniformAdminLoginPOM(WebDriver driver) {
			this.driver = driver; 
			PageFactory.initElements(driver, this);
		}
		
			
		@FindBy(id="input-username")
		private WebElement inputUserName; 
		
		@FindBy(id="input-password")
		private WebElement inputPassword; 
		
		@FindBy(xpath="//button[@class='btn btn-primary']")
		private WebElement loginKey;
				
		@FindBy(xpath="//div[@class='alert alert-danger']")
		private WebElement ErrorMessage;
		
		public void sendUsername(String username) {
		this.inputUserName.clear(); 
		this.inputUserName.sendKeys(username); 
		}
		
		public void sendPassword(String password) {
			this.inputPassword.clear(); 
			this.inputPassword.sendKeys(password); 
			}
				
				public void login() {
			this.loginKey.click(); 
		}
		
		public String ValidateErrorMessage() {
			return this.ErrorMessage.getText(); 
		} 
		
	}


