package com.example.model;

import javafx.beans.property.*;

public class CountryMedalTable {
    private final StringProperty pays;
    private final IntegerProperty or;
    private final IntegerProperty argent;
    private final IntegerProperty bronze;
    private final IntegerProperty points;

    public CountryMedalTable(String country, int gold, int silver, int bronze) {
        this.pays = new SimpleStringProperty(country);
        this.or = new SimpleIntegerProperty(gold);
        this.argent = new SimpleIntegerProperty(silver);
        this.bronze = new SimpleIntegerProperty(bronze);
        this.points = new SimpleIntegerProperty(calculPoints());
    }

    private int calculPoints() {
        return or.get() * 5 + argent.get() * 3 + bronze.get() * 1;
    }

    public String getPays() {
        return pays.get();
    }

    public StringProperty paysProperty() {
        return pays;
    }

    public int getOr() {
        return or.get();
    }

    public IntegerProperty orProperty() {
        return or;
    }

    public int getArgent() {
        return argent.get();
    }

    public IntegerProperty argentProperty() {
        return argent;
    }

    public int getBronze() {
        return bronze.get();
    }

    public IntegerProperty bronzeProperty() {
        return bronze;
    }

    public int getPoints() {
        return points.get();
    }

    public IntegerProperty pointsProperty() {
        return points;
    }

    public void addOr() {
        or.set(or.get() + 1);
        points.set(calculPoints());
    }

    public void addArgent() {
        argent.set(argent.get() + 1);
        points.set(calculPoints());
    }

    public void addBronze() {
        bronze.set(bronze.get() + 1);
        points.set(calculPoints());
    }
}
