package restful.booker.service;

import restful.booker.util.ReadableResponse;

public class BookingService extends BaseService{

    public ReadableResponse getBookingIds() { return getRequest("/booking"); }

    public ReadableResponse getBooking(Integer id) { return getRequest("/booking/" + id); }

    public ReadableResponse createBooking(String body) { return postRequest(body,"/booking"); }

    public ReadableResponse updateBooking(String token, String body, Integer id) { return putRequest("token=" + token, body,"/booking/" + id); }

    public ReadableResponse createToken(String body) { return postRequest( body,"/auth"); }

    public ReadableResponse partialUpdateBooking(String token, String body, Integer id) { return patchRequest("token=" + token, body,"/booking/" + id); }


}
