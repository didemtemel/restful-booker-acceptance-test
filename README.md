# restful-booker-acceptance-test

Restful Booker Api Document: https://restful-booker.herokuapp.com/apidoc/index.html



Test Cases:

CreateBookingTest
- it_should_create_booking()


DeleteBookingTest
- it_should_delete_booking_by_id()
- it_should_return_403_when_token_is_invalid_while_deleting_booking()


GetBookingIdsTest
- it_should_get_booking_ids


GetBookingTest
- it_should_get_booking_by_id()
- it_should_return_404_when_booking_id_not_found()

PartialUpdateBookingTest
- it_should_update_first_name()
- it_should_update_last_name()
- it_should_update_total_price()
- it_should_update_deposit_paid()
- it_should_update_additional_needs()
- it_should_return_403_when_token_is_invalid_while_updating_booking()


UpdateBookingTest
- it_should_update_booking()
- it_should_return_403_when_token_is_invalid_while_updating_booking()
