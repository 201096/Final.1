package data;

import data.interfaces.IDBManager;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBManager implements IDBManager {

    public Connection getConnection() {
        try {
            Class.forName("org.postgresql.driver");
            Connection connection = DriverManager.getConnection ( " jdbc.postgresql://localhost:5432/Medicalcenter", "postgres", "root");
            return connection;
        }
        catch (Exception e){
            e.printStackTrace();

        }
        return null;
    }

}
