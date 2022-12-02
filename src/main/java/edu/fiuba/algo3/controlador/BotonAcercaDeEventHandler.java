package edu.fiuba.algo3.controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;

public class BotonAcercaDeEventHandler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent actionEvent) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Acerca de");
            alert.setHeaderText("AlgoStar");
            alert.setContentText("AlgoStar es un juego de estrategia por turnos, basado en la construcción y administración de un imperio.");
            alert.showAndWait();
        }
}
