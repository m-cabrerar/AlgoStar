package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.modelo.casillero.Casillero;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

public class VistaCasillero extends StackPane {
    public VistaCasillero(Casillero casillero) {
        this.setPrefSize(50, 50);
        Image imagen;
        switch (casillero.getTipo().getClass().getSimpleName()) {
            case "CasilleroEspacial":
                imagen = new Image("file:src/main/java/edu/fiuba/algo3/vistas/img/casilleros/especial.png");
                break;
            case "Moho":
                imagen = new Image("file:src/main/java/edu/fiuba/algo3/vistas/img/casilleros/moho.png");
                break;
            case "NodoGas":
                imagen = new Image("file:src/main/java/edu/fiuba/algo3/vistas/img/casilleros/nodoGas.png");
                break;
            case "NodoMineral":
                imagen = new Image("file:src/main/java/edu/fiuba/algo3/vistas/img/casilleros/nodoMineral.png");
                break;
            default:
                imagen = new Image("file:src/main/java/edu/fiuba/algo3/vistas/img/casilleros/vacio.png");
                break;
        }
        BackgroundSize backgroundSize = new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, false, true);
        this.setBackground(new Background(new BackgroundImage(imagen, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize)));
    }
}

