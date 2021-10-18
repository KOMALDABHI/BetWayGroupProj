package base;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class baseTest {

    public static WebDriver driver;
    public static Properties properties;


    public static WebDriver setUp() {
        properties=new Properties();
        try
        {
            FileInputStream fs=new FileInputStream("src\\main\\resources\\config\\data.properties");
            properties.load(fs);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        String BROWSER=properties.getProperty("browsername");

        System.out.println("browsername"+BROWSER);
        if(BROWSER.equalsIgnoreCase("crome")) {

            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
        else if(BROWSER.equalsIgnoreCase("firefox")) {

            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
      return driver;

    }


}
