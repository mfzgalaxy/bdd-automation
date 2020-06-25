package FirdausProj.glue;
import base.BaseScenario;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class CheetahGlue extends BaseScenario {
    @When("^I drag little blue circle and drop into large circle$")
    public void iDragLittleBlueCircleAndDropIntoLargeCircle() {
        WebDriverWait wait = new WebDriverWait(driver, secondsToWait);
        WebElement From = driver.findElement(By.id("draggable"));
        WebElement To = driver.findElement(By.id("droptarget"));
        Actions act=new Actions(driver);
        act.dragAndDrop(From, To).build().perform();
    }

    @Then("^I will be able to see You did great! Results$")
    public void iWillBeAbleToSeeYouDidGreatResults() {
       assertThat(driver.findElement(By.id("droptarget")).getText(), is("You did great!"));
    }
}
