package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.modelo.Casillero;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

public class VistaCasillero extends StackPane {
    public VistaCasillero(Casillero casillero) {
        this.setPrefSize(50, 50);
        Image imagen;
        System.out.println(casillero.getTipo().getClass().getSimpleName());
        if (casillero.getTipo().getClass().getSimpleName().equals("CasilleroEspacial")) {
            imagen = new Image("file:src/main/java/edu/fiuba/algo3/vistas/img/casilleros/especial.png");
        } else if (casillero.getTipo().getClass().getSimpleName().equals("Moho")) {
            imagen = new Image("file:src/main/java/edu/fiuba/algo3/vistas/img/casilleros/moho.png");
        } else if (casillero.getTipo().getClass().getSimpleName().equals("NodoGas")) {
            imagen = new Image("file:src/main/java/edu/fiuba/algo3/vistas/img/casilleros/nodoGas.png");
        } else if (casillero.getTipo().getClass().getSimpleName().equals("NodoMineral")) {
            imagen = new Image("file:src/main/java/edu/fiuba/algo3/vistas/img/casilleros/nodoMineral.png");
        } else {
            imagen = new Image("file:src/main/java/edu/fiuba/algo3/vistas/img/casilleros/vacio.png");
        }
        BackgroundSize backgroundSize = new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, false, true);
        this.setBackground(new Background(new BackgroundImage(imagen, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize)));
    }
}

