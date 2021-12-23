package kaya.springframework.FlightSearch.dto;

public class UpdateReservationRequest {

    private Long id;
    private Boolean checkedIn;
    private int numberOfBags;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getCheckedIn() {
        return checkedIn;
    }

    public void setCheckedIn(Boolean checkedIn) {
        this.checkedIn = checkedIn;
    }

    public int getNumberOfBags() {
        return numberOfBags;
    }

    public void setNumberOfBags(int numOfBags) {
        this.numberOfBags = numOfBags;
    }
}
