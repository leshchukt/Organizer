package ua.training.model.dao.implementation;

import ua.training.model.dao.OpponentDao;
import ua.training.model.entity.Event;
import ua.training.model.entity.Opponent;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Set;

public class JDBCOpponentDao implements OpponentDao {
    private Connection connection;

    public JDBCOpponentDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(Opponent entity) {

    }

    @Override
    public Opponent findById(int id) {
        return null;
    }

    @Override
    public Set<Opponent> findAll(String sqlQuery) {
        return null;
    }

    @Override
    public void update(Opponent entity) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void close(){

    }
}
