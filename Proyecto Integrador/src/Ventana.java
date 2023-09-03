import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Ventana extends JFrame {
	public JPanel panel;
    private JTextField textField1;
	
	public Ventana() {
		setSize(800, 640);
		setTitle("Interfaz De Prueba");
		setLocationRelativeTo(null);
		crearPanel();
		botones();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	private void crearPanel() {
		panel= new JPanel();
		panel.setBackground(Color.black);
		this.getContentPane().add(panel);
		JLabel etiqueta= new JLabel("Ingresa el nombre del txt");
		etiqueta.setForeground(Color.CYAN);
		panel.setLayout(null);
		etiqueta.setBounds(10, 10, 200, 30);
		etiqueta.setBackground(Color.GREEN);
		panel.add(etiqueta);
        textField1 = new JTextField();
        textField1.setBounds(10, 50, 500, 30);
        panel.add(textField1);
	}
	
	private void botones(){
		JButton boton1 = new JButton("Buscar TXT");
		boton1.setBounds(100, 200, 300, 90);
		panel.add(boton1);
        ActionListener accion = new ActionListener(){
        	//se coloca override porque actionlistener es una interfaz y debemos implementar sus metodos 
            @Override
            public void actionPerformed(ActionEvent e) {
                String txt = textField1.getText() + ".txt";
                Scanner leer = null;
                try {
					leer = new Scanner(new File (txt))   ;
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
                if(leer != null) {
					//String linea = leer.nextLine() ;
					JFrame arch1 = new JFrame ("contenido");
					arch1.setBounds(100, 100, 400, 300);
					arch1.setLocationRelativeTo(null);
					
					
					String nombres = "";
					int cont=0;
					while(cont<=10) {
						 nombres += leer.nextLine() + "\n";
						 cont++;
					   
					}
					JPanel panel2= new JPanel();
					arch1.getContentPane().add(panel2);
					JTextArea eti = new JTextArea();
					 eti.setBounds(10, 10, 200, 300);
					 eti.setText(nombres);
					 panel2.add(eti);
					JButton boton2= new JButton("Siguiente...");
					boton2.setBounds(10, 10, 10, 10);
					panel2.add(boton2);
					 //arch1.removeAll();
					 
					arch1.setVisible(true); // Debes hacer visible la ventana después de agregar todas las etiquetas
                }
					
					
              
                 
                
                
                
                
            }
        };
        boton1.addActionListener(accion);
	}
        
	
}
