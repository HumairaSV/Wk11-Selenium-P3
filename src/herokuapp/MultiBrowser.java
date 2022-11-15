package herokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class MultiBrowser {
    static String baseUrl = "https://the-internet.herokuapp.com/login";
    static String browser = "firefox";
    static WebDriver driver;

    public static void main(String[] args) {
        if(browser.equalsIgnoreCase("chrome")){
            System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("edge")) {
            System.setProperty("webdriver.edge.driver", "drivers/msedgedriver.exe");
            driver = new EdgeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.firefox.driver", "drivers/geckodriver.exe");
            driver = new FirefoxDriver();
        }else {
            System.out.println("Incorrect browser name-Select from Chrome or Edge or Firefox");
        }

        //launch the url
        driver.get(baseUrl);
        //maximising the browser window
        driver.manage().window().maximize();
        //giving implicit wait time to the driver
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        //Print the title of the page
        System.out.println("Page title:  " + driver.getTitle());
        //Print the current url
        System.out.println("Current url:  " + driver.getCurrentUrl());
        //Print the page source
        System.out.println("Page source:  " + driver.getPageSource());

        //Find the username field and input the data in the field
        WebElement usernameField = driver.findElement(By.id("username"));
        usernameField.sendKeys("tomsmith");

        //Find the password field and input the data in the field
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("SuperSecretPassword!");

        //close the browser
        driver.quit();
    }
}
