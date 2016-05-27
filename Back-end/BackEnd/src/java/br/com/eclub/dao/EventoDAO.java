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

    private Connection conLocal;

    public EventoDAO() {
        ConnectionFactory con = new ConnectionFactory();
        conLocal = con.getConnection();
    }

    public void inserirEvento(Evento evento) {
        Evento e = new Evento();
        e = evento;
        String sql = "INSERT INTO Evento VALUES ('?', '?', '?', '?', '?', '?', '?', '?', '?')";
        //terminar execução do código SQL
    }
    public List<Evento> listarEventos(String local) throws SQLException{
        
        //falar com andre para ele criar o codigo sql para o select no banco 
        //para trazer todos os eventos aparti de um  local 
        String sql = "SELECT * FROM Evento WHERE ";
        PreparedStatement stmt = conLocal.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        
        List<Evento> eventos = new ArrayList<>();
        while (rs.next()){
            //continuar codigo 
            //responsavel
        }
        
        return eventos;
    }
}
