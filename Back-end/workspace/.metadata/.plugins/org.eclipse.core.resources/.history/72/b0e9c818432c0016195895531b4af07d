package br.com.eclub.ws;

import br.com.eclub.controller.EventoController;
import br.com.eclub.modelo.Endereco;
import br.com.eclub.modelo.Evento;
import java.sql.SQLException;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//@author Gustavo
@Path("/evento")
public class EventoWS {
	
	
	
	@GET
    @Path("/teste")
    @Produces("application/json")
    public String teste() throws SQLException {
        return "eureka!!";
    }
	
	@GET
    @Path("/listarTodosEventos")
    @Produces("application/json")
    public List<Evento> listarEventos(String local) throws SQLException {
        EventoController ec = new EventoController();
        Endereco endereco = new Endereco();
        endereco.setCidade(local);
        return ec.ListarEventos(local);
    }
}
