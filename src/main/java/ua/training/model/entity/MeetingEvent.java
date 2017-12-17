package ua.training.model.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class MeetingEvent extends Event {
    private List<Opponent> opponents = new ArrayList<>();

    public MeetingEvent() {
    }

    public MeetingEvent(int idEvent, String eventTitle, LocalDateTime date, Category category, List<Opponent> opponents) {
        super(idEvent, eventTitle, date, category);
        this.opponents = opponents;
    }

    public List<Opponent> getOpponents() {
        return opponents;
    }

    public void setOpponents(List<Opponent> opponents) {
        this.opponents = opponents;
    }

    @Override
    public String toString() {
        return "MeetingEvent{" +
                "idEvent=" + getIdEvent() +
                ", eventTitle='" + getEventTitle() + '\'' +
                ", date='" + getDate() + '\'' +
                ", category=" + getCategory() +
                "opponents=" + opponents +
                "}\n";
    }
}
