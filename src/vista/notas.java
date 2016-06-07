package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

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
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class notas extends JFrame {

	private JPanel contentPane;
	private modelo mod;
	private login log;
	private controlador con;
	private JTable tablaprofesor;
	private JTable tablamodulos;
	private JTable tablalumnos;
	private JTable tablanotamodulo;
	private JTable tablanotatotal;
	private JTextField txtcurso;
	private JTextField txtnombremodulo;
	private JTextField txthoras;
	private JTextField txtexprofesor;
	private JButton btnAnadirmod;
	private JButton btnBorrarmod;
	private JButton btnModificarmod;
	private JTextField txtexprof;
	private JTextField txtnomprofe;
	private JTextField txtcorreoprof;
	private JButton btnanadirprofe;
	private JTextField txtexpalumno;
	private JTextField txtnomalumno;
	private JTextField txtcorreo;
	private JButton btnAnadiralumno;
	private JButton btnModificaralumn;
	private JTextField txtexp;
	private JTextField txtnotamod;
	private JTextField txtcursomod;
	private JTextField txtnommodulo;
	private JButton btnAnadirnotmod;
	private JButton btnModificarnotmod;
	private JTextField txtnotatotalcurso;
	private JTextField txtexpnotatotal;
	private JTextField txtnotatotal;
	private JButton btnanadirnotatotal;
	private JButton btnBorrarnotatotal;
	private JButton btnModificarnotatotal;
	private DefaultTableModel dtmodulo;
	private DefaultTableModel dtmprofesores;
	private DefaultTableModel dtmalumnos;
	private DefaultTableModel dtmnotamod;
	private DefaultTableModel dtmnotatotal;
	private String curso;
	private String nombremod;
	private String horas;
	private String expprofesormod;
	private String expprofe;
	private String nomprofe;
	private String correoprofe;
	private String expalumno;
	private String nomalumno;
	private String correoalumno;
	private String expmod;
	private String notamod;
	private String cursomod;
	private String nommod;
	private String notatotalcurso;
	private String exptotalcurso;
	private String notatotal;

	private void setmodulo(String curso, String nombremod, String horas, String expprofesormod) {
		this.curso = curso;
		this.nombremod = nombremod;
		this.horas = horas;
		this.expprofesormod = expprofesormod;
	}

	private void setprofesor(String expprofe, String nomprofe, String correoprofe) {
		this.expprofe = expprofe;
		this.nomprofe = nomprofe;
		this.correoprofe = correoprofe;
	}

	private void setalumno(String expalumno, String nomalumno, String correoalumno) {
		this.expalumno = expalumno;
		this.nomalumno = nomalumno;
		this.correoalumno = correoalumno;
	}

	private void setnotamod(String expmod, String notamod, String cursomod, String nommod) {
		this.expmod = expmod;
		this.notamod = notamod;
		this.cursomod = cursomod;
		this.nommod = nommod;
	}

	private void setnotatotal(String notatotalcurso, String exptotalcurso, String notatotal) {
		this.notatotalcurso = notatotalcurso;
		this.exptotalcurso = exptotalcurso;
		this.notatotal = notatotal;
	}

	public void setmodelo(modelo modelo) {
		this.mod = modelo;
	}

	public void setcontrolador(controlador con) {
		this.con = con;
	}

	public notas() {
		addWindowListener(new WindowAdapter() {
			public void windowOpened(WindowEvent e) {
				con.cargarprofesores();
				con.cargarmodulos();
				con.cargaralumnos();
				con.cargarnotaalumnos();
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 856, 538);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);

		JButton btnvolver = new JButton("");
		btnvolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				con.mostrarventanalogin();
			}
		});
		btnvolver.setIcon(new ImageIcon(notas.class.getResource("/imagenes/back.png")));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, 830, Short.MAX_VALUE)
				.addGroup(gl_contentPane.createSequentialGroup().addContainerGap().addComponent(btnvolver)
						.addContainerGap(755, Short.MAX_VALUE)));
		gl_contentPane
				.setVerticalGroup(
						gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, 435,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED).addComponent(btnvolver)
										.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

		JPanel panelmodulos = new JPanel();
		tabbedPane.addTab("M\u00F3dulos", null, panelmodulos, null);

		JScrollPane scrollPane_1 = new JScrollPane();

		JLabel lblIntroduzcaCurso = new JLabel("Introduzca curso");

		JComboBox combocurso = new JComboBox();
		combocurso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object combocu = combocurso.getSelectedItem();
				String res = String.valueOf(combocu);
				txtcurso.setText(res);
			}
		});
		combocurso.setModel(new DefaultComboBoxModel(new String[] { "1\u00BA DAM", "2\u00BA DAM" }));

		txtcurso = new JTextField();
		txtcurso.setColumns(10);

		JLabel lblIntroduzcaNombreModulo = new JLabel("Introduzca nombre modulo");

		JComboBox combomodulo1 = new JComboBox();
		combomodulo1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object combomod = combomodulo1.getSelectedItem();
				String res = String.valueOf(combomod);
				txtnombremodulo.setText(res);
			}
		});
		combomodulo1.setModel(new DefaultComboBoxModel(new String[] { "Bases de datos", "Sistemas Inform\u00E1ticos",
				"Programaci\u00F3n", "Lenguaje de marcas", "Entornos de desarrollo", "Acceso a datos",
				"Desarrollo de interfaces", "Empresa e iniciativa emprendedora",
				"Programaci\u00F3n de servicios y procesos", "Programaci\u00F3n multimedia y dispositivos m\u00F3viles",
				"Sistemas de gesti\u00F3n empresarial", "Formaci\u00F3n en Centros de Trabajo" }));

		txtnombremodulo = new JTextField();
		txtnombremodulo.setColumns(10);

		JLabel label = new JLabel("Horas semanales");

		txthoras = new JTextField();
		txthoras.setColumns(10);

		JLabel lblNExpprof = new JLabel("N\u00BA Exp/prof");

		txtexprofesor = new JTextField();
		txtexprofesor.setColumns(10);

		btnAnadirmod = new JButton("A\u00F1adir");
		btnAnadirmod.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Object[] fila = { txtcurso.getText(), txtnombremodulo.getText(), txthoras.getText(),
						txtexprofesor.getText() };
				dtmodulo.addRow(fila);
				setmodulo(txtcurso.getText(), txtnombremodulo.getText(), txthoras.getText(), txtexprofesor.getText());
				txtcurso.setText("");
				txtnombremodulo.setText("");
				txthoras.setText("");
				txtexprofesor.setText("");
				JOptionPane.showMessageDialog(null, "Añadido!!", "", JOptionPane.INFORMATION_MESSAGE);


			}
		});

		btnModificarmod = new JButton("Modificar");
		btnModificarmod.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tablamodulos.setValueAt(txtcurso.getText(), tablamodulos.getSelectedRow(), 0);
				tablamodulos.setValueAt(txtnombremodulo.getText(), tablamodulos.getSelectedRow(), 1);
				tablamodulos.setValueAt(txthoras.getText(), tablamodulos.getSelectedRow(), 2);
				tablamodulos.setValueAt(txtexprofesor.getText(), tablamodulos.getSelectedRow(), 3);
				txtcurso.setText("");
				txtnombremodulo.setText("");
				txthoras.setText("");
				txtexprofesor.setText("");
				JOptionPane.showMessageDialog(null, "Modificado!!", "", JOptionPane.INFORMATION_MESSAGE);

			}
		});

		btnBorrarmod = new JButton("Borrar");
		btnBorrarmod.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dtmodulo.removeRow(tablamodulos.getSelectedRow());
				txtcurso.setText("");
				txtnombremodulo.setText("");
				txthoras.setText("");
				txtexprofesor.setText("");
				JOptionPane.showMessageDialog(null, "Borrado!!", "", JOptionPane.INFORMATION_MESSAGE);

			}
		});
		GroupLayout gl_panelmodulos = new GroupLayout(panelmodulos);
		gl_panelmodulos
				.setHorizontalGroup(gl_panelmodulos.createParallelGroup(Alignment.LEADING).addGroup(
						gl_panelmodulos
								.createSequentialGroup().addGroup(gl_panelmodulos
										.createParallelGroup(Alignment.LEADING).addGroup(gl_panelmodulos
												.createSequentialGroup()
												.addContainerGap().addGroup(gl_panelmodulos.createParallelGroup(
														Alignment.LEADING)
														.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 805,
																Short.MAX_VALUE)
														.addGroup(
																gl_panelmodulos.createSequentialGroup()
																		.addGroup(gl_panelmodulos
																				.createParallelGroup(Alignment.LEADING)
																				.addComponent(lblIntroduzcaCurso)
																				.addComponent(combocurso,
																						GroupLayout.PREFERRED_SIZE,
																						GroupLayout.DEFAULT_SIZE,
																						GroupLayout.PREFERRED_SIZE)
																				.addComponent(txtcurso,
																						GroupLayout.PREFERRED_SIZE, 122,
																						GroupLayout.PREFERRED_SIZE))
																		.addGap(63)
																		.addGroup(gl_panelmodulos
																				.createParallelGroup(Alignment.LEADING,
																						false)
																				.addComponent(lblIntroduzcaNombreModulo)
																				.addComponent(combomodulo1, 0, 183,
																						Short.MAX_VALUE)
																				.addComponent(txtnombremodulo))
																		.addGap(52)
																		.addGroup(
																				gl_panelmodulos
																						.createParallelGroup(
																								Alignment.LEADING)
																						.addComponent(label)
																						.addComponent(txthoras,
																								GroupLayout.PREFERRED_SIZE,
																								GroupLayout.DEFAULT_SIZE,
																								GroupLayout.PREFERRED_SIZE))
																		.addGap(108)
																		.addGroup(gl_panelmodulos
																				.createParallelGroup(Alignment.LEADING)
																				.addComponent(txtexprofesor,
																						GroupLayout.PREFERRED_SIZE,
																						GroupLayout.DEFAULT_SIZE,
																						GroupLayout.PREFERRED_SIZE)
																				.addComponent(lblNExpprof)))))
										.addGroup(gl_panelmodulos.createSequentialGroup().addGap(269)
												.addComponent(btnAnadirmod).addGap(18).addComponent(btnModificarmod)
												.addGap(18).addComponent(btnBorrarmod)))
								.addContainerGap()));
		gl_panelmodulos.setVerticalGroup(gl_panelmodulos.createParallelGroup(Alignment.LEADING).addGroup(gl_panelmodulos
				.createSequentialGroup().addContainerGap()
				.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 238, GroupLayout.PREFERRED_SIZE).addGap(18)
				.addGroup(gl_panelmodulos.createParallelGroup(Alignment.BASELINE).addComponent(lblIntroduzcaCurso)
						.addComponent(lblIntroduzcaNombreModulo).addComponent(label).addComponent(lblNExpprof))
				.addPreferredGap(ComponentPlacement.UNRELATED)
				.addGroup(gl_panelmodulos.createParallelGroup(Alignment.BASELINE)
						.addComponent(combocurso, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(combomodulo1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(txthoras, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(txtexprofesor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.UNRELATED)
				.addGroup(gl_panelmodulos.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtcurso, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(txtnombremodulo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
				.addGroup(gl_panelmodulos.createParallelGroup(Alignment.BASELINE).addComponent(btnAnadirmod)
						.addComponent(btnModificarmod).addComponent(btnBorrarmod))
				.addContainerGap()));

		tablamodulos = new JTable();
		tablamodulos.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent arg0) {
				txtcurso.setText((String) dtmodulo.getValueAt(tablamodulos.getSelectedRow(), 0));
				txtnombremodulo.setText((String) dtmodulo.getValueAt(tablamodulos.getSelectedRow(), 1));
				txthoras.setText((String) dtmodulo.getValueAt(tablamodulos.getSelectedRow(), 2));
				txtexprofesor.setText((String) dtmodulo.getValueAt(tablamodulos.getSelectedRow(), 3));

			}
		});
		dtmodulo = new DefaultTableModel(new Object[][] {},
				new String[] { "Curso", "Nombre_modulo", "Horas/semana", "N\u00BA Expediente/profesor" });
		tablamodulos.setModel(dtmodulo);
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

		txtnomprofe = new JTextField();
		txtnomprofe.setColumns(10);

		JLabel lblCorreoProfesor = new JLabel("Correo profesor");

		txtcorreoprof = new JTextField();
		txtcorreoprof.setColumns(10);

		btnanadirprofe = new JButton("A\u00F1adir");
		btnanadirprofe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Object[] fila = { txtexprof.getText(), txtnomprofe.getText(), txtcorreoprof.getText() };
				dtmprofesores.addRow(fila);
				setprofesor(txtexprof.getText(), txtnomprofe.getText(), txtcorreoprof.getText());
				txtexprof.setText("");
				txtnomprofe.setText("");
				txtcorreoprof.setText("");
				JOptionPane.showMessageDialog(null, "Añadido!!", "", JOptionPane.INFORMATION_MESSAGE);

			}
		});

		JButton btnModificarprofe = new JButton("Modificar");
		btnModificarprofe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tablaprofesor.setValueAt(txtexprof.getText(), tablaprofesor.getSelectedRow(), 0);
				tablaprofesor.setValueAt(txtnomprofe.getText(), tablaprofesor.getSelectedRow(), 1);
				tablaprofesor.setValueAt(txtcorreoprof.getText(), tablaprofesor.getSelectedRow(), 2);
				txtexprof.setText("");
				txtnomprofe.setText("");
				txtcorreoprof.setText("");
				JOptionPane.showMessageDialog(null, "Modificado!!", "", JOptionPane.INFORMATION_MESSAGE);

			}
		});

		JButton btnBorrarprofe = new JButton("Borrar");
		btnBorrarprofe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dtmprofesores.removeRow(tablaprofesor.getSelectedRow());
				txtexprof.setText("");
				txtnomprofe.setText("");
				txtcorreoprof.setText("");
				JOptionPane.showMessageDialog(null, "Borrado!!", "", JOptionPane.INFORMATION_MESSAGE);

			}
		});
		GroupLayout gl_panelprofesores = new GroupLayout(panelprofesores);
		gl_panelprofesores.setHorizontalGroup(gl_panelprofesores.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelprofesores.createSequentialGroup().addGroup(gl_panelprofesores
						.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelprofesores.createSequentialGroup().addContainerGap()
								.addGroup(gl_panelprofesores.createParallelGroup(Alignment.LEADING)
										.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 805, Short.MAX_VALUE)
										.addGroup(gl_panelprofesores.createSequentialGroup()
												.addComponent(txtexprof, GroupLayout.PREFERRED_SIZE, 109,
														GroupLayout.PREFERRED_SIZE)
												.addGap(171)
												.addComponent(txtnomprofe, GroupLayout.PREFERRED_SIZE, 197,
														GroupLayout.PREFERRED_SIZE)
												.addGap(73).addComponent(txtcorreoprof, GroupLayout.PREFERRED_SIZE, 197,
														GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_panelprofesores.createSequentialGroup()
												.addComponent(lblIntroduzcaNExpediente).addGap(173)
												.addComponent(lblNombreYApellidos).addGap(132)
												.addComponent(lblCorreoProfesor))))
						.addGroup(gl_panelprofesores.createSequentialGroup().addGap(214).addComponent(btnanadirprofe)
								.addGap(18).addComponent(btnModificarprofe)
								.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(btnBorrarprofe)))
						.addContainerGap()));
		gl_panelprofesores
				.setVerticalGroup(
						gl_panelprofesores.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panelprofesores.createSequentialGroup().addContainerGap()
										.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 238,
												GroupLayout.PREFERRED_SIZE)
										.addGap(18)
										.addGroup(gl_panelprofesores.createParallelGroup(Alignment.BASELINE)
												.addComponent(lblIntroduzcaNExpediente)
												.addComponent(lblNombreYApellidos).addComponent(lblCorreoProfesor))
										.addPreferredGap(ComponentPlacement.RELATED)
										.addGroup(gl_panelprofesores.createParallelGroup(Alignment.BASELINE)
												.addComponent(txtexprof, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(txtnomprofe, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(txtcorreoprof, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
										.addGroup(gl_panelprofesores.createParallelGroup(Alignment.BASELINE)
												.addComponent(btnanadirprofe).addComponent(btnModificarprofe)
												.addComponent(btnBorrarprofe))
										.addContainerGap()));

		tablaprofesor = new JTable();
		tablaprofesor.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				txtexprof.setText((String) dtmprofesores.getValueAt(tablaprofesor.getSelectedRow(), 0));
				txtnomprofe.setText((String) dtmprofesores.getValueAt(tablaprofesor.getSelectedRow(), 1));
				txtcorreoprof.setText((String) dtmprofesores.getValueAt(tablaprofesor.getSelectedRow(), 2));

			}
		});
		dtmprofesores = new DefaultTableModel(new Object[][] {},
				new String[] { "N\u00BA Expediente", "Nombre y apellidos del profesor", "Correo profesor" });
		tablaprofesor.setModel(dtmprofesores);

		scrollPane.setViewportView(tablaprofesor);
		panelprofesores.setLayout(gl_panelprofesores);

		JPanel panelalumnos = new JPanel();
		tabbedPane.addTab("Alumnos", null, panelalumnos, null);

		JScrollPane scrollPane_2 = new JScrollPane();

		JLabel lblIntroduzcaNumeroExpediente = new JLabel("Introduzca n\u00BA expediente alumno");

		txtexpalumno = new JTextField();
		txtexpalumno.setColumns(10);

		JLabel lblIntroduzcaNombreY = new JLabel("Introduzca nombre y apellidos alumno");

		txtnomalumno = new JTextField();
		txtnomalumno.setColumns(10);

		JLabel lblCorreoAlumno = new JLabel("Correo alumno");

		txtcorreo = new JTextField();
		txtcorreo.setColumns(10);

		btnAnadiralumno = new JButton("A\u00F1adir");
		btnAnadiralumno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object[] fila = { txtexpalumno.getText(), txtnomalumno.getText(), txtcorreo.getText() };
				dtmalumnos.addRow(fila);
				setalumno(txtexpalumno.getText(), txtnomalumno.getText(), txtcorreo.getText());
				txtexpalumno.setText("");
				txtnomalumno.setText("");
				txtcorreo.setText("");
				JOptionPane.showMessageDialog(null, "Añadido!!", "", JOptionPane.INFORMATION_MESSAGE);

			}
		});

		btnModificaralumn = new JButton("Modificar");
		btnModificaralumn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tablalumnos.setValueAt(txtexpalumno.getText(), tablalumnos.getSelectedRow(), 0);
				tablalumnos.setValueAt(txtnomalumno.getText(), tablalumnos.getSelectedRow(), 1);
				tablalumnos.setValueAt(txtcorreo.getText(), tablalumnos.getSelectedRow(), 2);
				txtexpalumno.setText("");
				txtnomalumno.setText("");
				txtcorreo.setText("");
				JOptionPane.showMessageDialog(null, "Modificado!!", "", JOptionPane.INFORMATION_MESSAGE);

			}
		});

		JButton btnBorraralumn = new JButton("Borrar");
		btnBorraralumn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dtmalumnos.removeRow(tablalumnos.getSelectedRow());
				txtexpalumno.setText("");
				txtnomalumno.setText("");
				txtcorreo.setText("");
				JOptionPane.showMessageDialog(null, "Borrado!!", "", JOptionPane.INFORMATION_MESSAGE);

			}
		});
		GroupLayout gl_panelalumnos = new GroupLayout(panelalumnos);
		gl_panelalumnos
				.setHorizontalGroup(gl_panelalumnos.createParallelGroup(Alignment.LEADING).addGroup(
						gl_panelalumnos
								.createSequentialGroup()
								.addGroup(gl_panelalumnos.createParallelGroup(Alignment.LEADING).addGroup(
										gl_panelalumnos.createSequentialGroup().addContainerGap().addGroup(
												gl_panelalumnos
														.createParallelGroup(
																Alignment.LEADING)
														.addComponent(scrollPane_2, GroupLayout.DEFAULT_SIZE, 805,
																Short.MAX_VALUE)
														.addGroup(
																gl_panelalumnos.createSequentialGroup()
																		.addGroup(gl_panelalumnos
																				.createParallelGroup(Alignment.LEADING)
																				.addComponent(
																						lblIntroduzcaNumeroExpediente)
																				.addComponent(txtexpalumno,
																						GroupLayout.PREFERRED_SIZE, 138,
																						GroupLayout.PREFERRED_SIZE))
																		.addGap(74)
																		.addGroup(gl_panelalumnos
																				.createParallelGroup(Alignment.LEADING)
																				.addComponent(txtnomalumno,
																						GroupLayout.PREFERRED_SIZE, 206,
																						GroupLayout.PREFERRED_SIZE)
																				.addComponent(lblIntroduzcaNombreY))
																		.addPreferredGap(
																				ComponentPlacement.RELATED, 129,
																				Short.MAX_VALUE)
																		.addGroup(gl_panelalumnos
																				.createParallelGroup(Alignment.LEADING)
																				.addComponent(txtcorreo,
																						GroupLayout.PREFERRED_SIZE, 187,
																						GroupLayout.PREFERRED_SIZE)
																				.addComponent(lblCorreoAlumno))
																		.addGap(49))))
										.addGroup(gl_panelalumnos.createSequentialGroup().addGap(222)
												.addComponent(btnAnadiralumno).addGap(18)
												.addComponent(btnModificaralumn).addGap(18)
												.addComponent(btnBorraralumn)))
								.addContainerGap()));
		gl_panelalumnos
				.setVerticalGroup(
						gl_panelalumnos.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panelalumnos.createSequentialGroup().addContainerGap()
										.addComponent(scrollPane_2, GroupLayout.PREFERRED_SIZE, 238,
												GroupLayout.PREFERRED_SIZE)
										.addGap(18)
										.addGroup(gl_panelalumnos.createParallelGroup(Alignment.BASELINE)
												.addComponent(lblIntroduzcaNumeroExpediente)
												.addComponent(lblCorreoAlumno).addComponent(lblIntroduzcaNombreY))
										.addGap(18)
										.addGroup(gl_panelalumnos.createParallelGroup(Alignment.BASELINE)
												.addComponent(txtexpalumno, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(txtcorreo, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(txtnomalumno, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
										.addGroup(gl_panelalumnos.createParallelGroup(Alignment.BASELINE)
												.addComponent(btnAnadiralumno).addComponent(btnModificaralumn)
												.addComponent(btnBorraralumn))
										.addContainerGap()));

		tablalumnos = new JTable();
		tablalumnos.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent arg0) {
				txtexpalumno.setText((String) dtmalumnos.getValueAt(tablalumnos.getSelectedRow(), 0));
				txtnomalumno.setText((String) dtmalumnos.getValueAt(tablalumnos.getSelectedRow(), 1));
				txtcorreo.setText((String) dtmalumnos.getValueAt(tablalumnos.getSelectedRow(), 2));

			}
		});
		dtmalumnos = new DefaultTableModel(new Object[][] {},
				new String[] { "N\u00BA Expediente", "Nombre y apellidos alumno", "Correo_alumno" });
		tablalumnos.setModel(dtmalumnos);
		tablalumnos.getColumnModel().getColumn(1).setPreferredWidth(152);
		tablalumnos.getColumnModel().getColumn(2).setPreferredWidth(130);
		scrollPane_2.setViewportView(tablalumnos);
		panelalumnos.setLayout(gl_panelalumnos);

		JPanel panelnotamodulo = new JPanel();
		tabbedPane.addTab("Nota m\u00F3dulos", null, panelnotamodulo, null);

		JScrollPane scrollPane_3 = new JScrollPane();

		JLabel lblIntroduzcaCurso_1 = new JLabel("Introduzca curso");

		JLabel lblIntroduzcaNombreMdulo = new JLabel("Introduzca nombre m\u00F3dulo");

		JComboBox comboBoxcurso = new JComboBox();
		comboBoxcurso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object combomod = comboBoxcurso.getSelectedItem();
				String res = String.valueOf(combomod);
				txtcursomod.setText(res);
			}
		});
		comboBoxcurso.setModel(new DefaultComboBoxModel(new String[] { "1\u00BA DAM", "2\u00BA DAM" }));

		JComboBox combonommodd = new JComboBox();
		combonommodd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object combomod = combonommodd.getSelectedItem();
				String res = String.valueOf(combomod);
				txtnommodulo.setText(res);
			}
		});
		combonommodd.setModel(new DefaultComboBoxModel(new String[] { "Bases de datos", "Sistemas Inform\u00E1ticos",
				"Programaci\u00F3n", "Lenguaje de marcas", "Entornos de desarrollo", "Acceso a datos",
				"Desarrollo de interfaces", "Empresa e iniciativa emprendedora",
				"Programaci\u00F3n de servicios y procesos", "Programaci\u00F3n multimedia y dispositivos m\u00F3viles",
				"Sistemas de gesti\u00F3n empresarial", "Formaci\u00F3n en Centros de Trabajo" }));

		JLabel lblNewLabel = new JLabel("N\u00BA Expediente/alumn");

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
		btnAnadirnotmod.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object[] fila = { txtcursomod.getText(), txtnommodulo.getText(), txtexp.getText(),
						txtnotamod.getText() };
				dtmnotamod.addRow(fila);
				setnotamod(txtcursomod.getText(), txtnommodulo.getText(), txtexp.getText(), txtnotamod.getText());
				txtcursomod.setText("");
				txtnommodulo.setText("");
				txtexp.setText("");
				txtnotamod.setText("");
				JOptionPane.showMessageDialog(null, "Añadido!!", "", JOptionPane.INFORMATION_MESSAGE);

			}
		});

		btnModificarnotmod = new JButton("Modificar");
		btnModificarnotmod.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tablanotamodulo.setValueAt(txtcursomod.getText(), tablanotamodulo.getSelectedRow(), 0);
				tablanotamodulo.setValueAt(txtnommodulo.getText(), tablanotamodulo.getSelectedRow(), 1);
				tablanotamodulo.setValueAt(txtexp.getText(), tablanotamodulo.getSelectedRow(), 2);
				tablanotamodulo.setValueAt(txtnotamod.getText(), tablanotamodulo.getSelectedRow(), 3);
				txtcursomod.setText("");
				txtnommodulo.setText("");
				txtexp.setText("");
				txtnotamod.setText("");
				JOptionPane.showMessageDialog(null, "Modificado!!", "", JOptionPane.INFORMATION_MESSAGE);

			}
		});

		JButton btnBorrarnotmod = new JButton("Borrar");
		btnBorrarnotmod.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dtmnotamod.removeRow(tablanotamodulo.getSelectedRow());
				txtcursomod.setText("");
				txtnommodulo.setText("");
				txtexp.setText("");
				txtnotamod.setText("");
				JOptionPane.showMessageDialog(null, "Borrado!!", "", JOptionPane.INFORMATION_MESSAGE);

			}
		});
		GroupLayout gl_panelnotamodulo = new GroupLayout(panelnotamodulo);
		gl_panelnotamodulo
				.setHorizontalGroup(
						gl_panelnotamodulo.createParallelGroup(Alignment.LEADING).addGroup(gl_panelnotamodulo
								.createSequentialGroup().addGroup(gl_panelnotamodulo
										.createParallelGroup(
												Alignment.LEADING)
										.addGroup(
												gl_panelnotamodulo.createSequentialGroup().addContainerGap()
														.addGroup(gl_panelnotamodulo
																.createParallelGroup(Alignment.LEADING)
																.addComponent(scrollPane_3, GroupLayout.DEFAULT_SIZE,
																		805, Short.MAX_VALUE)
																.addGroup(gl_panelnotamodulo.createSequentialGroup()
																		.addGroup(gl_panelnotamodulo
																				.createParallelGroup(Alignment.LEADING)
																				.addComponent(lblIntroduzcaCurso_1)
																				.addComponent(comboBoxcurso,
																						GroupLayout.PREFERRED_SIZE,
																						GroupLayout.DEFAULT_SIZE,
																						GroupLayout.PREFERRED_SIZE)
																				.addComponent(txtcursomod,
																						GroupLayout.PREFERRED_SIZE,
																						GroupLayout.DEFAULT_SIZE,
																						GroupLayout.PREFERRED_SIZE))
																		.addGap(130)
																		.addGroup(gl_panelnotamodulo
																				.createParallelGroup(Alignment.LEADING,
																						false)
																				.addComponent(txtnommodulo)
																				.addComponent(lblIntroduzcaNombreMdulo)
																				.addComponent(combonommodd, 0, 149,
																						Short.MAX_VALUE))
																		.addGap(70)
																		.addGroup(gl_panelnotamodulo
																				.createParallelGroup(Alignment.LEADING,
																						false)
																				.addComponent(txtexp)
																				.addComponent(lblNewLabel,
																						GroupLayout.DEFAULT_SIZE,
																						GroupLayout.DEFAULT_SIZE,
																						Short.MAX_VALUE))
																		.addGap(92)
																		.addGroup(gl_panelnotamodulo
																				.createParallelGroup(Alignment.LEADING)
																				.addComponent(txtnotamod,
																						GroupLayout.PREFERRED_SIZE,
																						GroupLayout.DEFAULT_SIZE,
																						GroupLayout.PREFERRED_SIZE)
																				.addComponent(lblNotaModulo)))))
										.addGroup(gl_panelnotamodulo.createSequentialGroup().addGap(235)
												.addComponent(btnAnadirnotmod).addGap(18)
												.addComponent(btnModificarnotmod).addGap(18)
												.addComponent(btnBorrarnotmod)))
								.addContainerGap()));
		gl_panelnotamodulo.setVerticalGroup(gl_panelnotamodulo.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelnotamodulo.createSequentialGroup().addContainerGap()
						.addComponent(scrollPane_3, GroupLayout.PREFERRED_SIZE, 238, GroupLayout.PREFERRED_SIZE)
						.addGap(18)
						.addGroup(gl_panelnotamodulo.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblIntroduzcaCurso_1).addComponent(lblIntroduzcaNombreMdulo)
								.addComponent(lblNewLabel).addComponent(lblNotaModulo))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(gl_panelnotamodulo.createParallelGroup(Alignment.BASELINE)
								.addComponent(comboBoxcurso, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(combonommodd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(txtexp, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(txtnotamod, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_panelnotamodulo.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtcursomod, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(txtnommodulo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
						.addGroup(
								gl_panelnotamodulo.createParallelGroup(Alignment.BASELINE).addComponent(btnAnadirnotmod)
										.addComponent(btnModificarnotmod).addComponent(btnBorrarnotmod))
						.addContainerGap()));

		tablanotamodulo = new JTable();
		tablanotamodulo.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent arg0) {
				txtcursomod.setText((String) dtmnotamod.getValueAt(tablanotamodulo.getSelectedRow(), 0));
				txtnommodulo.setText((String) dtmnotamod.getValueAt(tablanotamodulo.getSelectedRow(), 1));
				txtexp.setText((String) dtmnotamod.getValueAt(tablanotamodulo.getSelectedRow(), 2));
				txtnotamod.setText((String) dtmnotamod.getValueAt(tablanotamodulo.getSelectedRow(), 3));
			}
		});
		dtmnotamod = new DefaultTableModel(new Object[][] {},
				new String[] { "Curso", "Nombre m\u00F3dulo", "n\u00BA expediente/alumno", "Nota" });
		tablanotamodulo.setModel(dtmnotamod);

		scrollPane_3.setViewportView(tablanotamodulo);
		panelnotamodulo.setLayout(gl_panelnotamodulo);

		JPanel panelnotatotal = new JPanel();
		tabbedPane.addTab("Nota total", null, panelnotatotal, null);

		JScrollPane scrollPane_4 = new JScrollPane();

		JLabel lblIntroduzcaCurso_2 = new JLabel("Introduzca curso");

		JComboBox combocursototal = new JComboBox();
		combocursototal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object combomod = combocursototal.getSelectedItem();
				String res = String.valueOf(combomod);
				txtnotatotalcurso.setText(res);

			}
		});
		combocursototal.setModel(new DefaultComboBoxModel(new String[] { "1\u00BA DAM", "2\u00BA DAM" }));

		txtnotatotalcurso = new JTextField();
		txtnotatotalcurso.setColumns(10);

		JLabel lblNExpedientealumno = new JLabel("N\u00BA Expediente/alumno");

		txtexpnotatotal = new JTextField();
		txtexpnotatotal.setColumns(10);

		txtnotatotal = new JTextField();
		txtnotatotal.setColumns(10);

		JLabel lblIntroduzcaNotaTotal = new JLabel("Introduzca nota media");

		btnanadirnotatotal = new JButton("A\u00F1adir");
		btnanadirnotatotal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object[] fila = { txtnotatotalcurso.getText(), txtexpnotatotal.getText(), txtnotatotal.getText() };
				dtmnotatotal.addRow(fila);
				setnotatotal(txtnotatotalcurso.getText(), txtexpnotatotal.getText(), txtnotatotal.getText());
				txtnotatotalcurso.setText("");
				txtexpnotatotal.setText("");
				txtnotatotal.setText("");
				JOptionPane.showMessageDialog(null, "Añadido!!", "", JOptionPane.INFORMATION_MESSAGE);

			}
		});

		btnModificarnotatotal = new JButton("Modificar");
		btnModificarnotatotal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tablanotatotal.setValueAt(txtnotatotalcurso.getText(), tablanotatotal.getSelectedRow(), 0);
				tablanotatotal.setValueAt(txtexpnotatotal.getText(), tablanotatotal.getSelectedRow(), 1);
				tablanotatotal.setValueAt(txtnotatotal.getText(), tablanotatotal.getSelectedRow(), 2);
				txtnotatotalcurso.setText("");
				txtexpnotatotal.setText("");
				txtnotatotal.setText("");
				JOptionPane.showMessageDialog(null, "Modificado!!", "", JOptionPane.INFORMATION_MESSAGE);

			}
		});

		btnBorrarnotatotal = new JButton("Borrar");
		btnBorrarnotatotal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dtmnotatotal.removeRow(tablanotatotal.getSelectedRow());
				txtcurso.setText("");
				txtnotatotalcurso.setText("");
				txtexpnotatotal.setText("");
				txtnotatotal.setText("");
				JOptionPane.showMessageDialog(null, "Borrado!!", "", JOptionPane.INFORMATION_MESSAGE);

			}
		});
		GroupLayout gl_panelnotatotal = new GroupLayout(panelnotatotal);
		gl_panelnotatotal.setHorizontalGroup(gl_panelnotatotal.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelnotatotal.createSequentialGroup().addContainerGap()
						.addGroup(gl_panelnotatotal.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panelnotatotal.createSequentialGroup()
										.addGroup(gl_panelnotatotal.createParallelGroup(Alignment.LEADING)
												.addComponent(scrollPane_4, GroupLayout.DEFAULT_SIZE, 805,
														Short.MAX_VALUE)
												.addComponent(combocursototal, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addContainerGap())
								.addGroup(gl_panelnotatotal.createSequentialGroup()
										.addGroup(gl_panelnotatotal.createParallelGroup(Alignment.LEADING)
												.addComponent(lblIntroduzcaCurso_2).addComponent(txtnotatotalcurso,
														GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
														GroupLayout.PREFERRED_SIZE))
										.addGap(199)
										.addGroup(gl_panelnotatotal.createParallelGroup(Alignment.LEADING)
												.addComponent(txtexpnotatotal, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(lblNExpedientealumno))
										.addPreferredGap(ComponentPlacement.RELATED, 167, Short.MAX_VALUE)
										.addGroup(gl_panelnotatotal.createParallelGroup(Alignment.LEADING, false)
												.addComponent(txtnotatotal, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(lblIntroduzcaNotaTotal))
										.addContainerGap(170, Short.MAX_VALUE))))
				.addGroup(gl_panelnotatotal.createSequentialGroup().addGap(275).addComponent(btnanadirnotatotal)
						.addGap(18).addComponent(btnModificarnotatotal).addGap(18).addComponent(btnBorrarnotatotal)
						.addContainerGap(287, Short.MAX_VALUE)));
		gl_panelnotatotal
				.setVerticalGroup(
						gl_panelnotatotal.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panelnotatotal.createSequentialGroup().addContainerGap()
										.addComponent(scrollPane_4, GroupLayout.PREFERRED_SIZE, 238,
												GroupLayout.PREFERRED_SIZE)
										.addGap(18)
										.addGroup(gl_panelnotatotal.createParallelGroup(Alignment.BASELINE)
												.addComponent(lblIntroduzcaCurso_2).addComponent(lblNExpedientealumno)
												.addComponent(lblIntroduzcaNotaTotal))
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(combocursototal, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addGroup(gl_panelnotatotal.createParallelGroup(Alignment.BASELINE)
												.addComponent(txtnotatotalcurso, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(txtexpnotatotal, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(txtnotatotal, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
										.addGroup(gl_panelnotatotal.createParallelGroup(Alignment.BASELINE)
												.addComponent(btnanadirnotatotal).addComponent(btnModificarnotatotal)
												.addComponent(btnBorrarnotatotal))
										.addContainerGap()));

		tablanotatotal = new JTable();
		tablanotatotal.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent arg0) {
				txtnotatotalcurso.setText((String) dtmnotatotal.getValueAt(tablanotatotal.getSelectedRow(), 0));
				txtexpnotatotal.setText((String) dtmnotatotal.getValueAt(tablanotatotal.getSelectedRow(), 1));
				txtnotatotal.setText((String) dtmnotatotal.getValueAt(tablanotatotal.getSelectedRow(), 2));

			}
		});
		dtmnotatotal = new DefaultTableModel(new Object[][] {},
				new String[] { "Curso", "N\u00BAExpediente/alumno", "Nota media" });
		tablanotatotal.setModel(dtmnotatotal);

		scrollPane_4.setViewportView(tablanotatotal);
		panelnotatotal.setLayout(gl_panelnotatotal);
		contentPane.setLayout(gl_contentPane);
	}

	public void rellenarTablaprofes() {
		String[][] tabla = mod.getprofesor();
		DefaultTableModel modelo = (DefaultTableModel) tablaprofesor.getModel();
		for (int i = 0; i < tabla.length; i++) {
			modelo.addRow(tabla[i]);

		}
	}

	public void rellenarTablamodulos() {
		String[][] tabla = mod.getmodulos();
		DefaultTableModel modelo = (DefaultTableModel) tablamodulos.getModel();
		for (int i = 0; i < tabla.length; i++) {
			modelo.addRow(tabla[i]);

		}
	}

	public void rellenarTablaalumnos() {
		String[][] tabla = mod.getalumnos();
		DefaultTableModel modelo = (DefaultTableModel) tablalumnos.getModel();
		for (int i = 0; i < tabla.length; i++) {
			modelo.addRow(tabla[i]);

		}
	}

	public void rellenarTablanotamodulos() {
		String[][] tabla = mod.getnotaalumnos();
		DefaultTableModel modelo = (DefaultTableModel) tablanotamodulo.getModel();
		for (int i = 0; i < tabla.length; i++) {
			modelo.addRow(tabla[i]);

		}
		
	}
}