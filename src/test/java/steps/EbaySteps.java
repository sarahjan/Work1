package steps;import cucumber.api.PendingException;import cucumber.api.java.en.And;import cucumber.api.java.en.Given;import cucumber.api.java.en.Then;import cucumber.api.java.en.When;import org.apache.http.util.Asserts;import org.openqa.selenium.By;import org.openqa.selenium.WebDriver;import org.openqa.selenium.chrome.ChromeDriver;import org.testng.Assert;import utilities.Driver;/* When User search for "wooden spoon" under related category    And User can see search result    Then User should click "All" button    And should be able to see total wooden result for all categories    And Search result for categories should be more than search for related category    Then User should able to navigate back and see whether "wooden spoon" is still displayed in search box    And User should navigate back to home page and search box should be empty*/public class EbaySteps {    public static WebDriver driver;    public static int numAllResult;    public static int numResult;    public static String s;    @Given("^Ebay home page$")    public void ebay_home_page() throws Throwable {        Driver.setDriver("chrome");        driver=Driver.getDriver();        driver.get("https://www.ebay.com/");    }    @When("^User search for \"([^\"]*)\" under related category$")    public void user_search_for_something_under_related_category(String strArg1) throws Throwable {        driver.findElement(By.cssSelector("input[type='text']")).sendKeys("wooden spoon");        driver.findElement(By.id("gh-btn")).click();    }    @Then("^User should click \"([^\"]*)\" button$")    public void user_should_click_something_button(String strArg1) throws Throwable {        driver.findElement(By.xpath("//*[.='All']")).click();        Thread.sleep(3000);    }    @And("^User can see search result$")    public void user_can_see_search_result() throws Throwable {        String result = driver.findElement(By.cssSelector("h1[class='srp-controls__count-heading'")).getText();        result = result.replaceAll("[^0-9]", "");       numResult = Integer.parseInt(result);        Thread.sleep(3000);    }    @And("^should be able to see total wooden result for all categories$")    public void should_be_able_to_see_total_wooden_result_for_all_categories() throws Throwable {        String allResult = driver.findElement(By.className("srp-controls__count-heading")).getText();        allResult = allResult.replaceAll("[^0-9]", "");         numAllResult = Integer.parseInt(allResult);    }    @And("^Search result for categories should be more than search for related category$")    public void search_result_for_categories_should_be_more_than_search_for_related_category() throws Throwable {        Assert.assertTrue(numAllResult > numResult, "Working as expected");    }    @Then("^User should able to navigate back and see whether \"([^\"]*)\" is still displayed in search box$")    public void user_should_able_to_navigate_back_and_see_whether_something_is_still_displayed_in_search_box(String strArg1) throws Throwable {        driver.navigate().back();        s=driver.findElement(By.cssSelector("input[type='text']")).getAttribute("value");        Assert.assertTrue(s.contains("wooden spoon"),"Target search is still displayed after navigating back");    }    @And("^User should navigate back to home page and search box should be empty$")    public void user_should_navigate_back_to_home_page_and_search_box_should_be_empty() throws Throwable {        driver.navigate().back();        s=driver.findElement(By.cssSelector("input[type='text']")).getText();        Assert.assertTrue(s.isEmpty(),"Home search is empty after navigating back to home page");    }}