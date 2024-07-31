package com.example.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class SportDiscipline {
    private final StringProperty nom;

    public SportDiscipline(String name) {
        this.nom = new SimpleStringProperty(name);
    }

    public String getName() {
        return nom.get();
    }

    public StringProperty nameProperty() {
        return nom;
    }
}
