package CucumberTest.cucumber;


import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.openqa.selenium.By;		
import org.openqa.selenium.WebDriver;		
import org.openqa.selenium.firefox.FirefoxDriver;	


import io.cucumber.java.en.Given;		
import io.cucumber.java.en.Then;		
import io.cucumber.java.en.When;		

		
  public class CaseStudy {
	

    WebDriver driver;			
    
    
    @Given("^Open the Firefox and launch the application$")					
    public void open_the_Firefox_and_launch_the_application() throws Throwable							
    {		
       System.setProperty("webdriver.gecko.driver", "E://Selenium//Selenium_Jars//geckodriver.exe");					
       driver= new FirefoxDriver();					
       driver.manage().window().maximize();			
       driver.get("http://automationpractice.com/index.php");					
    }		

    @When("^Enter the Username and Password Login$")					
    public void enter_the_Username_and_Password_Login() throws Throwable 							
    {	
       driver.findElement(By.className("login")).click();
       driver.findElement(By.id("email")).sendKeys("username12.hotmail");							
       driver.findElement(By.id("passwd")).sendKeys("password12");	
       driver.findElement(By.xpath("//*[@id=\"SubmitLogin\"]/span")).click();
       
       String URL = driver.getCurrentUrl();
       Assert.assertTrue(URL.contains("http://automationpractice.com/index.php?controller=my-account"));
    }
    
    @Then("^Go to productpage category under Dresses The product in the second row is added to the basket")					
    public void productpage__add_basket() throws Throwable 							
    {	
       //Dresses altında summer dresses kategorisine gidilir.
       driver.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[2]/a")).click();
       
       //2.sepete ekle
       driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[2]/div/div[2]/div[2]/a[1]/span")).click();
       
       //alışverişe devam etbutonu basılır
       driver.findElement(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/span/span")).click();
     //*[@id="layer_cart"]/div[1]/div[2]/div[4]/span/span
       // tişört katogersine gidlir
       driver.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[3]/a")).click();
     
    // Bir ürün sepete eklenir.
       driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li/div/div[2]/div[2]/a[1]/span")).click();
       
       //alıs veriş tamamlanır, Sepete gidilir
       driver.findElement(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a/span")).click();
    }
    
    @Then(" check the basket")					
    public void check_basket() throws Throwable 							
    {
        // dress ad ve fiyat dogru olduğu kontrol edilir
   
       // ad kontrol
       String actualname1=driver.findElement(By.xpath("//*[@id=\"product_4_16_0_463892\"]/td[2]/p/a")).getText(); 
       
       String expectedname1 = ("Printed Dress");
       assertTrue(actualname1.contains(expectedname1));
       
       // fiyat kontrol
       String actualprice1=driver.findElement(By.xpath("//*[@id=\"product_price_4_16_463892\"]/span")).getText(); 
       
       String expectedprice1 = ("$50.99");
       assertTrue(actualprice1.contains(expectedprice1));
       
    // tşort ad ve fiyat dogru olduğu kontrol edilir
       
       String actualname2=driver.findElement(By.xpath("//*[@id=\"product_1_1_0_463892\"]/td[2]/p/a")).getText(); 
       
       String expectedname2 = ("Faded Short Sleeve T-shirts");
       assertTrue(actualname2.contains(expectedname2));
       
       // fiyat kontrol
       String actualprice2=driver.findElement(By.xpath("//*[@id=\"product_price_1_1_463892\"]/span")).getText(); 
       
       String expectedprice2 = ("$16.51");
       assertTrue(actualprice2.contains(expectedprice2));
       
       
       
       //ürün tutar toplamı alanlarıyla doğru
       //geldiği kontrol edili
       
       String actualtotalprice=driver.findElement(By.xpath("//*[@id=\"product_price_1_1_463892\"]/span")).getText(); 
       
       String expectedtotalprice = ("$16.51");
       assertTrue(actualtotalprice.contains(expectedtotalprice));
       driver.quit();
       
    }


}		

