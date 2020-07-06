/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

/**
 *
 * @author user
 */
public class Elementos {
    public String proceso;
    public int llegada;
    public int rafaga;
    public int prioridad;
    
    public String getProceso() {
        return proceso;
    }
 
    public void setProceso(String proceso) {
        this.proceso = proceso;
    }
    
    public int getLlegada() {
        return llegada;
    }
 
    public void setLlegada(int llegada) {
        this.llegada = llegada;
    }
    public int getRagafa() {
        return rafaga;
    }
 
    public void setRafaga(int rafaga) {
        this.rafaga = rafaga;
    }
    public int getPriorida() {
        return prioridad;
    }
 
    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }
}
