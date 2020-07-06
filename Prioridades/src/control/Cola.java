package control;

import vista.Interfaz;

//Gestor de la cola
public class Cola{
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
	public Cola(){
		cabeza.proceso = "";
		cabeza.llegada = 0;
		cabeza.rafaga = 0;
		cabeza.comienzo = 0;
		cabeza.fin = 0;
		cabeza.retorno = 0;
		cabeza.espera = 0;
		cabeza.prioridad = 0;
		cabeza.sig = cabeza;
		aux2 = cabeza;
	}
	
	//Insertar elemento
	public void insertar(String proceso, int llegada, int rafaga, int segundos, int prioridad){
		//Si la cola esta vacia
		if (vacio == true){
			cabeza.proceso = proceso;
                        System.out.println(proceso);
			cabeza.llegada = llegada;
			cabeza.rafaga = rafaga;
			cabeza.comienzo = segundos;
			cabeza.prioridad = prioridad;
			cabeza.fin = cabeza.comienzo + cabeza.rafaga;
			cabeza.retorno = cabeza.fin - cabeza.llegada;
			cabeza.espera = cabeza.retorno - cabeza.rafaga;
			cabeza.sig = cabeza;
			aux = cabeza;
			vacio = false;
                       
		}
	}
	
	//Consultar datos
	public void consultar(Interfaz interfaz){
		//Consultar elemento
		if (aux2.fin>=10 & aux2.comienzo>=10 & aux2.retorno<10) {
			interfaz.textAreaProceso.append("      "+aux2.proceso+"              "+aux2.llegada+"            "+aux2.rafaga+"               "+aux2.comienzo+"               "+aux2.fin+"         "+aux2.retorno+"             "+aux2.espera+"           "+aux2.prioridad+"\n");
		}
		else {
			if (aux2.fin>=10 & aux2.comienzo>=10) {
				interfaz.textAreaProceso.append("      "+aux2.proceso+"              "+aux2.llegada+"            "+aux2.rafaga+"               "+aux2.comienzo+"          "+aux2.fin+"        "+aux2.retorno+"            "+aux2.espera+"          "+aux2.prioridad+"\n");
			}
			else {
				if(aux2.fin>=10) {
					interfaz.textAreaProceso.append("      "+aux2.proceso+"              "+aux2.llegada+"            "+aux2.rafaga+"                "+aux2.comienzo+"             "+aux2.fin+"         "+aux2.retorno+"             "+aux2.espera+"          "+aux2.prioridad+"\n");
				}
				else {
					interfaz.textAreaProceso.append("      "+aux2.proceso+"              "+aux2.llegada+"            "+aux2.rafaga+"                "+aux2.comienzo+"               "+aux2.fin+"          "+aux2.retorno+"             "+aux2.espera+"          "+aux2.prioridad+"\n");
				}
			}
		}
		vacio = true;
	}
        
        public void Ordenar(){
            
        }
}
