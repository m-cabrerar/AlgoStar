package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.exceptions.*;
import edu.fiuba.algo3.modelo.Inventario;
import edu.fiuba.algo3.modelo.casillero.Casillero;
import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.Mapa;
import edu.fiuba.algo3.modelo.unidades.Unidad;
import edu.fiuba.algo3.modelo.unidades.edificios.*;
import edu.fiuba.algo3.modelo.unidades.moviles.UnidadMovil;
import javafx.beans.binding.Bindings;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

import java.util.ArrayList;
import java.util.List;

public class VistaJuego {
    private final Juego juego;
    private final Mapa mapa;
    private final GridPane tablero;
    private final GridPane tableroUnidades;
    private final GridPane tableroDeBotones;
    private final Botonera botonera;
    private final ContenedorPrincipal contenedorPrincipal;
    private boolean[][][] casillerosOcupadosUnidades;
    private boolean[][][] casillerosOcupadosEdificios;
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
        casillerosOcupadosUnidades = new boolean[juego.cantidadDeJugadores()][ancho][alto];
        casillerosOcupadosEdificios = new boolean[juego.cantidadDeJugadores()][ancho][alto];
        update();
    }

    public void update() {
        updateMapa();
        updateUnidades();
        updateBotones();
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

    public void updateBotones() {
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
                if (casillerosOcupadosEdificios[juego.getTurnos() % juego.cantidadDeJugadores()][i][j]) {
                    boton.setOnAction(e -> {
                        Inventario inventario = inventarios[juego.getTurnos()%juego.cantidadDeJugadores()];
                        for (EdificioEnConstruccion edificio : inventario.getEdificios()) {
                            if (edificio.estaPorAca(casillero)) {
                                botonera.mostrarBotonesEdificio(edificio);
                            }
                        }
                    });
                }else if (casillerosOcupadosEdificios[(juego.getTurnos()+1) % juego.cantidadDeJugadores()][i][j]) {
                    boton.setOnAction(e -> {
                        Inventario inventario = inventarios[(juego.getTurnos()+1)%juego.cantidadDeJugadores()];
                        for (EdificioEnConstruccion edificio : inventario.getEdificios()) {
                            if (edificio.estaPorAca(casillero)) {
                                botonera.mostrarInfoEdificio(edificio);
                            }
                        }
                    });
                } else if (casillerosOcupadosUnidades[juego.getTurnos() % juego.cantidadDeJugadores()][i][j]) {
                    boton.setOnAction(e -> {
                        Inventario inventario = inventarios[juego.getTurnos()%juego.cantidadDeJugadores()];
                        for (Unidad unidad : inventario.getUnidades()) {
                            if (unidad.estaPorAca(casillero)) {
                                botonera.mostrarBotonesUnidad(unidad);
                            }
                        }
                    });
                } else if (casillerosOcupadosUnidades[(juego.getTurnos()+1) % juego.cantidadDeJugadores()][i][j]) {
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
                        botonera.update();
                    });
                }
            }
        }
    }

    public void updateUnidades() {
        updateUnidadesMoviles();
        updateEdificios();
    }

    public void updateUnidadesMoviles() {
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
            casillerosOcupadosUnidades[juego.getTurnos() % juego.cantidadDeJugadores()][posicion[0]][posicion[1]] = true;
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
            casillerosOcupadosUnidades[(juego.getTurnos()+1) % juego.cantidadDeJugadores()][posicion[0]][posicion[1]] = true;
        }
    }

    public void updateEdificios() {
        tableroUnidades.setPrefSize(alto * 50, alto * 50);
        Inventario jugadorActual = inventarios[juego.getTurnos() % juego.cantidadDeJugadores()];
        Inventario jugadorEnemigo = inventarios[(juego.getTurnos() + 1) % juego.cantidadDeJugadores()];

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
            casillerosOcupadosEdificios[juego.getTurnos() % juego.cantidadDeJugadores()][posicion[0]][posicion[1]] = true;
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
            casillerosOcupadosEdificios[(juego.getTurnos() + 1) % juego.cantidadDeJugadores()][posicion[0]][posicion[1]] = true;
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
                        label.setText("Nexo mineral en construccion");
                        updateEdificios();
                        botonera.update();
                    } catch (CasilleroNoCompatible | CorrelativasInsuficientes | RecursosInsuficientes | UbicacionInvalida ex) {
                        label.setText(ex.getMessage());
                    }
                    updateBotones();
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
                        label.setText("Pilon en construccion");
                        updateEdificios();
                        botonera.update();
                    } catch (CasilleroNoCompatible | CorrelativasInsuficientes | RecursosInsuficientes | UbicacionInvalida ex) {
                        label.setText(ex.getMessage());
                    }
                    updateBotones();
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
                        label.setText("Asimilador en construccion");
                        updateEdificios();
                        botonera.update();
                    } catch (CasilleroNoCompatible | CorrelativasInsuficientes | RecursosInsuficientes | UbicacionInvalida ex) {
                        label.setText(ex.getMessage());
                    }
                    updateBotones();
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
                        label.setText("Puerto estelar en construccion");
                        updateEdificios();
                        botonera.update();
                    } catch (CasilleroNoCompatible | CorrelativasInsuficientes | RecursosInsuficientes | UbicacionInvalida ex) {
                        label.setText(ex.getMessage());
                    }
                    updateBotones();
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
                        label.setText("Acceso en construccion");
                        updateEdificios();
                        botonera.update();
                    } catch (CasilleroNoCompatible | CorrelativasInsuficientes | RecursosInsuficientes | UbicacionInvalida ex) {
                        label.setText(ex.getMessage());
                    }
                    updateBotones();
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
                        label.setText("Extractor en construccion");
                        updateEdificios();
                        botonera.update();
                    } catch (CasilleroNoCompatible | CorrelativasInsuficientes | RecursosInsuficientes | UbicacionInvalida ex) {
                        label.setText(ex.getMessage());
                    }
                    updateBotones();
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
                        label.setText("Criadero en construccion");
                        updateEdificios();
                        botonera.update();
                    } catch (CasilleroNoCompatible | CorrelativasInsuficientes | RecursosInsuficientes | UbicacionInvalida ex) {
                        label.setText(ex.getMessage());
                    }
                    updateBotones();
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
                        label.setText("Reserva de reproduccion en construccion");
                        updateEdificios();
                        botonera.update();
                    } catch (CasilleroNoCompatible | CorrelativasInsuficientes | RecursosInsuficientes | UbicacionInvalida ex) {
                        label.setText(ex.getMessage());
                    }
                    updateBotones();
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
                        label.setText("Guarida en construccion");
                        updateEdificios();
                        botonera.update();
                    } catch (CasilleroNoCompatible | CorrelativasInsuficientes | RecursosInsuficientes | UbicacionInvalida ex) {
                        label.setText(ex.getMessage());
                    }
                    updateBotones();
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
                        label.setText("Espiral en construccion");
                        updateEdificios();
                        botonera.update();
                    } catch (CasilleroNoCompatible | CorrelativasInsuficientes | RecursosInsuficientes | UbicacionInvalida ex) {
                        label.setText(ex.getMessage());
                    }
                    updateBotones();
                });
            }
        }
    }

    public void moverUnidad(UnidadMovil unidad, Label label) {
        tableroDeBotones.getChildren().clear();
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
                        unidad.moverA(casillero);
                        botonera.update();
                        updateBotones();
                    } catch (CasilleroNoCompatible | UbicacionInvalida ex) {
                        label.setText(ex.getMessage());
                    }
                });
            }
        }
    }

    public void unidadAtacar(UnidadMovil unidad, Label label) {
        tableroDeBotones.getChildren().clear();
        Inventario inventarioEnemigo = inventarios[(juego.getTurnos()+1)%juego.cantidadDeJugadores()];
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
                        for (Unidad unidadEnemiga : inventarioEnemigo.getUnidades()) {
                            Integer[] posicion = unidadEnemiga.obtenerPosicion();
                            if (mapa.obtenerCasillero(posicion[0], posicion[1]).equals(casillero)) {
                                System.out.println("atacando" + posicion[0] + ", " + posicion[1]);
                                unidad.atacar(unidadEnemiga);
                            }
                        }
                        for (Unidad edificioEnemigo : inventarioEnemigo.getEdificios()) {
                            Integer[] posicion = edificioEnemigo.obtenerPosicion();
                            if (mapa.obtenerCasillero(posicion[0], posicion[1]).equals(casillero)) {
                                System.out.println("atacando" + posicion[0] + ", " + posicion[1]);
                                unidad.atacar(edificioEnemigo);
                            }
                        }
                        botonera.update();
                        updateBotones();
                    } catch (CasilleroNoCompatible | UbicacionInvalida | UnidadOcupada ex) {
                        label.setText(ex.getMessage());
                    }
                });
            }
        }
    }
}
