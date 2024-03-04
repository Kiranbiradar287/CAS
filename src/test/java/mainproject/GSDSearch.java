package mainproject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GSDSearch {
  WebDriver driver;
  public GSDSearch(WebDriver driver) {
	  this.driver=driver;
	  PageFactory.initElements(driver,this);
	  }
	  
      //locator
	  @FindBy(id="oneC_searchAutoComplete")
		WebElement gsdsearch;
	  
	  @FindBy(xpath="//*[@class = 'appsResultText']")
	  WebElement livesupport1;
	  
		
	  //Actions method
	  
	  public void searchGsd(String gsd) {
		  gsdsearch.sendKeys(gsd);
		   }
	  public void livesupport2() {
			 livesupport1.click();
		 }
}
