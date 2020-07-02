/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author nicolas
 */
public class Proceso {
    
    private int proceso;
    private int TComienzo;
    private int tiempoInicial;
    private int tiempoRafaga;
    private int tiempoFinal;
    private int tiempoRetorno;
    private int tiempoEespera;
    private int rafagaRestante;
    private int tiempoEnCPU;
    
    private int prioridad;
    private Proceso sig;

    public int getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }

    
   

    public int getTiempoEnCPU() {
        return tiempoEnCPU;
    }

    public void setTiempoEnCPU(int tiempoEnCPU) {
        this.tiempoEnCPU = tiempoEnCPU;
    }

    
    
    public int getRafagaRestante() {
        return rafagaRestante;
    }

    public void setRafagaRestante(int rafagaRestante) {
        this.rafagaRestante = rafagaRestante;
    }
    
    
    
    public int getTComienzo() {
        return TComienzo;
    }

    public void setTComienzo(int TComienzo) {
        this.TComienzo = TComienzo;
    }
    
    public int getProceso() {
        return proceso;
    }

    public void setProceso(int proceso) {
        this.proceso = proceso;
    }

    public int getTiempoInicial() {
        return tiempoInicial;
    }

    public void setTiempoInicial(int tiempoInicial) {
        this.tiempoInicial = tiempoInicial;
    }

    public int getTiempoRafaga() {
        return tiempoRafaga;
    }

    public void setTiempoRafaga(int tiempoRafaga) {
        this.tiempoRafaga = tiempoRafaga;
    }

    public Proceso getSig() {
        return sig;
    }

    public void setSig(Proceso sig) {
        this.sig = sig;
    }

    public int getTiempoEjecucion() {
        return TComienzo;
    }

    public void setTiempoEjecucion(int tiempoEjecucion) {
        this.TComienzo = tiempoEjecucion;
    }

    public int getTiempoFinal() {
        return tiempoFinal;
    }

    public void setTiempoFinal(int tiempoFinal) {
        this.tiempoFinal = tiempoFinal;
    }

    public int getTiempoRetorno() {
        return tiempoRetorno;
    }

    public void setTiempoRetorno(int tiempoRetorno) {
        this.tiempoRetorno = tiempoRetorno;
    }

    public int getTiempoEespera() {
        return tiempoEespera;
    }

    public void setTiempoEespera(int tiempoEespera) {
        this.tiempoEespera = tiempoEespera;
    }
    
    
}
