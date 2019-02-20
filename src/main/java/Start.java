import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.IOException;

public class Start {

    @DataProvider(name = "test1")
    public Object[][] createData1() {
        return new Object[][]{
                {"Dowgaluk", "7", "0939517619"},
                {"Dowgaluktest", "7", "0939517619"},


        };
    }

    @Test(dataProvider = "test1")
    public void employee(String n1, String n2, String n3) {
        System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost:8080/test5/employee");
        Login addEmployee = new Login(driver);
        addEmployee.typeUserName(n1);
        addEmployee.typeUserId(n2);
        addEmployee.typeUserContactNumber(n3);
        addEmployee.clickOnSendRequest();


        Assert.assertTrue(addEmployee.comparisonName().contains(addEmployee.a));
        Assert.assertTrue(addEmployee.comparisonId().contains(addEmployee.b));
        Assert.assertTrue(addEmployee.comparisonNumber().contains(addEmployee.c));


        driver.quit();


    }

    @AfterMethod
    public void screenBag(ITestResult result) throws IOException, AWTException, InterruptedException {

        if (result.getStatus() == ITestResult.FAILURE) {
            Thread.sleep(1000);
            ScreenShot photo = new ScreenShot();
            photo.screenshot();
        }
        if (result.getStatus() == ITestResult.SUCCESS) {
            System.out.println("Все ок");
        }


    }


}
