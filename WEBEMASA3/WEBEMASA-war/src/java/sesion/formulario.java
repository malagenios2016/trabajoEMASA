/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sesion;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author Steven
 */

@Named(value = "formulario")
@SessionScoped
public class formulario implements Serializable{

   private LinkedList<aviso> listaAvisos;

    public formulario() {
        listaAvisos = new LinkedList<aviso>();
    }

    public LinkedList<aviso> getListaAvisos() {
        return listaAvisos;
    }

    public void setListaAvisos(LinkedList<aviso> listaAvisos) {
        this.listaAvisos = listaAvisos;
    }
    
    
    
    public String modificar(){
        return "modificar";
    }
    
    public void crear(aviso a){
        
        listaAvisos.add(a);
    }
    
    public void modificar(aviso a){
        
        listaAvisos.add(a);
    }
    
    public void eliminar(aviso a){
    
            listaAvisos.remove(a);
        
    }
}
