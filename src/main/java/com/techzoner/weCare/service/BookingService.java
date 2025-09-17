package com.techzoner.weCare.service;

import com.techzoner.weCare.dto.BookingDTO;
import com.techzoner.weCare.dto.BookingUpdateDTO;
import com.techzoner.weCare.exception.weCareException;

public interface BookingService {
    public Boolean bookAppointment(String userId,String coachId,BookingDTO bookingDto) throws weCareException;
    public void deleteBooking(Integer bookingId);
    public Boolean rescheduleBooking(Integer bookingId, BookingUpdateDTO bookingUpdatedto) throws weCareException;
}
