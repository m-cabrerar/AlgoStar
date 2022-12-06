package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.modelo.Inventario;
import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.unidades.edificios.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class Botonera extends VBox {
    private final Juego juego;
    private final ContenedorPrincipal contenedorPrincipal;
    private Jugador[] jugadores;
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

        Button botonNexoMineral = new Button("Nexo Mineral");
        Label labelNexoMineral = new Label("Costo: 50 Mineral");
        botonNexoMineral.setOnAction(e -> {
        });
        if (!inventario.tieneRecursos(0,50) || !inventario.puedeConstruir(NexoMineral.getNivelDeConstruccion())) {
            System.out.println("No se puede construir. recusos insuficientes:"+ !inventario.tieneRecursos(50, 0) + " nivel insuficiente: " + !inventario.puedeConstruir(NexoMineral.getNivelDeConstruccion()));
            botonNexoMineral.setDisable(true);
        }
        VBox contenedorNexoMineral = new VBox(botonNexoMineral, labelNexoMineral);

        Button botonPilon = new Button("Pilon");
        Label labelPilon = new Label("Costo: 100 Mineral");
        botonPilon.setOnAction(e -> {
        });
        if (!inventario.tieneRecursos(0,100) || !inventario.puedeConstruir(Pilon.getNivelDeConstruccion())) {
            botonPilon.setDisable(true);
        }
        VBox contenedorPilon = new VBox(botonPilon, labelPilon);

        Button botonAsimilador = new Button("Asimilador");
        Label labelAsimilador = new Label("Costo: 100 Mineral");
        botonAsimilador.setOnAction(e -> {
        });
        if (!inventario.tieneRecursos(0,100) || !inventario.puedeConstruir(Asimilador.getNivelDeConstruccion())) {
            botonAsimilador.setDisable(true);
        }
        VBox contenedorAsimilador = new VBox(botonAsimilador, labelAsimilador);

        Button botonAcceso = new Button("Acceso");
        Label labelAcceso = new Label("Costo: 150 Mineral");
        botonAcceso.setOnAction(e -> {
        });
        if (!inventario.tieneRecursos(0,150) || !inventario.puedeConstruir(Acceso.getNivelDeConstruccion())) {
            botonAcceso.setDisable(true);
        }
        VBox contenedorAcceso = new VBox(botonAcceso, labelAcceso);

        Button botonPuertoEstelar = new Button("Puerto Estelar");
        Label labelPuertoEstelar = new Label("Costo: 150 Mineral, 150 Gas");
        botonPuertoEstelar.setOnAction(e -> {
        });
        if (!inventario.tieneRecursos(150,150) || !inventario.puedeConstruir(PuertoEstelar.getNivelDeConstruccion())) {
            botonPuertoEstelar.setDisable(true);
        }
        VBox contenedorPuertoEstelar = new VBox(botonPuertoEstelar, labelPuertoEstelar);

        this.getChildren().addAll(new VBox(), contenedorPilon, contenedorAsimilador, contenedorAcceso, contenedorPuertoEstelar);
        this.setSpacing(15);
    }
    public void updateZerg(Jugador jugadorActual) {
        Inventario inventario = jugadorActual.getInventario();

        Button botonExtractor = new Button("Extractor");
        Label labelExtractor = new Label("Costo: 100 Mineral");
        botonExtractor.setOnAction(e -> {
        });
        if (!inventario.tieneRecursos(0,100) || !inventario.puedeConstruir(Extractor.getNivelDeConstruccion())) {
            botonExtractor.setDisable(true);
        }
        VBox contenedorExtractor = new VBox(botonExtractor, labelExtractor);

        Button botonCriadero = new Button("Criadero");
        Label labelCriadero = new Label("Costo: 200 Mineral");
        botonCriadero.setOnAction(e -> {
        });
        if (!inventario.tieneRecursos(0,200) || !inventario.puedeConstruir(Criadero.getNivelDeConstruccion())) {
            botonCriadero.setDisable(true);
        }
        VBox contenedorCriadero = new VBox(botonCriadero, labelCriadero);

        Button botonReservaDeReproduccion = new Button("Reserva De Reproduccion");
        Label labelReservaDeReproduccion = new Label("Costo: 150 Mineral");
        botonReservaDeReproduccion.setOnAction(e -> {
        });
        if (!inventario.tieneRecursos(0,150) || !inventario.puedeConstruir(ReservaDeReproduccion.getNivelDeConstruccion())) {
            botonReservaDeReproduccion.setDisable(true);
        }
        VBox contenedorReservaDeReproduccion = new VBox(botonReservaDeReproduccion, labelReservaDeReproduccion);

        Button botonGuarida = new Button("Guarida");
        Label labelGuarida = new Label("Costo: 200 Mineral, 100 Gas");
        botonGuarida.setOnAction(e -> {
        });
        if (!inventario.tieneRecursos(200,100) || !inventario.puedeConstruir(Guarida.getNivelDeConstruccion())) {
            botonGuarida.setDisable(true);
        }
        VBox contenedorGuarida = new VBox(botonGuarida, labelGuarida);

        Button botonEspiral = new Button("Espiral");
        Label labelEspiral = new Label("Costo: 150 Mineral, 100 Gas");
        botonEspiral.setOnAction(e -> {
        });
        if (!inventario.tieneRecursos(150,100) || !inventario.puedeConstruir(Espiral.getNivelDeConstruccion())) {
            botonEspiral.setDisable(true);
        }
        VBox contenedorEspiral = new VBox(botonEspiral, labelEspiral);

        this.getChildren().addAll(new VBox(), contenedorExtractor, contenedorCriadero, contenedorReservaDeReproduccion, contenedorGuarida, contenedorEspiral);
        this.setSpacing(15);
    }
}
