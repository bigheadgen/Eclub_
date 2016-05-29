package br.com.eclub.teste;
import br.com.eclub.dao.ConnectionFactory;
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.SQLException;
//@author Gustavo
public class TestConexao {
    public static void main(String []Args) throws SQLException{
        
        try (Connection con = new ConnectionFactory().getConnection()) {
            out.println("Conexao Aberta");
        }
    }  
}
