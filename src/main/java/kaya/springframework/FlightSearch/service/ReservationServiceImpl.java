package kaya.springframework.FlightSearch.service;

import kaya.springframework.FlightSearch.dto.ReservationRequest;
import kaya.springframework.FlightSearch.entity.Flight;
import kaya.springframework.FlightSearch.entity.Passenger;
import kaya.springframework.FlightSearch.entity.Reservation;
import kaya.springframework.FlightSearch.repository.FlightRepository;
import kaya.springframework.FlightSearch.repository.PassengerRepository;
import kaya.springframework.FlightSearch.repository.ReservationRepository;
import org.springframework.stereotype.Service;

@Service
public class ReservationServiceImpl implements ReservationService{

    private FlightRepository flightRepository;
    private PassengerRepository passengerRepository;
    private ReservationRepository reservationRepository;

    public ReservationServiceImpl(FlightRepository flightRepository, PassengerRepository passengerRepository, ReservationRepository reservationRepository) {
        this.flightRepository = flightRepository;
        this.passengerRepository = passengerRepository;
        this.reservationRepository = reservationRepository;
    }

    @Override
    public Reservation bookFlight(ReservationRequest request) {

        Long flightId = request.getFlightId();
        Flight flight = flightRepository.getById(flightId);

        Passenger passenger = new Passenger();
        passenger.setFirstName(request.getPassengerFirstName());
        passenger.setLastName(request.getPassengerLastName());
        passenger.setEmail(request.getPassengerEmail());
        passenger.setPhone(request.getPassengerPhone());
        Passenger savedPassenger = passengerRepository.save(passenger);

        Reservation reservation = new Reservation();
        reservation.setPassenger(savedPassenger);
        reservation.setFlight(flight);
        reservation.setCheckedIn(false);
        Reservation savedReservation = reservationRepository.save(reservation);

        return savedReservation;
    }
}
