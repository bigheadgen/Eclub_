package br.com.eclub.teste;

import br.com.eclub.dao.ConnectionFactory;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author Gustavo
 */
public class TestConexao {
    
    public static void main(String []Args) throws SQLException{
        
        Connection con = new ConnectionFactory().getConnection();
        System.out.println("Conexao Aberta");
        con.close();
        
        
    }
    
}
