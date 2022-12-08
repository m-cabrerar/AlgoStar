package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.modelo.Inventario;
import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.unidades.Unidad;
import edu.fiuba.algo3.modelo.unidades.edificios.*;
import edu.fiuba.algo3.modelo.unidades.moviles.Mutalisco;
import edu.fiuba.algo3.modelo.unidades.moviles.UnidadMovil;
import edu.fiuba.algo3.modelo.unidades.moviles.UnidadMovilProtoss;
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
        if (!inventario.tieneRecursos(0,50) || !inventario.puedeConstruir(NexoMineral.getNivelDeConstruccionRequerido())) {
            botonNexoMineral.setDisable(true);
        }
        VBox contenedorNexoMineral = new VBox(botonNexoMineral, labelNexoMineral);

        Button botonPilon = new Button("Pilon");
        Label labelPilon = new Label("Costo: 100 Mineral");
        botonPilon.setOnAction(e -> {
            contenedorPrincipal.crearPilon(error);
        });
        if (!inventario.tieneRecursos(0,100) || !inventario.puedeConstruir(Pilon.getNivelDeConstruccionRequerido())) {
            botonPilon.setDisable(true);
        }
        VBox contenedorPilon = new VBox(botonPilon, labelPilon);

        Button botonAsimilador = new Button("Asimilador");
        Label labelAsimilador = new Label("Costo: 100 Mineral");
        botonAsimilador.setOnAction(e -> {
            contenedorPrincipal.crearAsimilador(error);
        });
        if (!inventario.tieneRecursos(0,100) || !inventario.puedeConstruir(Asimilador.getNivelDeConstruccionRequerido())) {
            botonAsimilador.setDisable(true);
        }
        VBox contenedorAsimilador = new VBox(botonAsimilador, labelAsimilador);

        Button botonAcceso = new Button("Acceso");
        Label labelAcceso = new Label("Costo: 150 Mineral");
        botonAcceso.setOnAction(e -> {
            contenedorPrincipal.crearAcceso(error);
        });
        if (!inventario.tieneRecursos(0,150) || !inventario.puedeConstruir(Acceso.getNivelDeConstruccionRequerido())) {
            botonAcceso.setDisable(true);
        }
        VBox contenedorAcceso = new VBox(botonAcceso, labelAcceso);

        Button botonPuertoEstelar = new Button("Puerto Estelar");
        Label labelPuertoEstelar = new Label("Costo: 150 Mineral, 150 Gas");
        botonPuertoEstelar.setOnAction(e -> {
            contenedorPrincipal.crearPuertoEstelar(error);
        });
        if (!inventario.tieneRecursos(150,150) || !inventario.puedeConstruir(PuertoEstelar.getNivelDeConstruccionRequerido())) {
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
        if (!inventario.tieneRecursos(0,100) || !inventario.puedeConstruir(Extractor.getNivelDeConstruccionRequerido())) {
            botonExtractor.setDisable(true);
        }
        VBox contenedorExtractor = new VBox(botonExtractor, labelExtractor);

        Button botonCriadero = new Button("Criadero");
        Label labelCriadero = new Label("Costo: 200 Mineral");
        botonCriadero.setOnAction(e -> {
            contenedorPrincipal.crearCriadero(error);
        });
        if (!inventario.tieneRecursos(0,200) || !inventario.puedeConstruir(Criadero.getNivelDeConstruccionRequerido())) {
            botonCriadero.setDisable(true);
        }
        VBox contenedorCriadero = new VBox(botonCriadero, labelCriadero);

        Button botonReservaDeReproduccion = new Button("Reserva De Reproduccion");
        Label labelReservaDeReproduccion = new Label("Costo: 150 Mineral");
        botonReservaDeReproduccion.setOnAction(e -> {
            contenedorPrincipal.crearReservaDeReproduccion(error);
        });
        if (!inventario.tieneRecursos(0,150) || !inventario.puedeConstruir(ReservaDeReproduccion.getNivelDeConstruccionRequerido())) {
            botonReservaDeReproduccion.setDisable(true);
        }
        VBox contenedorReservaDeReproduccion = new VBox(botonReservaDeReproduccion, labelReservaDeReproduccion);

        Button botonGuarida = new Button("Guarida");
        Label labelGuarida = new Label("Costo: 200 Mineral, 100 Gas");
        botonGuarida.setOnAction(e -> {
            contenedorPrincipal.crearGuarida(error);
        });
        if (!inventario.tieneRecursos(200,100) || !inventario.puedeConstruir(Guarida.getNivelDeConstruccionRequerido())) {
            botonGuarida.setDisable(true);
        }
        VBox contenedorGuarida = new VBox(botonGuarida, labelGuarida);

        Button botonEspiral = new Button("Espiral");
        Label labelEspiral = new Label("Costo: 150 Mineral, 100 Gas");
        botonEspiral.setOnAction(e -> {
            contenedorPrincipal.crearEspiral(error);
        });
        if (!inventario.tieneRecursos(150,100) || !inventario.puedeConstruir(Espiral.getNivelDeConstruccionRequerido())) {
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
            mostrarUnidadListo(edificio.getConstruido(), opciones, error);
            return;
        }
        VistaUnidad vistaUnidad = new VistaUnidad(edificio);
        vistaUnidad.setPrefSize(150, 150);
        Label nombre = new Label("Edificio en construccion");
        Label turnosRestantes = new Label("Turnos restantes: " + edificio.turnosParaConstruir());

        Button botonAtras = new Button("Atras");
        botonAtras.setOnAction(e -> {
            update();
        });

        this.getChildren().clear();
        this.getChildren().addAll(nombre, vistaUnidad, turnosRestantes, opciones, botonAtras, error);
    }

    public void mostrarBotonesEdificio(EdificioEnConstruccion edificio) {
        if (!edificio.estaListo()) {
            mostrarEdificio(edificio, new VBox(), new Label());
            return;
        }
        VBox opciones = new VBox();
        opciones.setSpacing(10);
        Label error = new Label();
        error.styleProperty().setValue("-fx-text-fill: red");
        Unidad edificioListo = edificio.getConstruido();
        if (edificioListo instanceof Criadero) {
            Button botonZangano = new Button("Engendrar Zangano");
            botonZangano.setOnAction(e -> {
                try {
                    ((Criadero) edificioListo).engendrarZangano();
                    error.setText("Creando zangano");
                    error.styleProperty().setValue("-fx-text-fill: green");
                } catch (Exception ex) {
                    error.setText(ex.getMessage());
                }
            });

            Button botonZerling = new Button("Engendrar Zerling");
            botonZerling.setOnAction(e -> {
                try {
                    ((Criadero) edificioListo).engendrarZerling();
                    error.setText("Creando zerling");
                    error.styleProperty().setValue("-fx-text-fill: green");
                } catch (Exception ex) {
                    error.setText(ex.getMessage());
                }
            });

            Button botonAmo = new Button("Engendrar Amo Supremo");
            botonAmo.setOnAction(e -> {
                try {
                    ((Criadero) edificioListo).engendrarAmoSupremo();
                    error.setText("Creando amo supremo");
                    error.styleProperty().setValue("-fx-text-fill: green");
                } catch (Exception ex) {
                    error.setText(ex.getMessage());
                }
            });

            Button botonHidralisco = new Button("Engendrar Hidralisco");
            botonHidralisco.setOnAction(e -> {
                try {
                    ((Criadero) edificioListo).engendrarHidralisco();
                    error.setText("Creando hidralisco");
                    error.styleProperty().setValue("-fx-text-fill: green");
                } catch (Exception ex) {
                    error.setText(ex.getMessage());
                }
            });

            Button botonMutalisco = new Button("Engendrar Mutalisco");
            botonMutalisco.setOnAction(e -> {
                try {
                    ((Criadero) edificioListo).engendrarMutalisco();
                    error.setText("Creando mutalisco");
                    error.styleProperty().setValue("-fx-text-fill: green");
                } catch (Exception ex) {
                    error.setText(ex.getMessage());
                }
            });
            opciones.getChildren().addAll(botonZangano, botonZerling, botonAmo, botonHidralisco, botonMutalisco);
        } else if (edificioListo instanceof Acceso) {
            Button botonZealot = new Button("Engendrar Zealot");
            botonZealot.setOnAction(e -> {
                try {
                    ((Acceso) edificioListo).engendrarZealot();
                    error.setText("Creando zealot");
                    error.styleProperty().setValue("-fx-text-fill: green");
                } catch (Exception ex) {
                    error.setText(ex.getMessage());
                }
            });

            Button botonDragon = new Button("Engendrar Dragon");
            botonDragon.setOnAction(e -> {
                try {
                    ((Acceso) edificioListo).engendrarDragon();
                    error.setText("Creando dragon");
                    error.styleProperty().setValue("-fx-text-fill: green");
                } catch (Exception ex) {
                    error.setText(ex.getMessage());
                }
            });
            opciones.getChildren().addAll(botonZealot, botonDragon);
        } else if (edificioListo instanceof PuertoEstelar) {
            Button botonScout = new Button("Engendrar Scout");
            botonScout.setOnAction(e -> {
                try {
                    ((PuertoEstelar) edificioListo).engendrarScout();
                    error.setText("Creando scout");
                    error.styleProperty().setValue("-fx-text-fill: green");
                } catch (Exception ex) {
                    error.setText(ex.getMessage());
                }
            });
            opciones.getChildren().add(botonScout);
        }
        mostrarEdificio(edificio, opciones, error);
    }

    public void mostrarUnidadListo(Unidad unidad, VBox opciones, Label error) {
        VistaUnidad vistaUnidad = new VistaUnidad(unidad);
        vistaUnidad.setPrefSize(150, 150);
        Label nombre = new Label(unidad.getClass().getSimpleName());
        Label vida = new Label("Vida: " + unidad.getVida() + "/" + unidad.getVidaMaxima());
        VBox contenedorVida = new VBox(vida);
        try {
            Label escudo = new Label("Escudo: " + ((EdificioProtoss) unidad).getEscudo() + "/" + ((EdificioProtoss) unidad).getEscudoMaximo());
            contenedorVida.getChildren().add(escudo);
        } catch (Exception e) {
        }
        try {
            Label escudo = new Label("Escudo: " + ((UnidadMovilProtoss) unidad).getEscudo() + "/" + ((UnidadMovilProtoss) unidad).getEscudoMaximo());
        }
        catch (Exception e) {
        }

        Button botonAtras = new Button("Atras");
        botonAtras.setOnAction(e -> {
            update();
        });

        this.getChildren().clear();
        this.getChildren().addAll(nombre, vistaUnidad, contenedorVida, opciones, botonAtras, error);
    }

    public void mostrarInfoUnidad(Unidad unidad) {
        mostrarUnidadListo(unidad, new VBox(), new Label());
    }

    public void mostrarBotonesUnidad(Unidad unidad) {
        mostrarInfoUnidad(unidad);
        VBox opciones = new VBox();
        opciones.setSpacing(10);
        Label error = new Label();
        error.styleProperty().setValue("-fx-text-fill: red");

        Button botonMover = new Button("Mover");
        botonMover.setOnAction(e -> {
            try {
                contenedorPrincipal.moverUnidad((UnidadMovil) unidad, error);
            } catch (Exception ex) {
            }
        });
        Button botonAtacar = new Button("Atacar");
        botonAtacar.setOnAction(e -> {
            try {
                contenedorPrincipal.unidadAtacar((UnidadMovil) unidad, error);
            } catch (Exception ex) {
                error.setText(ex.getMessage());
            }
        });
        opciones.getChildren().addAll(botonMover, botonAtacar);

        if (unidad instanceof Mutalisco) {
            Button botonGuardian = new Button("Evolucionar a Guardian");
            botonGuardian.setOnAction(e -> {
                try {
                    ((Mutalisco) unidad).evolucionarAGuardian();
                    error.setText("Evolucionando a guardian");
                    error.styleProperty().setValue("-fx-text-fill: green");
                    contenedorPrincipal.updateEdificios();
                } catch (Exception ex) {
                    error.setText(ex.getMessage());
                }
            });
            Button botonDevorador = new Button("Evolucionar a Devorador");
            botonDevorador.setOnAction(e -> {
                try {
                    ((Mutalisco) unidad).evolucionarADevorador();
                    error.setText("Evolucionando a devorador");
                    error.styleProperty().setValue("-fx-text-fill: green");
                    contenedorPrincipal.updateEdificios();
                } catch (Exception ex) {
                    error.setText(ex.getMessage());
                }
            });
            opciones.getChildren().addAll(botonGuardian, botonDevorador);
        }

        mostrarUnidadListo(unidad, opciones, error);
    }

}
