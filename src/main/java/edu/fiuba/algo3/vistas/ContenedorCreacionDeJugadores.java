package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.controlador.BotonCrearJugadorEventHandler;
import edu.fiuba.algo3.modelo.Juego;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ContenedorCreacionDeJugadores extends VBox {

    private Stage stage;
    private Scene proximaEscena;
    private final Juego juego;

    public ContenedorCreacionDeJugadores(Stage stage, Scene proximaEscena, Juego juego, ContenedorPrincipal contenedorPrincipal) {
        super();
        this.stage = stage;
        this.proximaEscena = proximaEscena;
        this.juego = juego;

        Label titulo = new Label("Jugador 1");
        titulo.styleProperty().set("-fx-font-size: 20px; -fx-font-weight: bold;");

        Label error = new Label();

        Label nombreLabel = new Label("Nombre:");
        TextField nombre = new TextField();
        nombre.setPromptText("Ingrese su nombre");

        Label colorLabel = new Label("Color:");
        Button rojo = new Button("⠀");
        rojo.styleProperty().set("-fx-background-color: #DA4728;");
        Button azul = new Button("⠀");
        azul.styleProperty().set("-fx-background-color: #3F58D2;");
        Button amarillo = new Button("⠀");
        amarillo.styleProperty().set("-fx-background-color: #F1C532;");
        Button verde = new Button("⠀");
        verde.styleProperty().set("-fx-background-color: #65D54F;");

        Label razas = new Label("Escoja su raza");
        Button protoss = new Button("Protoss");
        Button zerg = new Button("Zerg");

        rojo.setOnAction(e -> {
            rojo.styleProperty().set("-fx-background-color: #DA4728; -fx-border-color: #5DADE2; -fx-border-width: 2px; -fx-border-radius: 5px;");
            azul.styleProperty().set("-fx-background-color: #3F58D2;");
            amarillo.styleProperty().set("-fx-background-color: #F1C532;");
            verde.styleProperty().set("-fx-background-color: #65D54F;");
        });
        azul.setOnAction(e -> {
            azul.styleProperty().set("-fx-background-color: #3F58D2; -fx-border-color: #5DADE2; -fx-border-width: 2px; -fx-border-radius: 5px;");
            rojo.styleProperty().set("-fx-background-color: #DA4728;");
            amarillo.styleProperty().set("-fx-background-color: #F1C532;");
            verde.styleProperty().set("-fx-background-color: #65D54F;");
        });
        amarillo.setOnAction(e -> {
            amarillo.styleProperty().set("-fx-background-color: #F1C532; -fx-border-color: #5DADE2; -fx-border-width: 2px; -fx-border-radius: 5px;");
            rojo.styleProperty().set("-fx-background-color: #DA4728;");
            azul.styleProperty().set("-fx-background-color: #3F58D2;");
            verde.styleProperty().set("-fx-background-color: #65D54F;");
        });
        verde.setOnAction(e -> {
            verde.styleProperty().set("-fx-background-color: #65D54F; -fx-border-color: #5DADE2; -fx-border-width: 2px; -fx-border-radius: 5px;");
            rojo.styleProperty().set("-fx-background-color: #DA4728;");
            azul.styleProperty().set("-fx-background-color: #3F58D2;");
            amarillo.styleProperty().set("-fx-background-color: #F1C532;");
        });

        protoss.setOnAction(e -> {
            protoss.styleProperty().set("-fx-border-color: #5DADE2; -fx-border-width: 2px; -fx-border-radius: 5px;");
            zerg.styleProperty().set("");
        });
        zerg.setOnAction(e -> {
            zerg.styleProperty().set("-fx-border-color: #5DADE2; -fx-border-width: 2px; -fx-border-radius: 5px;");
            protoss.styleProperty().set("");
        });

        Button siguiente = new Button("Siguiente");
        siguiente.setOnAction(new BotonCrearJugadorEventHandler(error, titulo, nombre, rojo, azul, amarillo, verde, protoss, zerg, juego, stage, proximaEscena, contenedorPrincipal));

        HBox botonesRaza = new HBox(protoss, zerg);
        botonesRaza.setSpacing(10);
        HBox botonesColor = new HBox(rojo, azul, amarillo, verde);
        botonesColor.setSpacing(10);

        VBox body = new VBox(error, nombre, colorLabel, botonesColor, razas, botonesRaza, siguiente);
        body.setSpacing(20);
        this.getChildren().addAll(titulo, body);
        this.setSpacing(15);
        this.styleProperty().set("-fx-padding: 10px;");
    }
}
