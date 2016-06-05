package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.controlador;
import modelo.modelo;

public class notas extends JFrame {

	private JPanel contentPane;
	private modelo mod;
	private controlador con;

	public void setmodelo(modelo modelo) {
		this.mod = modelo;
	}
	public void setcontrolador(controlador con){
		this.con=con;
	}

	public notas() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

}
