/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sesion;

import sesion.Usuario;
import sesion.Usuario.Rol;
import static sesion.Usuario.Rol.ADMINISTRADOR;
import static sesion.Usuario.Rol.OPERARIO;
import static sesion.Usuario.Rol.CALLCENTER;
import static sesion.Usuario.Rol.SUPERVISOR;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.faces.context.FacesContext;

/**
 *
 * @author francis
 */
@Named(value = "controlAutorizacion")
@SessionScoped
public class ControlAutorizacion implements Serializable {

    private Usuario usuario;

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public String home() {    
        if(this.usuario == null){
            // No hay usuario identificado por tanto nos vamos al login
            return "login";
        }else if(this.usuario != null){
            //hay usuario, pero debemos comprobar si es admin o es usuario normal
           if(this.usuario.getRol()== ADMINISTRADOR){
               // tenemos que es un rol administrador entonces vamos a la pagina admin
               return "admin";
           }else if(this.usuario.getRol()==OPERARIO){
               //estamos ante un usuario normal, entonces vamos a pagina normal
               return "operario";
           }else if(this.usuario.getRol() == CALLCENTER){
               return "callcenter";
           }else if(this.usuario.getRol() == SUPERVISOR){
               return "supervisor";
           }
        }
        
        return null;
    }
    
    public String logout()
    {
        // Destruye la sesión (y con ello, el ámbito de este bean)
        FacesContext ctx = FacesContext.getCurrentInstance();
        ctx.getExternalContext().invalidateSession();
        usuario = null;
        return "login";
    }

    /**
     * Creates a new instance of ControlAutorizacion
     */
    public ControlAutorizacion() {
    }
}
