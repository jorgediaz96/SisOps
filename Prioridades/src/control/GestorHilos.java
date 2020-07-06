package control;

import java.util.ArrayList;
import java.util.Arrays;

import vista.DiagramaGant;
import vista.Interfaz;

public class GestorHilos extends Thread{
	public boolean nuevoElemento;
	public ArrayList diagramaGant = new ArrayList();
	private DiagramaGant diagrama;
	private Nodo aux = new Nodo();
	private int[] prioridad;
	private String[] procesos;
	private int[] llegada;
	private int[] rafaga;
         public Elementos elemento[]=new Elementos[5];
         public Elementos auxElementos;
	
	//Se agregan nuevoselementos = false
	public GestorHilos() {
		nuevoElemento = false;
	}
        
        public void OrdenElemento(){
        elemento[0]= new Elementos();
        elemento[0].setProceso("A");
        elemento[0].setLlegada(0);
        elemento[0].setPrioridad(1);
        elemento[0].setRafaga(4);
        
        elemento[1]= new Elementos();
        elemento[1].setProceso("B");
        elemento[1].setLlegada(1);
        elemento[1].setPrioridad(4);
        elemento[1].setRafaga(8);
        
        elemento[2]= new Elementos();
        elemento[2].setProceso("C");
        elemento[2].setLlegada(2);
        elemento[2].setPrioridad(3);
        elemento[2].setRafaga(3);
        
        elemento[3]= new Elementos();
        elemento[3].setProceso("D");
        elemento[3].setLlegada(3);
        elemento[3].setPrioridad(3);
        elemento[3].setRafaga(5);
        
        elemento[4]= new Elementos();
        elemento[4].setProceso("E");
        elemento[4].setLlegada(4);
        elemento[4].setPrioridad(2);
        elemento[4].setRafaga(1);
        
        for(int i=0;i<=elemento.length;i++){
            for(int j=0;j<elemento.length-1;j++){
            if(elemento[j].prioridad>elemento[j+1].prioridad){
                auxElementos=elemento[j];
                elemento[j]=elemento[j+1];
                elemento[j+1]=auxElementos;
                
            }
           }
        }
        for (int k=0; k<elemento.length;k++){
        System.out.println(elemento[k].proceso+" "+elemento[k].llegada+" "+elemento[k].rafaga+" "+elemento[k].prioridad);
        }
        }
	
	public void elementos() {
          
           
		//int [] priori = {(int)Math.round(Math.random()*4)+1, (int)Math.round(Math.random()*4)+1, (int)Math.round(Math.random()*4)+1, (int)Math.round(Math.random()*4)+1, (int)Math.round(Math.random()*4)+1};	
                int [] priori2 = {elemento[0].prioridad, elemento[1].prioridad, elemento[2].prioridad, elemento[3].prioridad,elemento[4].prioridad};
		//Arrays.sort(priori);
		prioridad = priori2;
		//String[] proceso = {"A","B", "C", "D", "E"};
                String[] proceso2 = {elemento[0].proceso, elemento[1].proceso, elemento[2].proceso, elemento[3].proceso, elemento[4].proceso};
		procesos = proceso2;
		//int[] lleg = {0, 1, 2, 3, 4,5};
                int[] lleg2 = {elemento[0].llegada, elemento[1].llegada, elemento[2].llegada, elemento[3].llegada,elemento[4].llegada};
		llegada = lleg2;
		//int[] raf = {2, 2, 3, 3, 3};
                int[] raf2 = {elemento[0].rafaga,elemento[1].rafaga,elemento[2].rafaga, elemento[3].rafaga,elemento[4].rafaga};
		rafaga = raf2;
	}
	//Elementos iniciales a insertar
	public int elementosIniciales(Cola cola, ColaBloqueados cola2, Nodo nodo, int elementos, int segundos){
		//Elementos Iniciales
               
		int espera = 0;
               // cola.insertar(elemento[0].proceso, elemento[0].llegada, elemento[0].rafaga, segundos, elemento[0].prioridad);
               // cola.insertar(elemento[1].proceso, elemento[1].llegada, elemento[1].rafaga, segundos, elemento[1].prioridad);
		boolean validar = true;
		while (true) {
			if (segundos != llegada[elementos]) {
				cola.insertar(procesos[elementos], llegada[elementos], rafaga[elementos], segundos, prioridad[elementos]);
				//System.out.println(cola.aux2.proceso+" "+cola.aux2.llegada+" "+cola.aux2.rafaga+" "+cola.aux2.prioridad);
				espera = rafaga[elementos];
				validar = false;
				return espera;
			}
			else {
				cola.insertar(procesos[elementos], llegada[elementos], rafaga[elementos], segundos, prioridad[elementos]);
				//System.out.println(cola.aux2.proceso+" "+cola.aux2.llegada+" "+cola.aux2.rafaga+" "+cola.aux2.prioridad);
				espera = rafaga[elementos];
				validar = false;
				return espera;
			}
                
		}

	}
	
	//Hilo para visualizar datos
	public void visualizar(Cola cola, ColaBloqueados cola2, Nodo nodo, Interfaz interfaz) throws InterruptedException {
		//Segundos en el programa
		int segundos = 0;
		//Cantidad de elementos iniciales
		int elementos = 0;
		int otro = 0;
		//Empezar la visualización por la cabeza
		cola.aux2 = cola.cabeza;
		//Objeto de DiagramaGant
		diagrama = new DiagramaGant();
		//Declarar elementos iniciales
		elementos();
		//Visualizar la cola
		while (true){
			//Mientras agrega elementos iniciales
			if(elementos < llegada.length) {
				int espera = elementosIniciales(cola, cola2, nodo, elementos, segundos);
				cola.consultar(interfaz);
				diagramaGant.add("");
				int i = 0;
				while (i < espera) {
					sleep(1000);
					//Hacer el diagrama
					diagrama.diagrama(this, otro,segundos,interfaz, cola.aux2.proceso);
					segundos++;
					i++;
				}
				elementos++;
				otro++;
				//Cuando se agrega un elemento
				if (interfaz.nuevoElemento) {
					int j=0;
					j = elementos-1;
					if(interfaz.prioridad < prioridad[j]) {
						cola.insertar(interfaz.proceso,interfaz.llegada, interfaz.rafaga, segundos, interfaz.prioridad);
					}
					else {
						cola.insertar(procesos[elementos],llegada[elementos], rafaga[elementos], segundos, prioridad[elementos]);
						while(interfaz.prioridad > prioridad[j]) {
							prioridad[j] = prioridad[j+1];
							procesos[j] = procesos[j+1];
							llegada[j] = llegada[j+1];
							rafaga[j] = rafaga[j+1];
							j++;
						}
						prioridad[j] = interfaz.prioridad;
						procesos[j] = interfaz.proceso;
						llegada[j] = interfaz.llegada;
						rafaga[j] = interfaz.rafaga;
					}
					interfaz.nuevoElemento = false;
					cola.consultar(interfaz);
					diagramaGant.add("");
					i = 0;
					while (i < interfaz.rafaga) {
						sleep(1000);
						diagrama.diagrama(this, elementos,segundos,interfaz,cola.aux2.proceso);
						segundos++;
						i++;
					}
					otro++;
				}
			}
			else {
				sleep(1000);
				segundos++;
				//Cuando se agrega un elemento
				if (interfaz.nuevoElemento) {
					cola.insertar(interfaz.proceso,interfaz.llegada, interfaz.rafaga, segundos, interfaz.prioridad);
					interfaz.nuevoElemento = false;
					cola.consultar(interfaz);
					diagramaGant.add("");
					int i = 0;
					while (i < interfaz.rafaga) {
						sleep(1000);
						diagrama.diagrama(this, otro,segundos,interfaz,cola.aux2.proceso);
						segundos++;
						i++;
					}
					otro++;
				}
			}
		}
	}
}
