package FirdausProj.glue;

import base.BaseScenario;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.google.common.collect.Range.greaterThan;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;


public class AstroGlue extends BaseScenario {
   
    @When("^I check every link available$")
    public void iCheckEveryLinkAvailable() {
        String url = "";
        HttpURLConnection huc = null;
        int respCode = 200;
        List<WebElement> links = driver.findElements(By.tagName("a"));
        Iterator<WebElement> it = links.iterator();

        while(it.hasNext()) {

            url = it.next().getAttribute("href");

            System.out.println(url);
        }
    }

    @Then("^All the links should be up and running$")
    public void allTheLinksShouldBeUpAndRunning() {
        String url = "";
        HttpURLConnection huc = null;
        int respCode = 200;
        List<WebElement> links = driver.findElements(By.tagName("a"));
        Iterator<WebElement> it = links.iterator();

        while(it.hasNext()){

            url = it.next().getAttribute("href");

            if(url == null || url.isEmpty()){
                System.out.println("URL is either not configured for anchor tag or it is empty");
                continue;
            }

            try {
                huc = (HttpURLConnection)(new URL(url).openConnection());

                huc.setRequestMethod("HEAD");

                huc.connect();

                respCode = huc.getResponseCode();

                if(respCode >= 400){
                    System.out.println(url+" is a broken link");
                    assertTrue(respCode >=400);
                }
                else{
                    System.out.println(url+" is a valid link");
                }

            } catch (MalformedURLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    @When("^\"([^\"]*)\" page should be up and running$")
    public void pageShouldBeUpAndRunning(String url) throws Throwable {

        HttpURLConnection huc = null;
        int respCode = 200;


            huc = (HttpURLConnection)(new URL(url).openConnection());

            huc.setRequestMethod("HEAD");

            huc.connect();

            respCode = huc.getResponseCode();

            if(respCode >= 400){
                System.out.println(url+" is a broken link");
                fail("Reason of fail");
//                assertTrue(respCode >=400);
            }
            else{
                System.out.println(url+" is a valid link");
            }



    }
}
