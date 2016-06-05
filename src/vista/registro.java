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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import controlador.controlador;
import modelo.modelo;

public class registro extends JFrame {
	private JPanel contentPane;
	private JTextField txtNick;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtemail;
	private JButton btnRegistrer;
	private JLabel lblSingIn;
	private JLabel lblNick;
	private JLabel lblNombre;
	private JLabel lblApellidos;
	private JLabel lblEmail;
	private JLabel lblContrasea;
	private JLabel lblRepetirContrasea;
	private JButton btnCancel;
	private JPasswordField password1;
	private JPasswordField password2;
	private login log;
	private notas man;
	private controlador cont;
	private modelo modelo;

	public void setLog(login lg, notas man, controlador cont) {
		this.log = lg;
		this.man = man;
		this.cont = cont;

	}

	public String getNick() {

		return txtNick.getText();
	}

	public String getNombre() {

		return txtNombre.getText();
	}

	public String getEmail() {

		return txtemail.getText();
	}

	public String getPass() {

		return new String(password1.getPassword());
	}

	public String getApellidos() {

		return txtApellido.getText();
	}

	/**
	 * Create the frame.
	 */
	public registro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 577, 388);
		contentPane = new JPanel();
		contentPane.setBackground(Color.CYAN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		lblSingIn = new JLabel("");
		lblSingIn.setIcon(new ImageIcon(registro.class.getResource("/imagenes/ICON.png")));

		lblNick = new JLabel("NICK*");

		txtNick = new JTextField();

		txtNick.setColumns(10);

		lblNombre = new JLabel("NOMBRE");

		txtNombre = new JTextField();
		txtNombre.setColumns(10);

		lblApellidos = new JLabel("APELLIDOS");

		txtApellido = new JTextField();
		txtApellido.setColumns(10);

		lblEmail = new JLabel("EMAIL*");

		txtemail = new JTextField();

		txtemail.setColumns(10);

		lblContrasea = new JLabel("CONTRASE\u00D1A*");

		lblRepetirContrasea = new JLabel("REPETIR CONTRASE\u00D1A*");

		btnCancel = new JButton("");
		btnCancel.setIcon(new ImageIcon(registro.class.getResource("/imagenes/back.png")));
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				cont.mostrarventanalogin();
			}
		});

		btnRegistrer = new JButton("");
		btnRegistrer.setIcon(new ImageIcon(registro.class.getResource("/imagenes/registrarse.gif")));
		btnRegistrer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int errores = 0;
				String pass1 = new String(password1.getPassword());
				String pass2 = new String(password2.getPassword());

				if (!(txtemail.getText().contains(".") && txtemail.getText().contains("@"))) {

					JOptionPane.showMessageDialog(null, "Introduce un Email valido", "", JOptionPane.ERROR_MESSAGE);
					errores++;

				}

				if (txtNick.getText().trim().equals("") || txtemail.getText().trim().equals("") || pass1.equals("")
						|| pass2.equals("")) {

					JOptionPane.showMessageDialog(null, "Rellana los campos obligatorios (*)", "",
							JOptionPane.ERROR_MESSAGE);
					errores++;
				}

				if (!pass1.equals(pass2)) {

					JOptionPane.showMessageDialog(null, "Las Contraseñas no son iguales", "",
							JOptionPane.ERROR_MESSAGE);
					password1.setText("");
					password2.setText("");

					errores++;

				}

				if (errores == 0) {

					cont.solicitarDatosSignin();
					limpiador();
				}

			}
		});

		password1 = new JPasswordField();

		password2 = new JPasswordField();

		JLabel lblNewLabel = new JLabel("(*) campos obligatorios");

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup().addGap(39)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING).addGroup(gl_contentPane
						.createSequentialGroup().addGap(67).addComponent(lblNewLabel)
						.addPreferredGap(ComponentPlacement.RELATED, 158, Short.MAX_VALUE).addComponent(btnCancel)
						.addGap(36).addComponent(btnRegistrer).addContainerGap())
						.addGroup(gl_contentPane
								.createSequentialGroup().addGroup(gl_contentPane
										.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
												.createSequentialGroup().addComponent(lblRepetirContrasea)
												.addGap(18).addComponent(password2, GroupLayout.DEFAULT_SIZE, 190,
														Short.MAX_VALUE))
										.addGroup(gl_contentPane.createSequentialGroup()
												.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
														.addComponent(lblApellidos).addComponent(lblNombre)
														.addGroup(gl_contentPane.createSequentialGroup()
																.addPreferredGap(ComponentPlacement.RELATED)
																.addComponent(lblNick)))
												.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
														.addGroup(gl_contentPane.createSequentialGroup().addGap(77)
																.addGroup(gl_contentPane
																		.createParallelGroup(Alignment.LEADING)
																		.addComponent(txtNombre,
																				GroupLayout.DEFAULT_SIZE, 196,
																				Short.MAX_VALUE)
																		.addComponent(txtApellido,
																				GroupLayout.PREFERRED_SIZE, 196,
																				GroupLayout.PREFERRED_SIZE)))
														.addGroup(gl_contentPane.createSequentialGroup()
																.addPreferredGap(ComponentPlacement.RELATED)
																.addComponent(txtNick, GroupLayout.PREFERRED_SIZE, 196,
																		GroupLayout.PREFERRED_SIZE)
																.addGap(2))))
										.addGroup(gl_contentPane.createSequentialGroup()
												.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
														.addComponent(lblEmail).addComponent(lblContrasea))
												.addGap(63)
												.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
														.addComponent(password1, GroupLayout.PREFERRED_SIZE, 189,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(txtemail, GroupLayout.PREFERRED_SIZE, 190,
																GroupLayout.PREFERRED_SIZE))))
								.addGap(101).addComponent(lblSingIn).addGap(36)))));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup()
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup().addContainerGap().addComponent(lblSingIn))
						.addGroup(gl_contentPane.createSequentialGroup().addGap(30).addComponent(lblNick))
						.addGroup(gl_contentPane.createSequentialGroup().addGap(30).addComponent(txtNick,
								GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
				.addGap(18)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addComponent(lblNombre).addComponent(
						txtNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(18)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addComponent(lblApellidos).addComponent(
						txtApellido, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(18)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addComponent(lblEmail).addComponent(
						txtemail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(18)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addComponent(lblContrasea).addComponent(
						password1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(18)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(lblRepetirContrasea)
						.addComponent(password2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING,
								gl_contentPane.createSequentialGroup()
										.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
												.addComponent(btnCancel).addComponent(btnRegistrer))
										.addContainerGap())
						.addGroup(Alignment.TRAILING,
								gl_contentPane.createSequentialGroup().addComponent(lblNewLabel).addGap(27)))));
		contentPane.setLayout(gl_contentPane);
	}

	public void limpiador() {
		txtNombre.setText("");
		txtApellido.setText("");
		txtemail.setText("");
		txtNick.setText("");
		password1.setText("");
		password2.setText("");

	}

	public void setControlador(controlador controlador) {
		this.cont = controlador;
	}

	public void setModelo(modelo modelo) {
		this.modelo = modelo;
	}
}
