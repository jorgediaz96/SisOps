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
public class ELementosOrden {
     public Elementos elemento[]=new Elementos[4];
     public Elementos aux;
     //public Elementos elemento1;
    public void Ordenar(){
        elemento[0]= new Elementos();
        elemento[0].setProceso("A");
        elemento[0].setLlegada(0);
        elemento[0].setPrioridad(1);
        elemento[0].setRafaga(6);
        
        elemento[1]= new Elementos();
        elemento[1].setProceso("B");
        elemento[1].setLlegada(1);
        elemento[1].setPrioridad(4);
        elemento[1].setRafaga(6);
        
        elemento[2]= new Elementos();
        elemento[2].setProceso("C");
        elemento[2].setLlegada(2);
        elemento[2].setPrioridad(3);
        elemento[2].setRafaga(6);
        
        elemento[3]= new Elementos();
        elemento[3].setProceso("D");
        elemento[3].setLlegada(3);
        elemento[3].setPrioridad(3);
        elemento[3].setRafaga(6);
        
        for(int i=0;i<=elemento.length;i++){
            for(int j=0;j<elemento.length-1;j++){
            if(elemento[j].prioridad>elemento[j+1].prioridad){
                aux=elemento[j];
                elemento[j]=elemento[j+1];
                elemento[j+1]=aux;
                
            }
           }
        }
        for (int k=0; k<elemento.length;k++){
        System.out.println(elemento[k].proceso+" "+elemento[k].llegada+" "+elemento[k].rafaga+" "+elemento[k].prioridad);
        }
        
      
          
        }
}
