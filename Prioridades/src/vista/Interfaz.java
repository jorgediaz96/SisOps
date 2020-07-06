package vista;

import control.Cola;
import control.GestorHilos;
import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class Interfaz extends JFrame implements ActionListener{
	
	public boolean nuevoElemento;
	public String proceso;
	public int llegada;
	public int rafaga;
	public int prioridad;
	private JFrame frame;
	private JPanel panelIzquierdo, panelDerecho;
	private JLabel labelCola,labelProcesos, titulo;
	public JTextArea textAreaProceso, textAreaGant;
	private JTextField textFieldProceso, textFieldLlegada, textFieldRafaga, textFieldPrioridad;
	private JButton buttonAgregar, buttonBloquear;
	private JScrollPane scroll, scroll2;
	public boolean bloquear = false;
        
	//Primer Panel
	public void panelIzquierdo() {
		panelIzquierdo = new JPanel();
		labelCola = new JLabel("Gestor de Cola", JLabel.CENTER);
		labelCola.setFont(new Font("SansSerif",Font.BOLD, 16) );
		textAreaProceso = new JTextArea("",10,30);
		textAreaProceso.setEditable(false);
		textAreaProceso.setFont(new Font("SansSerif",Font.BOLD, 12) );
		textAreaProceso.setText("Proceso, Llegada, Rafaga, Comienzo, Final, Retorno, Espera, Prioridad"+"\n");
		scroll = new JScrollPane(textAreaProceso);
		textAreaGant = new JTextArea("",10,30);
		textAreaGant.setEditable(false);
		textAreaGant.setFont(new Font("SansSerif",Font.BOLD, 12) );
		scroll2 = new JScrollPane(textAreaGant);
		panelIzquierdo.setLayout(new BorderLayout());
		panelIzquierdo.setBackground(Color.red);
		panelIzquierdo.add(labelCola, BorderLayout.NORTH);
		panelIzquierdo.add(scroll, BorderLayout.CENTER);
		panelIzquierdo.add(scroll2, BorderLayout.SOUTH);
	}
	
	//Segundo Panel
	public void panelDerecho() {
		panelDerecho = new JPanel();
		labelProcesos = new JLabel("Nuevo Elemento",JLabel.CENTER);
		labelProcesos.setFont(new Font("SansSerif",Font.BOLD, 14) );
		textFieldProceso = new JTextField(15);
		textFieldProceso.setText("Proceso");
		textFieldLlegada = new JTextField(15);
		textFieldLlegada.setText("Llegada");
		textFieldRafaga = new JTextField(15);
		textFieldRafaga.setText("Rafaga");
		textFieldPrioridad = new JTextField(15);
		textFieldPrioridad.setText("Prioridad");
		buttonAgregar = new JButton("Agregar Elemento");
		buttonAgregar.setFont(new Font("SansSerif",Font.BOLD, 14) );
		buttonAgregar.addActionListener(this);
        buttonBloquear = new JButton("Bloquear Elemento");
		buttonBloquear.setFont(new Font("SansSerif",Font.BOLD, 14) );
		buttonBloquear.addActionListener(this);
		panelDerecho.setLayout(new BorderLayout());
		panelDerecho.setBackground(Color.green);
		//panelDerecho.add(labelProcesos, BorderLayout.NORTH);
		panelDerecho.add(buttonBloquear, BorderLayout.BEFORE_FIRST_LINE); 
        panelDerecho.add(textFieldProceso, BorderLayout.WEST);
        panelDerecho.add(textFieldLlegada, BorderLayout.CENTER);
        panelDerecho.add(textFieldRafaga, BorderLayout.EAST);
        panelDerecho.add(textFieldPrioridad, BorderLayout.SOUTH);
        panelDerecho.add(buttonAgregar, BorderLayout.PAGE_END);             
	}
	
	//Frame
	public void ventana(){
        frame = new JFrame();
        titulo = new JLabel("GESTOR DE COLA", JLabel.CENTER);
        Font aux= titulo.getFont();
        titulo.setFont(new Font(aux.getFontName(), aux.getStyle(), 20));
        frame.setLayout(new BorderLayout());

        //Agregar los elementos al frame
        frame.add(titulo,BorderLayout.NORTH);
        frame.add(panelIzquierdo,BorderLayout.NORTH);
        frame.add(panelDerecho,BorderLayout.SOUTH);
        
        //Configuración de la ventana
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
	
	//Acción del botón
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == buttonAgregar) {
			nuevoElemento = true;
			proceso = textFieldProceso.getText();
			llegada = Integer.parseInt(textFieldLlegada.getText());
			rafaga = Integer.parseInt(textFieldRafaga.getText());
			prioridad = Integer.parseInt(textFieldPrioridad.getText());
                }
                if (e.getSource() == buttonBloquear) {
			bloquear = true;
                }
	}
}