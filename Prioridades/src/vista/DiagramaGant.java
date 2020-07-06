package vista;

import java.awt.Color;
import java.awt.Font;

import control.GestorHilos;

public class DiagramaGant {
	//Diagrama de Gant
		public void diagrama(GestorHilos gestor, int elementos, int segundos, Interfaz interfaz, String proceso) {
			int i = 0;
			//Línea del tiempo 1 2 3 ... tiempo transcurrido
			String tiempoTranscurrido = "  0  ";
			while (i <= segundos) {
				if(i<3) {
					tiempoTranscurrido += i+1+"   "; 
					i++;
				}
				else {
					if(i<6 & i>3) {
						tiempoTranscurrido += i+1+"   "; 
						i++;
					}
					else {
						tiempoTranscurrido += i+1+"  "; 
						i++;
					}
				}
			}
			interfaz.textAreaGant.setText(tiempoTranscurrido+"\n");
                        //System.out.println(tiempoTranscurrido);
			
			i = 0;
			//Calcular tiempo hasta que comienza proceso se llena con "  "
			if(gestor.diagramaGant.get(elementos).equals("")) {
				gestor.diagramaGant.set(elementos,proceso+" ");
				while (i < segundos) {
					gestor.diagramaGant.set(elementos,gestor.diagramaGant.get(elementos)+"----");
					i++;
				}
				gestor.diagramaGant.set(elementos,gestor.diagramaGant.get(elementos)+"▀");
				i = 0;
			}
			//Si esta en zona critica "X", sino " "
			else {
				while (i < gestor.diagramaGant.size()) {
                                    
					if (i == elementos) {
						gestor.diagramaGant.set(i,gestor.diagramaGant.get(i)+" ▀");
					}
					i++;
				}
			}
			
			i=0;
			//Agregar todos los procesos ejecutados hasta el momento
			while(i < gestor.diagramaGant.size()) {
				int valor = (int)Math.round(Math.random()*2);
				switch(valor) {
				case 0:
					interfaz.textAreaGant.setForeground(Color.blue);
					break;
				case 1:
					interfaz.textAreaGant.setForeground(Color.red);
					break;
				case 2:
					interfaz.textAreaGant.setForeground(Color.magenta);
					break;
				}
				interfaz.textAreaGant.append(gestor.diagramaGant.get(i).toString()+"\n");
				i++;
			}
		}
}
