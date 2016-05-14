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
    private Connection con;

    //metodo que vai trazer todos os eventos de um local
    public ArrayList<Evento> getEventos(String localBusca) {
       
        
        //adicionar o retorno correto 
        return null;
    }   
    public int buscarEvento(String nome) throws SQLException{
        int id = -1;
        List <Evento> eventos = new ArrayList ();
        //query que busca o evento no banco
       con = new ConnectionFactory().getConnection();
       PreparedStatement stmt = con.prepareStatement("SELECT FROM Evento WHERE nome = ?"); 
       stmt.setString(1, nome);
       ResultSet rs = stmt.executeQuery();
       while (rs.next()){
           
       }
       con.close();
       return id;
    }
        
    public void removerEvento(String nome) throws SQLException{
    
       int id = buscarEvento(nome);
    //query que deleta o evento do banco
       
    
    }
    
}
