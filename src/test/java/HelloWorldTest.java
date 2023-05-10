import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HelloWorldTest {

    @Test
    public void testRestAssured() throws InterruptedException {
        JsonPath startJob = RestAssured
                .get("https://playground.learnqa.ru/api/longtime_job")
                .jsonPath();
        String token = startJob.get("token");
        Integer seconds = startJob.get("seconds");
        System.out.println(seconds);

        JsonPath firstTry = RestAssured
                .given()
                .queryParam("token", token)
                .get("https://playground.learnqa.ru/api/longtime_job")
                .jsonPath();
        String status = firstTry.get("status");
        System.out.println(status);

        Thread.sleep(seconds * 1000);
        JsonPath secondTry = RestAssured
                .given()
                .queryParam("token", token)
                .get("https://playground.learnqa.ru/api/longtime_job")
                .jsonPath();
        status = secondTry.get("status");
        String result = secondTry.get("result");
        System.out.println(status);
        System.out.println(result != null);
        if (result != null) {
            System.out.println(result);
        }
    }
}
