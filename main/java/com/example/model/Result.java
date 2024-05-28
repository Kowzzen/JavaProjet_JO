package com.example.model;

import javafx.beans.property.*;

public class Result {
    private final ObjectProperty<Athlete> athlete;
    private final ObjectProperty<SportEvent> event;
    private final IntegerProperty score;

    public Result(Athlete athlete, SportEvent event, int score) {
        this.athlete = new SimpleObjectProperty<>(athlete);
        this.event = new SimpleObjectProperty<>(event);
        this.score = new SimpleIntegerProperty(score);
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

    public int getScore() {
        return score.get();
    }

    public IntegerProperty scoreProperty() {
        return score;
    }
}
