package br.com.eclub.controller;
//@author Gustavo, Thierry

import br.com.eclub.dao.DivulgadorDAO;
import br.com.eclub.modelo.Divulgador;

public class DivulgadorController {
    private DivulgadorDAO divulgadorDAO;
    public DivulgadorController(){
        this.divulgadorDAO = new DivulgadorDAO();
    }
    public void CadastrarDivulgador (Divulgador divulgador){
        try{
            if (divulgadorDAO.BuscarDivulgador(divulgador) != null){
                divulgadorDAO.CadastrarDivulgador(divulgador);
            }
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
