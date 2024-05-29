package com.example.model;

import javafx.beans.property.*;

public class SportEvent {
    private final StringProperty name;
    private final StringProperty discipline;
    private final StringProperty date;
    private final StringProperty time;
    private final StringProperty location;
    private final StringProperty participants;
    private final StringProperty results;

    public SportEvent(String name, String discipline, String date, String time, String location, String participants, String results) {
        this.name = new SimpleStringProperty(name);
        this.discipline = new SimpleStringProperty(discipline);
        this.date = new SimpleStringProperty(date);
        this.time = new SimpleStringProperty(time);
        this.location = new SimpleStringProperty(location);
        this.participants = new SimpleStringProperty(participants);
        this.results = new SimpleStringProperty(results);
    }

    // Getters and Property Methods
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

    public String getDate() {
        return date.get();
    }

    public StringProperty dateProperty() {
        return date;
    }

    public String getTime() {
        return time.get();
    }

    public StringProperty timeProperty() {
        return time;
    }

    public String getLocation() {
        return location.get();
    }

    public StringProperty locationProperty() {
        return location;
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
