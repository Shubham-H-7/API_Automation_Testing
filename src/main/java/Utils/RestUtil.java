package Utils;

import java.util.concurrent.TimeUnit;
import static io.restassured.RestAssured.*;


public class RestUtil {

    public static long responseTime(String uri) {

        long t = get(uri).timeIn(TimeUnit.MILLISECONDS);
        return t;
    }

}
