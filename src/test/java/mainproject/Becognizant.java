package mainproject;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Becognizant {
	WebDriver driver;
	public Becognizant(WebDriver driver) {

		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	//locators
	
	@FindBy(xpath="//div[@class='_8ZYZKvxC8bvw1xgQGSkvvA==']")
	WebElement name;
	
	@FindBy(xpath="//div[@id='mectrl_currentAccount_primary']")
	WebElement name1;
	
	@FindBy(xpath="//div[@title='OneCognizant']")
	WebElement onecognizant;
	
	
 // Actions method
	
	public void namevalidClick() {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();",name);
	}
//	public void namevalidClick() throws InterruptedException {
//		name.click();
//		Thread.sleep(3000);
//	    name.click();
//	}
	public void namevalidPrint() {
		String nameprint=name1.getText();
		System.out.println(nameprint);
	}
	

	public void onecognizantClick() {
		onecognizant.click();
		Set<String> windowids = driver.getWindowHandles();
		List <String> windowslist = new ArrayList(windowids);
		String ParentId = windowslist.get(0);
		String ChildId = windowslist.get(1);
		driver.switchTo().window(ChildId);
	}
}
