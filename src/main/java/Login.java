import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login {


    WebDriver driver;

    By userName = By.id("name");
    By userId = By.id("id");
    By contactNumber = By.id("contactNumber");
    By sendRequest = By.cssSelector("input[type='submit']");
    String a ;
    String b ;
    String c ;


    public Login(WebDriver driver) {
        this.driver = driver;
    }

    public void typeUserName(String name) {
        a=name;
        driver.findElement(userName).sendKeys(name);
    }

    public void typeUserId(String id) {
        b=id;
        driver.findElement(userId).clear();
        driver.findElement(userId).sendKeys(id);
    }

    public void typeUserContactNumber(String number) {
        c=number;
        driver.findElement(contactNumber).sendKeys(number);

    }

    public void clickOnSendRequest() {

        WebElement explicitWait = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.elementToBeClickable(sendRequest));
        explicitWait.click();
    }


    public String comparisonName() {
        String q = driver.findElement(By.xpath("html/body/table/tbody/tr[1]/td[2]")).getText();
        return q;

    }
    public String comparisonId() {
        String w = driver.findElement(By.xpath("html/body/table/tbody/tr[2]/td[2]")).getText();
        return w;

    }
    public String comparisonNumber() {
        String e = driver.findElement(By.xpath("html/body/table/tbody/tr[3]/td[2]")).getText();
        return e;

    }

}
