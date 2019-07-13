package utilities;import org.openqa.selenium.WebDriver;import org.openqa.selenium.WebElement;import org.openqa.selenium.support.FindBy;import org.openqa.selenium.support.PageFactory;public class ContactsPage {    WebDriver driver;    public ContactsPage(WebDriver driver){        this.driver=driver;        PageFactory.initElements(driver, this);    }    @FindBy(xpath = "//h1[@class='oro-subtitle']")    public WebElement allContacts;    @FindBy(xpath = "//a[contains(@class,'btn main-group btn-primary pull-right')]")    public WebElement createContact;}