package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.modelo.*;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

public class ContenedorJugador extends HBox {
    private Juego juego;
    private Jugador[] jugadores;
    public ContenedorJugador(Juego juego) {
        this.juego = juego;
    }
    public void iniciarJuego() {
        jugadores = juego.getJugadores();
        update();
    }

    public void update() {
        this.getChildren().clear();
        Jugador jugadorActual = jugadores[juego.getTurnos()%juego.cantidadDeJugadores()];
        String color = jugadorActual.getColor();
        String nombre = jugadorActual.getNombre();
        String raza = jugadorActual.getRaza();
        Inventario inventario = jugadorActual.getInventario();

        Label nombreJugador = new Label(nombre);
        nombreJugador.setStyle("-fx-font-size: 15px; -fx-font-weight: bold; -fx-text-fill: " + color + ";");
        Image imagen = new Image("file:src/main/java/edu/fiuba/algo3/vistas/img/"+raza.toLowerCase()+".png");
        ImageView iv = new ImageView();
        iv.setImage(imagen);
        iv.setFitWidth(100);
        iv.setPreserveRatio(true);
        iv.setSmooth(true);
        iv.setCache(true);
        VBox retrato = new VBox(nombreJugador, iv);

        HBox contenedorInventario = new HBox();
        Label mineral = new Label("Mineral: "+inventario.getMineral() + " ");
        Label gas = new Label("Gas: "+inventario.getGas() + " ");
        Label suministros = new Label("Suministros: "+inventario.getSuministros() + "/" + inventario.getSuministrosMaximos());
        Label poblacion = new Label("Poblacion: "+inventario.getSuministrosEmpleados() + "/" + inventario.getPoblacionMaxima());
        contenedorInventario.getChildren().addAll(mineral, gas, suministros, poblacion);
        contenedorInventario.setAlignment(Pos.CENTER);

        this.getChildren().addAll(retrato, contenedorInventario);
        this.setSpacing(10);
    }
}
