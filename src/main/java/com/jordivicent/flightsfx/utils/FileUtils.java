package com.jordivicent.flightsfx.utils;

import com.jordivicent.flightsfx.model.Flight;

import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

public class FileUtils {
    //Cargar Vuelos
    public static List<Flight> loadFlights(){
        DateTimeFormatter formatDepart = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        DateTimeFormatter formatDurat = DateTimeFormatter.ofPattern("H:mm");

        try{
            return Files.lines(Paths.get("flights.txt"))
                    .map(line -> new Flight(line.split(";")[0],
                            line.split(";")[1], LocalDateTime.parse(line.split(";")[2], formatDepart),
                            LocalTime.parse(line.split(";")[3], formatDurat)))
                    .collect(Collectors.toList());
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }

    //Guardar Vuelos
    public static void saveFlights(List<Flight> flights){
        try(PrintWriter pw = new PrintWriter("flights.txt")){
            flights.stream().forEach(f-> pw.println(f.toString()));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
