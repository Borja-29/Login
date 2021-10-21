package dad.login;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Vista extends Application {
		
	private TextField usrTxt;
	private PasswordField pswrTxt;
	
	private CheckBox ldap;
	
	private Button cancelar;
	private Button acceder;
 	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		usrTxt = new TextField();
		usrTxt.setPromptText("Nombre de usuario");
		
		pswrTxt = new PasswordField();
		pswrTxt.setPromptText("Contraseña de usuario");
		
		ldap = new CheckBox("Usar LDAP");
		
		acceder = new Button("Acceder");
		acceder.setOnAction(e -> onComprobarAction(e));
		
		cancelar = new Button("Cancelar");
		
		GridPane root = new GridPane();
		root.setAlignment(Pos.CENTER);
		root.setPadding(new Insets (5));
		root.setHgap(5);
		root.setVgap(5);
		root.addRow(0, new Label("Usuario:"), usrTxt);
		root.addRow(1, new Label("Contraseña:"), pswrTxt);
		root.add(ldap, 1, 2);
		root.addRow(3, acceder, cancelar);
		
		Scene scene = new Scene(root, 320, 200);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Login.fxml");
		primaryStage.show();
	
	}
	private Object onComprobarAction(ActionEvent e) {

		return null;
	}
	public static void main(String[] args) {
		launch(args);
	}

}