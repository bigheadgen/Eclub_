package br.com.eclub.dao;

import br.com.eclub.modelo.Divulgador;
import java.sql.Connection;
import java.sql.SQLException;

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
        //Implemmentar método
        return null;
    }
    //Método para cadastrar usuário divulgador
    public Divulgador CadastrarDivulgador (String CNPJ)throws SQLException{
        //Implementar método
        return null;
    }
    //Método para alterar usuário divulgador
    public Divulgador AlterarDivulgador (String CNPJ)throws SQLException{
        //Implementar método
        return null;
    }
    //Método para remover usuário divulgador
    public void RemoverDivulgador (String CNPJ)throws SQLException{
        //Implementar método
        
    }
}
