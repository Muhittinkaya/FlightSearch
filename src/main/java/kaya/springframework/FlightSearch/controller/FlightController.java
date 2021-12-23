package kaya.springframework.FlightSearch.controller;

import kaya.springframework.FlightSearch.entity.Flight;
import kaya.springframework.FlightSearch.repository.FlightRepository;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

@Controller
public class FlightController {

    private FlightRepository flightRepository;

    public FlightController(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    @RequestMapping("/findFlights")
    public String findFlights(@RequestParam("from") String from, @RequestParam("to") String to,
                              @RequestParam("departureDate") @DateTimeFormat(pattern = "MM-dd-yyyy")Date departureDate, ModelMap modelMap){
        List<Flight> flights = flightRepository.findFlights(from, to, departureDate);
        modelMap.addAttribute("flights", flights);
        return "displayFlights";
    }
}
