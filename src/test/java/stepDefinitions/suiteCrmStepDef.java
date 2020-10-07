package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.util.List;
import java.util.Random;

public class suiteCrmStepDef {
  //  public baseClass baseClass;
   // Random rand = new Random();
   // String userName;
   // String firstName1;
   // String lastName1;
    int count;


    public WebDriver driver;
    public WebDriverWait wait;

    public static String DRIVER_DIR = System.getProperty("user.dir")
            + File.separator
            +"Drivers"
            + File.separator;

    public static String CHROME_DRIVER_PATH = DRIVER_DIR+"chromedriver.exe";

    @Given("user is Alchemy CRM site")
    public void userIsAlchemyCRMSite() {
        System.setProperty("webdriver.chrome.driver",CHROME_DRIVER_PATH);
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, 15);
        System.out.println("In here");
        driver.get("https://alchemy.hguy.co/crm/");
    }

    @When("user enters the {string} and {string}")
    public void userEntersTheAnd(String userName, String password) {
        driver.findElement(By.id("user_name")).sendKeys(userName);
        driver.findElement(By.id("username_password")).sendKeys(password);
        driver.findElement(By.id("bigbutton")).click();
    }

    @Then("user is navigated to the Homepage")
    public void userIsNavigatedToTheHomepage() {
        String dashboard= driver.findElement(By.id("tab0")).getText();
        Assert.assertEquals("SUITECRM DASHBOARD",dashboard);
    }

    @Given("user is on Homepage")
    public void userIsOnHomepage() {
        String dashboard= driver.findElement(By.id("tab0")).getText();
        Assert.assertEquals("SUITECRM DASHBOARD",dashboard);
    }

    @When("user counts the dashlets")
    public void userCountsTheDashlets() {
      wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("div[class='dashletPanel']")));
        List<WebElement> dashletCount = driver.findElements(By.cssSelector("div[class='dashletPanel']"));
        System.out.println((dashletCount.size()));
        count=dashletCount.size();
    }

    @Then("Print the number and title of each dashlet")
    public void printTheNumberAndTitleOfEachDashlet() {
        System.out.println("Number of Dashlet = "+count);
    }

    @And("Close the Browser")
    public void closeTheBrowser() {
     // driver.quit();
    }

    @When("user navigates to Create Lead page")
    public void userNavigatesToCreateLeadPage() {
      driver.manage().window().maximize();
      wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@id=\"toolbar\"]/ul/li[3]")));
      driver.findElement(By.xpath("//div[@id=\"toolbar\"]/ul/li[3]")).click();
      driver.findElement(By.linkText(("Leads"))).click();
      wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class=\"actionmenulink\"]")));
      driver.findElement(By.xpath("//div[@class=\"actionmenulink\"]")).click();
    }

    @And("Fill in the {string}")
    public void fillInThe(String lastName) {
      wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("last_name")));
      driver.findElement(By.id("last_name")).sendKeys(lastName);
    }

    @And("click on save lead button")
    public void clickOnSaveLeadButton() {
      //driver.findElement(By.id("SAVE")).click();
      driver.findElement(By.cssSelector("input[value=\"Save\"]")).click();
    }

    @Then("navigate to View leads page")
    public void navigateToViewLeadsPage() {
      driver.findElement(By.xpath("//div[@id=\"actionMenuSidebar\"]/ul/li[3]")).click();
    }

    @And("Validate the results")
    public void validateTheResults() {

    }

    @When("user navigates to Schedule a meeting page")
    public void userNavigatesToScheduleAMeetingPage() {
      driver.manage().window().maximize();
      WebElement meetings = driver.findElement(By.xpath("//a[text()='Meetings']"));
      driver.get(meetings.getAttribute("href"));
      WebElement scheduleMeetingLink = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@data-action-name='Schedule_Meeting']")));
      driver.get(scheduleMeetingLink.getAttribute("href"));
    }

    @And("Enter the details of the meeting {string}")
    public void enterTheDetailsOfTheMeeting(String subject) {
      wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("input#name")));
      driver.findElement(By.cssSelector("input#name")).sendKeys(subject);
    }

    @And("Search for members and add them to the meeting {string}, {string}, {string}")
    public void searchForMembersAndAddThemToTheMeeting(String invitee1, String invitee2, String invitee3) {
      driver.findElement(By.cssSelector("input#search_email")).clear();
      driver.findElement(By.cssSelector("input#search_email")).sendKeys(invitee1);
      wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("input#invitees_search.button")));
      driver.findElement(By.cssSelector("input#invitees_search.button")).click();
      wait.until((ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("invitees_add_1"))));
      driver.findElement(By.id("invitees_add_1")).click();

      driver.findElement(By.cssSelector("input#search_email")).clear();
      driver.findElement(By.cssSelector("input#search_email")).sendKeys(invitee2);
      wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("input#invitees_search.button")));
      driver.findElement(By.cssSelector("input#invitees_search.button")).click();
      wait.until((ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("invitees_add_1"))));
      driver.findElement(By.id("invitees_add_1")).click();

      driver.findElement(By.cssSelector("input#search_email")).clear();
      driver.findElement(By.cssSelector("input#search_email")).sendKeys(invitee3);
      wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("input#invitees_search.button")));
      driver.findElement(By.cssSelector("input#invitees_search.button")).click();
      wait.until((ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("invitees_add_1"))));
      driver.findElement(By.id("invitees_add_1")).click();
    }

    @And("click Save Meeting button")
    public void clickSaveMeetingButton() throws InterruptedException {
      Thread.sleep(3000);
     WebElement ele =  driver.findElement(By.id("save_and_send_invites_header"));
      JavascriptExecutor js = (JavascriptExecutor) driver;
      js.executeScript("arguments[0].click()", ele);
     // wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input#SAVE_HEADER.button.primary")));
     // driver.findElement(By.cssSelector("input#SAVE_HEADER.button.primary")).click();
    //  driver.findElement(By.id("SAVE_HEADER")).click();
     // driver.findElement(By.id("save_and_send_invites_header")).click();
    }

    @Then("user navigates to view meeting page")
    public void userNavigatesToViewMeetingPage() {
        driver.findElement(By.xpath("//div[@id=\"actionMenuSidebar\"]/ul/li[2]")).click();
    }

    @And("confirms if meeting is created")
    public void confirmsIfMeetingIsCreated() {
    }

    @When("user navigates to the Create Product page")
    public void userNavigatesToTheCreateProductPage() {
      driver.manage().window().maximize();
      WebElement productsLink = driver.findElement(By.xpath("//a[text()='Products']"));
      driver.get(productsLink.getAttribute("href"));
      wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[name='Assign']")));
      driver.findElement(By.xpath("//div[@id=\"actionMenuSidebar\"]/ul/li[1]")).click();
      wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id=\"content\"]/div")));
    }

    @And("Enter the details of the product {string}, {string}")
    public void enterTheDetailsOfTheProduct(String name, String price) {
      wait.until(ExpectedConditions.presenceOfElementLocated(By.id("name")));
      driver.findElement(By.id("name")).sendKeys(name);
      driver.findElement(By.id("price")).sendKeys(price);

    }

    @And("click Save products")
    public void clickSaveProducts() {
      driver.findElement(By.id("SAVE")).click();
    }

    @Then("navigate to View Products page")
    public void navigateToViewProductsPage() {
      driver.findElement(By.xpath("//div[@id=\"actionMenuSidebar\"]/ul/li[2]")).click();
    }

    @And("validate the products created")
    public void validateTheProductsCreated() {
    }
}
