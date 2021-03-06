package restful.booker.service;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import restful.booker.util.QueryParam;
import restful.booker.util.ReadableResponse;

import java.util.List;

import static io.restassured.RestAssured.given;
import static restful.booker.helper.Config.BOOKING_SERVICE_URL;

public class BaseService {
    private static final String CONTENT_TYPE = "Content-Type";
    private static final String ACCEPT = "Accept";
    private static final String APPLICATION_JSON = "application/json";
    private static final String COOKIE = "Cookie";

    private final RequestSpecification spec = new RequestSpecBuilder()
            .setBaseUri(BOOKING_SERVICE_URL)
            .setBasePath("/")
            .addFilter(new AllureRestAssured())
            .build();

    protected ReadableResponse getRequest(String endPoint) {
        Response response = given()
                .spec(spec)
                .header(CONTENT_TYPE, APPLICATION_JSON)
                .when()
                .get(endPoint)
                .then()
                .extract()
                .response();

        return new ReadableResponse(response);
    }



    protected ReadableResponse getRequest(List<QueryParam> queryParams, String endPoint) {
        RequestSpecification requestSpecification = given()
                .spec(spec)
                .header(CONTENT_TYPE, APPLICATION_JSON);

        for (QueryParam queryParam : queryParams) {
            requestSpecification.queryParam(queryParam.getKey(), queryParam.getValue());
        }

        var response = requestSpecification
                .when()
                .get(endPoint)
                .then()
                .extract()
                .response();

        return new ReadableResponse(response);
    }

    protected ReadableResponse postRequest(String body, String endPoint) {

        var response = given()
                .spec(spec)
                .header(CONTENT_TYPE, APPLICATION_JSON)
                .when()
                .body(body)
                .post(endPoint)
                .then()
                .extract()
                .response();

        return new ReadableResponse(response);
    }

    protected ReadableResponse putRequest(String body, String endPoint) {

        var response = given()
                .spec(spec)
                .header(CONTENT_TYPE, APPLICATION_JSON)
                .when()
                .body(body)
                .put(endPoint)
                .then()
                .extract()
                .response();

        return new ReadableResponse(response);
    }

    protected ReadableResponse putRequest(String token, String body, String endPoint) {

        var response = given()
                .spec(spec)
                .header(CONTENT_TYPE, APPLICATION_JSON)
                .header(ACCEPT, APPLICATION_JSON)
                .header(COOKIE, token)
                .when()
                .body(body)
                .put(endPoint)
                .then()
                .extract()
                .response();

        return new ReadableResponse(response);
    }

    protected ReadableResponse patchRequest(String token, String body, String endPoint) {

        var response = given()
                .spec(spec)
                .header(CONTENT_TYPE, APPLICATION_JSON)
                .header(ACCEPT, APPLICATION_JSON)
                .header(COOKIE, token)
                .when()
                .body(body)
                .patch(endPoint)
                .then()
                .extract()
                .response();

        return new ReadableResponse(response);
    }

    protected ReadableResponse deleteRequest(String token, String endPoint) {

        var response = given()
                .spec(spec)
                .header(CONTENT_TYPE, APPLICATION_JSON)
                .header(ACCEPT, APPLICATION_JSON)
                .header(COOKIE, token)
                .when()
                .delete(endPoint)
                .then()
                .extract()
                .response();

        return new ReadableResponse(response);
    }

    protected ReadableResponse putRequest(String endPoint) {

        var response = given()
                .spec(spec)
                .header(CONTENT_TYPE, APPLICATION_JSON)
                .when()
                .put(endPoint)
                .then()
                .extract()
                .response();

        return new ReadableResponse(response);
    }
}
