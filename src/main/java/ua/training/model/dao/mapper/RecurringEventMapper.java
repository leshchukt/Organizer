package ua.training.model.dao.mapper;

import ua.training.model.entity.Category;
import ua.training.model.entity.RecurringEvent;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RecurringEventMapper extends EventMapper {
    @Override
    public RecurringEvent extractFromResultSet(ResultSet rs) throws SQLException {
        RecurringEvent result = new RecurringEvent();

        result.setIdEvent(rs.getInt("idevent") );
        result.setEventTitle( rs.getString("eventtitle") );
        result.setDate(rs.getTimestamp("date").toLocalDateTime());
        result.setPeriod(rs.getInt("period"));
        result.setCategory(Category.valueOf(rs.getString("category")));

        return result;
    }
}
