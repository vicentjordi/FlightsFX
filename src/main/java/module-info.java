module com.jordivicent.flightsfx {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens com.jordivicent.flightsfx to javafx.fxml;
    exports com.jordivicent.flightsfx;
}