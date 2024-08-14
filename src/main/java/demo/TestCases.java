package demo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;


public class TestCases {
    WebDriver driver;
    public TestCases()
    {
        System.out.println("Constructor: TestCases");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    public void endTest()
    {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }

    public boolean findElement(WebDriver driver, WebElement ele) {
		boolean flag = false;
		try {
			ele.isDisplayed();
			flag = true;
		} catch (Exception e) {
			// System.out.println("Location not found: "+locatorName);
			flag = false;
		} finally {
			if (flag) {
				System.out.println("Successfully Found element at");

			} else {
				System.out.println("Unable to locate element at");
			}
		}
		return flag;
	}


    public boolean type(WebElement ele, String text) {
		boolean flag = false;
		try {
			flag = ele.isDisplayed();
			ele.clear();
			ele.sendKeys(text);
			// logger.info("Entered text :"+text);
			flag = true;
		} catch (Exception e) {
			System.out.println("Location Not found");
			flag = false;
		} finally {
			if (flag) {
				System.out.println("Successfully entered value");
			} else {
				System.out.println("Unable to enter value");
			}

		}
		return flag;
	}


    
    public  void testCase01() throws InterruptedException{
        System.out.println("Start Test case: testCase01");
        driver.get("https://www.google.com");
		// navigating to Chrome using get method
        WebElement searchBar= driver.findElement(By.xpath("//textarea[@title='Search']"));
		// getting the xpath for serch bar and verifying the locator using wrapper method
		this.findElement(this.driver, searchBar);
		// entering the selenium text i search bar and pressing enter to search
        this.type(searchBar, "Selenium");
        searchBar.sendKeys(Keys.ENTER);
        Thread.sleep(3000); 
		// Getting the results in list of webelement and iterting it for required value with equals method and verifying it 
        List <WebElement> SearchResult =  driver.findElements(By.tagName("h3"));
        for (WebElement element : SearchResult) {
            if(element.getText().equals("Selenium")){
                System.out.println("The result page shows the selenium result successfully");
                break;
            }else{
                System.out.println("Unsuccessfull search result found");
            }  
        } 
        
    }




}
