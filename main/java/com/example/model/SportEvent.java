package com.example.model;

import javafx.beans.property.*;
import java.time.LocalDate;

public class SportEvent {
    private final StringProperty nom;
    private final StringProperty discipline;
    private final ObjectProperty<LocalDate> date;
    private final StringProperty heure;
    private final StringProperty lieu;
    private final StringProperty participants;
    private final StringProperty results;

    public SportEvent(String name, String discipline, LocalDate date, String time, String location, String participants, String results) {
        this.nom = new SimpleStringProperty(name);
        this.discipline = new SimpleStringProperty(discipline);
        this.date = new SimpleObjectProperty<>(date);
        this.heure = new SimpleStringProperty(time);
        this.lieu = new SimpleStringProperty(location);
        this.participants = new SimpleStringProperty(participants);
        this.results = new SimpleStringProperty(results);
    }

    // Getters and Property Methods
    public String getNom() {
        return nom.get();
    }

    public StringProperty nomProperty() {
        return nom;
    }

    public String getDiscipline() {
        return discipline.get();
    }

    public StringProperty disciplineProperty() {
        return discipline;
    }

    public LocalDate getDate() {
        return date.get();
    }

    public ObjectProperty<LocalDate> dateProperty() {
        return date;
    }

    public String getTime() {
        return heure.get();
    }

    public StringProperty timeProperty() {
        return heure;
    }

    public String getLocation() {
        return lieu.get();
    }

    public StringProperty locationProperty() {
        return lieu;
    }

    public String getParticipants() {
        return participants.get();
    }

    public StringProperty participantsProperty() {
        return participants;
    }

    public String getResults() {
        return results.get();
    }

    public StringProperty resultsProperty() {
        return results;
    }
}
