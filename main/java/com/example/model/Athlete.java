package com.example.model;

import javafx.beans.property.*;

public class Athlete {
    private final StringProperty nom;
    private final StringProperty pays;
    private final IntegerProperty age;
    private final StringProperty genre;
    private final ObjectProperty<SportDiscipline> discipline;

    public Athlete(String nom, String pays, int age, String genre, SportDiscipline discipline) {
        this.nom = new SimpleStringProperty(nom);
        this.pays = new SimpleStringProperty(pays);
        this.age = new SimpleIntegerProperty(age);
        this.genre = new SimpleStringProperty(genre);
        this.discipline = new SimpleObjectProperty<>(discipline);
    }

    // Getters and Property methods

    public String getNom() {
        return nom.get();
    }

    public StringProperty nomProperty() {
        return nom;
    }

    public String getPays() {
        return pays.get();
    }

    public StringProperty paysProperty() {
        return pays;
    }

    public int getAge() {
        return age.get();
    }

    public IntegerProperty ageProperty() {
        return age;
    }

    public String getGenre() {
        return genre.get();
    }

    public StringProperty genderProperty() {
        return genre;
    }

    public SportDiscipline getDiscipline() {
        return discipline.get();
    }

    public ObjectProperty<SportDiscipline> disciplineProperty() {
        return discipline;
    }
}
