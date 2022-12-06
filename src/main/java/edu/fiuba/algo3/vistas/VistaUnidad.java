package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.modelo.unidades.Unidad;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

public class VistaUnidad extends StackPane {
    public VistaUnidad(Unidad unidad) {
        this.setPrefSize(50, 50);
        Image image;
        switch (unidad.getClass().getSimpleName()) {
            case "Acceso":
                image = new Image("file:src/main/java/edu/fiuba/algo3/vistas/img/edificios/acceso.png");
                break;
            case "Asimilador":
                image = new Image("file:src/main/java/edu/fiuba/algo3/vistas/img/edificios/asimilador.png");
                break;
            case "Criadero":
                image = new Image("file:src/main/java/edu/fiuba/algo3/vistas/img/edificios/criadero.png");
                break;
            case "Espiral":
                image = new Image("file:src/main/java/edu/fiuba/algo3/vistas/img/edificios/espiral.png");
                break;
            case "Extractor":
                image = new Image("file:src/main/java/edu/fiuba/algo3/vistas/img/edificios/extractor.png");
                break;
            case "Guarida":
                image = new Image("file:src/main/java/edu/fiuba/algo3/vistas/img/edificios/guarida.png");
                break;
            case "NexoMineral":
                image = new Image("file:src/main/java/edu/fiuba/algo3/vistas/img/edificios/nexoMineral.png");
                break;
            case "Pilon":
                image = new Image("file:src/main/java/edu/fiuba/algo3/vistas/img/edificios/pilon.png");
                break;
            case "PuertoEstelar":
                image = new Image("file:src/main/java/edu/fiuba/algo3/vistas/img/edificios/puertoEstelar.png");
                break;
            case "ReservaDeReproduccion":
                image = new Image("file:src/main/java/edu/fiuba/algo3/vistas/img/edificios/reservaDeReproduccion.png");
                break;
            case "UnidadEnEvolucion":
                image = new Image("file:src/main/java/edu/fiuba/algo3/vistas/img/unidades/unidadEnEvolucion.png");
                break;
            case "AmoSupremo":
                image = new Image("file:src/main/java/edu/fiuba/algo3/vistas/img/unidades/amoSupremo.png");
                break;
            case "Devorador":
                image = new Image("file:src/main/java/edu/fiuba/algo3/vistas/img/unidades/devorador.png");
                break;
            case "Dragon":
                image = new Image("file:src/main/java/edu/fiuba/algo3/vistas/img/unidades/dragon.png");
                break;
            case "Guardian":
                image = new Image("file:src/main/java/edu/fiuba/algo3/vistas/img/unidades/guardian.png");
                break;
            case "Hidralisco":
                image = new Image("file:src/main/java/edu/fiuba/algo3/vistas/img/unidades/hidralisco.png");
                break;
            case "Mutalisco":
                image = new Image("file:src/main/java/edu/fiuba/algo3/vistas/img/unidades/mutalisco.png");
                break;
            case "Scout":
                image = new Image("file:src/main/java/edu/fiuba/algo3/vistas/img/unidades/scout.png");
                break;
            case "Zealot":
                image = new Image("file:src/main/java/edu/fiuba/algo3/vistas/img/unidades/zealot.png");
                break;
            case "Zerling":
                image = new Image("file:src/main/java/edu/fiuba/algo3/vistas/img/unidades/zerling.png");
                break;
            default:
                image = new Image("file:src/main/java/edu/fiuba/algo3/vistas/img/unknown.png");
                break;
        }
        BackgroundSize backgroundSize = new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, false, true);
        this.setBackground(new Background(new BackgroundImage(image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize)));
    }
}
