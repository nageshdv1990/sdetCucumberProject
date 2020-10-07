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
import java.util.List;
import java.util.concurrent.TimeUnit;

public class alchemyJobSearch {
    public WebDriver driver;
    public WebDriverWait wait;

    public static String DRIVER_DIR = System.getProperty("user.dir")
            + File.separator
            +"Drivers"
            + File.separator;

    public static String CHROME_DRIVER_PATH = DRIVER_DIR+"chromedriver.exe";

    @Given("user launches Alchemy Jobs Site")
    public void userLaunchesAlchemyJobsSite() {
        System.out.println("launching alchemy admin login page");
        System.setProperty("webdriver.chrome.driver",CHROME_DRIVER_PATH);
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        driver.get("https://alchemy.hguy.co/jobs/");
        wait = new WebDriverWait(driver, 15);
    }



    @When("user clicks on Jobs")
    public void userClicksOnJobs() {
        driver.findElement(By.id("menu-item-24")).click();

    }

    @Then("user is navigated to the Jobs Search Page")
    public void userIsNavigatedToTheJobsSearchPage() {
        Assert.assertEquals("Jobs – Alchemy Jobs",driver.getTitle());
    }

    @When("user enters data into the search criteria")
    public void userEntersDataIntoTheSearchCriteria() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("search_keywords")));
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@name=\"search_keywords\"]")).sendKeys("Intelligent Tester");
    }

    @And("selects only full time")
    public void selectsOnlyFullTime() throws InterruptedException {
        //wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\\\"job_type_internship\\\"]")));
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"job_type_internship\"]")).click();
        Thread.sleep(1000);
        //wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\\\"job_type_part-time\\\"]")));
        driver.findElement(By.xpath("//*[@id=\"job_type_part-time\"]")).click();
        Thread.sleep(1000);
        //wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\\\"job_type_temporary\\")));
        driver.findElement(By.xpath("//*[@id=\"job_type_temporary\"]")).click();
        Thread.sleep(1000);
        driver.findElement((By.xpath("//*[@id=\"job_type_freelance\"]"))).click();
        Thread.sleep(1000);
    }

    @And("clicks on Search Jobs page")
    public void clicksOnSearchJobsPage() {
        driver.findElement(By.xpath("//input[@value=\"Search Jobs\"]")).click();
    }

    @Then("Verify the number of matching records")
    public void verifyTheNumberOfMatchingRecords() {
      //  driver.findElement(By)

    }

    @When("user select the first matching record")
    public void userSelectTheFirstMatchingRecord() throws InterruptedException {
       // driver.findElement(By.id("")).click();
       Thread.sleep(2000);
        List jobList = driver.findElements(By.partialLinkText("Intellgent Tester"));
        System.out.println(jobList.size());
        driver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);
        driver.findElement(By.cssSelector("ul.job_listings >  li > a[href")).click();

    }

    @Then("user is navigated to the Job Details page")
    public void userIsNavigatedToTheJobDetailsPage() {
        Assert.assertEquals("Intelligent Tester – Alchemy Jobs",driver.getTitle());
    }

    @When("user clicks on Apply for job")
    public void userClicksOnApplyForJob() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//input[@value=\"Apply for job\"]")));
        driver.findElement(By.xpath("//input[@value=\"Apply for job\"]")).click();
    }

    @Then("confirmation message is displayed")
    public void confirmationMessageIsDisplayed() {
       boolean value =  driver.findElement(By.xpath("//*[@id=\"post-1800\"]/div/div/div/div[3]/div/p")).isDisplayed();
       if(value==true){
           System.out.println("Applied for job");
       }
    }
}
