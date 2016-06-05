package test;

import controlador.controlador;
import modelo.modelo;
import vista.login;
import vista.config;
import vista.notas;
import vista.registro;

public class test {
	public static void main(String[] args) {
		controlador controlador = new controlador();
		modelo modelo = new modelo();
		login ventanalogin = new login();
		registro ventanaregistro = new registro();
		notas ventananotas = new notas();
		config ventanaconfig = new config();
		// modelo conoce a vistas...
		modelo.setLogin(ventanalogin);
		modelo.setRegistro(ventanaregistro);
		modelo.setmanten(ventananotas);
		modelo.setconfig(ventanaconfig);
		// vistas conoce a controlador y modelo
		ventanalogin.setControlador(controlador);
		ventanalogin.setModelo(modelo);
		ventanaregistro.setControlador(controlador);
		ventanaregistro.setModelo(modelo);
		ventananotas.setcontrolador(controlador);
		ventananotas.setmodelo(modelo);
		ventanaconfig.setmodelo(modelo);
		ventanaconfig.setcontrolador(controlador);
		// controlador conoce a modelo y a vista
		controlador.setmodelo(modelo);
		controlador.setlogin(ventanalogin);
		controlador.setregistro(ventanaregistro);
		controlador.setnotas(ventananotas);
		controlador.setconfig(ventanaconfig);
		ventanalogin.setVisible(true);

	}
}