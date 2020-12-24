package Base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;


import static io.restassured.RestAssured.*;

public class BaseMethod {


    public static ExtentReports extentReport() {
        ExtentHtmlReporter htmlReporter;
        ExtentReports extent;
        htmlReporter = new ExtentHtmlReporter("extentReports.html");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        return extent;
    }

    public static void getMethod(String url) {
        given().get(url).then().statusCode(200).log().all();
    }
}
