package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.exceptions.CasilleroNoCompatible;
import edu.fiuba.algo3.exceptions.CorrelativasInsuficientes;
import edu.fiuba.algo3.exceptions.RecursosInsuficientes;
import edu.fiuba.algo3.exceptions.UbicacionInvalida;
import edu.fiuba.algo3.modelo.Inventario;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.casillero.Casillero;
import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.Mapa;
import edu.fiuba.algo3.modelo.unidades.Unidad;
import edu.fiuba.algo3.modelo.unidades.edificios.*;
import javafx.beans.binding.Bindings;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

import java.util.List;

public class VistaJuego {
    private final Juego juego;
    private final Mapa mapa;
    private final GridPane tablero;
    private final GridPane tableroUnidades;
    private final GridPane tableroDeBotones;
    private final Botonera botonera;
    private final ContenedorPrincipal contenedorPrincipal;
    private boolean[][] casilleroOcupadoPorEdificioAliado;
    private boolean[][] casilleroOcupadoPorEdificioEnemigo;
    private boolean[][] casilleroOcupadoPorUnidadAliada;
    private boolean[][] casilleroOcupadoPorUnidadEnemiga;
    private Inventario[] inventarios;
    private int alto;
    private int ancho;
    private StackPane centerPane;
    public VistaJuego(Juego juego, GridPane tablero, GridPane tableroUnidades, GridPane tableroDeBotones, Botonera botonera, StackPane centerPane, ContenedorPrincipal contenedorPrincipal) {
        this.juego = juego;
        this.mapa = juego.getMapa();
        this.tablero = tablero;
        this.tableroUnidades = tableroUnidades;
        this.tableroDeBotones = tableroDeBotones;
        this.botonera = botonera;
        this.centerPane = centerPane;
        this.contenedorPrincipal = contenedorPrincipal;
    }

    public void iniciarJuego() {
        inventarios = juego.getInventarios();
        this.alto = mapa.getAlto();
        this.ancho = mapa.getAncho();
        this.casilleroOcupadoPorEdificioAliado = new boolean[alto][ancho];
        this.casilleroOcupadoPorEdificioEnemigo = new boolean[alto][ancho];
        this.casilleroOcupadoPorUnidadAliada = new boolean[alto][ancho];
        this.casilleroOcupadoPorUnidadEnemiga = new boolean[alto][ancho];
        update();
    }

    public void update() {
        updateMapa();
        actualizarUnidades();
        actualizarBotones();
    }
    public void updateMapa() {
        tablero.getChildren().clear();
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

    public void actualizarBotones() {
        tableroDeBotones.getChildren().clear();
        tableroDeBotones.setPrefSize(ancho*50, alto*50);
        for (int i = 0; i < alto; i++) {
            for (int j = 0; j < ancho; j++) {
                Button boton = new Button();
                boton.setPrefSize(50, 50);
                tableroDeBotones.add(boton, i, j);
                boton.prefWidthProperty().bind(Bindings.min(centerPane.widthProperty().divide(alto),
                        centerPane.heightProperty().divide(alto)));
                boton.prefHeightProperty().bind(Bindings.min(centerPane.widthProperty().divide(alto),
                        centerPane.heightProperty().divide(alto)));
                boton.opacityProperty().setValue(0);
                List<Casillero> casillero = new java.util.ArrayList<>();
                casillero.add(mapa.obtenerCasillero(i, j));
                if (casilleroOcupadoPorEdificioAliado[i][j]) {
                    boton.setOnAction(e -> {
                        Inventario inventario = inventarios[juego.getTurnos()%juego.cantidadDeJugadores()];
                        for (EdificioEnConstruccion edificio : inventario.getEdificios()) {
                            if (edificio.estaPorAca(casillero)) {
                                botonera.mostrarBotonesEdificio(edificio);
                            }
                        }
                    });
                }else if (casilleroOcupadoPorEdificioEnemigo[i][j]) {
                    int fila = i;
                    int columna = j;
                    boton.setOnAction(e -> {
                        Inventario inventario = inventarios[(juego.getTurnos()+1)%juego.cantidadDeJugadores()];
                        for (EdificioEnConstruccion edificio : inventario.getEdificios()) {
                            if (edificio.estaPorAca(casillero)) {
                                botonera.mostrarInfoEdificio(edificio);
                            }
                        }
                    });
                } else if (casilleroOcupadoPorUnidadAliada[i][j]) {
                    int fila = i;
                    int columna = j;
                    boton.setOnAction(e -> {
                        Inventario inventario = inventarios[juego.getTurnos()%juego.cantidadDeJugadores()];
                        for (Unidad unidad : inventario.getUnidades()) {
                            if (unidad.estaPorAca(casillero)) {
                                botonera.mostrarBotonesUnidad(unidad);
                            }
                        }
                    });
                } else if (casilleroOcupadoPorUnidadEnemiga[i][j]) {
                    int fila = i;
                    int columna = j;
                    boton.setOnAction(e -> {
                        Inventario inventario = inventarios[(juego.getTurnos()+1)%juego.cantidadDeJugadores()];
                        for (Unidad unidad : inventario.getUnidades()) {
                            if (unidad.estaPorAca(casillero)) {
                                botonera.mostrarInfoUnidad(unidad);
                            }
                        }
                    });
                } else {
                    boton.setOnAction(e -> {
                        contenedorPrincipal.update();
                    });
                }
            }
        }
    }

    public void actualizarUnidades() {
        tableroUnidades.setPrefSize(alto*50, alto*50);


        Inventario jugadorActual = inventarios[juego.getTurnos()%juego.cantidadDeJugadores()];
        Inventario jugadorEnemigo = inventarios[(juego.getTurnos()+1)%juego.cantidadDeJugadores()];

        List<Unidad> unidadesAliadas = jugadorActual.getUnidades();
        for (Unidad unidad : unidadesAliadas) {
            VistaUnidad vistaUnidad = new VistaUnidad(unidad);
            vistaUnidad.prefWidthProperty().bind(Bindings.min(centerPane.widthProperty().divide(mapa.getAlto()),
                    centerPane.heightProperty().divide(mapa.getAlto())));
            vistaUnidad.prefHeightProperty().bind(Bindings.min(centerPane.widthProperty().divide(mapa.getAlto()),
                    centerPane.heightProperty().divide(mapa.getAlto())));
            Integer[] posicion = unidad.obtenerPosicion();
            tablero.add(vistaUnidad, posicion[0], posicion[1]);
            casilleroOcupadoPorUnidadAliada[posicion[0]][posicion[1]] = true;
        }
        List<EdificioEnConstruccion> edificiosAliados = jugadorActual.getEdificios();
        for (EdificioEnConstruccion edificio : edificiosAliados) {
            VistaUnidad vistaEdificio = new VistaUnidad(edificio);
            if (edificio.estaListo()) {
                vistaEdificio = new VistaUnidad(edificio.getConstruido());
            }
            vistaEdificio.prefWidthProperty().bind(Bindings.min(centerPane.widthProperty().divide(mapa.getAlto()),
                    centerPane.heightProperty().divide(mapa.getAlto())));
            vistaEdificio.prefHeightProperty().bind(Bindings.min(centerPane.widthProperty().divide(mapa.getAlto()),
                    centerPane.heightProperty().divide(mapa.getAlto())));
            Integer[] posicion = edificio.obtenerPosicion();
            tablero.add(vistaEdificio, posicion[0], posicion[1]);
            casilleroOcupadoPorEdificioAliado[posicion[0]][posicion[1]] = true;
        }

        List<Unidad> unidadesEnemigas = jugadorEnemigo.getUnidades();
        for (Unidad unidad : unidadesEnemigas) {
            VistaUnidad vistaUnidad = new VistaUnidad(unidad);
            vistaUnidad.prefWidthProperty().bind(Bindings.min(centerPane.widthProperty().divide(mapa.getAlto()),
                    centerPane.heightProperty().divide(mapa.getAlto())));
            vistaUnidad.prefHeightProperty().bind(Bindings.min(centerPane.widthProperty().divide(mapa.getAlto()),
                    centerPane.heightProperty().divide(mapa.getAlto())));
            Integer[] posicion = unidad.obtenerPosicion();
            tablero.add(vistaUnidad, posicion[0], posicion[1]);
            casilleroOcupadoPorUnidadEnemiga[posicion[0]][posicion[1]] = true;
        }
        List<EdificioEnConstruccion> edificiosEnemigos = jugadorEnemigo.getEdificios();
        for (EdificioEnConstruccion edificio : edificiosEnemigos) {
            VistaUnidad vistaEdificio = new VistaUnidad(edificio);
            if (edificio.estaListo()) {
                vistaEdificio = new VistaUnidad(edificio.getConstruido());
            }
            vistaEdificio.prefWidthProperty().bind(Bindings.min(centerPane.widthProperty().divide(mapa.getAlto()),
                    centerPane.heightProperty().divide(mapa.getAlto())));
            vistaEdificio.prefHeightProperty().bind(Bindings.min(centerPane.widthProperty().divide(mapa.getAlto()),
                    centerPane.heightProperty().divide(mapa.getAlto())));
            Integer[] posicion = edificio.obtenerPosicion();
            tablero.add(vistaEdificio, posicion[0], posicion[1]);
            casilleroOcupadoPorEdificioEnemigo[posicion[0]][posicion[1]] = true;
        }
    }

    public void crearNexoMineral(Label label) {
        tableroDeBotones.getChildren().clear();
        Inventario inventario = inventarios[juego.getTurnos()%juego.cantidadDeJugadores()];
        for (int i = 0; i<alto; i++) {
            for (int j = 0; j<ancho; j++) {
                Button boton = new Button();
                boton.setPrefSize(50, 50);
                tableroDeBotones.add(boton, i, j);
                boton.prefWidthProperty().bind(Bindings.min(centerPane.widthProperty().divide(alto),
                        centerPane.heightProperty().divide(alto)));
                boton.prefHeightProperty().bind(Bindings.min(centerPane.widthProperty().divide(alto),
                        centerPane.heightProperty().divide(alto)));
                boton.opacityProperty().setValue(0);
                Casillero casillero = mapa.obtenerCasillero(i, j);
                boton.setOnAction(e -> {
                    try {
                        NexoMineral.construir(casillero, inventario);
                        contenedorPrincipal.finalizarTurno();
                    } catch (CasilleroNoCompatible | CorrelativasInsuficientes | RecursosInsuficientes | UbicacionInvalida ex) {
                        label.setText(ex.getMessage());
                        actualizarBotones();
                    }
                });
            }
        }
    }

    public void crearPilon(Label label) {
        tableroDeBotones.getChildren().clear();
        Inventario inventario = inventarios[juego.getTurnos()%juego.cantidadDeJugadores()];
        for (int i = 0; i<alto; i++) {
            for (int j = 0; j<ancho; j++) {
                Button boton = new Button();
                boton.setPrefSize(50, 50);
                tableroDeBotones.add(boton, i, j);
                boton.prefWidthProperty().bind(Bindings.min(centerPane.widthProperty().divide(alto),
                        centerPane.heightProperty().divide(alto)));
                boton.prefHeightProperty().bind(Bindings.min(centerPane.widthProperty().divide(alto),
                        centerPane.heightProperty().divide(alto)));
                boton.opacityProperty().setValue(0);
                Casillero casillero = mapa.obtenerCasillero(i, j);
                boton.setOnAction(e -> {
                    try {
                        Pilon.construir(casillero, inventario);
                        contenedorPrincipal.finalizarTurno();
                    } catch (CasilleroNoCompatible | CorrelativasInsuficientes | RecursosInsuficientes | UbicacionInvalida ex) {
                        label.setText(ex.getMessage());
                    }
                });
            }
        }
    }

    public void crearAsimilador(Label label) {
        tableroDeBotones.getChildren().clear();
        Inventario inventario = inventarios[juego.getTurnos()%juego.cantidadDeJugadores()];
        for (int i = 0; i<alto; i++) {
            for (int j = 0; j<ancho; j++) {
                Button boton = new Button();
                boton.setPrefSize(50, 50);
                tableroDeBotones.add(boton, i, j);
                boton.prefWidthProperty().bind(Bindings.min(centerPane.widthProperty().divide(alto),
                        centerPane.heightProperty().divide(alto)));
                boton.prefHeightProperty().bind(Bindings.min(centerPane.widthProperty().divide(alto),
                        centerPane.heightProperty().divide(alto)));
                boton.opacityProperty().setValue(0);
                Casillero casillero = mapa.obtenerCasillero(i, j);
                boton.setOnAction(e -> {
                    try {
                        Asimilador.construir(casillero, inventario);
                        contenedorPrincipal.finalizarTurno();
                    } catch (CasilleroNoCompatible | CorrelativasInsuficientes | RecursosInsuficientes | UbicacionInvalida ex) {
                        label.setText(ex.getMessage());
                    }
                });
            }
        }
    }

    public void crearPuertoEstelar(Label label) {
        tableroDeBotones.getChildren().clear();
        Inventario inventario = inventarios[juego.getTurnos()%juego.cantidadDeJugadores()];
        for (int i = 0; i<alto; i++) {
            for (int j = 0; j<ancho; j++) {
                Button boton = new Button();
                boton.setPrefSize(50, 50);
                tableroDeBotones.add(boton, i, j);
                boton.prefWidthProperty().bind(Bindings.min(centerPane.widthProperty().divide(alto),
                        centerPane.heightProperty().divide(alto)));
                boton.prefHeightProperty().bind(Bindings.min(centerPane.widthProperty().divide(alto),
                        centerPane.heightProperty().divide(alto)));
                boton.opacityProperty().setValue(0);
                Casillero casillero = mapa.obtenerCasillero(i, j);
                boton.setOnAction(e -> {
                    try {
                        PuertoEstelar.construir(casillero, inventario);
                        contenedorPrincipal.finalizarTurno();
                    } catch (CasilleroNoCompatible | CorrelativasInsuficientes | RecursosInsuficientes | UbicacionInvalida ex) {
                        label.setText(ex.getMessage());
                    }
                });
            }
        }
    }

    public void crearAcceso(Label label) {
        tableroDeBotones.getChildren().clear();
        Inventario inventario = inventarios[juego.getTurnos()%juego.cantidadDeJugadores()];
        for (int i = 0; i<alto; i++) {
            for (int j = 0; j<ancho; j++) {
                Button boton = new Button();
                boton.setPrefSize(50, 50);
                tableroDeBotones.add(boton, i, j);
                boton.prefWidthProperty().bind(Bindings.min(centerPane.widthProperty().divide(alto),
                        centerPane.heightProperty().divide(alto)));
                boton.prefHeightProperty().bind(Bindings.min(centerPane.widthProperty().divide(alto),
                        centerPane.heightProperty().divide(alto)));
                boton.opacityProperty().setValue(0);
                Casillero casillero = mapa.obtenerCasillero(i, j);
                boton.setOnAction(e -> {
                    try {
                        Acceso.construir(casillero, inventario);
                        contenedorPrincipal.finalizarTurno();
                    } catch (CasilleroNoCompatible | CorrelativasInsuficientes | RecursosInsuficientes | UbicacionInvalida ex) {
                        label.setText(ex.getMessage());
                    }
                });
            }
        }
    }

    public void crearExtractor(Label label) {
        tableroDeBotones.getChildren().clear();
        Inventario inventario = inventarios[juego.getTurnos()%juego.cantidadDeJugadores()];
        for (int i = 0; i<alto; i++) {
            for (int j = 0; j<ancho; j++) {
                Button boton = new Button();
                boton.setPrefSize(50, 50);
                tableroDeBotones.add(boton, i, j);
                boton.prefWidthProperty().bind(Bindings.min(centerPane.widthProperty().divide(alto),
                        centerPane.heightProperty().divide(alto)));
                boton.prefHeightProperty().bind(Bindings.min(centerPane.widthProperty().divide(alto),
                        centerPane.heightProperty().divide(alto)));
                boton.opacityProperty().setValue(0);
                Casillero casillero = mapa.obtenerCasillero(i, j);
                boton.setOnAction(e -> {
                    try {
                        Extractor.construir(casillero, inventario);
                        contenedorPrincipal.finalizarTurno();
                    } catch (CasilleroNoCompatible | CorrelativasInsuficientes | RecursosInsuficientes | UbicacionInvalida ex) {
                        label.setText(ex.getMessage());
                    }
                });
            }
        }
    }

    public void crearCriadero(Label label) {
        tableroDeBotones.getChildren().clear();
        Inventario inventario = inventarios[juego.getTurnos()%juego.cantidadDeJugadores()];
        for (int i = 0; i<alto; i++) {
            for (int j = 0; j<ancho; j++) {
                Button boton = new Button();
                boton.setPrefSize(50, 50);
                tableroDeBotones.add(boton, i, j);
                boton.prefWidthProperty().bind(Bindings.min(centerPane.widthProperty().divide(alto),
                        centerPane.heightProperty().divide(alto)));
                boton.prefHeightProperty().bind(Bindings.min(centerPane.widthProperty().divide(alto),
                        centerPane.heightProperty().divide(alto)));
                boton.opacityProperty().setValue(0);
                Casillero casillero = mapa.obtenerCasillero(i, j);
                boton.setOnAction(e -> {
                    try {
                        Criadero.construir(casillero, inventario);
                        contenedorPrincipal.finalizarTurno();
                    } catch (CasilleroNoCompatible | CorrelativasInsuficientes | RecursosInsuficientes | UbicacionInvalida ex) {
                        label.setText(ex.getMessage());
                    }
                });
            }
        }
    }

    public void crearReservaDeReproduccion(Label label) {
        tableroDeBotones.getChildren().clear();
        Inventario inventario = inventarios[juego.getTurnos()%juego.cantidadDeJugadores()];
        for (int i = 0; i<alto; i++) {
            for (int j = 0; j<ancho; j++) {
                Button boton = new Button();
                boton.setPrefSize(50, 50);
                tableroDeBotones.add(boton, i, j);
                boton.prefWidthProperty().bind(Bindings.min(centerPane.widthProperty().divide(alto),
                        centerPane.heightProperty().divide(alto)));
                boton.prefHeightProperty().bind(Bindings.min(centerPane.widthProperty().divide(alto),
                        centerPane.heightProperty().divide(alto)));
                boton.opacityProperty().setValue(0);
                Casillero casillero = mapa.obtenerCasillero(i, j);
                boton.setOnAction(e -> {
                    try {
                        ReservaDeReproduccion.construir(casillero, inventario);
                        contenedorPrincipal.finalizarTurno();
                    } catch (CasilleroNoCompatible | CorrelativasInsuficientes | RecursosInsuficientes | UbicacionInvalida ex) {
                        label.setText(ex.getMessage());
                    }
                });
            }
        }
    }

    public void crearGuarida(Label label) {
        tableroDeBotones.getChildren().clear();
        Inventario inventario = inventarios[juego.getTurnos()%juego.cantidadDeJugadores()];
        for (int i = 0; i<alto; i++) {
            for (int j = 0; j<ancho; j++) {
                Button boton = new Button();
                boton.setPrefSize(50, 50);
                tableroDeBotones.add(boton, i, j);
                boton.prefWidthProperty().bind(Bindings.min(centerPane.widthProperty().divide(alto),
                        centerPane.heightProperty().divide(alto)));
                boton.prefHeightProperty().bind(Bindings.min(centerPane.widthProperty().divide(alto),
                        centerPane.heightProperty().divide(alto)));
                boton.opacityProperty().setValue(0);
                Casillero casillero = mapa.obtenerCasillero(i, j);
                boton.setOnAction(e -> {
                    try {
                        Guarida.construir(casillero, inventario);
                        contenedorPrincipal.finalizarTurno();
                    } catch (CasilleroNoCompatible | CorrelativasInsuficientes | RecursosInsuficientes | UbicacionInvalida ex) {
                        label.setText(ex.getMessage());
                    }
                });
            }
        }
    }

    public void crearEspiral(Label label) {
        tableroDeBotones.getChildren().clear();
        Inventario inventario = inventarios[juego.getTurnos()%juego.cantidadDeJugadores()];
        for (int i = 0; i<alto; i++) {
            for (int j = 0; j<ancho; j++) {
                Button boton = new Button();
                boton.setPrefSize(50, 50);
                tableroDeBotones.add(boton, i, j);
                boton.prefWidthProperty().bind(Bindings.min(centerPane.widthProperty().divide(alto),
                        centerPane.heightProperty().divide(alto)));
                boton.prefHeightProperty().bind(Bindings.min(centerPane.widthProperty().divide(alto),
                        centerPane.heightProperty().divide(alto)));
                boton.opacityProperty().setValue(0);
                Casillero casillero = mapa.obtenerCasillero(i, j);
                boton.setOnAction(e -> {
                    try {
                        Espiral.construir(casillero, inventario);
                        contenedorPrincipal.finalizarTurno();
                    } catch (CasilleroNoCompatible | CorrelativasInsuficientes | RecursosInsuficientes | UbicacionInvalida ex) {
                        label.setText(ex.getMessage());
                    }
                });
            }
        }
    }
}
