package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UniformAdminDashboardPOM {
	
	private WebDriver driver; 
	
	public UniformAdminDashboardPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
		
	@FindBy(xpath="//i[@class='fa fa-tags fa-fw']")
	private WebElement catalog; 
	
	@FindBy(css="div:nth-child(3) div.page-header div.container-fluid div.pull-right:nth-child(1) > a.btn.btn-primary:nth-child(1)")
	private WebElement AddNew; 
	
	@FindBy(id="input-name1")
	private WebElement ipName;
	
	@FindBy(xpath="//div[@class='note-editable panel-body']")
	private WebElement catDesc;
	
	@FindBy(id="input-meta-title1")
	private WebElement tagName;
	
	
	@FindBy(id="input-meta-description1")
	private WebElement tagDesc;
	
	@FindBy(xpath="//button[@class='btn btn-primary']")
	private WebElement saveBtn;
	
	@FindBy(xpath="//div[@class='alert alert-success']")
	private WebElement sucMess;
	
	@FindBy(xpath="//td[contains(text(),'1Test')]")
	private WebElement addedCat;
	
	@FindBy(xpath="//tr[12]//td[1]//input[1]")
	private WebElement addedCheckBox;
	
	@FindBy(xpath="//tr[12]//td[4]//a[1]//i[1]")
	private WebElement editCat;
		
	
	public String succMessage() {
		return this.sucMess.getText();
	}
	
    public void sendipName(String name) {
	this.ipName.clear(); 
	this.ipName.sendKeys(name); 
		}
    
    public void sendcatDesc(String desc) {
    	this.catDesc.clear(); 
    	this.catDesc.sendKeys(desc); 
    		}
    
    public void sendtagName(String tagname) {
    	this.tagName.clear(); 
    	this.tagName.sendKeys(tagname); 
    }
    
    public void sendtagDesc(String tagdesc) {
    	this.tagDesc.clear();
    	this.tagDesc.sendKeys(tagdesc);
    }
		
	/*public void sendPassword(String password) {
	this.inputPassword.clear(); 
	this.inputPassword.sendKeys(password); 
			} */
				
	public void addNew() {
	this.AddNew.click(); 
		}
	
	public void save() {
		this.saveBtn.click(); 
			}
	
	public void clickCheckBox() {
		this.addedCheckBox.click(); 
			}

	public void editCategory() {
		this.editCat.click(); 
			}
	

}
