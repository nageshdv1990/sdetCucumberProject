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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


import static stepDefinitions.baseClass.driver;
import static stepDefinitions.baseClass.wait;

import java.io.File;
import java.util.List;
import java.util.Random;

public class orangeHrm {

    public baseClass baseClass;
    Random rand = new Random();
    String userName;
    String firstName1;
    String lastName1;


    public WebDriver driver;
    public WebDriverWait wait;

    public static String DRIVER_DIR = System.getProperty("user.dir")
            + File.separator
            +"Drivers"
            + File.separator;

    public static String CHROME_DRIVER_PATH = DRIVER_DIR+"chromedriver.exe";

    @Given("user has opened HRM login page")
    public void userHasOpenedHRMLoginPage() {
        System.setProperty("webdriver.chrome.driver",CHROME_DRIVER_PATH);
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, 15);
        System.out.println("In here");
        driver.get("http://alchemy.hguy.co/orangehrm");
    }

    @When("user enter the username and password")
    public void userEnterTheUsernameAndPassword() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("txtUsername")));
        driver.findElement(By.id("txtUsername")).sendKeys("orange");
        driver.findElement(By.id("txtPassword")).sendKeys("orangepassword123");
    }

    @And("clicks on login button")
    public void clicksOnLoginButton() {
        driver.findElement(By.id("btnLogin")).click();
    }

    @Then("user is navigated to the HRM dashboard page")
    public void userIsNavigatedToTheHRMDashboardPage() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@id=\"content\"]/div/div[1]/h1")));
        String message = driver.findElement(By.xpath("//div[@id=\"content\"]/div/div[1]/h1")).getText();
        Assert.assertEquals(message, "Dashboard");
        System.out.println(message);
    }

    @Given("user is on HRM dashboard page")
    public void userIsOnHRMDashboardPage() {

    }

    @When("user hovers on Recruitment and clicks on vacancies option")
    public void userHoversOnRecruitmentAndClicksOnVacanciesOption() {
        driver.findElement(By.id("menu_recruitment_viewRecruitmentModule")).click();
        driver.findElement(By.id("menu_recruitment_viewJobVacancy")).click();

    }

    @Then("user is navigated to Vacancies page")
    public void userIsNavigatedToVacanciesPage() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id=\"srchVacancy\"]/div[1]/h1")));
        String pageName = driver.findElement(By.xpath("//*[@id=\"srchVacancy\"]/div[1]/h1")).getText();
        System.out.println(pageName);
        Assert.assertEquals(pageName,"Vacancies");
    }

    @When("user clicks on Add")
    public void userClicksOnAdd() {
        driver.findElement(By.xpath("//input[@id=\"btnAdd\"]")).click();
    }

    @Then("Add Job Vacancy form is displayed")
    public void addJobVacancyFormIsDisplayed() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@id=\"addJobVacancy\"]/div[1]/h1")));
        WebElement title = driver.findElement(By.xpath("//div[@id=\"addJobVacancy\"]/div[1]/h1"));
        String titleText = title.getText();
        System.out.println(titleText);
        Assert.assertEquals(titleText,"Add Job Vacancy");
    }

    @When("user select Job Title from the dropdown")
    public void userSelectJobTitleFromTheDropdown() {
        Select jobTitle = new Select(driver.findElement(By.xpath("//select[@id=\"addJobVacancy_jobTitle\"]")));
        List jobTitles = jobTitle.getOptions();
        jobTitle.selectByVisibleText("DevOps Engineer");
        System.out.println(jobTitles);
    }

    @And("Adds vacancy name")
    public void addsVacancyName() {
        driver.findElement(By.id("addJobVacancy_name")).sendKeys("Dev Sec Ops Lead");
    }

    @And("provides name of the Hiring manager from the options")
    public void providesNameOfTheHiringManagerFromTheOptions() {
        driver.findElement(By.id("addJobVacancy_hiringManager")).sendKeys("astin bibber");

    }

    @And("clicks on Save")
    public void clicksOnSave() {
        driver.findElement(By.id("btnSave")).click();
    }

    @Then("successfully saved message is displayed")
    public void successfullySavedMessageIsDisplayed() {
        System.out.println("Saved");
    }

    @When("user hovers on Recruitment option and clicks on candidates")
    public void userHoversOnRecruitmentOptionAndClicksOnCandidates() {
        driver.findElement(By.id("menu_recruitment_viewRecruitmentModule")).click();
        driver.findElement(By.id("menu_recruitment_viewCandidates")).click();
    }


    @Then("user is navigated to the candidates page")
    public void userIsNavigatedToTheCandidatesPage() {
        WebElement candidateTitle = driver.findElement(By.xpath("//div[@id=\"srchCandidates\"]/div[1]/h1"));
        String title = candidateTitle.getText();
        Assert.assertEquals(title,"Candidates");
    }

    @When("user clicks of Add")
    public void userClicksOfAdd() {
        driver.findElement(By.id("btnAdd")).click();
    }

    @Then("user is navigated to the Add candidate form page")
    public void userIsNavigatedToTheAddCandidateFormPage() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("addCandidateHeading")));
        WebElement pageTitle = driver.findElement(By.id("addCandidateHeading"));
        String title = pageTitle.getText();
        Assert.assertEquals(title,"Add Candidate");
    }

    @When("user enters First Name")
    public void userEntersFirstName() {
        driver.findElement(By.id("addCandidate_firstName")).sendKeys("vir");
    }

    @And("user enters Last name")
    public void userEntersLastName() {
        driver.findElement(By.id("addCandidate_lastName")).sendKeys("at");
    }

    @And("user enter Email Id")
    public void userEnterEmailId() {
        driver.findElement(By.id("addCandidate_email")).sendKeys("vir99@gmail.com");
    }

    @And("user uploads Resume")
    public void userUploadsResume() {
        WebElement resume = driver.findElement(By.id("addCandidate_resume"));
        String fileName = "test.pdf";
        String path = System.getProperty("user.dir") + File.separator + "files" + File.separator + fileName;
        resume.sendKeys(path);
    }

    @And("click Save")
    public void clickSave() {
        driver.findElement(By.id("btnSave")).click();
    }


    @When("user clicks PIM on menu bar and selects Add Employee")
    public void userClicksPIMOnMenuBarAndSelectsAddEmployee() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("menu_pim_viewPimModule")));
        driver.findElement(By.id("menu_pim_viewPimModule")).click();
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("menu_pim_addEmployee")));
        driver.findElement(By.id("menu_pim_addEmployee")).click();
        driver.findElement(By.linkText("Add Employee")).click();
    }

    @Then("user is navigated to Add Employee page")
    public void userIsNavigatedToAddEmployeePage() {
        String pageTitle =  driver.findElement(By.xpath("//div[@id=\"content\"]/div/div[1]/h1")).getText();
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("firstName")));

       Assert.assertEquals("Add Employee",pageTitle);
    }

    @When("user provides {string} and {string} and {string}")
    public void userProvidesAndAnd(String firstName, String lastName, String empId) {
        driver.findElement(By.id("firstName")).sendKeys(firstName);
        driver.findElement(By.id("lastName")).sendKeys(lastName);
        driver.findElement(By.id("employeeId")).sendKeys(empId);
        firstName1 = firstName;
        lastName1 = lastName;
    }

    @And("enable Create Login Details checkbox")
    public void enableCreateLoginDetailsCheckbox() {
        driver.findElement(By.id("chkLogin")).click();
        userName ="vir"+rand.nextInt(500);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("user_name")));
        driver.findElement(By.id("user_name")).sendKeys(userName);
        driver.findElement(By.id("btnSave")).click();

    }

    @Then("verify the employee details are created")
    public void verifyTheEmployeeDetailsAreCreated() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("personal_txtEmpFirstName")));
        String fName = driver.findElement(By.id("personal_txtEmpFirstName")).getAttribute("value");
        String lName = driver.findElement(By.id("personal_txtEmpLastName")).getAttribute("value");
        Assert.assertEquals(firstName1,fName);
        Assert.assertEquals(lastName1,lName);
        driver.quit();

    }

    @And("Adds {string}")
    public void adds(String vacancyName) {
        driver.findElement(By.id("addJobVacancy_name")).sendKeys(vacancyName);
    }

}
