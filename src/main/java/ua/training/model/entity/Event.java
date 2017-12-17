package ua.training.model.entity;

import java.awt.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Event {
    private int idEvent;
    private String eventTitle;
    private LocalDateTime date;
    private Category category;

    public Event() {
    }

    public Event(int idEvent, String eventTitle, LocalDateTime date, Category category) {
        this.idEvent = idEvent;
        this.eventTitle = eventTitle;
        this.date = date;
        this.category = category;
    }

    public int getIdEvent() {
        return idEvent;
    }

    public void setIdEvent(int idEvent) {
        this.idEvent = idEvent;
    }

    public String getEventTitle() {
        return eventTitle;
    }

    public void setEventTitle(String eventTitle) {
        this.eventTitle = eventTitle;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Event{" +
                "idEvent=" + idEvent +
                ", eventTitle='" + eventTitle + '\'' +
                ", date='" + date + '\'' +
                ", category=" + category +
                "}\n";
    }

}
