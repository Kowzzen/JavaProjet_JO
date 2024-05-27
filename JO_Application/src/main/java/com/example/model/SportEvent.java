package com.example.model;

import javafx.beans.property.*;

public class SportEvent {
    private final StringProperty name;
    private final StringProperty discipline;

    public SportEvent(String name, String discipline) {
        this.name = new SimpleStringProperty(name);
        this.discipline = new SimpleStringProperty(discipline);
    }

    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public String getDiscipline() {
        return discipline.get();
    }

    public StringProperty disciplineProperty() {
        return discipline;
    }
}
