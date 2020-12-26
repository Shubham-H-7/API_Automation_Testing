package Test;

import API.SampleAPI;
import Base.BaseMethod;
import Utils.RestUtil;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class TestSuite {
    ExtentReports extent;

    @Test(priority = 1)
    public void test_Get_1() {

        extent = BaseMethod.extentReport();
        ExtentTest test1 = extent.createTest("GET_TestCase_1");
        String className = this.getClass().getSimpleName();
        test1.log(Status.INFO, "Test Started");
        BaseMethod.getMethod("https://reqres.in/api/users?page=2");
        test1.log(Status.PASS, MarkupHelper.createLabel("Test completed and passed", ExtentColor.GREEN));
        test1.log(Status.INFO, "Time taken by url to response " + RestUtil.responseTime("https://reqres.in/api/users?page=2") + " MILLISECONDS");
    }

    @Test(priority = 2)
    public void test_Get_Query() {

        ExtentTest test2 = extent.createTest("GET_TestCase_Query1");
        test2.log(Status.INFO, "Test started");
        SampleAPI.getParaMethod("CUSTOMER_ID", "68195", "PASSWORD", "1234", "Account_No", "1", "http://demo.guru99.com/V4/sinkministatement.php");
        test2.log(Status.PASS, MarkupHelper.createLabel("Test completed and passed", ExtentColor.GREEN));
        test2.log(Status.INFO, "Details of query GET has been fetched");
        test2.log(Status.INFO, "Time taken by url to response " + RestUtil.responseTime("http://demo.guru99.com/V4/sinkministatement.php") + " MILLISECONDS");
    }

    @Test(priority = 3)
    public void test_Post() {

        ExtentTest test3 = extent.createTest("POST_TestCase_1");
        test3.log(Status.INFO, "Test started");
        SampleAPI.getPOSTMethod("name", "morpheus", "job", "leader", "https://reqres.in/api/users");
        test3.log(Status.PASS, MarkupHelper.createLabel("Test completed and passed", ExtentColor.GREEN));
        test3.log(Status.INFO, "Time taken by url to response " + RestUtil.responseTime("http://demo.guru99.com/V4/sinkministatement.php") + " MILLISECONDS");

    }

    @Test(priority = 4)
    public void test_Put() {

        ExtentTest test4 = extent.createTest("PUT_TestCase_1");
        test4.log(Status.INFO, "Test Started");
        SampleAPI.getPUTMethod("name", "morpheus", "job", "zion resident", "Content-Tye", "application/json", "https://reqres.in/api/users/2");
        test4.log(Status.PASS, MarkupHelper.createLabel("Test completed and passed", ExtentColor.GREEN));
        test4.log(Status.INFO, "Time taken by url to response " + RestUtil.responseTime("https://reqres.in/api/users/2") + " MILLISECONDS");
    }

    @AfterClass
    public void afterTest() {

        extent.flush();
    }
}
