package steps;import cucumber.api.java.Before;import org.openqa.selenium.WebDriver;import org.testng.asserts.SoftAssert;import utilities.Driver;import utilities.VyTrackLoginPage;import java.util.concurrent.TimeUnit;public class Hooks {        public static WebDriver driver;        @Before("@driver")        public void driverLogin() {            driver= Driver.getDriver();            driver.get("http://qa1.vytrack.com/");            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);            VyTrackLoginPage loginPage = new VyTrackLoginPage(driver);            loginPage.login("user156", "UserUser123");            SoftAssert softAssert = new SoftAssert();            softAssert.assertTrue(driver.getTitle().equals("Dashboard"), "Driver was able to successfully login to the VyTrack");        }        @Before("@storeManager")        public void storeManagerLogin() {            driver= Driver.getDriver();            driver.get("http://qa1.vytrack.com/");            VyTrackLoginPage loginPage = new VyTrackLoginPage(driver);            loginPage.login("storemanager89", "UserUser123");            SoftAssert softAssert = new SoftAssert();            softAssert.assertTrue(driver.getTitle().equals("Dashboard"), "Store manager was able to successfully login to the VyTrack");        }        @Before("@salesManager")        public void saleseManagerLogin() {            driver= Driver.getDriver();            driver.get("http://qa1.vytrack.com/");            VyTrackLoginPage loginPage = new VyTrackLoginPage(driver);            loginPage.login("salesmanager255", "UserUser123");            SoftAssert softAssert = new SoftAssert();            softAssert.assertTrue(driver.getTitle().equals("Dashboard"), "Sales manager was able to successfully login to the VyTrack");    }}