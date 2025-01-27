import java.io.IOException;
import java.time.LocalDate;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import dev.failsafe.internal.util.Assert;

class Amosafer {
	WebDriver driver = new ChromeDriver() ;
	String mywebsite = "https://www.almosafer.com/en" ;
	 
	Random rand = new Random() ; 
	
	
	@BeforeTest
	
	public void mysetup () {
		
		driver.get(mywebsite); 
		driver.manage().window().maximize(); 
		
	WebElement buttonforthecurency =	driver.findElement(By.cssSelector(".sc-jTzLTM.hQpNle.cta__button.cta__saudi.btn.btn-primary")); ;
		buttonforthecurency.click(); 
		
		
	}
	
	@Test(priority = 1,enabled = true)
	public void checkLanEnIsCorrect () { 
		
	String AcctualResult =	driver.findElement(By.tagName("html")).getAttribute("lang") ; 
		String expectedResult = "en" ; 
		
		org.testng.Assert.assertEquals(AcctualResult, expectedResult);  
		
	} 
	@Test (priority = 2,enabled = false)
	public void CheckSarIsDefualt () { 
        String AcctualResult=	driver.findElement(By.xpath("//Button[@data-testid='Header__CurrencySelector']")).getText() ;
		String expectedResult = "SAR" ; 
		org.testng.Assert.assertEquals(AcctualResult, expectedResult) ; 
		
		
		
	}
	@Test (priority = 3,enabled = true)
	public void CheckNumIsareCorrect ( ) {
	String AcctualNumber =	driver.findElement(By.cssSelector(".sc-hUfwpO.bWcsTG")).getText() ;  
	String expectedNumber = "+966554400000" ; 
	org.testng.Assert.assertEquals(AcctualNumber, expectedNumber); 
	
	}
	@Test (priority = 4,enabled = true)
	public void verifyGitafLogoIsDisplayed () {
	boolean Acctualresult = 	driver.findElement(By.cssSelector(".sc-ghsgMZ.hIElfs")).isDisplayed() ;
	boolean expectedresult = true ; 
	org.testng.Assert.assertEquals(Acctualresult, expectedresult); 
		
	}
	@SuppressWarnings("deprecation")
	@Test (priority = 5,enabled = false)
	public void hotelsTabIsNotByDefualt () {
	WebElement Hotels = driver.findElement(By.id("uncontrolled-tab-example-tab-hotels")) ;
     String actualresult=Hotels.getAttribute("aria-selected") ; 
     String exprctedresult = "false" ;  
     org.testng.Assert.assertEquals(actualresult, exprctedresult); 
		
	}
	
	@Test(priority = 6, enabled = true)
	public void CheckDepatureDate() throws IOException {
		int today = LocalDate.now().getDayOfMonth() ; 
		int Tomorrow = LocalDate.now().plusDays(1).getDayOfMonth() ; 
		int DayAfterTomorrow = LocalDate.now().plusDays(2).getDayOfMonth() ; 
		
	String acctualDepature = 	driver.findElement(By.cssSelector("div[class='sc-OxbzP sc-lnrBVv gKbptE'] span[class='sc-fvLVrH hNjEjT']")).getText();  ;
	String expectedDepature = Integer.toString(Tomorrow) ; 
	org.testng.Assert.assertEquals(acctualDepature, expectedDepature); 
	

		//String ActualDepature = driver
			//	.findElement(By.cssSelector("div[class='sc-OxbzP sc-lnrBVv gKbptE'] span[class='sc-fvLVrH hNjEjT']"))
			//	.getText();

	
		//Assert.assertEquals(ActualDepature, expectedDeparture);

	}
	@Test(priority = 7,enabled = false)
	public void CheckReturnDat () {
		int today = LocalDate.now().getDayOfMonth() ; 
		int Tomorrow = LocalDate.now().plusDays(1).getDayOfMonth() ; 
		int DayAfterTomorrow = LocalDate.now().plusDays(2).getDayOfMonth() ; 
		
	String acctualReturn = 	driver.findElement(By.cssSelector("div[class='sc-OxbzP sc-bYnzgO bojUIa'] span[class='sc-fvLVrH hNjEjT']")).getText();  ;
	String expectedReturn = Integer.toString(DayAfterTomorrow) ; 
	org.testng.Assert.assertEquals(acctualReturn, expectedReturn);  
		
		
		
	}

	

	@Test(priority = 8, enabled = true) 
	public void RandomlyChangeTheLanguage() throws InterruptedException   {
		
		String [] EnglishCitiesName = {"jeddah","riyadh","dubai"} ; 
		String [] ArabicCitiesName = {"دبي","جده"} ; 
	int RandomArabicCity =	rand.nextInt(ArabicCitiesName.length);
	int RandomEnglishCity =	rand.nextInt(EnglishCitiesName.length); 
		
		
		 
		String [] MyWebSites = {"https://www.almosafer.com/ar","https://www.almosafer.com/en"} ;
		int randomIndex = rand.nextInt(MyWebSites.length) ;
		driver.get(MyWebSites[randomIndex]);  
		WebElement HotelTab = driver.findElement(By.id("uncontrolled-tab-example-tab-hotels")) ;
		HotelTab.click(); 
		
		WebElement HotelTabSearch = driver.findElement(By.cssSelector(".sc-phbroq-2.uQFRS.AutoComplete__Input"));
		
		
		
		if(driver.getCurrentUrl().equals("https://www.almosafer.com/ar"))  {
			String AcctualResult =	driver.findElement(By.tagName("html")).getAttribute("lang") ; 
			String expectedResult = "ar" ; 
			
			org.testng.Assert.assertEquals(AcctualResult, expectedResult);  
			HotelTabSearch.sendKeys(ArabicCitiesName[RandomArabicCity]) ; 
			
		} else {
			String AcctualResult =	driver.findElement(By.tagName("html")).getAttribute("lang") ; 
			String expectedResult = "en" ; 
			
			org.testng.Assert.assertEquals(AcctualResult, expectedResult);  
			HotelTabSearch.sendKeys(EnglishCitiesName[RandomEnglishCity]) ;  
				
		}
		Thread.sleep(2000)   ; 
		WebElement  citiesList = driver.findElement(By.cssSelector(".sc-phbroq-4.gGwzVo.AutoComplete__List")) ;
	WebElement selectNumberOfVisitor	=driver.findElement(By.cssSelector(".sc-tln3e3-1.gvrkTi"));
	 citiesList.findElement(By.tagName("li")).click(); 
	 Select select = new Select(selectNumberOfVisitor) ; 
	 int RandomvisitorOfNumber = rand.nextInt(2) ; 
	 
	 select.selectByIndex(RandomvisitorOfNumber) ; 
	 
	WebElement SearchButton =   driver.findElement(By.xpath("//Button[@data-testid='HotelSearchBox__SearchButton']")) ;  
	SearchButton.click() ; 
		
		
	} 


	@Test(priority = 10,enabled = true)
	public void CheckTheSortOption() throws InterruptedException, IOException {

		Thread.sleep(10000);

		WebElement SortOption = driver.findElement(By.xpath("//div[@data-testid='srp_sort_LOWEST_PRICE']"));
		SortOption.click();

		Thread.sleep(2000);
	}
	
	
	
}
