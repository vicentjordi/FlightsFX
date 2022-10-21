package com.jordivicent.flightsfx;

import com.jordivicent.flightsfx.model.Flight;
import com.jordivicent.flightsfx.utils.FileUtils;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class FXMLMainViewController {

    //TableView
    @FXML
    private TableView<Flight> tvFlights;
    @FXML
    private TableColumn<Flight, LocalTime> colDuration;
    @FXML
    private TableColumn<Flight, LocalDateTime> colDeparture;
    @FXML
    private TableColumn<Flight, String> colDestination;
    @FXML
    private TableColumn<Flight, String> colFlightNumber;

    //TextFields
    @FXML
    private TextField tfFlightNumber;
    @FXML
    private TextField tfDestination;
    @FXML
    private TextField tfDeparture;
    @FXML
    private TextField tfDuration;

    //ChoiceBox
    @FXML
    private ChoiceBox<String> cbFormFilter;

    //Button
    @FXML
    private Button btnAdd;
    @FXML
    private Button btnDelete;
    @FXML
    private Button btnFilter;
    public void initialize(){
        //Anyade las opciones para el ChoiceBox
        cbFormFilter.setItems(
                FXCollections.observableArrayList(
                    "Show all Flights", "Show all flights to currently selected city",
                        "Show long flights", "Show next 5 flights", "Show flight duration average"
                )
        );

        //Assignar las columnas en la tabla
        colFlightNumber.setCellValueFactory(new PropertyValueFactory<Flight, String>("flightNumber"));
        colDestination.setCellValueFactory(new PropertyValueFactory<Flight, String>("destination"));
        colDeparture.setCellValueFactory(new PropertyValueFactory<Flight, LocalDateTime>("departure"));
        colDuration.setCellValueFactory(new PropertyValueFactory<Flight, LocalTime>("duration"));

        //Cargar datos Tabla
        tvFlights.setItems(getFlight());

    }


    public ObservableList<Flight> getFlight(){
        ObservableList<Flight> flight = FXCollections.observableArrayList();
        String Flight;
        String[] colFlight;

        // DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        // DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("HH:mm");
        for (int i = 0; i < FileUtils.loadFlights().size(); i++){
            //Separar el ArrayList de FileUtils en diferentes Strings
            Flight = FileUtils.loadFlights().get(i);

            //Separar Las strings usando como spliter el ";" y guardarlo en una array
            colFlight = Flight.split(";");

            //Anyadir a la ObservableList los valores separados
            // flight.add(new Flight(colFlight[0], colFlight[1], LocalDateTime.parse(colFlight[2], formatter), LocalTime.parse(colFlight[3], formatter1)));
        }
        return flight;
    }

}