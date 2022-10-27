package com.jordivicent.flightsfx.utils;

import org.controlsfx.control.Notifications;

public class MessageUtils {
    public static void errorFilterCity(){
        Notifications.create().title("Error!").text("Se debe seleccionar un vuelo para poder filtrar por ciudad").showError();
    }
}
