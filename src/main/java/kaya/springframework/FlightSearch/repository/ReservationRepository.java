package kaya.springframework.FlightSearch.repository;

import kaya.springframework.FlightSearch.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Long>{

}
