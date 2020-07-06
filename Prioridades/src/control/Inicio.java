package control;

import vista.Interfaz;
import control.Cola;

//Clase principal
public class Inicio{
    
	public static void main(String[] args) throws InterruptedException {
		Cola cola = new Cola();
		ColaBloqueados cola2 = new ColaBloqueados();
		Nodo nodo = new Nodo();
		//Hilos
		GestorHilos hilos = new GestorHilos();
		//Ventana
		hilos.OrdenElemento();
                Interfaz interfaz = new Interfaz();
		interfaz.panelIzquierdo();
		interfaz.panelDerecho();
		interfaz.ventana();
		//Visualizar
		hilos.visualizar(cola, cola2, nodo, interfaz);
                
               
                
                
            
	}
}
