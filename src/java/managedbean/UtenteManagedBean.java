package managedbean;

import ejbs.UtenteEjbLocal;
import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;


@Named(value = "utente")
@SessionScoped
public class UtenteManagedBean implements Serializable {

    private String email;
    private String nome;
    private String cognome;
    private String password;
    
    @EJB
    UtenteEjbLocal utenteEjb;
    
    public UtenteManagedBean() {
        
    }
    
    public void registraUtente(){
        String destinationPage = "faces/" + utenteEjb.registraUtente(this) + ".xhtml"; 
        try {
            FacesContext.getCurrentInstance().getExternalContext().dispatch(destinationPage);
        } catch (IOException ex) {
            Logger.getLogger(UtenteManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void eseguiLogin(){
        String destinationPage =  "faces/" + utenteEjb.eseguiLogin(email, password) + ".xhtml"; 
        try {
            FacesContext.getCurrentInstance().getExternalContext().dispatch(destinationPage);
        } catch (IOException ex) {
            Logger.getLogger(UtenteManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UtenteEjbLocal getUtenteEjb() {
        return utenteEjb;
    }

    public void setUtenteEjb(UtenteEjbLocal utenteEjb) {
        this.utenteEjb = utenteEjb;
    }
    
    
}
