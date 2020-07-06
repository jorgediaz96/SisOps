package control;

import vista.Interfaz;

//Gestor de la cola
public class ColaBloqueados{
	//Nodos y variables
	//Cabeza de la cola (Referencia)
	public Nodo cabeza = new Nodo();
	//Nodo auxiliar para agregar
	public Nodo aux = new Nodo();
	//Nodo auxiliar para consultar
	public Nodo aux2 = new Nodo();
	//Nodo que guardara el ultimo elemento
	public Nodo ultimo = new Nodo();
	public ManejoCola manejo;
	public boolean vacio = true;
	public int cab = 0;
	public int num = 0;
	
	//Constructor
	//Crear cola circular vacia
	public ColaBloqueados(){
		cabeza.proceso = "";
		cabeza.llegada = 0;
		cabeza.rafaga = 0;
		cabeza.prioridad = 0;
		cabeza.sig = cabeza;
		aux2 = cabeza;
	}
	
	//Insertar elemento
	public void insertar(String proceso, int llegada, int rafaga, int prioridad){
		//Si la cola esta vacia
		if (vacio == true){
			cabeza.proceso = proceso;
			cabeza.llegada = llegada;
			cabeza.rafaga = rafaga;
			cabeza.prioridad = prioridad;
			cabeza.sig = cabeza;
			aux = cabeza;
			vacio = false;
		//La cola no esta vacia
		}else{
			//Se crea un nuevo nodo
			Nodo nuevo = new Nodo();
			nuevo.proceso = proceso;
			nuevo.llegada = llegada;
			nuevo.rafaga = rafaga;
			nuevo.prioridad = prioridad;
			nuevo.sig = cabeza;
			//Si solo está la cabeza de la cola
			if (cab == 0){
				cabeza.sig = nuevo;
				aux = nuevo;
				cab = 1;
			//Si está la cabeza y otro nodo en la cola
			}else{
				aux.sig = nuevo;
				aux = nuevo;
			}
		}
	}
	
	//Consultar datos
	public Nodo consultar(){
		manejo = new ManejoCola();
		
		// Visualizar cabeza
		if (num == 0) {
			//Controlar número de procesos en cola
			aux = aux2;
			aux2 = aux2.sig;
			num = 1;
			return aux;
		} else {
			// Mientras hayan elementos en la cola
			if (aux2.sig != cabeza) {
				aux = aux2;
				aux2 = aux2.sig;
				return aux;
			} else {
				if (manejo.terminarCola(aux2)) {
					// Imprimir último elemento
					if(aux2 != cabeza) {
						aux = aux2;
						return aux;
					}
					//Cuando no hay más elementos en la cola, se crea una cola circular solo con la cabeza
					cabeza.proceso = "";
					cabeza.llegada = 0;
					cabeza.rafaga = 0;
					cabeza.sig = cabeza;
					aux2 = cabeza;
					vacio = true;
					return aux2;
				}
				else {
					aux = aux2;
					aux2 = aux2.sig;
					return aux;
				}
			}
		}
	}
}
