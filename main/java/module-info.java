module com.example.jo_application {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;

    // Ouvrir les packages nécessaires pour javafx.fxml

    opens com.example.controller to javafx.fxml;
    opens com.example.view to javafx.fxml;

    // Exporter les packages nécessaires

    exports com.example.controller;
    exports com.example.view;
    exports com.example.model;

    // Exporter le package com.example vers javafx.graphics
    exports com.example to javafx.graphics;
}
