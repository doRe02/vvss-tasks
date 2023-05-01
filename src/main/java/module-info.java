module tasks {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.controlsfx.controls;
    requires log4j;


    opens tasks.model to javafx.base;
    exports tasks.model;
    opens tasks.view to javafx.fxml;
    exports tasks.view;
    exports tasks.controller;
    exports tasks.repository;
    opens tasks.controller to javafx.base, javafx.fxml;
    exports tasks.services;
    opens tasks.services to javafx.base, javafx.fxml;
    exports tasks.observer;
    opens tasks.observer to javafx.base, javafx.fxml;
    opens tasks.repository to javafx.base, javafx.fxml;
}