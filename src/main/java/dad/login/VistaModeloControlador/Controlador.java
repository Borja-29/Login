package dad.login.VistaModeloControlador;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.apache.commons.codec.digest.DigestUtils;

import dad.login.auth.AuthService;
import dad.login.auth.FileAuthService;
import dad.login.auth.LdapAuthService;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class Controlador {

	private Vista vista = new Vista();
	private Modelo modelo = new Modelo();
	private BufferedReader br = null;

	public Controlador() {

		vista.getUsuario().textProperty().bindBidirectional(modelo.usuarioProperty());
		vista.getContraseña().textProperty().bindBidirectional(modelo.contraseñaProperty());
		vista.getLdap().selectedProperty().bindBidirectional(modelo.checkboxLdapProperty());
		vista.getAcceder().setOnAction(e -> onAccederAction(e));
		vista.getCancelar().setOnAction(e -> onCancelarAction(e));

	}

	private void onAccederAction(ActionEvent e) {

		AuthService auth = modelo.isCheckboxLdap() ? new LdapAuthService() : new FileAuthService();

		try {
			if (auth.login(modelo.getUsuario(), modelo.getContraseña()) == true) {
				Alert correctoAlert = new Alert(AlertType.INFORMATION);
				correctoAlert.setTitle("Iniciar sesión");
				correctoAlert.setHeaderText("Acceso permitido");
				correctoAlert.setContentText("Las credenciales de acceso son válidas.");
				correctoAlert.showAndWait();
			} else {
				Alert errorAlert = new Alert(AlertType.ERROR);
				errorAlert.setTitle("Iniciar sesión");
				errorAlert.setHeaderText("Acceso denegado");
				errorAlert.setContentText("El usuario y/o la contraseña no son válidos.");
				errorAlert.showAndWait();
				vista.getUsuario().clear();
				vista.getContraseña().clear();
			}

			} catch (Exception e1) {
				e1.printStackTrace();
			}

	}

	private void onCancelarAction(ActionEvent e) {
		System.exit(0);
	}
	
	public Vista getView() {
		return vista;
	}

	public Modelo getModel() {
		return modelo;
	}

}