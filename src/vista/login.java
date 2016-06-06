package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import controlador.controlador;
import modelo.modelo;
import java.awt.Font;

public class login extends JFrame {
	public static JTextField txtUsuario;
	private JButton btnLogIn;
	private JButton btnSingIn;
	private JButton btnLogOut;
	private JPanel contentPane;
	public static JPasswordField passwordField;
	private JLabel lblNewLabel;
	private registro sg;
	private notas not;
	private controlador controlador;
	private modelo modelo;
	private JButton btnConfiguracion;
	public config con;

	public void setsing(registro sg, notas not) {
		this.sg = sg;
		this.not = not;
	}

	public void setControlador(controlador controlador) {
		this.controlador = controlador;
	}

	public void setModelo(modelo modelo) {
		this.modelo = modelo;
	}

	public void setconfig(config con) {
		this.con = con;
	}

	public login() {

		setBounds(100, 100, 517, 369);
		contentPane = new JPanel();
		contentPane.setBackground(Color.CYAN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		txtUsuario = new JTextField();

		txtUsuario.setColumns(10);

		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setIcon(new ImageIcon(login.class.getResource("/imagenes/UsuarioBueno.jpg")));

		JLabel lblContraseña = new JLabel("Contrase\u00F1a:");
		lblContraseña.setIcon(new ImageIcon(login.class.getResource("/imagenes/Contrase\u00F1aBuena.png")));

		btnLogIn = new JButton("LogIn");
		btnLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controlador.solicitarusuarioypass();
			}
		});
		btnLogIn.setIcon(new ImageIcon(login.class.getResource("/imagenes/Login_in.png")));

		btnSingIn = new JButton("SignIn");
		btnSingIn.setIcon(new ImageIcon(login.class.getResource("/imagenes/icono_registro.gif")));
		btnSingIn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				// esto debe llevarte a la ventana de SingIn.
				setVisible(false);
				controlador.mostrarventanaregistro();
			}
		});

		btnLogOut = new JButton("LogOut");
		btnLogOut.setIcon(new ImageIcon(login.class.getResource("/imagenes/on-off.png")));
		btnLogOut.addMouseListener(new MouseAdapter() {
			// este boton cierra la aplicación
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
				// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

			}
		});

		passwordField = new JPasswordField();

		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(login.class.getResource("/imagenes/libros-de-la-biblioteca-icono-5623-48.png")));

		btnConfiguracion = new JButton("configuraci\u00F3n");
		btnConfiguracion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				controlador.mostrarventanaconfig();
			}
		});
		btnConfiguracion.setIcon(new ImageIcon(login.class.getResource("/imagenes/Setting-icon60.png")));
		
		JLabel lblAdministrador = new JLabel("ADMINISTRADOR");
		lblAdministrador.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(40)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(btnLogIn)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(btnSingIn))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(lblContraseña)
										.addComponent(lblUsuario))
									.addGap(25)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
										.addComponent(txtUsuario, Alignment.TRAILING)
										.addComponent(passwordField, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE))))
							.addGap(18))
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addContainerGap(214, Short.MAX_VALUE)
							.addComponent(lblAdministrador)
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_contentPane.createSequentialGroup()
								.addPreferredGap(ComponentPlacement.RELATED, 119, Short.MAX_VALUE)
								.addComponent(lblNewLabel)
								.addGap(8))
							.addComponent(btnConfiguracion, GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE))
						.addComponent(btnLogOut))
					.addGap(26))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblAdministrador)
							.addGap(8)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblUsuario)
								.addComponent(txtUsuario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addComponent(lblNewLabel))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblContraseña)
						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnConfiguracion, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE))
					.addGap(49)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnLogIn)
						.addComponent(btnSingIn)
						.addComponent(btnLogOut, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(62, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);

	}

	public String getNick() {
		return txtUsuario.getText();
	}

	public String getPass() {
		return new String(passwordField.getPassword());
	}
}