/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sesion;

import sesion.Usuario;
import sesion.Usuario.Rol;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

/**
 *
 * @author francis
 */
@Named(value = "login")
@RequestScoped
public class Login {

    private String usuario;
    private String contrasenia;
    private List<Usuario> usuarios;
    
    @Inject
    private ControlAutorizacion ctrl;

    /**
     * Creates a new instance of Login
     */
    public Login() {
        usuarios = new ArrayList<Usuario>();
        usuarios.add(new Usuario("pepe", "asdf", Rol.OPERARIO));
        usuarios.add(new Usuario("manolo", "qwer", Rol.ADMINISTRADOR));
        usuarios.add(new Usuario("carmen","1234",Rol.CALLCENTER));
    }

    public String getUsuario() {
        return usuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String autenticar() {
        boolean encontrado = false;
        int tam = usuarios.size();
        int i = 0;
        
        
        while(i<tam && !encontrado){
            //recorremos la lista buscando al usuario
            if(usuarios.get(i).getUsuario().equals(this.usuario)){
                encontrado = true;
                if(usuarios.get(i).getContrasenia().equals(this.contrasenia)){
                    // usuario y contraseña correcto
                   ctrl.setUsuario(usuarios.get(i));
                  ;
                }else{
                    FacesContext ctx = FacesContext.getCurrentInstance();
                    ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error contraseña", "Error contraseña"));
                }
                
            } 
            i++;
        }
        
        if(encontrado == false){
            FacesContext ctx = FacesContext.getCurrentInstance();
            ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error usuario inexistente", "Error usuario inexistente"));
            return null;
        }else{
            return ctrl.home();
        }    
    
    }
}
