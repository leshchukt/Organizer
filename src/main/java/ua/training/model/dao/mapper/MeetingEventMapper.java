package ua.training.model.dao.mapper;

import ua.training.model.entity.Event;
import ua.training.model.entity.MeetingEvent;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MeetingEventMapper extends EventMapper {
    @Override
    public MeetingEvent extractFromResultSet(ResultSet rs) throws SQLException {
        MeetingEvent result = new MeetingEvent();

        result.setIdEvent(rs.getInt("idevent") );
        result.setEventTitle( rs.getString("eventtitle") );
        result.setDate(rs.getTimestamp("date").toLocalDateTime());

        return result;
    }
}
