package ua.training.model.sort;

import ua.training.model.entity.Event;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class EventSort {
    class EventComparatorByDate implements Comparator<Event> {
        @Override
        public int compare(Event o1, Event o2) {
            LocalDateTime date1 = o1.getDate();
            LocalDateTime date2 = o2.getDate();
            return (date1.equals(date2)
                    ? 0
                    : (date1.isBefore(date2))
                        ? -1
                        : 1);
        }
    }

    public List<Event> sortEventsByDate(List<Event> events) {
        Collections.sort(events, new EventComparatorByDate());
        return events;
    }
}
