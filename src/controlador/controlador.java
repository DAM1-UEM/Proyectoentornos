package controlador;

import modelo.modelo;
import vista.config;
import vista.login;
import vista.notas;
import vista.registro;

public class controlador {
	private modelo modelo;
	private login login;
	private notas notas;
	private registro si;
	private config con;

	public void setlogin(login login) {
		this.login = login;
	}

	public void setconfig(config con) {
		this.con = con;
	}

	public void setregistro(registro si) {
		this.si = si;
	}

	public void setmodelo(modelo modelo) {
		this.modelo = modelo;
	}

	public void setnotas(notas nota) {
		this.notas = nota;
	}

	public void cargarprofesores() {
		modelo.consultaProfesores();
	}

	public void cargarmodulos() {
		modelo.consultamodulos();
	}

	public void modificarBBDD() {
		String usu = con.getUsu();
		String contra = con.getContra();
		String url = con.getURL();
		modelo.modificarBBDD(usu, contra, url);
	}

	public void mostrarventanalogin() {
		login.setVisible(true);
	}

	public void mostrarventanaregistro() {
		si.setVisible(true);
	}

	public void mostrarventananotas() {
		notas.setVisible(true);
	}

	public void mostrarventanaconfig() {
		modelo.mostrarUsuContra();
		con.setVisible(true);
	}

	public void solicitarDatosSignin() {
		String Nombre = si.getNombre();
		String Apellidos = si.getApellidos();
		String Email = si.getEmail();
		String Nick = si.getNick();
		String Pass = si.getPass();
		modelo.setDatos(Nombre, Apellidos, Email, Nick, Pass);
	}

	public void solicitarusuarioypass() {
		String usuario = login.getNick();
		String contraseña = login.getPass();
		modelo.comprobarUsuarioyContraseña(usuario, contraseña);
	}

}
