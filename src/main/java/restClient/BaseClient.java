package restClient;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.config.LogConfig;
import com.jayway.restassured.config.RestAssuredConfig;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import json.JsonParser;
import models.Human;

import java.io.PrintStream;

import static com.jayway.restassured.RestAssured.given;

public class BaseClient {
    private static PrintStream printStream;

    RequestSpecification getRestClient() {
        return given().config(configRestClient(printStream)).log().all().baseUri("http://localhost:8080").auth().basic("admin", "123");
    }

    public Response get(String endPoint) {
        return getRestClient().get(endPoint);
    }

    public Response create(String endPoint, Human human) {
        return getRestClient().header("Content-Type", "application/json").body(JsonParser.convertHumanToJson(human)).post(endPoint);
    }

    public Response delete(String endPoint, String paramName, String paramValue) {
        return getRestClient().param(paramName, paramValue).delete(endPoint);
    }

    public static RestAssuredConfig configRestClient(PrintStream file) {
        return RestAssured.config().logConfig(new LogConfig(file, true));
    }

    public static void setPrintStream(PrintStream stream) {
        printStream = stream;
    }
}
