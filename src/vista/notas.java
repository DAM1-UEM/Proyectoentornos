package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.controlador;
import modelo.modelo;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JPasswordField;

public class notas extends JFrame {

	private JPanel contentPane;
	private modelo mod;
	private controlador con;
	private JTable tablaprofesor;
	private JTable tablamodulos;
	private JTable tablalumnos;
	private JTable tablanotamodulo;
	private JTable table;
	private JTextField txtcurso;
	private JTextField txtnombremodulo;
	private JTextField txthoras;
	private JTextField txtexprofesor;
	private JButton btnAnadirmod;
	private JButton btnBorrarmod;
	private JButton btnModificarmod;
	private JTextField txtexprof;
	private JTextField textField;
	private JTextField textField_1;
	private JButton btnanadirprofe;
	private JTextField txtexpalumno;
	private JTextField textField_2;
	private JTextField txtcorreo;
	private JPasswordField passwordField;
	private JButton btnAnadiralumno;
	private JButton btnModificaralumn;
	private JTextField txtexp;
	private JTextField txtnotamod;
	private JTextField txtcursomod;
	private JTextField txtnommodulo;
	private JButton btnAnadirnotmod;
	private JButton btnModificarnotmod;

	public void setmodelo(modelo modelo) {
		this.mod = modelo;
	}
	public void setcontrolador(controlador con){
		this.con=con;
	}

	public notas() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 856, 538);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		
		JButton btnvolver = new JButton("");
		btnvolver.setIcon(new ImageIcon(notas.class.getResource("/imagenes/back.png")));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, 830, Short.MAX_VALUE)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnvolver)
					.addContainerGap(755, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, 435, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnvolver)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		JPanel panelmodulos = new JPanel();
		tabbedPane.addTab("M\u00F3dulos", null, panelmodulos, null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		
		JLabel lblIntroduzcaCurso = new JLabel("Introduzca curso");
		
		JComboBox combocurso = new JComboBox();
		combocurso.setModel(new DefaultComboBoxModel(new String[] {"1\u00BA DAM", "2\u00BA DAM"}));
		
		txtcurso = new JTextField();
		txtcurso.setColumns(10);
		
		JLabel lblIntroduzcaNombreModulo = new JLabel("Introduzca nombre modulo");
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Bases de datos", "Sistemas Inform\u00E1ticos", "Programaci\u00F3n", "Lenguaje de marcas", "Entornos de desarrollo", "Acceso a datos", "Desarrollo de interfaces", "Empresa e iniciativa emprendedora", "Programaci\u00F3n de servicios y procesos", "Programaci\u00F3n multimedia y dispositivos m\u00F3viles", "Sistemas de gesti\u00F3n empresarial", "Formaci\u00F3n en Centros de Trabajo"}));
		
		txtnombremodulo = new JTextField();
		txtnombremodulo.setColumns(10);
		
		JLabel label = new JLabel("Horas semanales");
		
		txthoras = new JTextField();
		txthoras.setColumns(10);
		
		JLabel lblNExpprof = new JLabel("N\u00BA Exp/prof");
		
		txtexprofesor = new JTextField();
		txtexprofesor.setColumns(10);
		
		btnAnadirmod = new JButton("A\u00F1adir");
		
		btnModificarmod = new JButton("Modificar");
		
		btnBorrarmod = new JButton("Borrar");
		GroupLayout gl_panelmodulos = new GroupLayout(panelmodulos);
		gl_panelmodulos.setHorizontalGroup(
			gl_panelmodulos.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelmodulos.createSequentialGroup()
					.addGroup(gl_panelmodulos.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelmodulos.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_panelmodulos.createParallelGroup(Alignment.LEADING)
								.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 805, Short.MAX_VALUE)
								.addGroup(gl_panelmodulos.createSequentialGroup()
									.addGroup(gl_panelmodulos.createParallelGroup(Alignment.LEADING)
										.addComponent(lblIntroduzcaCurso)
										.addComponent(combocurso, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(txtcurso, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE))
									.addGap(63)
									.addGroup(gl_panelmodulos.createParallelGroup(Alignment.LEADING, false)
										.addComponent(lblIntroduzcaNombreModulo)
										.addComponent(comboBox, 0, 183, Short.MAX_VALUE)
										.addComponent(txtnombremodulo))
									.addGap(52)
									.addGroup(gl_panelmodulos.createParallelGroup(Alignment.LEADING)
										.addComponent(label)
										.addComponent(txthoras, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addGap(108)
									.addGroup(gl_panelmodulos.createParallelGroup(Alignment.LEADING)
										.addComponent(txtexprofesor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNExpprof)))))
						.addGroup(gl_panelmodulos.createSequentialGroup()
							.addGap(269)
							.addComponent(btnAnadirmod)
							.addGap(18)
							.addComponent(btnModificarmod)
							.addGap(18)
							.addComponent(btnBorrarmod)))
					.addContainerGap())
		);
		gl_panelmodulos.setVerticalGroup(
			gl_panelmodulos.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelmodulos.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 238, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_panelmodulos.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblIntroduzcaCurso)
						.addComponent(lblIntroduzcaNombreModulo)
						.addComponent(label)
						.addComponent(lblNExpprof))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panelmodulos.createParallelGroup(Alignment.BASELINE)
						.addComponent(combocurso, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txthoras, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtexprofesor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panelmodulos.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtcurso, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtnombremodulo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
					.addGroup(gl_panelmodulos.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAnadirmod)
						.addComponent(btnModificarmod)
						.addComponent(btnBorrarmod))
					.addContainerGap())
		);
		
		tablamodulos = new JTable();
		tablamodulos.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"Curso", "Nombre_modulo", "Horas/semana", "N\u00BA Expediente/profesor"
			}
		));
		tablamodulos.getColumnModel().getColumn(1).setPreferredWidth(104);
		tablamodulos.getColumnModel().getColumn(2).setPreferredWidth(105);
		tablamodulos.getColumnModel().getColumn(3).setPreferredWidth(107);
		scrollPane_1.setViewportView(tablamodulos);
		panelmodulos.setLayout(gl_panelmodulos);
		
		JPanel panelprofesores = new JPanel();
		tabbedPane.addTab("Profesores", null, panelprofesores, null);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel lblIntroduzcaNExpediente = new JLabel("Introduzca n\u00BA expediente");
		
		txtexprof = new JTextField();
		txtexprof.setColumns(10);
		
		JLabel lblNombreYApellidos = new JLabel("Nombre y apellidos del profesor");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JLabel lblCorreoProfesor = new JLabel("Correo profesor");
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		btnanadirprofe = new JButton("A\u00F1adir");
		
		JButton btnModificarprofe = new JButton("Modificar");
		
		JButton btnBorrarprofe = new JButton("Borrar");
		GroupLayout gl_panelprofesores = new GroupLayout(panelprofesores);
		gl_panelprofesores.setHorizontalGroup(
			gl_panelprofesores.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelprofesores.createSequentialGroup()
					.addGroup(gl_panelprofesores.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelprofesores.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_panelprofesores.createParallelGroup(Alignment.LEADING)
								.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 805, Short.MAX_VALUE)
								.addGroup(gl_panelprofesores.createSequentialGroup()
									.addComponent(txtexprof, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
									.addGap(171)
									.addComponent(textField, GroupLayout.PREFERRED_SIZE, 197, GroupLayout.PREFERRED_SIZE)
									.addGap(73)
									.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 197, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panelprofesores.createSequentialGroup()
									.addComponent(lblIntroduzcaNExpediente)
									.addGap(173)
									.addComponent(lblNombreYApellidos)
									.addGap(132)
									.addComponent(lblCorreoProfesor))))
						.addGroup(gl_panelprofesores.createSequentialGroup()
							.addGap(214)
							.addComponent(btnanadirprofe)
							.addGap(18)
							.addComponent(btnModificarprofe)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnBorrarprofe)))
					.addContainerGap())
		);
		gl_panelprofesores.setVerticalGroup(
			gl_panelprofesores.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelprofesores.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 238, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_panelprofesores.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblIntroduzcaNExpediente)
						.addComponent(lblNombreYApellidos)
						.addComponent(lblCorreoProfesor))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panelprofesores.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtexprof, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
					.addGroup(gl_panelprofesores.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnanadirprofe)
						.addComponent(btnModificarprofe)
						.addComponent(btnBorrarprofe))
					.addContainerGap())
		);
		
		tablaprofesor = new JTable();
		tablaprofesor.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"N\u00BA Expediente", "Nombre y apellidos del profesor", "Correo profesor"
			}
		));
		scrollPane.setViewportView(tablaprofesor);
		panelprofesores.setLayout(gl_panelprofesores);
		
		JPanel panelalumnos = new JPanel();
		tabbedPane.addTab("Alumnos", null, panelalumnos, null);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		
		JLabel lblIntroduzcaNumeroExpediente = new JLabel("Introduzca n\u00BA expediente alumno");
		
		txtexpalumno = new JTextField();
		txtexpalumno.setColumns(10);
		
		JLabel lblIntroduzcaNombreY = new JLabel("Introduzca nombre y apellidos alumno");
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		
		JLabel lblCorreoAlumno = new JLabel("Correo alumno");
		
		txtcorreo = new JTextField();
		txtcorreo.setColumns(10);
		
		JLabel lblContraseaAlumno = new JLabel("Contrase\u00F1a alumno");
		
		passwordField = new JPasswordField();
		
		btnAnadiralumno = new JButton("A\u00F1adir");
		
		btnModificaralumn = new JButton("Modificar");
		
		JButton btnBorraralumn = new JButton("Borrar");
		GroupLayout gl_panelalumnos = new GroupLayout(panelalumnos);
		gl_panelalumnos.setHorizontalGroup(
			gl_panelalumnos.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelalumnos.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelalumnos.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelalumnos.createSequentialGroup()
							.addComponent(scrollPane_2, GroupLayout.DEFAULT_SIZE, 805, Short.MAX_VALUE)
							.addContainerGap())
						.addGroup(gl_panelalumnos.createSequentialGroup()
							.addGroup(gl_panelalumnos.createParallelGroup(Alignment.LEADING)
								.addComponent(lblIntroduzcaNumeroExpediente)
								.addComponent(txtexpalumno, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE))
							.addGap(36)
							.addGroup(gl_panelalumnos.createParallelGroup(Alignment.LEADING)
								.addComponent(lblIntroduzcaNombreY)
								.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 206, GroupLayout.PREFERRED_SIZE))
							.addGap(41)
							.addGroup(gl_panelalumnos.createParallelGroup(Alignment.LEADING)
								.addComponent(lblCorreoAlumno)
								.addComponent(txtcorreo, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE))
							.addGap(40)
							.addGroup(gl_panelalumnos.createParallelGroup(Alignment.LEADING)
								.addComponent(lblContraseaAlumno)
								.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE))
							.addContainerGap(93, Short.MAX_VALUE))))
				.addGroup(gl_panelalumnos.createSequentialGroup()
					.addGap(222)
					.addComponent(btnAnadiralumno)
					.addGap(18)
					.addComponent(btnModificaralumn)
					.addGap(18)
					.addComponent(btnBorraralumn)
					.addContainerGap(340, Short.MAX_VALUE))
		);
		gl_panelalumnos.setVerticalGroup(
			gl_panelalumnos.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelalumnos.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane_2, GroupLayout.PREFERRED_SIZE, 238, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_panelalumnos.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblIntroduzcaNumeroExpediente)
						.addComponent(lblIntroduzcaNombreY)
						.addComponent(lblCorreoAlumno)
						.addComponent(lblContraseaAlumno))
					.addGap(18)
					.addGroup(gl_panelalumnos.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtexpalumno, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtcorreo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
					.addGroup(gl_panelalumnos.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAnadiralumno)
						.addComponent(btnModificaralumn)
						.addComponent(btnBorraralumn))
					.addContainerGap())
		);
		
		tablalumnos = new JTable();
		tablalumnos.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
			},
			new String[] {
				"N\u00BA Expediente", "Nombre y apellidos alumno", "Correo_alumno", "Contrase\u00F1a alumno"
			}
		));
		tablalumnos.getColumnModel().getColumn(1).setPreferredWidth(152);
		tablalumnos.getColumnModel().getColumn(2).setPreferredWidth(130);
		scrollPane_2.setViewportView(tablalumnos);
		panelalumnos.setLayout(gl_panelalumnos);
		
		JPanel panelnotamodulo = new JPanel();
		tabbedPane.addTab("Nota modulos", null, panelnotamodulo, null);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		
		JLabel lblIntroduzcaCurso_1 = new JLabel("Introduzca curso");
		
		JLabel lblIntroduzcaNombreMdulo = new JLabel("Introduzca nombre m\u00F3dulo");
		
		JComboBox comboBoxcurso = new JComboBox();
		comboBoxcurso.setModel(new DefaultComboBoxModel(new String[] {"1\u00BA DAM", "2\u00BA DAM"}));
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Bases de datos", "Sistemas Inform\u00E1ticos", "Programaci\u00F3n", "Lenguaje de marcas", "Entornos de desarrollo", "Acceso a datos", "Desarrollo de interfaces", "Empresa e iniciativa emprendedora", "Programaci\u00F3n de servicios y procesos", "Programaci\u00F3n multimedia y dispositivos m\u00F3viles", "Sistemas de gesti\u00F3n empresarial", "Formaci\u00F3n en Centros de Trabajo"}));
		
		JLabel lblNewLabel = new JLabel("N\u00BA Expediente");
		
		txtexp = new JTextField();
		txtexp.setColumns(10);
		
		JLabel lblNotaModulo = new JLabel("Nota modulo");
		
		txtnotamod = new JTextField();
		txtnotamod.setColumns(10);
		
		txtcursomod = new JTextField();
		txtcursomod.setColumns(10);
		
		txtnommodulo = new JTextField();
		txtnommodulo.setColumns(10);
		
		btnAnadirnotmod = new JButton("A\u00F1adir");
		
		btnModificarnotmod = new JButton("Modificar");
		
		JButton btnBorrarnotmod = new JButton("Borrar");
		GroupLayout gl_panelnotamodulo = new GroupLayout(panelnotamodulo);
		gl_panelnotamodulo.setHorizontalGroup(
			gl_panelnotamodulo.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelnotamodulo.createSequentialGroup()
					.addGroup(gl_panelnotamodulo.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelnotamodulo.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_panelnotamodulo.createParallelGroup(Alignment.LEADING)
								.addComponent(scrollPane_3, GroupLayout.DEFAULT_SIZE, 805, Short.MAX_VALUE)
								.addGroup(gl_panelnotamodulo.createSequentialGroup()
									.addGroup(gl_panelnotamodulo.createParallelGroup(Alignment.LEADING)
										.addComponent(lblIntroduzcaCurso_1)
										.addComponent(comboBoxcurso, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(txtcursomod, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addGap(130)
									.addGroup(gl_panelnotamodulo.createParallelGroup(Alignment.LEADING)
										.addComponent(txtnommodulo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addGroup(gl_panelnotamodulo.createSequentialGroup()
											.addGroup(gl_panelnotamodulo.createParallelGroup(Alignment.LEADING)
												.addComponent(lblIntroduzcaNombreMdulo)
												.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE))
											.addGap(108)
											.addGroup(gl_panelnotamodulo.createParallelGroup(Alignment.LEADING)
												.addComponent(lblNewLabel)
												.addComponent(txtexp, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
											.addGap(86)
											.addGroup(gl_panelnotamodulo.createParallelGroup(Alignment.LEADING)
												.addComponent(txtnotamod, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(lblNotaModulo)))))))
						.addGroup(gl_panelnotamodulo.createSequentialGroup()
							.addGap(235)
							.addComponent(btnAnadirnotmod)
							.addGap(18)
							.addComponent(btnModificarnotmod)
							.addGap(18)
							.addComponent(btnBorrarnotmod)))
					.addContainerGap())
		);
		gl_panelnotamodulo.setVerticalGroup(
			gl_panelnotamodulo.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelnotamodulo.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane_3, GroupLayout.PREFERRED_SIZE, 238, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_panelnotamodulo.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblIntroduzcaCurso_1)
						.addComponent(lblIntroduzcaNombreMdulo)
						.addComponent(lblNewLabel)
						.addComponent(lblNotaModulo))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panelnotamodulo.createParallelGroup(Alignment.BASELINE)
						.addComponent(comboBoxcurso, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtexp, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtnotamod, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panelnotamodulo.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtcursomod, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtnommodulo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
					.addGroup(gl_panelnotamodulo.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAnadirnotmod)
						.addComponent(btnModificarnotmod)
						.addComponent(btnBorrarnotmod))
					.addContainerGap())
		);
		
		tablanotamodulo = new JTable();
		tablanotamodulo.setModel(new DefaultTableModel(
			new Object[][] {
				{null, "", null, null},
			},
			new String[] {
				"Curso", "Nombre m\u00F3dulo", "n\u00BA expediente/alumno", "Nota"
			}
		));
		scrollPane_3.setViewportView(tablanotamodulo);
		panelnotamodulo.setLayout(gl_panelnotamodulo);
		
		JPanel panelnotatotal = new JPanel();
		tabbedPane.addTab("Nota total", null, panelnotatotal, null);
		
		JScrollPane scrollPane_4 = new JScrollPane();
		GroupLayout gl_panelnotatotal = new GroupLayout(panelnotatotal);
		gl_panelnotatotal.setHorizontalGroup(
			gl_panelnotatotal.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelnotatotal.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane_4, GroupLayout.DEFAULT_SIZE, 805, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panelnotatotal.setVerticalGroup(
			gl_panelnotatotal.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelnotatotal.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane_4, GroupLayout.PREFERRED_SIZE, 238, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(161, Short.MAX_VALUE))
		);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
			},
			new String[] {
				"Curso", "N\u00BAExpediente/alumno", "Nota total"
			}
		));
		scrollPane_4.setViewportView(table);
		panelnotatotal.setLayout(gl_panelnotatotal);
		contentPane.setLayout(gl_contentPane);
	}
}
