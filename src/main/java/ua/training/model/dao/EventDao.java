package ua.training.model.dao;

import ua.training.model.entity.Event;

import java.time.LocalDate;
import java.util.List;

public interface EventDao extends GenericDao<Event>{
    List<Event> findByDate(LocalDate date);
    List<Event> findWithinDates(LocalDate startDate, LocalDate endDate);
}
