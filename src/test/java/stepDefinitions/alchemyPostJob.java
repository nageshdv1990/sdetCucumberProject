package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;

public class alchemyPostJob{
    WebDriver driver;
    WebDriverWait wait;

    public static String DRIVER_DIR = System.getProperty("user.dir")
            + File.separator
            +"Drivers"
            + File.separator;

    public static String CHROME_DRIVER_PATH = DRIVER_DIR+"chromedriver.exe";



    @When("user clicks on Post a Job")
    public void userClicksOnPostAJob() {
        System.setProperty("webdriver.chrome.driver",CHROME_DRIVER_PATH);
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver,15);
        driver.get("https://alchemy.hguy.co/jobs/");
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.partialLinkText("Post a Job")));
        driver.findElement(By.linkText("Post a Job")).click();

    }

    @Then("user is navigated to Post a Job page")
    public void userIsNavigatedToPostAJobPage() {
        Assert.assertEquals("Post a Job – Alchemy Jobs", driver.getTitle());
    }

    @When("user enters Title {string}")
    public void userEntersTitle(String title) {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("job_title")));
        driver.findElement(By.id("job_title")).sendKeys(title);
    }

    @And("Email {string}")
    public void email(String email) {
        driver.findElement(By.id("application")).sendKeys(email);
        driver.findElement(By.id("create_account_email")).sendKeys(email);
    }

    @And("Company {string}")
    public void company(String company) {
        driver.findElement(By.id("company_name")).sendKeys(company);
    }

    @And("Description {string}")
    public void description(String description) {
        driver.switchTo().frame("job_description_ifr");
        driver.findElement(By.id("tinymce")).sendKeys("description");
        driver.switchTo().defaultContent();
    }

    @And("user clicks on Preview")
    public void userClicksOnPreview() {
        driver.findElement(By.xpath("//*[@id=\"submit-job-form\"]/p/input[4]")).click();
    }

    @Then("user is navigated to review page")
    public void userIsNavigatedToReviewPage() {
        Assert.assertEquals("Post a Job – Alchemy Jobs",driver.getTitle());
    }

    @When("user clicks on Submit Listing button")
    public void userClicksOnSubmitListingButton() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("job_preview_submit_button")));
        driver.findElement(By.id("job_preview_submit_button")).click();
    }

    @Then("Job is posted successfully")
    public void jobIsPostedSuccessfully() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class=\"entry-content clear\"]")));
      //  Assert.assertEquals("Job listed successfully. To view your listing click here.",driver.findElement(By.xpath("//div[@class=\"entry-content clear\"]")).getText());
        driver.quit();
    }

}
