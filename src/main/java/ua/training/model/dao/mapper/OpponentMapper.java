package ua.training.model.dao.mapper;

import ua.training.model.entity.Opponent;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public class OpponentMapper implements EntityMapper<Opponent>{
    @Override
    public Opponent extractFromResultSet(ResultSet rs) throws SQLException {
        Opponent result = new Opponent();

        result.setIdOpponent(rs.getInt("idoponent") );
        result.setFirstName(rs.getString("firstname") );
        result.setLastName(rs.getString("lastname"));
        result.setContactPhone(rs.getString("contactphone"));

        return result;
    }

    @Override
    public Opponent makeUnique(Map<Integer, Opponent> map, Opponent opponent) {
        map.putIfAbsent(opponent.getIdOpponent(), opponent);
        return map.get(opponent.getIdOpponent());
    }
}
