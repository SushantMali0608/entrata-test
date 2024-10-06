package Entrata.EntrataTestcaseDesign;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;

public class LoginWithInvalidCredentials {
    public WebDriver driver;
    public WebDriverWait wait;

    @BeforeMethod
    public void setUp() {
       WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
       wait = new WebDriverWait(driver, Duration.ofSeconds(10));
       driver.get("https://www.entrata.com/c");
       // Accept cookies
       wait.until(ExpectedConditions.elementToBeClickable(By.id("cookie-accept"))).click();
    }
    // Test for login into Property Manager Login with invalid credentials.
    @Test
    public void testLoginWithInvalidCredentials() {
         // Navigate to sign-in page
        driver.findElement(By.xpath("//a[@class='signin-button mb-full']")).click();
        String actualSignInUrl = driver.getCurrentUrl();
        String expectedSignInUrl = "https://www.entrata.com/sign-in";
        Assert.assertEquals(actualSignInUrl, expectedSignInUrl);

        // Click the login button
        driver.findElement(By.xpath("//a[@class='button hover_black new-button w-inline-block']")).click();
        String actualLoginUrl = driver.getCurrentUrl();
        String expectedLoginUrl = "https://sso.entrata.com/entrata/login";
        Assert.assertEquals(actualLoginUrl, expectedLoginUrl);

        // Enter credentials
        driver.findElement(By.id("entrata-username")).sendKeys("Testing");
        driver.findElement(By.id("entrata-password")).sendKeys("Testing123");
        driver.findElement(By.xpath("//button[@class='outline-btn reversed js-submit-form']")).click();

        // Wait for and capture the error message
        String actualErrorMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("statusMessage"))).getText();
        String expectedErrorMsg = "The username and password provided are not valid. Please try again.";
        Assert.assertEquals(actualErrorMsg, expectedErrorMsg);
        System.out.println(actualErrorMsg);
    }
    
    
    
    
    //validating Scheduling demo form
    @Test
    public void validatingRedirection() {
    	//click on Schedule Your Demo Button
      	driver.findElement(By.xpath("//a[@data-w-id='8dd0d511-faef-57fa-5e27-00f24bd455e7']")).click();
        String actualScheduleDemourl =driver.getCurrentUrl();
    	String expectedScheduleDemourl ="https://go.entrata.com/schedule-demo.html";
    	Assert.assertEquals(actualScheduleDemourl, expectedScheduleDemourl);
    	
    	//Schedule Demo form
    	
    	driver.findElement(By.id("FirstName")).sendKeys("abc");
    	driver.findElement(By.id("LastName")).sendKeys("xyz");
    	driver.findElement(By.id("Email")).sendKeys("abc@gmail.com");
    	driver.findElement(By.id("Company")).sendKeys("Entrata");
    	driver.findElement(By.id("Phone")).sendKeys("45678765456");
    	//Selecting Value of UnitCount from DropDown
    	WebElement UnitCount = driver.findElement(By.id("Unit_Count__c"));
    	Select dropdown = new Select(UnitCount);
    	dropdown.selectByValue("11 - 100");
    	driver.findElement(By.id("Title")).sendKeys("Testing");
    	WebElement am = driver.findElement(By.id("demoRequest"));
    	Select dropdown1 = new Select(am);
    	dropdown1.selectByIndex(1);
    	
    }
    
    
    
    
    // Validating Footer link redirection (Project Management)
    @Test
    public void validatingpageRedirection() {
    	
    	driver.findElement(By.id("w-node-_8dd0d511-faef-57fa-5e27-00f24bd455f3-47af4adb")).click();
    	String actualURL = driver.getCurrentUrl();
    	String expectedURL ="https://www.entrata.com/products/property-management";
    	Assert.assertEquals(actualURL, expectedURL);
    	System.out.println(actualURL);
    }
    
    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.close(); // Ensure the browser is closed
        }
    }
    
}
