package com.techzoner.weCare.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public class BookingUpdateDTO {
    @JsonFormat(shape=JsonFormat.Shape.STRING,pattern="dd-MM-yyyy")
    private LocalDate appointmentDate;
    private String slot;

    public LocalDate getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(LocalDate appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public String getSlot() {
        return slot;
    }

    public void setSlot(String slot) {
        this.slot = slot;
    }
}
