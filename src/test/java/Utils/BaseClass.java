package Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class BaseClass {

    public static WebDriver driver;

    public static void setDriver() {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");

        String projectPath = System.getProperty("user.dir");
        System.out.println("project path is" + projectPath);
        System.setProperty("webdriver.chrome.driver", projectPath + "/src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.navigate().to("https://www.migros.com.tr/");
        driver.manage().window().maximize();


    }

    public static void closeDriver()  {
        driver.quit();
    }



}
