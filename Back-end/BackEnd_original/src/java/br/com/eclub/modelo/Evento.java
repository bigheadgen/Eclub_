package br.com.eclub.modelo;
import java.sql.Time;
import java.util.Calendar;
import javax.xml.bind.annotation.XmlRootElement;
//@author Gustavo
@XmlRootElement
public class Evento {
    
    private Divulgador divulgador;
    private Endereco endereco;
    private String nomeEvento;
    private int idEvento;
    private String tipoEvento;
    private int qntHomens;
    private int qntmulheres;
    private int lotacaoMaxima;
    private double valorEntrada;
    private String descricaoEvento;
    private Calendar data;
    private Time horaEvento;

    public Evento(Divulgador divulgador, Endereco endereco){
        this.divulgador = divulgador;
        this.endereco = endereco;
    }
    public Evento() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    //gets e sets
    public void setHoraEvento(Time horaEvento) {
        this.horaEvento = horaEvento;
    }

    public Time getHoraEvento() {
        return horaEvento;
    }
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
    public Calendar getData() {
        return data;
    }
    public void setData(Calendar data) {
        this.data = data;
    }
}
