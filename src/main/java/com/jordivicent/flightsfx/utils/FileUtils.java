package com.jordivicent.flightsfx.utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileUtils {
    //Cargar Vuelos
    public static ArrayList<String> loadFlights(){
        String nomFichero = "flights.txt";
        ArrayList<String> listflight = new ArrayList<String>();

        try(BufferedReader fbr = new BufferedReader(new FileReader(nomFichero))) {
            while(fbr.ready()){
                //Mientras que el documento flights.txt no este vacio se guardaran todas las líneas en la array listflight
                listflight.add(fbr.readLine());
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return listflight;
    }

    //Guardar Vuelos
}
