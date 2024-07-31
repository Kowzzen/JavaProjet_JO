package com.example.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class MedalCount {
    private final StringProperty pays;
    private final IntegerProperty points;

    public MedalCount(String country) {
        this.pays = new SimpleStringProperty(country);
        this.points = new SimpleIntegerProperty(0);
    }

    public String getPays() {
        return pays.get();
    }

    public StringProperty paysProperty() {
        return pays;
    }

    public int getPoints() {
        return points.get();
    }

    public IntegerProperty pointsProperty() {
        return points;
    }

    public void addPoints(int points) {
        this.points.set(this.points.get() + points);
    }

}
