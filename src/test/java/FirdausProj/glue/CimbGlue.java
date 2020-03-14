package FirdausProj.glue;

import base.BaseScenario;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertTrue;

public class CimbGlue extends BaseScenario {
    private String year1interest;
    private String year2interest;
    private String year3interest;
    private String year4interest;
    private String year5interest;

    @When("^I select CIMB Deals$")
    public void iSelectCIMBDeals() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebDriverWait wait = new WebDriverWait(driver, secondsToWait);
        WebElement element = driver.findElement(By.xpath("(.//*[@href=\"/en/personal/cimb-deals.html\"])[2]"));
        js.executeScript("arguments[0].scrollIntoView();", element);
        wait.until(ExpectedConditions.visibilityOf(element));
        element.click();
        Thread.sleep(15000);
        String currentTab = driver.getWindowHandle();
        for (String tab : driver.getWindowHandles()) {
            if (!tab.equals(currentTab)) {
                driver.switchTo().window(tab);
            }
        }
        assertTrue(driver.getTitle().contains("CIMB Deals"));

    }

    @And("^I would like to explore more for \"([^\"]*)\" under Travel & Fun$")
    public void iWouldLikeToExploreMoreForUnderTravelFun(String Deal) throws Throwable {
        WebDriverWait wait = new WebDriverWait(driver, secondsToWait);
        WebElement element = driver.findElement(By.xpath("(.//*[@href=\"/my/travel%20&%20fun\"])[1]"));
        wait.until(ExpectedConditions.visibilityOf(element));
        element.click();
        Thread.sleep(8000);
        assertTrue(driver.getTitle().contains("Travel & Fun"));

        WebElement element2 = driver.findElement(By.xpath("//p[contains(text(),\""+Deal+"\")][1]"));
        wait.until(ExpectedConditions.visibilityOf(element2));
        element2.click();
        Thread.sleep(10000);
        //wait.until(ExpectedConditions.visibilityOf(element2));
    }

    @Then("^I will be able to see its details and other similar deals$")
    public void iWillBeAbleToSeeItsDetailsAndOtherSimilarDeals() throws Throwable {
        WebDriverWait wait = new WebDriverWait(driver, secondsToWait);
        WebElement element = driver.findElement(By.xpath("//p[text()='Similar Deals']"));
        Thread.sleep(10000);
        wait.until(ExpectedConditions.visibilityOf(element));
        assertTrue(element.isDisplayed());
    }

    @And("^I navigate to Tools page from menu$")
    public void iNavigateToToolsPageFromMenu() throws Throwable {
        WebDriverWait wait = new WebDriverWait(driver, secondsToWait);
        WebElement element = driver.findElement(By.xpath(".//*[@onclick=\"footerLinkClicked('Tools', '/content/cimbconsumersg/en/personal/support/help-and-support/tools.html');\"]"));
        wait.until(ExpectedConditions.visibilityOf(element));
        element.click();
        Thread.sleep(8000);
    }

    @When("^I access to Property Loan Repayment Calculator from menu$")
    public void iAccessToPropertyLoanRepaymentCalculatorFromMenu() throws Throwable {
        WebDriverWait wait = new WebDriverWait(driver, secondsToWait);
        WebElement element2 = driver.findElement(By.xpath(".//*[@href=\"http://www.cimbbank.com.sg/en/personal/support/help-and-support/tools/property-loan-repayment-calculator.html\"]"));
        wait.until(ExpectedConditions.visibilityOf(element2));
        element2.click();
        Thread.sleep(8000);

        WebElement element3 = driver.findElement(By.xpath("//a[contains(text(),\"Proceed\")]"));
        wait.until(ExpectedConditions.visibilityOf(element3));
        element3.click();
        Thread.sleep(8000);
    }


    @And("^I have enter Property Loan Amount = \"([^\"]*)\"$")
    public void iHaveEnter(String PropertyLoanAmount) throws Throwable {
        WebDriverWait wait = new WebDriverWait(driver, secondsToWait);
        WebElement element = driver.findElement(By.xpath(".//*[@class=\"principal-amount numeric-only nodecimal\"]"));
        wait.until(ExpectedConditions.visibilityOf(element));
        element.clear();
        element.sendKeys(PropertyLoanAmount);
    }

    @And("^I have enter Property Loan Tenure = \"([^\"]*)\"$")
    public void iHaveEnterPropertyLoanTenure(String PropertyLoanTenure) throws Throwable {
        WebDriverWait wait = new WebDriverWait(driver, secondsToWait);
        WebElement element = driver.findElement(By.xpath(".//*[@class=\"loan-tenure numeric-only nodecimal\"]"));
        wait.until(ExpectedConditions.visibilityOf(element));
        element.clear();
        element.sendKeys(PropertyLoanTenure);
    }

    @And("^I have enter Year 1 Interest = \"([^\"]*)\"$")
    public void iHaveEnterYear1Interest(String Year1Interest) throws Throwable {
        WebDriverWait wait = new WebDriverWait(driver, secondsToWait);
        WebElement element = driver.findElement(By.xpath(".//*[@class=\"interest-yr1 numeric-only\"]"));
        wait.until(ExpectedConditions.visibilityOf(element));
        element.clear();
        element.sendKeys(Year1Interest);
        this.year1interest=Year1Interest;
    }

    @And("^I have enter Year 2 Interest = \"([^\"]*)\"$")
    public void iHaveEnterYear2Interest(String Year2Interest) throws Throwable {
        WebDriverWait wait = new WebDriverWait(driver, secondsToWait);
        WebElement element = driver.findElement(By.xpath(".//*[@class=\"interest-yr2 numeric-only\"]"));
        wait.until(ExpectedConditions.visibilityOf(element));
        element.clear();
        element.sendKeys(Year2Interest);
        this.year2interest=Year2Interest;
    }

    @And("^I have enter Year 3 Interest = \"([^\"]*)\"$")
    public void iHaveEnterYear3Interest(String Year3Interest) throws Throwable {
        WebDriverWait wait = new WebDriverWait(driver, secondsToWait);
        WebElement element = driver.findElement(By.xpath(".//*[@class=\"interest-yr3 numeric-only\"]"));
        wait.until(ExpectedConditions.visibilityOf(element));
        element.clear();
        element.sendKeys(Year3Interest);
        this.year3interest=Year3Interest;
    }

    @And("^I have enter Year 4 Interest = \"([^\"]*)\"$")
    public void iHaveEnterYear4Interest(String Year4Interest) throws Throwable {
        WebDriverWait wait = new WebDriverWait(driver, secondsToWait);
        WebElement element = driver.findElement(By.xpath(".//*[@class=\"interest-yr4 numeric-only\"]"));
        wait.until(ExpectedConditions.visibilityOf(element));
        element.clear();
        element.sendKeys(Year4Interest);
        this.year4interest=Year4Interest;
    }

    @And("^I have enter Year 5 Interest = \"([^\"]*)\"$")
    public void iHaveEnterYear5Interest(String Year5Interest) throws Throwable {
        WebDriverWait wait = new WebDriverWait(driver, secondsToWait);
        WebElement element = driver.findElement(By.xpath(".//*[@class=\"interest-yr5 numeric-only\"]"));
        wait.until(ExpectedConditions.visibilityOf(element));
        element.clear();
        element.sendKeys(Year5Interest);
        this.year5interest=Year5Interest;
    }

    @And("^I click on Submit$")
    public void iClickOnSubmit() throws Throwable {
        WebDriverWait wait = new WebDriverWait(driver, secondsToWait);
        WebElement element = driver.findElement(By.xpath(".//*[@class=\"calculator-calculate-button btn-calculate\"]"));
        wait.until(ExpectedConditions.visibilityOf(element));
        element.click();
        Thread.sleep(8000);
    }

    @Then("^I will be able to see the Effective Interest Rate, Total Interest Payable and Total Amount Payable$")
    public void iWillBeAbleToSeeTheEffectiveInterestRateTotalInterestPayableAndTotalAmountPayable() {
        WebDriverWait wait = new WebDriverWait(driver, secondsToWait);
        WebElement element = driver.findElement(By.xpath("//div[contains(text(),\"Effective Interest Rate\")]"));
        wait.until(ExpectedConditions.visibilityOf(element));

        WebElement element2 = driver.findElement(By.xpath("//div[contains(text(),\"Total Interest Payable\")]"));
        wait.until(ExpectedConditions.visibilityOf(element2));

        WebElement element3 = driver.findElement(By.xpath("//div[contains(text(),\"Total Amount Payable\")]"));
        wait.until(ExpectedConditions.visibilityOf(element3));

    }

    @And("^I will be able to see the loan repayment table with total loan tenure that I’ve entered$")
    public void iWillBeAbleToSeeTheLoanRepaymentTableWithTotalLoanTenureThatIVeEntered() {
        WebDriverWait wait = new WebDriverWait(driver, secondsToWait);
        WebElement element = driver.findElement(By.xpath("//h2[contains(text(),\"Loan Repayment Table\")]"));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    @And("^different interest rates for different year based on my input$")
    public void differentInterestRatesForDifferentYearBasedOnMyInput() {
        WebElement element = driver.findElement(By.xpath("//tr[12]/td[2]"));
        assertTrue(element.getText().contains(this.year1interest));
        WebElement element2 = driver.findElement(By.xpath("//tr[24]/td[2]"));
        assertTrue(element2.getText().contains(this.year2interest));
        WebElement element3 = driver.findElement(By.xpath("//tr[36]/td[2]"));
        assertTrue(element3.getText().contains(this.year3interest));
        WebElement element4 = driver.findElement(By.xpath("//tr[48]/td[2]"));
        assertTrue(element4.getText().contains(this.year4interest));
        WebElement element5 = driver.findElement(By.xpath("//tr[60]/td[2]"));
        assertTrue(element5.getText().contains(this.year5interest));

    }
}
