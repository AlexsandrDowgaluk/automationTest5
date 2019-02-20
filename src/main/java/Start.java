import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.TestNG;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.internal.TestResult;

import java.awt.*;
import java.io.IOException;

public class Start {
    @Test
    public void employee() throws AWTException, IOException {
        System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost:8080/test5/employee");
        Login addEmployee = new Login(driver);
        addEmployee.typeUserName("Alexandr");
        addEmployee.typeUserId("7");
        addEmployee.typeUserContactNumber("0939517619");
        addEmployee.clickOnSendRequest();


        Assert.assertTrue(addEmployee.comparisonName().contains(addEmployee.a));
        Assert.assertTrue(addEmployee.comparisonId().contains(addEmployee.b));
        Assert.assertTrue(addEmployee.comparisonNumber().contains(addEmployee.c));




        driver.quit();


    }

    @AfterMethod
    public void screenBag(ITestResult result) throws IOException, AWTException {

if (result.getStatus()== ITestResult.FAILURE)
{
    ScreenShot photo = new ScreenShot();
    photo.screenshot();
}
if (result.getStatus()==ITestResult.SUCCESS){
    System.out.println("Все ок");
}


    }



}
