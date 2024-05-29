package com.example.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class SportDiscipline {
    private final StringProperty name;

    public SportDiscipline(String name) {
        this.name = new SimpleStringProperty(name);
    }

    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }
}
