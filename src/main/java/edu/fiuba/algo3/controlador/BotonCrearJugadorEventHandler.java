package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.vistas.ContenedorPrincipal;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class BotonCrearJugadorEventHandler implements EventHandler<ActionEvent> {

    private Juego juego;
    private Stage stage;
    private Scene proximaEscena;
    private TextField nombreJugador;
    private Label error;
    private Label titulo;
    private Button botonRojo;
    private Button botonAzul;
    private Button botonVerde;
    private Button botonAmarillo;
    private Button botonProtoss;
    private Button botonZerg;
    private final ContenedorPrincipal contenedorPrincipal;

    public BotonCrearJugadorEventHandler(Label error, Label titulo, TextField nombreJugador, Button botonRojo, Button botonAzul, Button botonAmarillo, Button botonVerde, Button botonProtoss, Button botonZerg, Juego juego, Stage stage, Scene proximaEscena, ContenedorPrincipal contenedorPrincipal) {

        this.nombreJugador = nombreJugador;
        this.error = error;
        this.titulo = titulo;
        this.botonRojo = botonRojo;
        this.botonAzul = botonAzul;
        this.botonAmarillo = botonAmarillo;
        this.botonVerde = botonVerde;
        this.botonProtoss = botonProtoss;
        this.botonZerg = botonZerg;
        this.juego = juego;
        this.stage = stage;
        this.proximaEscena = proximaEscena;
        this.contenedorPrincipal = contenedorPrincipal;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        if (nombreJugador.getText().trim().equals("")) {
            this.error.setText("El nombre no puede estar vacío");
            this.error.styleProperty().set("-fx-text-fill: #DA4728;");
            return;
        }
        if (nombreJugador.getText().trim().length() < 6) {
            this.error.setText("El nombre debe tener al menos 6 caracteres");
            this.error.styleProperty().set("-fx-text-fill: #DA4728;");
            return;
        }
        String nombre = nombreJugador.getText().trim();
        String color = "";
        String raza = "";
        if (botonRojo.getStyle().contains("-fx-border-color: #5DADE2;")) {
            color = "Rojo";
            botonRojo.setDisable(true);
        }
        if (botonAzul.getStyle().contains("-fx-border-color: #5DADE2;")) {
            color = "Azul";
            botonAzul.setDisable(true);
        }
        if (botonAmarillo.getStyle().contains("-fx-border-color: #5DADE2;")) {
            color = "Amarillo";
            botonAmarillo.setDisable(true);
        }
        if (botonVerde.getStyle().contains("-fx-border-color: #5DADE2;")) {
            color = "Verde";
            botonVerde.setDisable(true);
        }
        if (botonProtoss.getStyle().contains("-fx-border-color: #5DADE2;")) {
            raza = "Protoss";
            botonProtoss.setDisable(true);
        }
        if (botonZerg.getStyle().contains("-fx-border-color: #5DADE2;")) {
            raza = "Zerg";
            botonZerg.setDisable(true);
        }
        if (color.equals("")) {
            this.error.setText("Debe seleccionar un color");
            this.error.styleProperty().set("-fx-text-fill: #DA4728;");
            if(raza.equals("Protoss")){
                botonProtoss.setDisable(false);
            }
            if(raza.equals("Zerg")){
                botonZerg.setDisable(false);
            }
            return;
        }
        if (raza.equals("")) {
            this.error.setText("Debe seleccionar una raza");
            this.error.styleProperty().set("-fx-text-fill: #DA4728;");
            if(color.equals("Rojo")){
                botonRojo.setDisable(false);
            }
            if(color.equals("Azul")){
                botonAzul.setDisable(false);
            }
            if(color.equals("Amarillo")){
                botonAmarillo.setDisable(false);
            }
            if(color.equals("Verde")){
                botonVerde.setDisable(false);
            }
            return;
        }
        juego.registrarJugador(nombre, color, raza, new Jugador());
        titulo.setText("Jugador " + (juego.cantidadDeJugadores() + 1));
        nombreJugador.setText("");
        botonRojo.styleProperty().set("-fx-background-color: #DA4728;");
        botonAzul.styleProperty().set("-fx-background-color: #3F58D2;");
        botonAmarillo.styleProperty().set("-fx-background-color: #F1C532;");
        botonVerde.styleProperty().set("-fx-background-color: #65D54F;");

        if (juego.cantidadDeJugadores() == juego.cantidadDeJugadoresMaxima()) {
            stage.setScene(proximaEscena);
            stage.setFullScreen(true);
            juego.crearBases();

            contenedorPrincipal.actualizar();
        }

    }
}
