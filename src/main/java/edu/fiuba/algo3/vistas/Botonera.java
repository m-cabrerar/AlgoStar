package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.modelo.Inventario;
import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.unidades.Unidad;
import edu.fiuba.algo3.modelo.unidades.edificios.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class Botonera extends VBox {
    private final Juego juego;
    private Jugador[] jugadores;
    private final ContenedorPrincipal contenedorPrincipal;
    public Botonera(Juego juego, ContenedorPrincipal contenedorPrincipal) {
        this.juego = juego;
        this.contenedorPrincipal = contenedorPrincipal;
    }

    public void iniciarJuego() {
        jugadores = juego.getJugadores();
        update();
    }

    public void update() {
        this.getChildren().clear();
        Jugador jugadorActual = jugadores[juego.getTurnos()%juego.cantidadDeJugadoresMaxima()];
        if (jugadorActual.getRaza().equals("Protoss")) {
            updateProtoss(jugadorActual);
        } else {
            updateZerg(jugadorActual);
        }
    }

    public void updateProtoss(Jugador jugadorActual) {
        Inventario inventario = jugadorActual.getInventario();
        Label error = new Label();
        error.styleProperty().setValue("-fx-text-fill: red");

        Button botonNexoMineral = new Button("Nexo Mineral");
        Label labelNexoMineral = new Label("Costo: 50 Mineral");
        botonNexoMineral.setOnAction(e -> {
            contenedorPrincipal.crearNexoMineral(error);
        });
        if (!inventario.tieneRecursos(0,50) || !inventario.puedeConstruir(NexoMineral.getNivelDeConstruccion())) {
            botonNexoMineral.setDisable(true);
        }
        VBox contenedorNexoMineral = new VBox(botonNexoMineral, labelNexoMineral);

        Button botonPilon = new Button("Pilon");
        Label labelPilon = new Label("Costo: 100 Mineral");
        botonPilon.setOnAction(e -> {
            contenedorPrincipal.crearPilon(error);
        });
        if (!inventario.tieneRecursos(0,100) || !inventario.puedeConstruir(Pilon.getNivelDeConstruccion())) {
            botonPilon.setDisable(true);
        }
        VBox contenedorPilon = new VBox(botonPilon, labelPilon);

        Button botonAsimilador = new Button("Asimilador");
        Label labelAsimilador = new Label("Costo: 100 Mineral");
        botonAsimilador.setOnAction(e -> {
            contenedorPrincipal.crearAsimilador(error);
        });
        if (!inventario.tieneRecursos(0,100) || !inventario.puedeConstruir(Asimilador.getNivelDeConstruccion())) {
            botonAsimilador.setDisable(true);
        }
        VBox contenedorAsimilador = new VBox(botonAsimilador, labelAsimilador);

        Button botonAcceso = new Button("Acceso");
        Label labelAcceso = new Label("Costo: 150 Mineral");
        botonAcceso.setOnAction(e -> {
            contenedorPrincipal.crearAcceso(error);
        });
        if (!inventario.tieneRecursos(0,150) || !inventario.puedeConstruir(Acceso.getNivelDeConstruccion())) {
            botonAcceso.setDisable(true);
        }
        VBox contenedorAcceso = new VBox(botonAcceso, labelAcceso);

        Button botonPuertoEstelar = new Button("Puerto Estelar");
        Label labelPuertoEstelar = new Label("Costo: 150 Mineral, 150 Gas");
        botonPuertoEstelar.setOnAction(e -> {
            contenedorPrincipal.crearPuertoEstelar(error);
        });
        if (!inventario.tieneRecursos(150,150) || !inventario.puedeConstruir(PuertoEstelar.getNivelDeConstruccion())) {
            botonPuertoEstelar.setDisable(true);
        }
        VBox contenedorPuertoEstelar = new VBox(botonPuertoEstelar, labelPuertoEstelar);

        Button botonPasarTurno = new Button("Pasar Turno");
        botonPasarTurno.setOnAction(e -> {
            contenedorPrincipal.finalizarTurno();
        });

        this.getChildren().addAll(new VBox(), contenedorNexoMineral, contenedorPilon, contenedorAsimilador, contenedorAcceso, contenedorPuertoEstelar, botonPasarTurno, error);
        this.setSpacing(15);
    }
    public void updateZerg(Jugador jugadorActual) {
        Inventario inventario = jugadorActual.getInventario();
        Label error = new Label();
        error.styleProperty().setValue("-fx-text-fill: red");

        Button botonExtractor = new Button("Extractor");
        Label labelExtractor = new Label("Costo: 100 Mineral");
        botonExtractor.setOnAction(e -> {
            contenedorPrincipal.crearExtractor(error);
        });
        if (!inventario.tieneRecursos(0,100) || !inventario.puedeConstruir(Extractor.getNivelDeConstruccion())) {
            botonExtractor.setDisable(true);
        }
        VBox contenedorExtractor = new VBox(botonExtractor, labelExtractor);

        Button botonCriadero = new Button("Criadero");
        Label labelCriadero = new Label("Costo: 200 Mineral");
        botonCriadero.setOnAction(e -> {
            contenedorPrincipal.crearCriadero(error);
        });
        if (!inventario.tieneRecursos(0,200) || !inventario.puedeConstruir(Criadero.getNivelDeConstruccion())) {
            botonCriadero.setDisable(true);
        }
        VBox contenedorCriadero = new VBox(botonCriadero, labelCriadero);

        Button botonReservaDeReproduccion = new Button("Reserva De Reproduccion");
        Label labelReservaDeReproduccion = new Label("Costo: 150 Mineral");
        botonReservaDeReproduccion.setOnAction(e -> {
            contenedorPrincipal.crearReservaDeReproduccion(error);
        });
        if (!inventario.tieneRecursos(0,150) || !inventario.puedeConstruir(ReservaDeReproduccion.getNivelDeConstruccion())) {
            botonReservaDeReproduccion.setDisable(true);
        }
        VBox contenedorReservaDeReproduccion = new VBox(botonReservaDeReproduccion, labelReservaDeReproduccion);

        Button botonGuarida = new Button("Guarida");
        Label labelGuarida = new Label("Costo: 200 Mineral, 100 Gas");
        botonGuarida.setOnAction(e -> {
            contenedorPrincipal.crearGuarida(error);
        });
        if (!inventario.tieneRecursos(200,100) || !inventario.puedeConstruir(Guarida.getNivelDeConstruccion())) {
            botonGuarida.setDisable(true);
        }
        VBox contenedorGuarida = new VBox(botonGuarida, labelGuarida);

        Button botonEspiral = new Button("Espiral");
        Label labelEspiral = new Label("Costo: 150 Mineral, 100 Gas");
        botonEspiral.setOnAction(e -> {
            contenedorPrincipal.crearEspiral(error);
        });
        if (!inventario.tieneRecursos(150,100) || !inventario.puedeConstruir(Espiral.getNivelDeConstruccion())) {
            botonEspiral.setDisable(true);
        }
        VBox contenedorEspiral = new VBox(botonEspiral, labelEspiral);

        Button botonPasarTurno = new Button("Pasar Turno");
        botonPasarTurno.setOnAction(e -> {
            contenedorPrincipal.finalizarTurno();
        });

        this.getChildren().addAll(new VBox(), contenedorExtractor, contenedorCriadero, contenedorReservaDeReproduccion, contenedorGuarida, contenedorEspiral, botonPasarTurno,    error);
        this.setSpacing(15);
    }

    public void mostrarInfoEdificio(EdificioEnConstruccion edificio) {
        mostrarEdificio(edificio, new VBox(), new Label());
    }

    public void mostrarEdificio(EdificioEnConstruccion edificio, VBox opciones, Label error) {
        if (edificio.estaListo()) {
            mostrarEdificioListo(edificio.getConstruido(), opciones);
            return;
        }
        VistaUnidad vistaUnidad = new VistaUnidad(edificio);
        vistaUnidad.setPrefSize(150, 150);
        Label nombre = new Label("Edificio en construccion");
        Label turnosRestantes = new Label("Turnos restantes: " + edificio.turnosParaConstruir());

        Button botonAtras = new Button("Atras");
        botonAtras.setOnAction(e -> {
            contenedorPrincipal.update();
        });

        error.styleProperty().setValue("-fx-text-fill: red");

        this.getChildren().clear();
        this.getChildren().addAll(nombre, vistaUnidad, turnosRestantes, opciones, botonAtras, error);
    }

    public void mostrarBotonesEdificio(EdificioEnConstruccion edificio) {
        if (!edificio.estaListo()) {
            mostrarEdificio(edificio, new VBox(), new Label());
        }
        VBox opciones = new VBox();
        Label error = new Label();
        Unidad edificioListo = edificio.getConstruido();
        if (edificioListo instanceof Criadero) {
            Button botonZangano = new Button("Engendrar Zangano");
            botonZangano.setOnAction(e -> {
                try {
                    ((Criadero) edificioListo).engendrarZangano();
                    contenedorPrincipal.finalizarTurno();
                } catch (Exception ex) {
                    error.setText(ex.getMessage());
                }
            });

            Button botonZerling = new Button("Engendrar Zerling");
            botonZerling.setOnAction(e -> {
                try {
                    ((Criadero) edificioListo).engendrarZerling();
                    contenedorPrincipal.finalizarTurno();
                } catch (Exception ex) {
                    error.setText(ex.getMessage());
                }
            });

            Button botonAmo = new Button("Engendrar Amo Supremo");
            botonAmo.setOnAction(e -> {
                try {
                    ((Criadero) edificioListo).engendrarAmoSupremo();
                    contenedorPrincipal.finalizarTurno();
                } catch (Exception ex) {
                    error.setText(ex.getMessage());
                }
            });

            Button botonHidralisco = new Button("Engendrar Hidralisco");
            botonHidralisco.setOnAction(e -> {
                try {
                    ((Criadero) edificioListo).engendrarHidralisco();
                    contenedorPrincipal.finalizarTurno();
                } catch (Exception ex) {
                    error.setText(ex.getMessage());
                }
            });

            Button botonMutalisco = new Button("Engendrar Mutalisco");
            botonMutalisco.setOnAction(e -> {
                try {
                    ((Criadero) edificioListo).engendrarMutalisco();
                    contenedorPrincipal.finalizarTurno();
                } catch (Exception ex) {
                    error.setText(ex.getMessage());
                }
            });

        }

        mostrarEdificio(edificio, opciones, error);
    }

    public void mostrarEdificioListo(Unidad edificio, VBox opciones) {
        VistaUnidad vistaUnidad = new VistaUnidad(edificio);
        vistaUnidad.setPrefSize(150, 150);
        Label nombre = new Label(edificio.getClass().getSimpleName());
        Label vida = new Label("Vida: " + edificio.getVida() + "/" + edificio.getVidaMaxima());
        VBox contenedorVida = new VBox(vida);
        try {
            Label escudo = new Label("Escudo: " + ((EdificioProtoss) edificio).getEscudo() + "/" + ((EdificioProtoss) edificio).getEscudoMaximo());
            contenedorVida.getChildren().add(escudo);
        } catch (Exception e) {
        }

        Button botonAtras = new Button("Atras");
        botonAtras.setOnAction(e -> {
            contenedorPrincipal.update();
        });

        this.getChildren().clear();
        this.getChildren().addAll(nombre, vistaUnidad, contenedorVida, botonAtras);
    }

    public void mostrarInfoUnidad(Unidad unidad) {
    }

    public void mostrarInfoUnidadLista(Unidad unidad) {
    }

    public void mostrarBotonesUnidad(Unidad unidad) {
        mostrarInfoUnidad(unidad);
    }

}
