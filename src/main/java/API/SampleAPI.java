package API;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import static io.restassured.RestAssured.*;


public class SampleAPI {

    public static void getParaMethod(String q1, String p1, String q2, String p2, String q3, String p3, String url) {

        given().queryParam(q1, p1).queryParam(q2, p2).queryParam(q3, p3).when().get(url).then().log().body();
    }

    public static void getPOSTMethod(String name1, String surname1, String name2, String surname2, String path) {

        JSONObject request = new JSONObject();
        request.put(name1, surname1);
        request.put(name2, surname2);
        given().body(request.toJSONString()).when().post(path).then().statusCode(201);

    }

    public static void getPUTMethod(String name1, String surname1, String name2, String surname2, String name, String value, String path) {

        JSONObject request = new JSONObject();
        request.put(name1, surname1);
        request.put(name2, surname2);
        given().header(name, value).contentType(ContentType.JSON).accept(ContentType.JSON).body(request.toJSONString()).when().
                put(path).then().statusCode(200);
    }
}
