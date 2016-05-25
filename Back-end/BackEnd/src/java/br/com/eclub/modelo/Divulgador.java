package br.com.eclub.modelo;
/**
 *
 * @author Gustavo
 */
public class Divulgador {
    
    private String nomeDivulgador;
    private String emailDivulgador;
    private String telefoneDivulgador;
    private String tipoDivulgador;
    private Endereco endereco;
    private String cnpj;
    private String senhaDivulgador;

    
    //No Divulgador para o cadastro é obrigatorio o nome e o cnpj
    public Divulgador(String nomeDivulgador,String cnpj){
        this.nomeDivulgador = nomeDivulgador;
        this.cnpj = cnpj;
    }

    public Divulgador() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    //gets e sets
    public String getNomeDivulgador() {
        return nomeDivulgador;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
    
    public void setNomeDivulgador(String nomeDivulgador) {
        this.nomeDivulgador = nomeDivulgador;
    }

    public String getEmailDivulgador() {
        return emailDivulgador;
    }

    public void setEmailDivulgador(String emailDivulgador) {
        this.emailDivulgador = emailDivulgador;
    }

    public String getTelefoneDivulgador() {
        return telefoneDivulgador;
    }

    public void setTelefoneDivulgador(String telefoneDivulgador) {
        this.telefoneDivulgador = telefoneDivulgador;
    }

    public String getTipoDivulgador() {
        return tipoDivulgador;
    }

    public void setTipoDivulgador(String tipoDivulgador) {
        this.tipoDivulgador = tipoDivulgador;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getSenhaDivulgador() {
        return senhaDivulgador;
    }

    public void setSenhaDivulgador(String senhaDivulgador) {
        this.senhaDivulgador = senhaDivulgador;
    }
    
    
    
    
}
