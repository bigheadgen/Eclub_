package br.com.eclub.modelo;
import javax.xml.bind.annotation.XmlRootElement;
//@author Gustavo
@XmlRootElement
public class Endereco {
    private String estado;
    private String cidade;
    private String bairro;
    private String rua;
    private int numero;
    private String latitude;
    private String longetude;
            
    //construtor, a latitude e longetude sao obrigatorios 
    public Endereco(String latitude, String longetude){
        this.latitude = latitude;
        this.longetude = longetude;
    }
    public Endereco() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    } 
    //gets e sets
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public String getCidade() {
        return cidade;
    }
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
    public String getBairro() {
        return bairro;
    }
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }
    public String getRua() {
        return rua;
    }
    public void setRua(String rua) {
        this.rua = rua;
    }
    public int getNumero() {
        return numero;
    }
    public void setNumero(int numero) {
        this.numero = numero;
    }
    public String getLatitude() {
        return latitude;
    }
    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }
    public String getLongetude() {
        return longetude;
    }
    public void setLongetude(String longetude) {
        this.longetude = longetude;
    }
}
