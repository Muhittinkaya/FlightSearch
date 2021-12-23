package kaya.springframework.FlightSearch.controller;

import kaya.springframework.FlightSearch.dto.UpdateReservationRequest;
import kaya.springframework.FlightSearch.entity.Reservation;
import kaya.springframework.FlightSearch.repository.ReservationRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class ReservationRestController {

    private ReservationRepository reservationRepository;

    public ReservationRestController(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    @RequestMapping("/reservations/{id}")
    public Reservation findReservation(@PathVariable("id") Long id){
        return reservationRepository.findById(id).get();
    }

    @RequestMapping(value = "/reservations")
    public Reservation updateReservation(@RequestBody UpdateReservationRequest updateReservationRequest){
        Reservation reservation = reservationRepository.findById(updateReservationRequest.getId()).get();
        reservation.setNumberOfBags(updateReservationRequest.getNumberOfBags());
        reservation.setCheckedIn(updateReservationRequest.getCheckedIn());
        return reservationRepository.save(reservation);
    }
}
