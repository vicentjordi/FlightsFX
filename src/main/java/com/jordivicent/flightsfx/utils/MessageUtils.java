package com.jordivicent.flightsfx.utils;
import javafx.scene.control.Alert;
import org.controlsfx.control.Notifications;

public class MessageUtils {
    public  static void errorFilterButton(){
        Alert dialog = new Alert(Alert.AlertType.ERROR);

        dialog.setTitle("Error");
        dialog.setHeaderText("Filter Error");
        dialog.setContentText("Select an option to filter");
        dialog.showAndWait();
    }
    public static void errorFilterCity(){
        Alert dialog = new Alert(Alert.AlertType.ERROR);

        dialog.setTitle("Error");
        dialog.setHeaderText("Filter error");
        dialog.setContentText("Select a fly to filter the city");
        dialog.showAndWait();
    }

    public static void errorAddFlight(){
        Alert dialog = new Alert(Alert.AlertType.ERROR);

        dialog.setTitle("Error");
        dialog.setHeaderText("Add error");
        dialog.setContentText("All fields must be filled");
        dialog.showAndWait();
    }
    public static void formatError(){
        Alert dialog = new Alert(Alert.AlertType.ERROR);

        dialog.setTitle("Error");
        dialog.setHeaderText("Add error");
        dialog.setContentText("Format error. Please ensure that you put the correct format in the fields");
        dialog.showAndWait();
    }
}
