package br.com.eclub.dao;
import br.com.eclub.modelo.Divulgador;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
//@author Thierry Freire,@author Gustavo Enndi
public class DivulgadorDAO {
    private Connection conLocal;
    //Construtor Defaut
    public DivulgadorDAO() {
    }
    //Método para buscar usuário divulgador
    public Divulgador BuscarDivulgador(Divulgador divulgador){
        //Query no banco fazendo solicitação de busca da variável
        Divulgador div = new Divulgador();
        conLocal = new ConnectionFactory().getConnection();
        String sql = "SELECT * FROM Divulgador WHERE nomeDivulgador = ? AND cnpjDivulgador= ?";
        try {
            PreparedStatement stmt = conLocal.prepareStatement(sql);
            stmt.setString(1, divulgador.getNomeDivulgador());
            stmt.setString(2, divulgador.getCnpj());
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                div.setNomeDivulgador(rs.getString("nomeDivulgador"));
                div.setEmailDivulgador(rs.getString("emaiDivulgador"));
                div.setTelefoneDivulgador(rs.getString("telefoneDivulgador"));
                div.setSenhaDivulgador(rs.getString("senhaDivulgador"));
                div.setCnpj(rs.getString("cnpjDivulgador"));
            }
            stmt.close();
            rs.close();
            conLocal.close();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return div;
    }
    public List<Divulgador> listarDivulgadoresTodos(){
        List<Divulgador> divulgadoresList = new ArrayList<>();
        conLocal = new ConnectionFactory().getConnection();
        String sql = "SELECT * FROM Divulgador";
        try {
            PreparedStatement stmt = conLocal.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Divulgador div = new Divulgador();
                div.setNomeDivulgador(rs.getString("nomeDivulgador"));
                div.setEmailDivulgador(rs.getString("emaiDivulgador"));
                div.setTelefoneDivulgador(rs.getString("telefoneDivulgador"));
                div.setSenhaDivulgador(rs.getString("senhaDivulgador"));
                div.setCnpj(rs.getString("cnpjDivulgador"));
                divulgadoresList.add(div);
            }
            stmt.close();
            rs.close();
            conLocal.close();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return divulgadoresList;
    }
    //Método para cadastrar usuário divulgador
    public void CadastrarDivulgador(Divulgador divulgador){
       String sql = "INSERT INTO Divulgador(nomeDivulgador, emailDivulgador,telefoneDivulgador ,senhaDivulgador , cnpjDivulgador)"
                + "VALUES(?,?,?,?,?)";
        conLocal = new ConnectionFactory().getConnection();
        try {
            PreparedStatement stmt = conLocal.prepareStatement(sql);
            stmt.setString(1, divulgador.getNomeDivulgador());
            stmt.setString(2, divulgador.getEmailDivulgador());
            stmt.setString(3, divulgador.getTelefoneDivulgador());
            stmt.setString(4, divulgador.getSenhaDivulgador());
            stmt.setString(5, divulgador.getCnpj());
            stmt.execute();
            stmt.close();
            conLocal.close();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
    //Método para alterar usuário divulgador
    public void AlterarDivulgador(Divulgador divulgador) throws SQLException {
        //Query para alterar usuário Divulgador
            String sql = "UPDATE Divulgador SET nomeDivulgador = ?, telefoneDivulgador = ?, emailDivulgador = ?, senhaDivulgador = ?,"
                    + "cnpjDivulgador = ?, WHERE cnpj_Emp = ? AND nomeDivulgador = ?";
            ResultSet rs;
        try (PreparedStatement stmt = conLocal.prepareStatement(sql)) {
            stmt.setString(1, divulgador.getNomeDivulgador());
            stmt.setString(2, divulgador.getTelefoneDivulgador());
            stmt.setString(3, divulgador.getEmailDivulgador());
            stmt.setString(4, divulgador.getSenhaDivulgador());
            stmt.setString(5, divulgador.getCnpj());
            stmt.setString(6, divulgador.getCnpj());
            stmt.setString(7, divulgador.getNomeDivulgador());
            
            conLocal = new ConnectionFactory().getConnection();
            rs = stmt.executeQuery();
            while (rs.next()) {
                divulgador.setCnpj(rs.getString("cnpjDivulgador"));
                divulgador.setEmailDivulgador(rs.getString("emailDivulgador"));
                //Implementar set de endereço no método
                divulgador.setNomeDivulgador(rs.getString("nomeDivulgador"));
                divulgador.setSenhaDivulgador(rs.getString("senhaDivulgador"));
                divulgador.setTelefoneDivulgador(rs.getString("telefoneDivulgador"));
                //divulgador.setTipoDivulgador(rs.getString("tipo_Emp"));
                //o tipo ainda nao tem no banco mas colocarei depois 
            }
            rs.close();
            conLocal.close();
        }catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
    //Método para remover usuário divulgador
    public void RemoverDivulgador(Divulgador divulgador) throws SQLException {
        //Query de validar se o usuário exise para remoção;
            String sql = ("DELETE FROM Divulgador WHERE cnpj_Emp = ? AND nomeDivulgador = ?");
            conLocal = new ConnectionFactory().getConnection();
        try (PreparedStatement stmt = conLocal.prepareStatement(sql)) {
            stmt.setString(1, divulgador.getCnpj());
            stmt.setString(2, divulgador.getNomeDivulgador());
            stmt.close();
            conLocal.close();
        }
        catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
}
