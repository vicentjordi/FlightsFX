package com.jordivicent.flightsfx.utils;
import javafx.scene.control.Alert;
import org.controlsfx.control.Notifications;

public class MessageUtils {
    public static void errorFilterCity(){
        Alert dialog = new Alert(Alert.AlertType.ERROR);

        dialog.setTitle("Error");
        dialog.setHeaderText("Error al filtrar");
        dialog.setContentText("Se debe seleccionar un vuelo para poder filtrar por ciudad");
        dialog.showAndWait();
    }

    public static void errorAddFlight(){
        Alert dialog = new Alert(Alert.AlertType.ERROR);

        dialog.setTitle("Error");
        dialog.setHeaderText("Error al añadir un vuelo");
        dialog.setContentText("No se puede dejar ningún campo vacio");
        dialog.showAndWait();
    }
    public static void formatError(){
        Alert dialog = new Alert(Alert.AlertType.ERROR);

        dialog.setTitle("Error");
        dialog.setHeaderText("Error al añadir un vuelo");
        dialog.setContentText("Error en el formato de un campo de text. Revise que se ha escrito como se pide");
        dialog.showAndWait();
    }
}
