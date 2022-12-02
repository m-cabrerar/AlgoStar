package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.modelo.Juego;
import javafx.geometry.Pos;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ContenedorPrincipal extends BorderPane {

    BarraMenu barraMenu;
    VistaJuego vistaJuego;
    GridPane tablero;
    VBox contenedorCentral;
    HBox contenedorJugador;
    public ContenedorPrincipal(Stage stage, Juego juego) {
        this.setMenu(stage);
        this.setCentro(juego);
    }

    private void setMenu(Stage stage) {
        barraMenu = new BarraMenu(stage);
        this.setTop(barraMenu);
    }

    private void setCentro(Juego juego) {
        tablero = new GridPane();
        vistaJuego = new VistaJuego(juego, tablero);
        contenedorCentral = new VBox(tablero);
        contenedorCentral.setAlignment(Pos.CENTER);
        contenedorCentral.setSpacing(10);

        this.setCenter(contenedorCentral);
    }

    public void actualizar() {
        vistaJuego.actualizar();
    }

}
