package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import controlador.controlador;
import modelo.modelo;

public class config extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsuario;
	private JTextField txtContraseña;
	private login log;
	private modelo mod;
	private controlador con;
	private JTextField txtUrl;

	/**
	 * Create the frame.
	 */
	public void borrardatostxt(){
		txtUsuario.setText("");
		txtContraseña.setText("");
		
	}
	public String getURL(){
		return this.txtUrl.getText();
	}
	public String getUsu(){
		return txtUsuario.getText();
	}
	public String getContra(){
		return txtContraseña.getText();
	}
	public void setmodelo(modelo mod) {
		this.mod = mod;
	}

	public void setcontrolador(controlador con) {
		this.con = con;
	}
	public void setUsuContra(){
		txtUsuario.setText(mod.getUsuarioBBDD());
		txtContraseña.setText(mod.getContraseñaBBDD());
		txtUrl.setText(mod.geturlBBDD());
	}
	public config() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.CYAN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		txtUsuario = new JTextField();
		txtUsuario.setColumns(10);

		JLabel lblUsuario = new JLabel("UsuarioBBDD");
		lblUsuario.setIcon(new ImageIcon(config.class.getResource("/imagenes/UsuarioBueno.jpg")));

		JLabel lblContrasea = new JLabel("Contrase\u00F1aBBDD");
		lblContrasea.setIcon(new ImageIcon(config.class.getResource("/imagenes/Contrase\u00F1aBuena.png")));

		txtContraseña = new JTextField();
		txtContraseña.setColumns(10);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(config.class.getResource("/imagenes/anadir-mas-datos-de-base-icono-7011-48.png")));

		JButton btnModificar = new JButton("modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				con.modificarBBDD();
				mod.conectarse();
			}
		});

		JButton btnvolver = new JButton("");
		btnvolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				con.mostrarventanalogin();
			}
		});
		btnvolver.setIcon(new ImageIcon(config.class.getResource("/imagenes/back.png")));
		
		txtUrl = new JTextField();
		txtUrl.setColumns(10);
		
		JLabel lblUrl = new JLabel("URL");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(33)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(89)
							.addComponent(btnModificar))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblContrasea)
								.addComponent(lblUsuario))
							.addGap(26)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(txtUsuario, GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
								.addComponent(txtContraseña, GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(55)
							.addComponent(lblUrl)
							.addGap(18)
							.addComponent(txtUrl, GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(label, Alignment.TRAILING)
						.addComponent(btnvolver))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtUrl, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblUrl))
							.addGap(14)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblUsuario)
								.addComponent(txtUsuario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addComponent(label))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblContrasea)
						.addComponent(txtContraseña, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnvolver)
						.addComponent(btnModificar))
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}
}
