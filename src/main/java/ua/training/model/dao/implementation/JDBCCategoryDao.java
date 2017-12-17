package ua.training.model.dao.implementation;

import ua.training.model.dao.CategoryDao;
import ua.training.model.entity.Category;
import ua.training.model.entity.Opponent;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Set;

public class JDBCCategoryDao implements CategoryDao {
    private Connection connection;

    public JDBCCategoryDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(Category entity) {

    }

    @Override
    public Category findById(int id) {
        return null;
    }

    @Override
    public Set<Category> findAll(String sqlQuery) {
        return null;
    }

    @Override
    public void update(Category entity) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void close() throws Exception {

    }
}
