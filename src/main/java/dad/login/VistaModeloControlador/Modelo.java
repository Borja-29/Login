package dad.login.VistaModeloControlador;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Modelo {

	private StringProperty usuario = new SimpleStringProperty();
	private StringProperty contraseña = new SimpleStringProperty();
	private BooleanProperty checkboxLdap = new SimpleBooleanProperty();


	public StringProperty usuarioProperty() {
		return this.usuario;
	}

	public String getUsuario() {
		return this.usuarioProperty().get();
	}

	public void setUsuario(final String usuario) {
		this.usuarioProperty().set(usuario);
	}

	public StringProperty contraseñaProperty() {
		return this.contraseña;
	}

	public String getContraseña() {
		return this.contraseñaProperty().get();
	}

	public void setContraseña(final String contraseña) {
		this.contraseñaProperty().set(contraseña);
	}

	public BooleanProperty checkboxLdapProperty() {
		return this.checkboxLdap;
	}
	

	public boolean isCheckboxLdap() {
		return this.checkboxLdapProperty().get();
	}
	

	public void setCheckboxLdap(final boolean checkboxLdap) {
		this.checkboxLdapProperty().set(checkboxLdap);
	}
	
}