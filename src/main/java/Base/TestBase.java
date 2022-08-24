package Base;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

//Define our driver here and all test cases will extend this class
public class TestBase {
    protected static WebDriver driver;
    protected static Properties properties;
    public static ExtentReports extentReports;
    public static ExtentTest log;

    public TestBase() throws IOException {
        properties = new Properties();
        FileInputStream fileInputStream = new FileInputStream("src/main/java/Config/config.properties");
        properties.load(fileInputStream);
    }

    public static void initialization(){
        System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\webdriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20 , TimeUnit.SECONDS);
        driver.get(properties.getProperty("url"));

    }
}
