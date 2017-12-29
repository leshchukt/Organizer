package ua.training.model.dao.implementation;

import ua.training.model.dao.EventDao;
import ua.training.model.dao.mapper.*;
import ua.training.model.entity.*;
import ua.training.view.SQLQuery;

import java.sql.*;
import java.time.LocalDate;
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
        /*
        List<Event> eventsByDate = new ArrayList<>();
        for(Event event : findAll()) {
            if (event.getDate().toLocalDate().equals(date)) {
                eventsByDate.add(event);
            }
        }
        return eventsByDate;
        */
        String byDate = " WHERE DATE(event.date) = \'" + date + "\'";
        return new ArrayList<>(findAll(SQLQuery.selectAll + byDate));
    }

    @Override
    public List<Event> findWithinDates(LocalDate startDate, LocalDate endDate) {
        /*
        List<Event> eventsWithinDates = new ArrayList<>();
        for(Event event : findAll()) {
            LocalDate eventDate = event.getDate().toLocalDate();
            if(eventDate.isAfter(startDate) && eventDate.isBefore(endDate)) {
                eventsWithinDates.add(event);
            }
        }
        return eventsWithinDates;
    */
        String withinDates = " WHERE DATE(event.date) BETWEEN \'" +
                startDate + "\' AND \'" +
                endDate + "\'";
        return new ArrayList<>(findAll(SQLQuery.selectAll + withinDates));
    }

    @Override
    public List<Event> checkComingEvents() {
        String eventsForNextWeek = " WHERE DATE(event.date) BETWEEN \'" +
                LocalDate.now() + "\' AND \'" +
                LocalDate.now().plusWeeks(1) + "\'";
        return new ArrayList<>(findAll(SQLQuery.selectAll + eventsForNextWeek));
    }

    @Override
    public Set<Event> findAll(String sqlQuery) {
        Map<Integer,Opponent> opponentHashMap = new HashMap<>();
        Map<Integer,Event> eventHashMap = new HashMap<>();

        OpponentMapper opponentMapper = new OpponentMapper();
        EventMapper eventMapper = new EventMapper();
        RecurringEventMapper recurringEventMapper = new RecurringEventMapper();
        MeetingEventMapper meetingEventMapper = new MeetingEventMapper();

        try (Statement ps = connection.createStatement()){
            ResultSet rs = ps.executeQuery(sqlQuery);
            while ( rs.next() ){
                System.out.println(1);
                Event result = getEvent(eventMapper, recurringEventMapper, meetingEventMapper, rs);
                System.out.println(2);
                Opponent opponent = opponentMapper.extractFromResultSet(rs);
                result = eventMapper.makeUnique(eventHashMap, result);
                opponent = opponentMapper.makeUnique(opponentHashMap, opponent);
                System.out.println(3);
                if (isMeetingEvent(rs)) {
                    ((MeetingEvent)result).getOpponents().add(opponent);
                    opponent.getEvents().add((MeetingEvent) result);
                }
                System.out.println(4);
            }
        } catch (Exception e) {
            throw new RuntimeException("problem in findAll");
        }
        return new HashSet<>(eventHashMap.values());
    }

    private Event getEvent(EventMapper eventMapper,
                           RecurringEventMapper recurringEventMapper,
                           MeetingEventMapper meetingEventMapper,
                           ResultSet rs)
            throws SQLException {

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
    public void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
