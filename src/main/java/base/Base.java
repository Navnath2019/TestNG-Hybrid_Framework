package base;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import utility.Utility;


public class Base {

	public static WebDriver driver;
	public static Wait wait;
	public static Properties config;
	public static Properties locators;
	public static Properties testData;
	

	public void base() throws IOException {

		// Properties file access the Configuration data along with key-Valu pair

		//********************************************************************************************************************************************************************
		// Config.Properties File use to access browser and URL info
		config = new Properties();
		//String configFile = "C:\\Users\\nkmin\\eclipse-workspace\\TestNG_HybridFramework\\src\\main\\java\\propertiesFiles\\config.properties";
		FileInputStream con = new FileInputStream("C:\\Users\\nkmin\\eclipse-workspace\\TestNG_HybridFramework\\src\\main\\java\\propertiesFiles\\config.properties");
		config.load(con);
		//********************************************************************************************************************************************************************

		// locators.Properties File use to access locators
		locators = new Properties();
		//String locFile = "C:\\Users\\nkmin\\eclipse-workspace\\TestNG_HybridFramework\\src\\main\\java\\propertiesFiles\\locators.properties";
		FileInputStream loc = new FileInputStream("C:\\Users\\nkmin\\eclipse-workspace\\TestNG_HybridFramework\\src\\main\\java\\propertiesFiles\\locators.properties");
		locators.load(loc);
		//********************************************************************************************************************************************************************

		testData = new Properties();
		//String testdataFile = "C:\\Users\\nkmin\\eclipse-workspace\\TestNG_HybridFramework\\src\\main\\java\\propertiesFiles\\testData.properties";
		FileInputStream tD = new FileInputStream("C:\\Users\\nkmin\\eclipse-workspace\\TestNG_HybridFramework\\src\\main\\java\\propertiesFiles\\testData.properties");
		testData.load(tD);
		//********************************************************************************************************************************************************************

		// Cross Browser Testing  

		if (config.getProperty("browser").equalsIgnoreCase("Chrome")){

			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			System.out.println("Chrome Browser Invoked");

		}else if (config.getProperty("browser").equalsIgnoreCase("Firefox")) {

			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			System.out.println("Firefox Browser Invoked");

		}else if (config.getProperty("browser").equalsIgnoreCase("Edge")) {

			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			System.out.println("Edge Browser Invoked");
		
		}
		driver.manage().window().maximize();
        driver.get(config.getProperty("url"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Utility.IMPLICIT_WAIT));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Utility.PAGELOAD_WAIT));
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        
        System.out.println("Base Class passed Successfully");
		
		
		
		
		}

	}
