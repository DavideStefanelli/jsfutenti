package ejbs;

import entities.Utente;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import managedbean.UtenteManagedBean;

@Stateful
public class UtenteEjb implements UtenteEjbLocal {

    @PersistenceContext(unitName = "JsfUtentiPU")
    EntityManager em;

    Utente utente;
    
    @Override
    public String registraUtente(UtenteManagedBean uBean) {

        Utente utente = new Utente();
        utente.setEmail(uBean.getEmail());
        utente.setNome(uBean.getNome());
        utente.setCognome(uBean.getCognome());
        utente.setPassword(uBean.getPassword());
        em.persist(utente);

        String destinationPage;
        if (em.contains(utente)) {
            destinationPage = "success";
        } else {
            destinationPage = "failure";
        }
        return destinationPage;
    }

    @Override
    public String eseguiLogin(String email, String password) {
        String destinationPage;
        utente = em.createNamedQuery("Utente.findByEmailAndPassword", Utente.class)
                .setParameter("email", email)
                .setParameter("password", password)
                .getSingleResult();
        
        if(utente != null){
            destinationPage = "home";
        } else {
            destinationPage = "login";
        }
        return destinationPage;
    }

}
