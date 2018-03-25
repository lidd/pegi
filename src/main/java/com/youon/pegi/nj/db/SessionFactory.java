package com.youon.pegi.nj.db;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Component
public class SessionFactory {

    private Connection connection;

    @PostConstruct
    private void initConn() throws SQLException, ClassNotFoundException {
        Class.forName("drivername");
        connection = DriverManager.getConnection("url", "user", "passwrod");
    }

    public int update(String sql) throws SQLException {
        return connection.prepareStatement(sql).executeUpdate();
    }
}
