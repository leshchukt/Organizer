package ua.training.model.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class RecurringEvent extends Event {
    private int period;

    public RecurringEvent() {
    }

    public RecurringEvent(int idEvent, String eventTitle, LocalDateTime date, Category category, int period) {
        super(idEvent, eventTitle, date, category);
        this.period = period;
    }

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    @Override
    public String toString() {
        return "RecurringEvent{" +
                "idEvent=" + getIdEvent() +
                ", eventTitle='" + getEventTitle() + '\'' +
                ", date='" + getDate() + '\'' +
                ", category=" + getCategory() +
                ", period=" + period +
                "}\n";
    }
}
