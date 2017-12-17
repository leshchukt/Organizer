package ua.training.model.dao.implementation;

import org.apache.commons.dbcp.BasicDataSource;
import ua.training.view.DBConnectionConstants;

import javax.sql.DataSource;
import javax.xml.registry.infomodel.User;

public class ConnectionPoolHolder implements DBConnectionConstants{
    private static volatile DataSource dataSource;
    public static DataSource getDataSource(){

        if (dataSource == null){
            synchronized (ConnectionPoolHolder.class) {
                if (dataSource == null) {
                    BasicDataSource ds = new BasicDataSource();
                    ds.setUrl(URLDBConnection);
                    ds.setUsername(UserDBConnection);
                    ds.setPassword(PasswordDBConnection);
                    ds.setMinIdle(5);
                    ds.setMaxIdle(10);
                    ds.setMaxOpenPreparedStatements(100);
                    dataSource = ds;
                }
            }
        }

        return dataSource;

    }
}
