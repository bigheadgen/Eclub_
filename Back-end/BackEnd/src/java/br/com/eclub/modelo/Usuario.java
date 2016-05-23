package br.com.eclub.modelo;
import java.util.Date;
/**
 *
 * @author Gustavo
 */
public class Usuario {
    
    private String nomeUser;
    private String emailUser;
    private boolean sexo;
    private String telefoneUser;
    private Date dataNascimento;
    private String redeSocial;
    //Lembre de adicionar o atributo para a foto do usuario.

    
    //Construtor a rede social é obrigatorio para o cadastro do usuario.
    public Usuario(String redeSocial){
        this.redeSocial = redeSocial;        
    }    

    public Usuario() {
        
    }

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

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getRedeSocial() {
        return redeSocial;
    }

    public void setRedeSocial(String redeSocial) {
        this.redeSocial = redeSocial;
    }
   
}
