import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

public class HelloWorldTest {

    @Test
    public void testRestAssured() {
        Response response;
        String location = "https://playground.learnqa.ru/api/long_redirect";
        int count = 0;

        do {
            response = RestAssured
                    .given()
                    .redirects()
                    .follow(false)
                    .get(location)
                    .andReturn();
            location = response.getHeader("Location");
            System.out.println(location);
            count++;
        } while (response.getStatusCode() != 200);
        System.out.println(count);
    }
}
