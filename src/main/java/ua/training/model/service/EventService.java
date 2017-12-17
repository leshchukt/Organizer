package ua.training.model.service;

import ua.training.model.dao.DaoFactory;
import ua.training.model.dao.EventDao;
import ua.training.model.entity.Event;
import ua.training.view.SQLQuery;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class EventService implements SQLQuery{
    DaoFactory daoFactory = DaoFactory.getInstance();

    public Set<Event> getAllEvents(){
        try (EventDao dao = daoFactory.createEventDao()) {
            return dao.findAll(selectAll);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    public List<Event> getEventsByDate(LocalDate date) {
        try (EventDao dao = daoFactory.createEventDao()) {
            return dao.findByDate(date);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    public List<Event> getEventsWithinDates(LocalDate startDate, LocalDate endDate) {
        try (EventDao dao = daoFactory.createEventDao()) {
            return dao.findWithinDates(startDate, endDate);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    public List<Event> getEventsForNextWeek() {
        try (EventDao dao = daoFactory.createEventDao()) {
            return dao.checkComingEvents();
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

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
