package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;

public class alchemyStepDef {
    WebDriver driver;
    WebDriverWait wait;

    public static String DRIVER_DIR = System.getProperty("user.dir")
            + File.separator
            +"Drivers"
            + File.separator;

    public static String CHROME_DRIVER_PATH = DRIVER_DIR+"chromedriver.exe";

    @Given("user launches Alchemy Admin Login page")
    public void userLaunchesAlchemyAdminLoginPage() {
        System.out.println("launching alchemy admin login page");
        System.setProperty("webdriver.chrome.driver",CHROME_DRIVER_PATH);
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        driver.get("https://alchemy.hguy.co/jobs/wp-admin");

    }

    @When("user provides username and password")
    public void userProvidesUsernameAndPassword() {
        driver.findElement(By.id("user_login")).sendKeys("root");
        driver.findElement(By.id("user_pass")).sendKeys("pa$$w0rd");
    }

    @And("clicks on login")
    public void clicksOnLogin() {
        driver.findElement(By.id("wp-submit")).click();
    }

    @Then("user will be navigated to Dashboard page")
    public void userWillBeNavigatedToDashboardPage() {
        Assert.assertEquals(driver.getTitle(),"Dashboard ‹ Alchemy Jobs — WordPress");
    }

    @When("user hovers on the new button")
    public void userHoversOnTheNewButton() {
        WebElement element = driver.findElement(By.id("wp-admin-bar-new-content"));
        Actions builder = new Actions(driver);
        builder.moveToElement(element).perform();
    }

    @And("selects User option")
    public void selectsUserOption() {
        driver.findElement(By.partialLinkText("User")).click();
    }

    @Then("user is navigated to Add New User page")
    public void userIsNavigatedToAddNewUserPage() {
        Assert.assertEquals(driver.getTitle(),"Add New User ‹ Alchemy Jobs — WordPress");
    }

    @When("user enter Username and email")
    public void userEnterUsernameAndEmail() {
        driver.findElement(By.id("user_login")).sendKeys("Virat6");
        driver.findElement(By.id("email")).sendKeys("vir6@gmail.com");
    }

    @And("clicks on Add New User")
    public void clicksOnAddNewUser() {
        driver.findElement(By.id("createusersub")).click();
    }

    @Then("user is navigated to Users List View page")
    public void userIsNavigatedToUsersListViewPage() {
        Assert.assertEquals("Users ‹ Alchemy Jobs — WordPress",driver.getTitle());
    }

    @And("new user created confirmation message is displayed")
    public void newUserCreatedConfirmationMessageIsDisplayed() {
       // String newUserCreatedMessage = driver.findElement(By.partialLinkText("Edit user")).getText();
        String newUserCreatedMessage = driver.findElement(By.xpath("//div[@id=\"message\"]/p")).getText();
        Assert.assertEquals("New user created. Edit user",newUserCreatedMessage);

    }

    @And("close the browser")
    public void closeTheBrowser() {
        driver.quit();
    }
}
