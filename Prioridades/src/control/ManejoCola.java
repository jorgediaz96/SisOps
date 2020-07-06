package control;

import control.Cola;

//Operaciones de la cola
public class ManejoCola{
	
	//Cuando no hay mas elementos en la cola, se termina
	public boolean terminarCola(Nodo nodo) {
		if (nodo.rafaga-3 <= 0) {
			return true;
		}
		else {
			return false;
		}
	}
}
