package br.com.eclub.modelo;
import java.util.Calendar;
import javax.xml.bind.annotation.XmlRootElement;
//@author Gustavo
@XmlRootElement
public class Usuario {
    
    private String nomeUser;
    private String emailUser;
    private int sexo;
    private String telefoneUser;
    private Calendar dataNascimento;
    private int redeSocial;
    
    public Usuario(int redeSocial){
        this.redeSocial = redeSocial;        
    }    
    public Usuario(){}

    @Override
    public String toString() {
        return "Usuario{" + "nomeUser=" + nomeUser + ", emailUser=" + emailUser + ", sexo=" + sexo + ", telefoneUser=" + telefoneUser + ", dataNascimento=" + dataNascimento + ", redeSocial=" + redeSocial + '}';
    }
    //gets e sets
    public String getNomeUser() {
        return nomeUser;
    }
    public void setNomeUser(String nomeUser) {
        this.nomeUser = nomeUser;
    }
    public String getEmailUser() {
        return emailUser;
    }
    public void setEmailUser(String emailUser) {
        this.emailUser = emailUser;
    }
    public int getSexo() {
        return sexo;
    }
    public void setSexo(int sexo) {
        this.sexo = sexo;
    }
    public String getTelefoneUser() {
        return telefoneUser;
    }
    public void setTelefoneUser(String telefoneUser) {
        this.telefoneUser = telefoneUser;
    }
    public Calendar getDataNascimento() {
        return dataNascimento;
    }
    public void setDataNascimento(Calendar dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
    public int getRedeSocial() {
        return redeSocial;
    }
    public void setRedeSocial(int redeSocial) {
        this.redeSocial = redeSocial;
    }
}
