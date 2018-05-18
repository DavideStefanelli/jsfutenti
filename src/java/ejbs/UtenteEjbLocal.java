/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejbs;

import javax.ejb.Local;
import managedbean.UtenteManagedBean;

/**
 *
 * @author web4e
 */
@Local
public interface UtenteEjbLocal {
    
    public String registraUtente(UtenteManagedBean uBean);
    public String eseguiLogin(String email, String password);
    
}
