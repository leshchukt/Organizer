package ua.training.model.dao.mapper;

import ua.training.model.dao.implementation.JDBCEventDao;
import ua.training.model.entity.Category;
import ua.training.model.entity.Event;
import ua.training.model.entity.MeetingEvent;
import ua.training.model.entity.RecurringEvent;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Map;

public class EventMapper implements EntityMapper<Event>{
    @Override
    public Event extractFromResultSet(ResultSet rs) throws SQLException {
        Event result = new Event();

        result.setIdEvent(rs.getInt("idevent") );
        result.setEventTitle( rs.getString("eventtitle") );
        result.setDate(rs.getTimestamp("date").toLocalDateTime());
        result.setCategory(Category.valueOf(rs.getString("category")));

        return result;
    }



    @Override
    public Event makeUnique(Map<Integer, Event> map, Event event) {
        map.putIfAbsent(event.getIdEvent(), event);
        return map.get(event.getIdEvent());
    }
}
