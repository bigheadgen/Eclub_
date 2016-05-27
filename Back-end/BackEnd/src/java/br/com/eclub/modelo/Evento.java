package br.com.eclub.modelo;

import java.sql.Time;
import java.util.Date;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Gustavo
 */
@XmlRootElement
public class Evento {
    
    private Divulgador divulgador;
    private Endereco endereco;
    private String nomeEvento;
    /*o id provavelmente vai ser um auto incremente
    no banco entao falta alinhar com a equipe de banco de dados
    */
    private int idEvento;
    private String tipoEvento;
    private int qntHomens;
    private int qntmulheres;
    private int lotacaoMaxima;
    private double valorEntrada;
    private String descricaoEvento;
    private Date data;
    private Time horaEvento;
    //adicionar o atributo da foto
    
    
//    //Construtor é obrigatorio um divulgador e um endereco
//    public Evento(Divulgador divulgador, Endereco endereco){
//        this.divulgador = divulgador;
//        this.endereco = endereco;
//    }

    
    //gets e sets

    public Divulgador getDivulgador() {
        return divulgador;
    }

    public void setDivulgador(Divulgador divulgador) {
        this.divulgador = divulgador;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String getNomeEvento() {
        return nomeEvento;
    }

    public void setNomeEvento(String nomeEvento) {
        this.nomeEvento = nomeEvento;
    }

    public int getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(int idEvento) {
        this.idEvento = idEvento;
    }

    public String getTipoEvento() {
        return tipoEvento;
    }

    public void setTipoEvento(String tipoEvento) {
        this.tipoEvento = tipoEvento;
    }

    public int getQntHomens() {
        return qntHomens;
    }

    public void setQntHomens(int qntHomens) {
        this.qntHomens = qntHomens;
    }

    public int getQntmulheres() {
        return qntmulheres;
    }

    public void setQntmulheres(int qntmulheres) {
        this.qntmulheres = qntmulheres;
    }

    public int getLotacaoMaxima() {
        return lotacaoMaxima;
    }

    public void setLotacaoMaxima(int lotacaoMaxima) {
        this.lotacaoMaxima = lotacaoMaxima;
    }

    public double getValorEntrada() {
        return valorEntrada;
    }

    public void setValorEntrada(double valorEntrada) {
        this.valorEntrada = valorEntrada;
    }

    public String getDescricaoEvento() {
        return descricaoEvento;
    }

    public void setDescricaoEvento(String descricaoEvento) {
        this.descricaoEvento = descricaoEvento;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Time getHoraEvento() {
        return horaEvento;
    }

    public void setHoraEvento(Time horaEvento) {
        this.horaEvento = horaEvento;
    }

    
    
    
    
    
}
