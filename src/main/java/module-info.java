module com.moller {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires org.apache.commons.imaging;
    requires java.desktop;
    requires javafx.base;

    opens com.moller to javafx.fxml;

    exports com.moller;
}
