package restful.booker.builder;

import restful.booker.model.request.CreateTokenRequest;

public class CreateTokenSampleData {

    public static CreateTokenRequest.CreateTokenRequestBuilder createTokenRequestBuilder(){

        return CreateTokenRequest.builder()
                .username("admin")
                .password("password123");
    }
}
