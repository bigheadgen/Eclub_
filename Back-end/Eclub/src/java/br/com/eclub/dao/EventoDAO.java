package br.com.eclub.dao;

import br.com.eclub.modelo.Evento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Gustavo, Thierry Freire
 */
public class EventoDAO {

    public Connection conLocal;

    public EventoDAO() {
        ConnectionFactory con = new ConnectionFactory();
        conLocal = con.getConnection();
    }

    public void inserirEvento(Evento evento) {
        Evento e = new Evento();
        e = evento;
        String sql = "";

    }
}
