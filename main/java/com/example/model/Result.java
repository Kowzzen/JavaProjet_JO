package com.example.model;

import javafx.beans.property.*;

public class Result {
    private final ObjectProperty<Athlete> athlete;
    private final ObjectProperty<SportEvent> event;
    private final StringProperty medaille; // "Or", "Argent", "Bronze"

    public Result(Athlete athlete, SportEvent event, String medal) {
        this.athlete = new SimpleObjectProperty<>(athlete);
        this.event = new SimpleObjectProperty<>(event);
        this.medaille = new SimpleStringProperty(medal);
    }

    public Athlete getAthlete() {
        return athlete.get();
    }

    public ObjectProperty<Athlete> athleteProperty() {
        return athlete;
    }

    public SportEvent getEvent() {
        return event.get();
    }

    public ObjectProperty<SportEvent> eventProperty() {
        return event;
    }

    public String getMedal() {
        return medaille.get();
    }

    public StringProperty medalProperty() {
        return medaille;
    }

    public void setAthlete(Athlete athlete) {
        this.athlete.set(athlete);
    }

    public void setEvent(SportEvent event) {
        this.event.set(event);
    }

    public void setMedal(String medal) {
        this.medaille.set(medal);
    }
}
