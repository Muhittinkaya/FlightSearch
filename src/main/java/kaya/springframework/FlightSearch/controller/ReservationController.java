package kaya.springframework.FlightSearch.controller;

import kaya.springframework.FlightSearch.dto.ReservationRequest;
import kaya.springframework.FlightSearch.entity.Flight;
import kaya.springframework.FlightSearch.entity.Reservation;
import kaya.springframework.FlightSearch.repository.FlightRepository;
import kaya.springframework.FlightSearch.service.ReservationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class ReservationController {

    private FlightRepository flightRepository;
    private ReservationService reservationService;

    public ReservationController(FlightRepository flightRepository, ReservationService reservationService) {
        this.flightRepository = flightRepository;
        this.reservationService = reservationService;
    }

    @RequestMapping("/showCompleteReservation")
    public String showCompleteReservation(@RequestParam("flightId") Long flightId, ModelMap modelMap){
        Flight flight = flightRepository.getById(flightId);
        modelMap.addAttribute("flight",flight);
        return "/completeReservation";
    }

    @RequestMapping(value = "/completeReservation", method = RequestMethod.POST)
    public String completeReservation(ReservationRequest request, ModelMap modelMap){
        Reservation reservation = reservationService.bookFlight(request);
        modelMap.addAttribute("msg","Reservation is created and the id is: " + reservation.getId());
        return "/reservationConfirmation";
    }
}
