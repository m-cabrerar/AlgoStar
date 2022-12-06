package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.modelo.Inventario;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.casillero.Casillero;
import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.Mapa;
import edu.fiuba.algo3.modelo.unidades.Unidad;
import javafx.beans.binding.Bindings;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

import java.util.List;

public class VistaJuego {
    private final Juego juego;
    private final Mapa mapa;
    private final GridPane tablero;
    private final GridPane tableroUnidades;
    private Inventario[] inventarios;
    StackPane centerPane;
    public VistaJuego(Juego juego, GridPane tablero, GridPane tableroUnidades, StackPane centerPane) {
        this.juego = juego;
        this.mapa = juego.getMapa();
        this.tablero = tablero;
        this.tableroUnidades = tableroUnidades;
        this.centerPane = centerPane;
    }

    public void iniciarJuego() {
        inventarios = juego.getInventarios();
        update();
    }

    public void update() {
        updateMapa();
        updateUnidades();
    }
    public void updateMapa() {
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

    public void updateUnidades() {
        int alto = mapa.getAlto();
        int ancho = mapa.getAncho();

        tablero.setPrefSize(alto*50, alto*50);
        for (Inventario inventario : inventarios) {
            List<Unidad> unidades = inventario.getUnidades();
            for (Unidad unidad : unidades) {
                VistaUnidad vistaUnidad = new VistaUnidad(unidad);
                vistaUnidad.prefWidthProperty().bind(Bindings.min(centerPane.widthProperty().divide(mapa.getAlto()),
                        centerPane.heightProperty().divide(mapa.getAlto())));
                vistaUnidad.prefHeightProperty().bind(Bindings.min(centerPane.widthProperty().divide(mapa.getAlto()),
                        centerPane.heightProperty().divide(mapa.getAlto())));
                int[] posicion = unidad.obtenerPosicion();
                tablero.add(vistaUnidad, posicion[0], posicion[1]);
            }
        }
    }
}
