package dad.login;

import dad.login.VistaModeloControlador.Controlador;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

	private Controlador controlador;

	@Override
	public void start(Stage primaryStage) throws Exception {

		controlador = new Controlador();

		Scene loginScene = new Scene(controlador.getView(), 320, 200);

		Stage modificarStage = new Stage();
		modificarStage.setTitle("Modificar");
		modificarStage.setScene(loginScene);
		modificarStage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}

}