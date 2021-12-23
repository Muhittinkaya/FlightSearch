package kaya.springframework.FlightSearch.repository;

import kaya.springframework.FlightSearch.entity.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassengerRepository extends JpaRepository<Passenger, Long> {
}
