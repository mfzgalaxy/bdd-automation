package FirdausProj.glue;
import base.BaseScenario;
import com.gargoylesoftware.htmlunit.ElementNotFoundException;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class AxiataGlue extends BaseScenario {
    @When("^I click on Mobile Link$")
    public void iClickOnMobileLink() throws Throwable {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebDriverWait wait = new WebDriverWait(driver, secondsToWait);
        WebElement mobileLink = driver.findElement(By.xpath("(//a[contains(text(),'Mobile')])[6]"));
        js.executeScript("arguments[0].scrollIntoView();", mobileLink);
        wait.until(ExpectedConditions.visibilityOf(mobileLink));
        mobileLink.click();
        Thread.sleep(2000);
        WebElement TitleMobile = driver.findElement(By.xpath("//h2[contains(.,'Mobile')]"));
        wait.until(ExpectedConditions.visibilityOf(TitleMobile));
    }

    @And("^I click on Mobile Rate Plan$")
    public void iClickOnMobileRatePlan() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebDriverWait wait = new WebDriverWait(driver, secondsToWait);
        try {
            WebElement ratePlan = driver.findElement(By.xpath("(.//a[contains(@href, '/mobile-postpaid')])[4]"));
//            js.executeScript("arguments[0].scrollIntoView();", ratePlan);
            wait.until(ExpectedConditions.visibilityOf(ratePlan));
            ratePlan.click();
        } catch (ElementNotFoundException e){}
        Thread.sleep(2000);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[contains(.,'Plans for me')]"))));
        assertTrue(driver.findElement(By.xpath("//span[contains(.,'Plans for me')]")).isDisplayed());
    }

    @And("^I scroll down to Best Value Plan$")
    public void iScrollDownToBestValuePlan() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebDriverWait wait = new WebDriverWait(driver, secondsToWait);
        WebElement planSection = driver.findElement(By.xpath("//a[contains(text(),'Best value Mobile Postpaid Plans, tailored for you')]"));
        js.executeScript("arguments[0].scrollIntoView();", planSection);
        wait.until(ExpectedConditions.visibilityOf(planSection));
//        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//h3[contains(.,'Rs. 600 Plan')]"))));

    }

    @And("^I select \"([^\"]*)\"$")
    public void iSelect(int MobilePlan) throws Throwable {
        WebDriverWait wait = new WebDriverWait(driver, secondsToWait);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//h3[contains(.,'Rs. "+MobilePlan+" Plan')]"))));
        driver.findElement(By.id("PostpaidPlan"+MobilePlan+"")).click();
        Thread.sleep(2000);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//h2[contains(.,'"+MobilePlan+" Package')]"))));
        assertTrue(driver.findElement(By.xpath("//h2[contains(.,'"+MobilePlan+" Package')]")).isDisplayed());
//        throw new PendingException();
    }

    @And("^I add to cart$")
    public void iAddToCart() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, secondsToWait);
        WebElement addToCart = driver.findElement(By.name("submitButtonId"));
        wait.until(ExpectedConditions.visibilityOf(addToCart));
        addToCart.click();
        Thread.sleep(2000);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//h2[contains(.,'Shopping Cart')]"))));
        assertTrue(driver.findElement(By.xpath("//h2[contains(.,'Shopping Cart')]")).isDisplayed());
    }

    @And("^I remove from cart$")
    public void iRemoveFromCart() throws InterruptedException {
//        Open Link in New tab

//        Cart.sendKeys(Keys.CONTROL+"t");
        String currentURL = driver.getCurrentUrl();
        ((JavascriptExecutor)driver).executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        driver.get(currentURL);
        Thread.sleep(2000);
        WebElement Cart = driver.findElement(By.id("orderTotalCartBlock"));
        Cart.click();


        WebDriverWait wait = new WebDriverWait(driver, secondsToWait);
        WebElement removeCart = driver.findElement(By.cssSelector(".cart-remove > span"));
        wait.until(ExpectedConditions.visibilityOf(removeCart));
        removeCart.click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//h2[contains(.,'Shopping Cart is Empty')]"))));
    }

    @And("^I proceed checkout$")
    public void iProceedCheckout() {
        ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
        driver.close();
        driver.switchTo().window(tabs.get(0));

        WebDriverWait wait = new WebDriverWait(driver, secondsToWait);
        WebElement CheckOut = driver.findElement(By.id("shoppingcart_delivery_information"));
        wait.until(ExpectedConditions.visibilityOf(CheckOut));
        CheckOut.click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//h2[contains(.,'Shopping Cart is Empty')]"))));
        assertTrue(driver.findElement(By.xpath("//h2[contains(.,'Shopping Cart is Empty')]")).isDisplayed());
    }
}
