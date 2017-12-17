package ua.training.model.dao.implementation;

import ua.training.model.dao.EventDao;
import ua.training.model.dao.mapper.*;
import ua.training.model.entity.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

public class JDBCEventDao implements EventDao {
    private Connection connection;

    public JDBCEventDao(Connection connection) {
        this.connection = connection;
    }

    private boolean isRecurringEvent(ResultSet resultSet) throws SQLException {
        return (resultSet.getInt("period") != 0);
    }

    private boolean isMeetingEvent(ResultSet resultSet) throws SQLException {
        return (resultSet.getInt("idoponent") != 0);
    }

    @Override
    public void create(Event entity) {

    }

    @Override
    public Event findById(int id) {
        return null;
    }

    @Override
    public List<Event> findByDate(LocalDate date) {
        List<Event> eventsByDate = new ArrayList<>();
        for(Event event : findAll()) {
            if (event.getDate().toLocalDate().equals(date)) {
                eventsByDate.add(event);
            }
        }
        return eventsByDate;
    }

    @Override
    public List<Event> findWithinDates(LocalDate startDate, LocalDate endDate) {
        List<Event> eventsWithinDates = new ArrayList<>();
        for(Event event : findAll()) {
            LocalDate eventDate = event.getDate().toLocalDate();
            if(eventDate.isAfter(startDate) && eventDate.isBefore(endDate)) {
                eventsWithinDates.add(event);
            }
        }
        return eventsWithinDates;
    }

    @Override
    public Set<Event> findAll() {
        Set<Event> resultSet = new HashSet<>();
        Map<Integer,Opponent> opponentHashMap = new HashMap<>();
        Map<Integer,Event> eventHashMap = new HashMap<>();
        Map<Integer,Category> categoryHashMap = new HashMap<>();
        OpponentMapper opponentMapper = new OpponentMapper();
        CategoryMapper categoryMapper = new CategoryMapper();
        EventMapper eventMapper = new EventMapper();
        RecurringEventMapper recurringEventMapper = new RecurringEventMapper();
        MeetingEventMapper meetingEventMapper = new MeetingEventMapper();

        try (Statement ps = connection.createStatement()){
            ResultSet rs = ps.executeQuery(
                    "SELECT DISTINCT * FROM event " +
                            "LEFT JOIN category ON event.idcategory = category.idcategory " +
                            "left join event_has_oponent on event.idevent = event_has_oponent.idevent " +
                            "left join oponent on event_has_oponent.idoponent = oponent.idoponent");
            while ( rs.next() ){

                Event result = getEvent(eventMapper, recurringEventMapper, meetingEventMapper, rs);

                Opponent opponent = opponentMapper.extractFromResultSet(rs);
                Category category = categoryMapper.extractFromResultSet(rs);
                result = eventMapper.makeUnique(eventHashMap, result);
                opponent = opponentMapper.makeUnique(opponentHashMap, opponent);
                category = categoryMapper.makeUnique(categoryHashMap, category);
                result.setCategory(category);
                category.getEvents().add(result);

                if (isMeetingEvent(rs)) {
                    ((MeetingEvent)result).getOpponents().add(opponent);
                    opponent.getEvents().add((MeetingEvent) result);
                }
                resultSet.add(result);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return resultSet;
    }

    private Event getEvent(EventMapper eventMapper, RecurringEventMapper recurringEventMapper, MeetingEventMapper meetingEventMapper, ResultSet rs) throws SQLException {
        return isMeetingEvent(rs)
                            ? meetingEventMapper.extractFromResultSet(rs)
                            : (isRecurringEvent(rs)
                                    ? recurringEventMapper.extractFromResultSet(rs)
                                    : eventMapper.extractFromResultSet(rs));
    }


    @Override
    public void update(Event entity) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void close() throws Exception {

    }
}
