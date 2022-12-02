package edu.fiuba.algo3.controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

public class BotonPantallaCompletaHandler implements EventHandler<ActionEvent> {

    private final Stage stage;
    private MenuItem opcionPantallaCompleta;

    public BotonPantallaCompletaHandler(Stage stage, MenuItem opcionPantallaCompleta) {
        this.stage = stage;
        this.opcionPantallaCompleta = opcionPantallaCompleta;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        if (stage.isFullScreen()) {
            stage.hide();
            stage.setFullScreen(false);
            stage.show();
            opcionPantallaCompleta.setText("Pantalla completa");
        } else {
            stage.hide();
            stage.setFullScreen(true);
            stage.show();
            opcionPantallaCompleta.setText("Salir de pantalla completa");
        }
    }
}
