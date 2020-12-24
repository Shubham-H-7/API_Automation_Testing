package Test;

import API.SampleAPI;
import Base.BaseMethod;
import Utils.RestUtil;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class TestSuite {
    ExtentReports extent;

    @Test(priority = 1)
    public void test_Get_1() {
        extent = BaseMethod.extentReport();
        ExtentTest test1 = extent.createTest("GET_TestCase_1");
        test1.log(Status.INFO, "Test Started");
        BaseMethod.getMethod("https://reqres.in/api/users?page=2");
        test1.pass("Test Case is passed");
        test1.log(Status.INFO, "Time taken by url to response " + RestUtil.responseTime("https://reqres.in/api/users?page=2") + " Seconds");
    }

    @Test(priority = 2)
    public void test_Get_Query() {

        ExtentTest test2 = extent.createTest("GET_TestCase_Query1");
        test2.log(Status.INFO, "Test started");
        SampleAPI.getParaMethod("CUSTOMER_ID", "68195", "PASSWORD", "1234", "Account_No", "1", "http://demo.guru99.com/V4/sinkministatement.php");
        test2.pass("Test Case is passed");
        test2.log(Status.INFO, "Details of query GET has been fetched");
        test2.log(Status.INFO, "Time taken by url to response " + RestUtil.responseTime("http://demo.guru99.com/V4/sinkministatement.php") + " Seconds");
    }

    @Test(priority = 3)
    public void test_Post() {

        ExtentTest test3 = extent.createTest("POST_Test_Case_1");
        test3.log(Status.INFO, "Test started");
        SampleAPI.getPOSTMethod("name", "morpheus", "job", "leader", "https://reqres.in/api/users");
        test3.pass("Test Case is passed");
        test3.log(Status.INFO, "Time taken by url to response " + RestUtil.responseTime("http://demo.guru99.com/V4/sinkministatement.php") + " Seconds");

    }

    @Test(priority = 4)
    public void test_Put() {

        ExtentTest test4 = extent.createTest("PUT_Test_Case_1");
        test4.log(Status.INFO, "Test Started");
        SampleAPI.getPUTMethod("name", "morpheus", "job", "zion resident", "Content-Tye", "application/json", "https://reqres.in/api/users/2");
        test4.pass("Test Case is passed");
        test4.log(Status.INFO, "Time taken by url to response " + RestUtil.responseTime("https://reqres.in/api/users/2") + " Seconds");
    }

    @AfterClass
    public void afterTest() {

        extent.flush();
    }
}
