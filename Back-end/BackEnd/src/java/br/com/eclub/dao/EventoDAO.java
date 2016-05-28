package br.com.eclub.dao;

import br.com.eclub.modelo.Endereco;
import br.com.eclub.modelo.Evento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

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

    public void inserirEvento(Evento evento) throws SQLException {
        Evento e = new Evento();
        Endereco end = new Endereco(null, null);
        e = evento;
        String sql = "INSERT INTO evento (qntHomem, valorEntrada, qntMulher, qntMaxPessoas, idEvento, nome_Evento, tipo_Evento, data_Evento,hora_Evento, descrição_Evento, id_Endereco, nome_Emp, cnpj_Emp)";

        try (PreparedStatement stmt = conLocal.prepareStatement(sql)) {
            stmt.setInt(1, evento.getQntHomens());
            stmt.setDouble(2, evento.getValorEntrada());
            stmt.setInt(3, evento.getQntmulheres());
            stmt.setInt(4, evento.getLotacaoMaxima());
            stmt.setInt(5, evento.getIdEvento());
            stmt.setString(6, evento.getNomeEvento());
            stmt.setString(7, evento.getTipoEvento());
            stmt.setDate(8, (java.sql.Date) (Date) evento.getData());
            stmt.setTime(9, evento.getHoraEvento());
            stmt.setString(10, evento.getDescricaoEvento());
            stmt.setInt(11, evento.getEndereco().getIdEndereco());
            stmt.setString(12, evento.getDivulgador().getNomeDivulgador());
            stmt.setString(13, evento.getDivulgador().getCnpj());

            stmt.executeQuery();

        } catch (SQLException ex) {
            Logger.getLogger(EventoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        conLocal.close();
        
    }

    public boolean excluirEvento(Evento evento) throws SQLException {

        String sql = "DELETE from evento where id_evento = ?";
        PreparedStatement stmt = null;
        try {
            stmt = conLocal.prepareStatement(sql);
            stmt.setInt(1, evento.getIdEvento());

            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            return false;
        }
        
    }

    public Evento pesquisarEvento(String cidade) throws SQLException {

        Evento eve = new Evento();
        Endereco end = new Endereco("", "");

        String sql = "SELECT * from evento where cidade = ?";
        try {
            PreparedStatement stmt = conLocal.prepareStatement(sql);
            stmt.setString(1, cidade);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                eve.setNomeEvento(rs.getString("nome_Evento"));
                end.setCidade(rs.getString("cidade"));
                eve.setEndereco(end);
                eve.setQntHomens(rs.getInt("qntHomem"));
                eve.setQntmulheres(rs.getInt("qntMulher"));
                eve.setTipoEvento(rs.getString("tipo_Evento"));
                eve.setData(rs.getDate("data_Evento"));
                eve.setHoraEvento(rs.getTime("hora_Evento"));
                eve.setDescricaoEvento(rs.getString("descrição_Evento"));

            }
            return eve;
        } catch (SQLException e) {
            return null;
        }
      }
    }
    public List<Evento> listarEventos(Endereco endereco) throws SQLException {
        
        //falar com andre para ele criar o codigo sql para o select no banco 
        //para trazer todos os eventos a partir de um  local 
        String sql = "SELECT * FROM Evento E, Endereco D WHERE E.id_Endereco = ? AND D.cidade = ?;";
        //Verificar se o select está realmente correto
        PreparedStatement stmt = conLocal.prepareStatement(sql);
        stmt.setString(1, endereco.getCidade());
        ResultSet rs = stmt.executeQuery();
        
        List<Evento> eventos = new ArrayList<>();
        while (rs.next()){
            Evento ev = new Evento();
            
            ev.setNomeEvento(rs.getString("nome_Evento"));
            ev.setTipoEvento(rs.getString("tipo_Evento"));
            ev.setValorEntrada(rs.getDouble("valorEntrada"));
            ev.setData(rs.getDate("data_Evento"));
            ev.setLotacaoMaxima(rs.getByte("qntMaxPessoas"));
            ev.setHoraEvento(rs.getTime("hora_Evento"));
            ev.setQntHomens(rs.getInt("qntHomem"));
            ev.setQntmulheres(rs.getInt("qntMulher"));
            ev.setDescricaoEvento(rs.getString("descricaoEvento"));
            
            // falta adicionar ao evento o endereco e o divulgador
            
            //apos o evento estar completo deve ser adicionado a lista de eventos
            eventos.add(ev);
                        
            
           
        }
               
        return eventos;
    }

}

