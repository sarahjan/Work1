package steps;import cucumber.api.java.en.And;import cucumber.api.java.en.Given;import cucumber.api.java.en.Then;import cucumber.api.java.en.When;import org.openqa.selenium.By;import org.openqa.selenium.Keys;import org.openqa.selenium.WebDriver;import org.openqa.selenium.chrome.ChromeDriver;import org.testng.Assert;import org.testng.asserts.SoftAssert;import utilities.Driver;import java.security.Key;public class GoogleSteps {   public static WebDriver driver;    static   String url;    static String currentURL;    @Given("^Google lending page$")    public void google_lending_page() throws Throwable {        Driver.setDriver("chrome");       driver=Driver.getDriver();        driver.get("https://www.google.com/");    }    @When("^User is searching (.+)$")    public void user_is_searching(String search) throws Throwable {        driver.findElement(By.name("q")).sendKeys(search, Keys.ENTER);    }    @Then("^User capture first result url$")    public void user_capture_first_selult_url() throws Throwable {        url= driver.findElement(By.className("iUh30")).getText();    }    @Then("^Search url must match website url$")    public void search_url_must_match_website_url() throws Throwable {        Assert.assertEquals(currentURL, url, "Google Test has passed ");    }    @And("^Click to the first result$")    public void click_to_the_first_result() throws Throwable {        driver.findElement(By.className("iUh30")).click();        Thread.sleep(5000);        currentURL=driver.getCurrentUrl();        driver.navigate().back();        Thread.sleep(5000);        driver.findElement(By.name("q")).clear();    }}