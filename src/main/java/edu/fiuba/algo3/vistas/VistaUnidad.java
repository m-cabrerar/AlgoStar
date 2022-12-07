package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.modelo.unidades.Unidad;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

public class VistaUnidad extends StackPane {
    public VistaUnidad(Unidad unidad) {
        this.setPrefSize(50, 50);
        Image image;
        System.out.println(unidad.getClass().getSimpleName());
        switch (unidad.getClass().getSimpleName()) {
            case "EdificioEnConstruccion":
                image = new Image("file:src/main/java/edu/fiuba/algo3/vistas/img/edificios/edificioEnConstruccion.gif");
                break;
            case "Acceso":
                image = new Image("file:src/main/java/edu/fiuba/algo3/vistas/img/edificios/acceso.gif");
                break;
            case "Asimilador":
                image = new Image("file:src/main/java/edu/fiuba/algo3/vistas/img/edificios/asimilador.gif");
                break;
            case "Criadero":
                image = new Image("file:src/main/java/edu/fiuba/algo3/vistas/img/edificios/criadero.gif");
                break;
            case "Espiral":
                image = new Image("file:src/main/java/edu/fiuba/algo3/vistas/img/edificios/espiral.gif");
                break;
            case "Extractor":
                image = new Image("file:src/main/java/edu/fiuba/algo3/vistas/img/edificios/extractor.gif");
                break;
            case "Guarida":
                image = new Image("file:src/main/java/edu/fiuba/algo3/vistas/img/edificios/guarida.gif");
                break;
            case "NexoMineral":
                image = new Image("file:src/main/java/edu/fiuba/algo3/vistas/img/edificios/nexoMineral.gif");
                break;
            case "Pilon":
                image = new Image("file:src/main/java/edu/fiuba/algo3/vistas/img/edificios/pilon.gif");
                break;
            case "PuertoEstelar":
                image = new Image("file:src/main/java/edu/fiuba/algo3/vistas/img/edificios/puertoEstelar.gif");
                break;
            case "ReservaDeReproduccion":
                image = new Image("file:src/main/java/edu/fiuba/algo3/vistas/img/edificios/reservaDeReproduccion.gif");
                break;
            case "UnidadEnEvolucion":
                image = new Image("file:src/main/java/edu/fiuba/algo3/vistas/img/unidades/unidadEnEvolucion.gif");
                break;
            case "AmoSupremo":
                image = new Image("file:src/main/java/edu/fiuba/algo3/vistas/img/unidades/amoSupremo.gif");
                break;
            case "Devorador":
                image = new Image("file:src/main/java/edu/fiuba/algo3/vistas/img/unidades/devorador.gif");
                break;
            case "Dragon":
                image = new Image("file:src/main/java/edu/fiuba/algo3/vistas/img/unidades/dragon.gif");
                break;
            case "Guardian":
                image = new Image("file:src/main/java/edu/fiuba/algo3/vistas/img/unidades/guardian.gif");
                break;
            case "Hidralisco":
                image = new Image("file:src/main/java/edu/fiuba/algo3/vistas/img/unidades/hidralisco.gif");
                break;
            case "Mutalisco":
                image = new Image("file:src/main/java/edu/fiuba/algo3/vistas/img/unidades/mutalisco.gif");
                break;
            case "Scout":
                image = new Image("file:src/main/java/edu/fiuba/algo3/vistas/img/unidades/scout.gif");
                break;
            case "Zealot":
                image = new Image("file:src/main/java/edu/fiuba/algo3/vistas/img/unidades/zealot.gif");
                break;
            case "Zerling":
                image = new Image("file:src/main/java/edu/fiuba/algo3/vistas/img/unidades/zerling.gif");
                break;
            default:
                image = new Image("file:src/main/java/edu/fiuba/algo3/vistas/img/unknown.gif");
                break;
        }
        BackgroundSize backgroundSize = new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, false, true);
        this.setBackground(new Background(new BackgroundImage(image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize)));
    }
}
