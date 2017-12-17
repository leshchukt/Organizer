package ua.training.model.entity;

import java.util.ArrayList;
import java.util.List;

public class Opponent {
    private int idOpponent;
    private String firstName;
    private String lastName;
    private String contactPhone;
    private List<MeetingEvent> events = new ArrayList<>();

    public Opponent() {
    }

    public Opponent(int idOpponent, String firstName, String lastName, String contactPhone, List<MeetingEvent> events) {
        this.idOpponent = idOpponent;
        this.firstName = firstName;
        this.lastName = lastName;
        this.contactPhone = contactPhone;
        this.events = events;
    }

    public int getIdOpponent() {
        return idOpponent;
    }

    public void setIdOpponent(int idOpponent) {
        this.idOpponent = idOpponent;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public List<MeetingEvent> getEvents() {
        return events;
    }

    public void setEvents(List<MeetingEvent> events) {
        this.events = events;
    }

    @Override
    public String toString() {
        return "Opponent{" +
                "idOpponent=" + idOpponent +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", contactPhone='" + contactPhone + '\'' +
                '}';
    }
}
