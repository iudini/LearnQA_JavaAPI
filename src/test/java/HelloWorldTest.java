import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.util.*;

public class HelloWorldTest {

    public static final String YOU_ARE_AUTHORIZED = "You are authorized";

    @Test
    public void testRestAssured() {
        Set<String> passwords = new HashSet<>();
        passwords.add("password");
        passwords.add("123456");
        passwords.add("123456789");
        passwords.add("12345678");
        passwords.add("qwerty");
        passwords.add("baseball");
        passwords.add("iloveyou");
        passwords.add("1234567");
        passwords.add("1234567890");
        passwords.add("1q2w3e4r");
        passwords.add("666666");
        passwords.add("111111");
        passwords.add("1qaz2wsx");
        passwords.add("admin");
        passwords.add("abc123");
        passwords.add("1234");
        passwords.add("121212");
        passwords.add("bailey");
        passwords.add("access");
        passwords.add("flower");
        passwords.add("555555");
        passwords.add("monkey");
        passwords.add("lovely");
        passwords.add("shadow");
        passwords.add("ashley");
        passwords.add("letmein");
        passwords.add("7777777");
        passwords.add("football");
        passwords.add("12345");
        passwords.add("login");
        passwords.add("sunshine");
        passwords.add("!@#$%^&*");
        passwords.add("welcome");
        passwords.add("654321");
        passwords.add("jesus");
        passwords.add("master");
        passwords.add("hello");
        passwords.add("charlie");
        passwords.add("888888");
        passwords.add("superman");
        passwords.add("696969");
        passwords.add("qwertyuiop");
        passwords.add("hottie");
        passwords.add("freedom");
        passwords.add("aa123456");
        passwords.add("princess");
        passwords.add("ninja");
        passwords.add("azerty");
        passwords.add("123123");
        passwords.add("solo");
        passwords.add("loveme");
        passwords.add("whatever");
        passwords.add("donald");
        passwords.add("dragon");
        passwords.add("michael");
        passwords.add("mustang");
        passwords.add("batman");
        passwords.add("passw0rd");
        passwords.add("zaq1zaq1");
        passwords.add("qazwsx");
        passwords.add("Football");
        passwords.add("000000");
        passwords.add("starwars");
        passwords.add("password1");
        passwords.add("trustno1");
        passwords.add("qwerty123");
        passwords.add("123qwe");
        Map<String, String> params = new HashMap<>();
        for (String password : passwords) {
            params.put("login", "super_admin");
            params.put("password", password);
            Response response = RestAssured
                    .given()
                    .body(params)
                    .post("https://playground.learnqa.ru/api/get_secret_password_homework")
                    .andReturn();
            String auth_cookie = response.getCookie("auth_cookie");

            Response checkAuth = RestAssured
                    .given()
                    .cookie("auth_cookie", auth_cookie)
                    .get("https://playground.learnqa.ru/api/check_auth_cookie")
                    .andReturn();
            if (checkAuth.getBody().asString().equals(YOU_ARE_AUTHORIZED)) {
                System.out.println(password);
                break;
            }
        }
    }
}
