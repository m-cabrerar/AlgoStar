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
        tablero.setAlignment(Pos.CENTER);
        StackPane centerPane = new StackPane(tablero);
        vistaJuego = new VistaJuego(juego, tablero, centerPane);
        contenedorCentral = new VBox(centerPane);
        contenedorCentral.setAlignment(Pos.CENTER);
        contenedorCentral.setSpacing(10);

        Image backgroundImg = new Image("file:src/main/java/edu/fiuba/algo3/vistas/img/background.jpg");
        BackgroundSize backgroundSize = new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, false, true);
        contenedorCentral.setBackground(new Background(new BackgroundImage(backgroundImg, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize)));

        this.setCenter(contenedorCentral);
    }

    public void actualizar() {
        vistaJuego.actualizar();
    }

}
