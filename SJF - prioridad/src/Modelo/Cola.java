/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import javax.swing.JTable;
import javax.swing.JTextArea;

/**
 *
 * @author gabriela
 */
public class Cola {

    private Proceso cab, p;
     private JTextArea txaConsola;

    public Cola(JTextArea area) {
        p = new Proceso();
        p.setSig(p);
        cab = p;
        cab.setProceso(1000);
        
        this.txaConsola = area;
    }

    public boolean colaVacia() {
        if (p.getSig() == p) {
            return true;
        } else {
            return false;
        }
    }

    public void insertar(int proceso, int tiempoInicial, int tiempoRafaga, int prioridad) {
        Proceso nuevo;
        nuevo = new Proceso();
        nuevo.setProceso(proceso);
        nuevo.setTiempoInicial(tiempoInicial);
        nuevo.setTiempoRafaga(tiempoRafaga);
        nuevo.setTComienzo(0);
        nuevo.setTiempoFinal(0);
        nuevo.setTiempoRetorno(0);
        nuevo.setTiempoEespera(0);
        nuevo.setRafagaRestante(tiempoRafaga);
        nuevo.setTiempoEnCPU(0);
        nuevo.setPrioridad(prioridad);
        nuevo.setSig(null);
        if (colaVacia()) {
            p.setSig(nuevo);
            p = nuevo;
        } else {
            Proceso aux = p;
            aux.setSig(nuevo);
            p = nuevo;
        }
        
    }


    public void cargarTabla(JTable tabla) {

        String txt = "";
        Proceso aux = cab.getSig();
       

        if (!colaVacia()) {

            while (aux != null) {
                tabla.getModel().setValueAt(aux.getProceso(), aux.getProceso()-1, 0);
                tabla.getModel().setValueAt(aux.getTiempoInicial(), aux.getProceso()-1, 1);
                tabla.getModel().setValueAt(aux.getTiempoRafaga(), aux.getProceso()-1, 2);
                tabla.getModel().setValueAt(aux.getTComienzo(), aux.getProceso()-1, 3);
                tabla.getModel().setValueAt(aux.getTiempoFinal(), aux.getProceso()-1, 4);
                tabla.getModel().setValueAt(aux.getTiempoRetorno(), aux.getProceso()-1, 5);
                tabla.getModel().setValueAt(aux.getTiempoEespera(), aux.getProceso()-1, 6);
                tabla.getModel().setValueAt(aux.getPrioridad(), aux.getProceso()-1, 7);
                aux = aux.getSig();
            }

        } else {
            System.out.println("\"La cola está vacía \n");
        }
    }

    public int tamañoCola() {
        Proceso aux;
        aux = cab.getSig();
        int num = 0;
        while (aux != null) {
            num = num + 1;
            aux = aux.getSig();
        }
        return num;
    }

    public Proceso getCab() {
        return cab;
    }

    public void setCab(Proceso cab) {
        this.cab = cab;
    }

    public Proceso getP() {
        return p;
    }

    public void setP(Proceso p) {
        this.p = p;
    }

    public void eliminarNodo(Proceso eliminar) {//elimina un nodo en cualquier posición

        int c = -1;
        int num_eliminado;
        Proceso auxel = eliminar;
        Proceso asignar = this.p;
        while (auxel != this.p) {
            c++;
            auxel = auxel.getSig();
        }

        if (tamañoCola() != 1) {
            num_eliminado = this.tamañoCola() - c;
            //System.out.println("se eliminara el Nodo :" + num_eliminado);
            for (int n = num_eliminado; n > 1; n--) {
                asignar = asignar.getSig();
            }
            //System.out.println("se reasignara el proceso :" + asignar.proceso);
            asignar.setSig(eliminar.getSig());
            if (eliminar.getSig() == this.p) {
                cab = asignar;
            }
        } else {
            this.eliminarPrimero2();
        }

    }

    public void eliminarPrimero2() {
        Proceso auxx = p.getSig();
        if (auxx.getSig() != null) {
            p.setSig(auxx.getSig());
            cab = p.getSig();
        } else {
            p.setSig(p);
            cab = p;
        }
    }

   public Proceso buscarProceso(Proceso buscar) {
        Proceso aux = cab.getSig();
        Proceso encontrado = null;
        while (aux != null) {
            if (buscar.getProceso() == aux.getProceso()) {
                encontrado = aux;
            }
            aux = aux.getSig();
        }
        return encontrado;
    }

    public void eliminarElemento(Proceso elemento, Cola cola) {
        Proceso aux = cola.getCab();
        Proceso aux2 = aux.getSig();

        while (aux != null) {
            if (cola.tamañoCola() == 1) {
                cola.p = cola.cab;
                cola.p.setSig(p);
                cola.cab = cola.p;
                break;
            } else if (aux2 == elemento) {
                aux.setSig(aux2.getSig());
                break;
            }
            aux = aux.getSig();
            aux2 = aux2.getSig();
        }

    }
}
