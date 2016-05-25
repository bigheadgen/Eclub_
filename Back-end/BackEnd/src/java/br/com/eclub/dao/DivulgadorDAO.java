package br.com.eclub.dao;

import br.com.eclub.modelo.Divulgador;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

/**
 *
 * @author Thierry Freire
 */
public class DivulgadorDAO {
    
    private Connection conLocal;
    //Construtor Defaut
    public DivulgadorDAO() {
    
    
    }
    //Método para buscar usuário divulgador
    public Divulgador BuscarDivulgador (String CNPJ)throws SQLException{
        Divulgador aux = new Divulgador();
        aux.setCnpj(CNPJ);
        //Query no banco fazendo solicitação de busca da variável

         conLocal = new ConnectionFactory().getConnection();
         String s = "SELECT cnpj_Emp FROM empresa_divulgador WHERE CNPJ = ?;";
         PreparedStatement stmt;
         stmt = conLocal.prepareStatement(s);
         stmt.setString(1, aux.getCnpj());
         
        try (ResultSet rs = stmt.executeQuery()) {
            while(rs.next()) {
                aux.setEmailDivulgador(rs.getString("email_Emp"));
                //Implementar o set endereço na busca do divulgador
                aux.setNomeDivulgador(rs.getString("nome_Emp"));
                aux.setSenhaDivulgador(rs.getString("senha_Emp"));
                aux.setTelefoneDivulgador(rs.getString("telefone_Emp"));
                aux.setTipoDivulgador(rs.getString("tipo_Emp"));
            }
        }
                
         stmt.close();
         conLocal.close();
         
         return aux;
        
    }
    //Método para cadastrar usuário divulgador
    public Divulgador CadastrarDivulgador (String CNPJ)throws SQLException{
        Divulgador aux = new Divulgador();
        aux.setCnpj(CNPJ);
        //Query de cadastrar Divulgador
        if (BuscarDivulgador(aux.getCnpj()) == null){
           conLocal = new ConnectionFactory().getConnection();
           PreparedStatement stmt = conLocal.prepareStatement("INSERT INTO empresa_divulgador "
                   + "Values ('?', '?', '?', '?', '?', '?', '?')");
           ResultSet rs = stmt.executeQuery();
           while(rs.next()) {
                aux.setCnpj(rs.getString("cnpj_Emp"));
                aux.setEmailDivulgador(rs.getString("email_Emp"));
                //Implementar o set endereço no método
                aux.setNomeDivulgador(rs.getString("nome_Emp"));
                aux.setSenhaDivulgador(rs.getString("senha_Emp"));
                aux.setTelefoneDivulgador(rs.getString("telefone_Emp"));
                aux.setTipoDivulgador(rs.getString("tipo_Emp"));         
         }         
           conLocal.close();
           return aux;
        } else{
            return null;
            
        }
    }
    //Método para alterar usuário divulgador
    public Divulgador AlterarDivulgador (Divulgador aux)throws SQLException{
        //Query para alterar usuário Divulgador
         if (BuscarDivulgador(aux.getCnpj())!= null){
           conLocal = new ConnectionFactory().getConnection();
           PreparedStatement stmt = conLocal.prepareStatement("UPDATE empresa_divulgador "
                   + "SET nome_Emp = ?, telefone_Emp = ?, email_Emp = ?, tipo_Emp = ?, senha_Emp = ?,"
                   + " cnpj_Emp = ? WHERE cnpj_Emp = ?");
           ResultSet rs = stmt.executeQuery();
           while(rs.next()) {
                aux.setCnpj(rs.getString("cnpj_emp"));
                aux.setEmailDivulgador(rs.getString("email_Emp"));
                //Implementar set de endereço no método
                aux.setNomeDivulgador(rs.getString("nome_Emp"));
                aux.setSenhaDivulgador(rs.getString("senha_Emp"));
                aux.setTelefoneDivulgador(rs.getString("telefone_Emp"));
                aux.setTipoDivulgador(rs.getString("tipo_Emp"));
                
           }
           conLocal.close();
           return aux; 
        } else {
           return null;
        }
        
    }
    //Método para remover usuário divulgador
    public void RemoverDivulgador (Divulgador aux)throws SQLException{
        //Query de validar se o usuário exise para remoção;
        if (BuscarDivulgador(aux.getCnpj())!= null){
           String sql = ("DELETE FROM empresa_divulgador WHERE cnpj_Emp = ?;");
           
         conLocal = new ConnectionFactory().getConnection();
         PreparedStatement stmt;
         stmt = conLocal.prepareStatement(sql);
         stmt.setString(1, aux.getCnpj());
         stmt.close();
         conLocal.close();
        }
        
    }
}
