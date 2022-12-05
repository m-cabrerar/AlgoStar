package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.modelo.Juego;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class ContenedorPrincipal extends BorderPane {

    BarraMenu barraMenu;
    VistaJuego vistaJuego;
    GridPane tablero;
    GridPane tableroUnidades;
    VBox contenedorCentral;
    ContenedorJugador contenedorJugador;
    public ContenedorPrincipal(Stage stage, Juego juego) {
        this.setMenu(stage);
        this.setCentro(juego);
        this.setJugador(juego);
    }

    private void setMenu(Stage stage) {
        barraMenu = new BarraMenu(stage);
        this.setTop(barraMenu);
    }

    private void setCentro(Juego juego) {
        tablero = new GridPane();
        tablero.setAlignment(Pos.CENTER);
        tableroUnidades = new GridPane();
        tableroUnidades.setAlignment(Pos.CENTER);
        StackPane centerPane = new StackPane(tablero, tableroUnidades);
        vistaJuego = new VistaJuego(juego, tablero, tableroUnidades, centerPane);
        contenedorCentral = new VBox(centerPane);
        contenedorCentral.setAlignment(Pos.CENTER);
        contenedorCentral.setSpacing(10);

        Image backgroundImg = new Image("file:src/main/java/edu/fiuba/algo3/vistas/img/background.jpg");
        BackgroundSize backgroundSize = new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, false, true);
        contenedorCentral.setBackground(new Background(new BackgroundImage(backgroundImg, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize)));

        this.setCenter(contenedorCentral);
    }

    private void setJugador(Juego juego) {
        contenedorJugador = new ContenedorJugador(juego);
        this.setBottom(contenedorJugador);
    }

    public void actualizar() {
        vistaJuego.actualizar();
    }
    public void iniciarJuego() {
        vistaJuego.iniciarJuego();
        contenedorJugador.iniciarJuego();
    }

}
