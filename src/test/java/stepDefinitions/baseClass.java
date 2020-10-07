package stepDefinitions;

import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;

public class baseClass {


    public static WebDriver driver;
    public static WebDriverWait wait;

    public static String DRIVER_DIR = System.getProperty("user.dir")
            + File.separator
            +"Drivers"
            + File.separator;

    public static String chrome_path = DRIVER_DIR+"chromedriver.exe";

    @Before
    public void driverInstantiation(){
        System.setProperty("webdriver.chrome.driver", chrome_path);
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, 15);
        System.out.println(driver);
    }

 /*   public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", chrome_path);
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, 15);
        System.out.println(driver);
}*/
}
