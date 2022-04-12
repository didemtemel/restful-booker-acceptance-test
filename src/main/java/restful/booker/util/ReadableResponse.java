package restful.booker.util;

import io.restassured.response.Response;
import lombok.Data;

@Data
public class ReadableResponse {
    private int statusCode;
    private String statusLine;
    private Response response;

    public ReadableResponse(Response response) {
        this.response = response;
        this.statusCode = response.getStatusCode();
        this.statusLine = response.getStatusLine();
    }

}