package ua.training.model.dao.implementation;

import ua.training.model.dao.CategoryDao;
import ua.training.model.dao.DaoFactory;
import ua.training.model.dao.EventDao;
import ua.training.model.dao.OpponentDao;
import ua.training.view.DBConnectionConstants;

import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCDaoFactory extends DaoFactory implements DBConnectionConstants {

    private DataSource dataSource;

    public JDBCDaoFactory() {
        try {
            InitialContext initialContext = new InitialContext();
            dataSource = (DataSource) initialContext.lookup("java:comp/env/jdbc/organizer");
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    @Override
    public EventDao createEventDao() {
        return new JDBCEventDao(getConnection());
    }

    @Override
    public CategoryDao createCategoryDao() {
        return new JDBCCategoryDao(getConnection());
    }

    @Override
    public OpponentDao createOpponentDao() {
        return new JDBCOpponentDao(getConnection());
    }

    private Connection getConnection() {
        try {
            return dataSource.getConnection();
            /*
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            return DriverManager.getConnection(
                    URLDBConnection,
                    UserDBConnection ,
                    PasswordDBConnection); */
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
