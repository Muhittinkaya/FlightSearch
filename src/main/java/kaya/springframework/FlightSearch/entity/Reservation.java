package kaya.springframework.FlightSearch.entity;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import java.sql.Timestamp;

@Entity
public class Reservation extends BaseEntity {

    private boolean checkedIn;
    private int numberOfBags;
    @OneToOne
    private Passenger passenger;
    @OneToOne
    private Flight flight;
    private Timestamp created;

    public boolean isCheckedIn() {
        return checkedIn;
    }

    public void setCheckedIn(boolean checkedIn) {
        this.checkedIn = checkedIn;
    }

    public int getNumberOfBags() {
        return numberOfBags;
    }

    public void setNumberOfBags(int numberOfBags) {
        this.numberOfBags = numberOfBags;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }
}
