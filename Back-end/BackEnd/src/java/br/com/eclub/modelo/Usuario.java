package br.com.eclub.modelo;
import java.util.Calendar;
import javax.xml.bind.annotation.XmlRootElement;
//@author Gustavo
@XmlRootElement
public class Usuario {
    
    private String nomeUser;
    private String emailUser;
    private boolean sexo;
    private String telefoneUser;
    private Calendar dataNascimento;
    private String redeSocial;
    
    public Usuario(String redeSocial){
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
    public boolean isSexo() {
        return sexo;
    }
    public void setSexo(boolean sexo) {
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
    public String getRedeSocial() {
        return redeSocial;
    }
    public void setRedeSocial(String redeSocial) {
        this.redeSocial = redeSocial;
    }
}
