
package mainproject;
import java.io.IOException;
import java.util.*;
 
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
 

public class Oneclivesupport {
  static WebDriver driver;
  public Oneclivesupport(WebDriver driver) {
	  this.driver=driver;
	  PageFactory.initElements(driver,this);
  }
  //locator
  @FindBy(xpath="//*[@class = 'Welcome-automated-text']")
  WebElement welcome;
  @FindBy(xpath="//*[@class = 'nav-link dropdown-toggle btn btn-default dropdown-toggle btncursor mb-2 py-1 px-2' and @id = 'menu1']")
  WebElement languagedrop;
  @FindBy(xpath="/html/body/nav[1]/div/form/div[1]/ul/li")
   List<WebElement> options;
  @FindBy(xpath="//*[@id=\"menu2\"]")
  WebElement countryopclick;
  @FindBy(xpath="//*[@id='hamBarCollapseContainer']/div/div/div[2]/ul/li/a")
  List<WebElement> options2;
  @FindBy(xpath="//div[@role = 'heading']")
  List<WebElement> headingsop;
  @FindBy(xpath="//div[@class = 'col-md-12 application-tiles']")
  List<WebElement> subnameop;
  @FindBy(xpath="//div[@data-toggle = 'tooltip']")
  List<WebElement> tooltipop;
  @FindBy(xpath="/html/body/nav[1]/div/form/div[2]/ul/li/a")
  List< WebElement> countryList;
  @FindBy(xpath="//*[@id=\"menu1\"]/span")
	WebElement ln;		
	@FindBy(xpath="//*[@id=\"menu2\"]/span")
	WebElement ctry;
 
  @FindBy(xpath = "//div[@role='heading']") List<WebElement> headings;
  @FindBy(xpath = "(//div[@class='eachTileRow'])[1]//div[@class='col-md-12 application-tiles']")  List<WebElement> list1;
  @FindBy(xpath = "(//div[@class='eachTileRow'])[2]//div[@class='col-md-12 application-tiles']")  List<WebElement> list2;
  @FindBy(xpath = "(//div[@class='eachTileRow'])[3]//div[@class='col-md-12 application-tiles']")  List<WebElement> list3;
  @FindBy(xpath = "(//div[@class='eachTileRow'])[4]//div[@class='col-md-12 application-tiles']")  List<WebElement> list4;
  //actions method
  public static void print_list() {
		List<WebElement> list1 = driver.findElements(By.xpath("(//div[@class=\"eachTileRow\"])[1]//div[@class=\"col-md-12 application-tiles\"]"));
		List<WebElement> list2 = driver.findElements(By.xpath("(//div[@class=\"eachTileRow\"])[2]//div[@class=\"col-md-12 application-tiles\"]"));
		List<WebElement> list3 = driver.findElements(By.xpath("(//div[@class=\"eachTileRow\"])[3]//div[@class=\"col-md-12 application-tiles\"]"));
		List<WebElement> list4 = driver.findElements(By.xpath("(//div[@class=\"eachTileRow\"])[4]//div[@class=\"col-md-12 application-tiles\"]"));
		List<WebElement> tempList = driver.findElements(By.xpath("//div[@role='heading']"));  //4
		//System.out.println(title.size());
		System.out.println(tempList.size()); 
		for(int i=0;i<tempList.size();i++) {
			System.out.println(tempList.get(i).getText());
			System.out.println("-------------------------------------------------------------------------------------");
			if(tempList.get(i).getText().contains("IT Infra Support")) {
				for(int j=0; j<list1.size();j++) {
					System.out.println(list1.get(j).getText());
					System.out.println(list1.get(j).getAttribute("data-bs-original-title"));
					System.out.println("==============================");
				}
			}
			else if(tempList.get(i).getText().contains("Human Resources")) {
				for(int j=0; j<list2.size();j++) {
					System.out.println(list2.get(j).getText());
					System.out.println(list2.get(j).getAttribute("data-bs-original-title"));
					System.out.println("==============================");
				}
			}
			else if(tempList.get(i).getText().contains("IT Application Support")) {
				for(int j=0; j<list3.size();j++) {
					System.out.println(list3.get(j).getText());
					System.out.println(list3.get(j).getAttribute("data-bs-original-title"));
					System.out.println("==============================");
				}
			}
			else {
				//System.out.println(tempList.get(i).getText());
				for(int j=0; j<list4.size();j++) {
					System.out.println(list4.get(j).getText());
					System.out.println(list4.get(j).getAttribute("data-bs-original-title"));
					System.out.println("==============================");
				}
 
				
			}
		}

		}
  public String welcomeText() {
	  driver.switchTo().frame("appFrame");
	  return welcome.getText();
	  
  }

  public void languagedrClick() {
	  languagedrop.click();
  }
  public void languagelistprint() {
	  System.out.println(options.size()+"-------------------------------------------langs");
	  String[] langs = new String[options.size()];
	  System.out.println("languages :-");
		for(int i=0;i<options.size();i++) {
			langs[i] = options.get(i).getText();
			System.out.println(options.get(i).getText());
		}
		
  }
  public void countryClick() {
	  countryopclick.click(); 
  }
  public void countrylist() {
	  System.out.println(options2.size()+"-------------------------------------------------");
	  String[] countries = new String[options2.size()];
	  System.out.println("countrylist");
	 for(int i=0;i<options2.size();i++) {
		 countries[i] = options2.get(i).getText();
		 System.out.println(options2.get(i).getAttribute("innerHTML"));
	 }
	 
  }

 
  
  
  public  List<WebElement> headinglist(){
	  return headingsop;
  }
  public List<WebElement> subname(){
	  return subnameop;
  }
  public List<WebElement> tooltip1(){
	  return tooltipop;
  }

 

public void random_country1() {
	// TODO Auto-generated method stub
    Random random = new Random();
	int index1 = random.nextInt(options2.size());
	int index2;
	do{
		index2=random.nextInt(options2.size());
	}while(index2==index1);
	WebElement country1=options2.get(index1);
	((JavascriptExecutor) driver).executeScript("arguments[0].click()",country1);
	 String first_country = country1.getAttribute("innerHTML");
		System.out.println(first_country);
		System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
		print_list();
	WebElement country2=options2.get(index2);
	((JavascriptExecutor) driver).executeScript("arguments[0].click()",country2);
	String second_country = country2.getAttribute("innerHTML");
	System.out.println(second_country);
	System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
	print_list();
}
}