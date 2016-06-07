package br.com.eclub.controller;
//@author Gustavo, Thierry

import br.com.eclub.dao.DivulgadorDAO;
import br.com.eclub.modelo.Divulgador;
import java.sql.SQLException;

public class DivulgadorController {
    private DivulgadorDAO divulgadorDAO;
    public DivulgadorController(){
        this.divulgadorDAO = new DivulgadorDAO();
    }
    public void CadastrarDivulgador (Divulgador divulgador){
        try{
            if (divulgadorDAO.BuscarDivulgador(divulgador) == null){
                divulgadorDAO.CadastrarDivulgador(divulgador);
            }
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }
    public void AlterarDivulgador (Divulgador divulgador) throws SQLException{
        try {
            if(divulgadorDAO.BuscarDivulgador(divulgador) != null){
                divulgadorDAO.AlterarDivulgador(divulgador);
            }
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }
    public void RemoverDivulgador (Divulgador divulgador) throws SQLException{
        try{
            if (divulgadorDAO.BuscarDivulgador(divulgador) != null){
                divulgadorDAO.RemoverDivulgador(divulgador);
            }
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
