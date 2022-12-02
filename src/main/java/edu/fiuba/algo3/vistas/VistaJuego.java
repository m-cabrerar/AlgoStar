package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.modelo.Casillero;
import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.Mapa;
import javafx.beans.binding.Bindings;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

public class VistaJuego {
    private final Juego juego;
    private final Mapa mapa;
    private final GridPane tablero;
    StackPane centerPane;
    public VistaJuego(Juego juego, GridPane tablero, StackPane centerPane) {
        this.juego = juego;
        this.mapa = juego.getMapa();
        this.tablero = tablero;
        this.centerPane = centerPane;
    }

    public void actualizar() {
        int alto = mapa.getAlto();
        int ancho = mapa.getAncho();

        tablero.setPrefSize(alto*50, alto*50);
        for (int i = 0; i < alto; i++) {
            for (int j = 0; j < ancho; j++) {
                Casillero casillero = mapa.obtenerCasillero(i, j);
                VistaCasillero vistaCasillero = new VistaCasillero(casillero);
                tablero.add(vistaCasillero, i, j);
                vistaCasillero.prefWidthProperty().bind(Bindings.min(centerPane.widthProperty().divide(alto),
                        centerPane.heightProperty().divide(alto)));
                vistaCasillero.prefHeightProperty().bind(Bindings.min(centerPane.widthProperty().divide(alto),
                        centerPane.heightProperty().divide(alto)));
            }
        }
    }
}
