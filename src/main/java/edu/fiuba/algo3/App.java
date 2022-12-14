package edu.fiuba.algo3;

import edu.fiuba.algo3.controlador.BotonCrearJugadorEventHandler;
import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.vistas.ContenedorCreacionDeJugadores;
import edu.fiuba.algo3.vistas.ContenedorPrincipal;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        stage.setTitle("AlgoStar");
        Juego juego = new Juego();

        ContenedorPrincipal contenedorPrincipal = new ContenedorPrincipal(stage, juego);
        Scene escenaPrincipal = new Scene(contenedorPrincipal, 800, 600);
        ContenedorCreacionDeJugadores contenedorCreacionDeJugadores = new ContenedorCreacionDeJugadores(stage, escenaPrincipal, juego, contenedorPrincipal);

        Scene scene = new Scene(contenedorCreacionDeJugadores, 720, 480);

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}