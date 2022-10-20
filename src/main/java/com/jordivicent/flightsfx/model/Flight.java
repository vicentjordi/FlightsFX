package com.jordivicent.flightsfx.model;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class Flight {
    private String numFlight;
    private String destination;
    private LocalDateTime dateExit;
    private LocalTime duration;

    ///Constructor Número de Vuelo
    public Flight(String numFlight) {
        this.numFlight = numFlight;
    }

    //Constructor atributos
    public Flight(String destination, LocalDateTime dateExit, LocalTime duration){
        this.destination = destination;
        this.dateExit = dateExit;
        this.duration = duration;
    }

    //Getters & Setters
    public String getNumFlight() {
        return numFlight;
    }

    public void setNumFlight(String numFlight) {
        this.numFlight = numFlight;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public LocalDateTime getDateExit() {
        return dateExit;
    }

    public void setDateExit(LocalDateTime dateExit) {
        this.dateExit = dateExit;
    }

    public LocalTime getDuration() {
        return duration;
    }

    public void setDuration(LocalTime duration) {
        this.duration = duration;
    }
}
