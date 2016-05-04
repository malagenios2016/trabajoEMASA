/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sesion;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author Pablo
 */
public class aviso {
    
    private boolean estado;
    private String prioridad;
    private String direccion;
    private String observacion;
    
    
    
    Map<String, aviso> listaAvisos;

    public aviso() {
        
        listaAvisos     = new TreeMap<>();
    }

    public aviso(boolean estado, String prioridad, String direccion, String observacion) {
        this.estado = estado;
        this.prioridad = prioridad;
        this.direccion = direccion;
        this.observacion = observacion;
        
    }
    
    

    @SuppressWarnings("empty-statement")
    public aviso(boolean es, String pri, String dir, String texto,String id) {
        
        
        
        
            aviso nuevo = new aviso(es, pri, dir, texto);
            listaAvisos.put(id, nuevo);
        
      
       
           
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public String getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(String prioridad) {
        this.prioridad = prioridad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public Map<String, aviso> getListaAvisos() {
        return listaAvisos;
    }

    public void setListaAvisos(Map<String, aviso> listaAvisos) {
        this.listaAvisos = listaAvisos;
    }

    
    
    public void eliminar(String id){
        
        if(listaAvisos.containsKey(id)){
            listaAvisos.remove(id);
            
        }
    }
    
    
    public void modificar(String id){
        
        if(listaAvisos.containsKey(id)){
            aviso modifica = new aviso(estado, prioridad, direccion, observacion);
            listaAvisos.replace(id, modifica);
        }else{
            System.out.println("No existe dicho identificador)");
        }
    }
    
}
