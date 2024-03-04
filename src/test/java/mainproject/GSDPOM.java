 package mainproject;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
 @Listeners(mainproject.ExtentReportManager.class)
public class GSDPOM {
  WebDriver driver;
  Becognizant be;
  GSDSearch gsd;
  Oneclivesupport one;
     
     List <String> heading = new ArrayList<String>();
	 List<String> sub = new ArrayList<String>();
	 List <String> tooltip = new ArrayList<String>();
  
  @BeforeClass
  public void setup() {
	  WebDriverManager.chromedriver().setup();
	  driver=new ChromeDriver();
	  gsd=new GSDSearch(driver);
	  be=new Becognizant(driver);
	  one=new Oneclivesupport(driver);
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  driver.get("https://cognizantonline.sharepoint.com/sites/Be.Cognizant/SitePages/Home.aspx");
	  driver.manage().window().maximize();
  }
  @AfterClass
  public void teardown() {
	  driver.close();
	  driver.quit();
  }
  @Test (priority=1)
  public void nameClick() {
	  be.namevalidClick();
  }
  @Test (priority=2)
  public void valiName() {
   be.namevalidPrint();
  }
  @Test (priority=3)
  public void openOnecognizant() {
	 be.onecognizantClick();
  }
  
  @Test (priority=4)
  public void gsdsearch() {
	  gsd.searchGsd("GSD");
  }
  @Test (priority=5)
  public void livesClick() {
	gsd.livesupport2();
  }
  @Test (priority=6)
  public void welcomeTextVerify() {
	  //Assert.assertEquals(one.welcomeText(), true);
	  String actualText=one.welcomeText();
	  String expectedText="Welcome to the all-in-one Live Support!";
	  if(actualText.equals(expectedText)) {
		  Assert.assertTrue(true);
	  }
	  else {
		  Assert.assertTrue(false);
	  }
  }
  @Test (priority=7)
  public void languageClick() {
	  one.languagedrClick();
  }
  @Test (priority=8)
  public void languagePrint() {
	  one.languagelistprint();
  }
  @Test (priority=9)
  public void country() {
	  one.countryClick();
  }
  @Test (priority=10)
  public void countryprint() {
	  one.countrylist();
  }
  
  @Test (priority=11)
 public List<String> heading1(){
	  for(WebElement hd: one.headinglist()){
			heading.add(hd.getText());
		}
		return heading;
  }
  
  @Test (priority=12)
   public List<String>subnames1(){
	   for(WebElement sb:one.subname()) {
			  sub.add(sb.getText());
		  }
		  return sub;
   }
  @Test (priority=13)
  public List<String> tool(){
	  for(WebElement tl:one.tooltip1()) {
		  tooltip.add(tl.getAttribute("data-bs-original-title"));
	  }
	  return tooltip;
  }
  
  @Test (priority=14)
  public void excelPrint() throws IOException {
	//s	Excel ex = new Excel();
	
		Excel.writeToExcel(heading,sub,tooltip);
		//System.out.println("Excel file created successfully.");
	} 
  
  @Test(priority = 15)
  public void print_random_country() {
	  one.random_country1();
  }
  
}
