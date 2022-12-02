package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.modelo.Casillero;
import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.Mapa;
import javafx.scene.layout.GridPane;

public class VistaJuego {
    private final Juego juego;
    private final Mapa mapa;
    private final GridPane tablero;
    public VistaJuego(Juego juego, GridPane tablero) {
        this.juego = juego;
        this.mapa = juego.getMapa();
        this.tablero = tablero;
    }

    public void actualizar() {
        int alto = mapa.getAlto();
        int ancho = mapa.getAncho();

        for (int i = 0; i < alto; i++) {
            for (int j = 0; j < ancho; j++) {
                Casillero casillero = mapa.obtenerCasillero(i, j);
                VistaCasillero vistaCasillero = new VistaCasillero(casillero);
                tablero.add(vistaCasillero, i, j);
            }
        }
    }
}
