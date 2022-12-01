package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.controlador.BotonAcercaDeEventHandler;
import edu.fiuba.algo3.controlador.BotonComoJugarEventHandler;
import edu.fiuba.algo3.controlador.BotonPantallaCompletaHandler;
import edu.fiuba.algo3.controlador.BotonSalirEventHandler;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

public class BarraMenu extends MenuBar {

    MenuItem opcionPantallaCompleta = new MenuItem("Pantalla completa");

    public BarraMenu(Stage stage) {
        Menu menuJuego = new Menu("Juego");
        Menu menuVer = new Menu("Ver");
        Menu menuAyuda = new Menu("Ayuda");

        MenuItem opcionSalir = new MenuItem("Salir");
        MenuItem opcionAcercaDe = new MenuItem("Acerca de");
        MenuItem opcionComoJugar = new MenuItem("Como jugar");

        opcionSalir.setOnAction(new BotonSalirEventHandler(stage));
        opcionAcercaDe.setOnAction(new BotonAcercaDeEventHandler());
        opcionComoJugar.setOnAction(new BotonComoJugarEventHandler());
        opcionPantallaCompleta.setOnAction(new BotonPantallaCompletaHandler(stage, opcionPantallaCompleta));

        menuJuego.getItems().addAll(opcionSalir);
        menuVer.getItems().addAll(opcionPantallaCompleta);
        menuAyuda.getItems().addAll(opcionAcercaDe, opcionComoJugar);

        this.getMenus().addAll(menuJuego, menuVer, menuAyuda);
    }

}
