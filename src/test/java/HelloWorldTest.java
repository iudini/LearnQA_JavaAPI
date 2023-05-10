import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import org.junit.jupiter.api.Test;

import java.util.List;

public class HelloWorldTest {

    @Test
    public void testRestAssured() {
        JsonPath response = RestAssured
                .get("https://playground.learnqa.ru/api/get_json_homework")
                .jsonPath();
        List<JsonPath> messages = response.get("messages");
        System.out.println(messages.get(1));
    }
}
