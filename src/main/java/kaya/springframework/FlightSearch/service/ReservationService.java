package kaya.springframework.FlightSearch.service;

import kaya.springframework.FlightSearch.dto.ReservationRequest;
import kaya.springframework.FlightSearch.entity.Reservation;

public interface ReservationService {

    public Reservation bookFlight(ReservationRequest request);
}
