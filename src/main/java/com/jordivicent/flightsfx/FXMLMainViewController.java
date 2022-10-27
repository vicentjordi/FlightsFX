package com.jordivicent.flightsfx;

import com.jordivicent.flightsfx.model.Flight;
import com.jordivicent.flightsfx.utils.FileUtils;
import com.jordivicent.flightsfx.utils.MessageUtils;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

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
        //Añade las opciones para el ChoiceBox
        loadFormFilter();
        //Añade los datos de la tabla
        loadDataTable();
    }
    private void loadFormFilter(){
        cbFormFilter.setItems(
                FXCollections.observableArrayList(
                        "Show all Flights", "Show all flights to currently selected city",
                        "Show long flights", "Show next 5 flights", "Show flight duration average"
                )
        );
    }
    private void loadDataTable(){
        ObservableList<Flight> flights;

        //Cargar los datos del fichero flights.txt
        flights = FXCollections.observableArrayList(FileUtils.loadFlights());

        //Assignar las columnas en la tabla
        colFlightNumber.setCellValueFactory(new PropertyValueFactory<Flight, String>("numFlight"));
        colDestination.setCellValueFactory(new PropertyValueFactory<Flight, String>("destination"));
        colDeparture.setCellValueFactory(new PropertyValueFactory<Flight, LocalDateTime>("dateExit"));
        colDuration.setCellValueFactory(new PropertyValueFactory<Flight, LocalTime>("duration"));

        //Cargar datos Tabla
        tvFlights.setItems(flights);
    }
    public static List<Flight> filterFlights(List<Flight> srcFlight, Predicate<Flight> predFlight){
        List<Flight> flights = new ArrayList<>();

        for(Flight ft: srcFlight){
            if(predFlight.test(ft)){
                    flights.add(ft);
            }
        }
        return flights;
    }
    @FXML
    public void btnFilterAction(ActionEvent actionEvent) {
        int option = cbFormFilter.getSelectionModel().getSelectedIndex();
        switch (option){
            case 0:
                allFlights();
                break;
            case 1:
                selectedCity();
                break;
            case 2:
                longFlights();
                break;
            case 3:
                nextFlights();
                break;
            case 4:
                durationAverage();
                break;
            default:
                System.out.println("Seleccione una operación válida");
        }
    }
    private void allFlights(){
        tvFlights.getItems().clear();
        loadDataTable();
    }
    private void selectedCity(){
        //Crea una nueva Observable list para el filtro por ciudad que guardara y mostrara todos los vuelos a la misma ciudad
        ObservableList<Flight> filterCity;
        //Crea una observable List para obtener la ciudad del vuelo seleccionado y poder filtrar por esa ciudad
        ObservableList<Flight> city;

        try{
            city = tvFlights.getSelectionModel().getSelectedItems();

            //Crea una nueva lista y anyade todos los items de la lista de FIleUtils que su destino sea el mismo que el seleccionado;
            List<Flight> cityFlight = filterFlights(FileUtils.loadFlights(), ft -> ft.getDestination().equals(city.get(0).getDestination()));
            filterCity = FXCollections.observableArrayList(cityFlight);

            //Limpiamos la tabla
            tvFlights.getItems().clear();
            //Mostramos en la tabla los nuevos valores
            tvFlights.setItems(filterCity);

        }catch (Exception e){
            MessageUtils.errorFilterCity();
        }
    }

    private void longFlights(){
        //Crea Variable para comparar con la duración de los vuelos.
        DateTimeFormatter formatDurat = DateTimeFormatter.ofPattern("H:mm");
        LocalTime duration = LocalTime.parse("3:00", formatDurat);

        //Crea una nueva Observable list para el filtro por duración.
        ObservableList<Flight> filterLong;

        //Compara los vuelos y en caso de que su duración sea superior a las 3h se añadirá la lista.
        List<Flight> longFlights = filterFlights(FileUtils.loadFlights(), ft -> ft.getDuration().isAfter(duration));
        filterLong = FXCollections.observableArrayList(longFlights);

        //Limpiamos la tabla
        tvFlights.getItems().clear();
        //Mostramos en la tabla los nuevos valores
        tvFlights.setItems(filterLong);
        //Superior a 3 hores
    }

    private void nextFlights(){
        //Crea Variable para obtener fecha actual y poder comprar con los vuelos.
        LocalDateTime now = LocalDateTime.now();

        //Crea una nueva Observable list para filtrar los próximos 5 vuelos.
        ObservableList<Flight> filterNext;

        List<Flight> nextFlight = filterFlights(FileUtils.loadFlights(), ft -> ft.getDateExit().isAfter(now));

        Collections.sort(nextFlight, new Comparator<Flight>() {
            @Override
            public int compare(Flight o1, Flight o2) {
                return o1.getDateExit().compareTo(o2.getDateExit());
            }
        });

        nextFlight = nextFlight.stream().limit(5).collect(Collectors.toList());

        filterNext = FXCollections.observableArrayList(nextFlight);


        tvFlights.getItems().clear();

        tvFlights.setItems(filterNext);
    }

    private void durationAverage(){
        List<Flight> flights = FileUtils.loadFlights();

        //OptionalDouble avgFlight = flights.stream();

        Alert dialog = new Alert(Alert.AlertType.INFORMATION);
        dialog.setTitle("Duration Average");
        dialog.setHeaderText("Average duration of all flights");
        dialog.setContentText("Average: ");
        dialog.showAndWait();
    }
    @FXML
    public void btnDeleteAction(ActionEvent actionEvent) {
    }
    @FXML
    public void btnAddAction(ActionEvent actionEvent) {
    }
}