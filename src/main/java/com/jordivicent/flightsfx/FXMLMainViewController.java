package com.jordivicent.flightsfx;

import com.jordivicent.flightsfx.model.Flight;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class FXMLMainViewController {
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
    @FXML
    private TextField tfFlightNumber;
    @FXML
    private TextField tfDestination;
    @FXML
    private TextField tfDeparture;
    @FXML
    private TextField tfDuration;
    @FXML
    private ChoiceBox<String> cbFormFilter;

    public void initialize(){
        cbFormFilter.setItems(
                FXCollections.observableArrayList(
                    "Show all Flights", "Show all flights to currently selected city",
                        "Show long flights", "Show next 5 flights", "Show flight duration average"
                )
        );

    }
    @FXML
    private Button btnAdd;
    @FXML
    private Button btnDelete;
    @FXML
    private Button btnFilter;
}