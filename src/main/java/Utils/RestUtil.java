package Utils;

import io.restassured.RestAssured;
import java.util.concurrent.TimeUnit;
import static io.restassured.RestAssured.*;


public class RestUtil {

    public static String path;

    public static long responseTime(String uri) {
        long t = get(uri).timeIn(TimeUnit.SECONDS);
        return t;
    }

    public static void setBaseURI(String baseURI) {

        RestAssured.baseURI = baseURI;
    }

    public static void setBasePath(String basePathTerm) {

        RestAssured.basePath = basePathTerm;
    }

    public static void resetBaseURI() {

        RestAssured.baseURI = null;
    }

    public static void resetBasePath() {

        RestAssured.basePath = null;
    }
}
