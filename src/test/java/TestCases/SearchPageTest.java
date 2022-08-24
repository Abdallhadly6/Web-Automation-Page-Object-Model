package TestCases;

import Base.TestBase;
import Pages.HomePage;
import Pages.SearchPage;
import TestUtils.TestUtils;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.lang.reflect.Method;

public class SearchPageTest extends TestBase {

    public SearchPageTest() throws IOException {
        super();
    }

    SearchPage searchPage ;
    HomePage homePage;

    @BeforeMethod
    public void beforeMethod(Method method) throws IOException {
        log = extentReports.startTest(method.getName());
        initialization();
        searchPage = new SearchPage();
        homePage = new HomePage();
        homePage.pressOnPhotoLink();
    }

    @AfterMethod
    public void afterMethod(Method method , ITestResult result) throws IOException {
        TestUtils.screenShot(method.getName());
        if(result.getStatus() == ITestResult.SUCCESS){
            log.log(LogStatus.PASS , "Test Pass..");
            log.log(LogStatus.PASS , "<a href = '"+result.getName()+".png" + "'><span class = 'lable info'> SnapShot</span></a>");
        }
        else if(result.getStatus() == ITestResult.FAILURE){
            log.log(LogStatus.FAIL , "Test Failed..");
            log.log(LogStatus.FAIL , "<a href = '"+result.getName()+".png" + "'><span class = 'lable info'> SnapShot</span></a>");
            log.log(LogStatus.FAIL , result.getThrowable());
        }
        else {
            log.log(LogStatus.SKIP , "Test Skipped..");
            log.log(LogStatus.SKIP , "<a href = '"+result.getName()+".png" + "'><span class = 'lable info'> SnapShot</span></a>");
            log.log(LogStatus.SKIP , result.getThrowable());
        }

        driver.quit();
    }

    @Test (priority = 2 , dataProvider = "myData")
    public void search(String searchText) throws IOException {
        searchPage.search(searchText);
        Assert.assertTrue(searchPage.displayedIcon());
    }

    @DataProvider
    public Object[][] myData() throws IOException {
        Object[][] data = TestUtils.getDatFromExcel("search");
        return data;

    }
}
