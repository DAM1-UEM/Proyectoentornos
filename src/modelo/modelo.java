package modelo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import javax.swing.JOptionPane;
import vista.config;
import vista.login;
import vista.notas;
import vista.registro;

public class modelo {
	private notas nota;
	private registro sg;
	private String Nombre;
	private String Apellidos;
	private String Nick;
	private String Email;
	private String Pass;
	private Connection conexion;
	private int resultado;
	private String comprobarnick;
	private String comprobarpass;
	private login log;
	private int contadorFallos;
	private String usuarioBBDD;
	private String contraseñaBBDD;
	private String url;
	private InputStream entrada = null;
	private OutputStream salida = null;
	private Properties propiedades;
	private config con;
	private int usuariocodigo;

	public void setLogin(login login) {
		this.log = login;
	}

	public void setRegistro(registro registro) {
		this.sg = registro;
	}

	public void setmanten(notas nota) {
		this.nota = nota;
	}

	public void setconfig(config con) {
		this.con = con;
	}

	public void conectarse() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String mi_url = geturlBBDD();

			conexion = DriverManager.getConnection(mi_url, getUsuarioBBDD(), getContraseñaBBDD());
			JOptionPane.showMessageDialog(null, "Exito en la conexión con la BBDD", "",
					JOptionPane.INFORMATION_MESSAGE);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error en la conexión con la BBDD", "",
					JOptionPane.ERROR_MESSAGE);
		} catch (ClassNotFoundException e) {
			System.out.println("error en la conexión");
		}

	}

	public String geturlBBDD() {
		File file = new File("conexion.ini");
		try {
			entrada = new FileInputStream(file);
			propiedades = new Properties();
			propiedades.load(entrada);
			this.url = propiedades.getProperty("url");

		} catch (FileNotFoundException e) {
			System.out.println("error en ficheros FileInputStream");
		} catch (IOException e) {
			System.out.println("error en Propertuies fichero");
		}
		return this.url;
	}

	public String getContraseñaBBDD() {
		File file = new File("conexion.ini");
		try {
			entrada = new FileInputStream(file);
			propiedades = new Properties();
			propiedades.load(entrada);
			this.contraseñaBBDD = propiedades.getProperty("contraseña");

		} catch (FileNotFoundException e) {
			System.out.println("error en ficheros FileInputStream");
		} catch (IOException e) {
			System.out.println("error en Propertuies fichero");
		}
		return this.contraseñaBBDD;
	}

	public String getUsuarioBBDD() {
		File file = new File("conexion.ini");
		try {
			entrada = new FileInputStream(file);
			propiedades = new Properties();
			propiedades.load(entrada);
			this.usuarioBBDD = propiedades.getProperty("usuario");

		} catch (FileNotFoundException e) {
			System.out.println("error en ficheros FileInputStream");
		} catch (IOException e) {
			System.out.println("error en Propertuies fichero");
		}
		return this.usuarioBBDD;
	}

	public void modificarBBDD(String usu, String contra, String url) {
		File archivo = new File("conexion.ini");
		try {
			salida = new FileOutputStream(archivo);
			propiedades = new Properties();
			propiedades.setProperty("usuario", usu);
			propiedades.setProperty("contraseña", contra);
			propiedades.setProperty("url", url);
			try {
				propiedades.store(salida, "Comentario para el fichero");
			} catch (IOException e) {
				e.printStackTrace();
			}
			JOptionPane.showMessageDialog(null, "Se han modificado los datos", "", JOptionPane.INFORMATION_MESSAGE);
		} catch (FileNotFoundException e) {
			System.out.println("error en la escritura");
		}
	}

	public void mostrarUsuContra() {
		con.setUsuContra();
	}

	public void Select(String dato) {
		try {
			Statement stmt = conexion.createStatement();
			ResultSet rset = stmt.executeQuery(dato);
			while (rset.next()) {
				comprobarnick = rset.getString("NICK");
				comprobarpass = rset.getString("PASSWORD");
			}

		} catch (SQLException e) {
			System.out.println("Error Select");

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error en la conexión con la base de datos", "",
					JOptionPane.INFORMATION_MESSAGE);

		}
	}

	public void comprobarUsuarioyContraseña(String usuario, String contrasena) {
		conectarse();
		this.Nombre = usuario;
		this.Pass = contrasena;
		Select("select * from entornos.admin where nick='" + usuario + "' and password='" + contrasena + "'");

		try {
			if (comprobarnick.equals(usuario) && comprobarpass.equals(contrasena)) {
				JOptionPane.showMessageDialog(null, "Usuario y contraseña correctos", "",
						JOptionPane.INFORMATION_MESSAGE);
				nota.setVisible(true);
				log.setVisible(false);
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Usuario y contraseña no validos", "Error", JOptionPane.ERROR_MESSAGE);
			contadorFallos = contadorFallos + 1;
		}
		if (contadorFallos == 3) {
			System.exit(0);
		}

	}

	public void InsertRegistro(String dato) {
		resultado = 0;
		try {
			Statement stmt = conexion.createStatement();
			resultado = stmt.executeUpdate(dato);
		} catch (Exception e) {
			System.out.println("Error en InsertRegistro");
		}
	}

	public void setDatos(String Nombre, String Apellidos, String Email, String Nick, String Pass) {
		InsertRegistro("INSERT INTO entornos.admin (NICK, PASSWORD, EMAIL, NOMBRE, APELLIDOS) VALUES ( '" + Nick + "','"
				+ Pass + "','" + Email + "','" + Nombre + "','" + Apellidos + "')");
		if (resultado == 1) {
			JOptionPane.showMessageDialog(null, "Registrado!!", "", JOptionPane.INFORMATION_MESSAGE);
			nota.setVisible(true);
		} else {
			JOptionPane.showMessageDialog(null, "Este nick ya ha sido registrado, por favor introduzca de nuevo", "",
					JOptionPane.ERROR_MESSAGE);

		}

	}

}
