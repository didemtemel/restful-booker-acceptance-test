package restful.booker.service;

import restful.booker.util.ReadableResponse;

public class BookingService extends BaseService{
    public ReadableResponse getBookingIds() { return getRequest("/booking"); }

}
