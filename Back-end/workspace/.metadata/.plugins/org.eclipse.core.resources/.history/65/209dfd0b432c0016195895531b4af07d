package br.com.eclub.dao;
import java.sql.Connection;
import java.sql.DriverManager;
//@author Gustavo
public class ConnectionFactory {
    public Connection getConnection(){
        try {
            return DriverManager.
                    getConnection("jdbc:mysql://127.0.0.1/Eclub" ,"root", "");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
