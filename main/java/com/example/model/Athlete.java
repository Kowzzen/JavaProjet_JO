package com.example.model;

import javafx.beans.property.*;

public class Athlete {
    private final StringProperty name;
    private final StringProperty country;
    private final IntegerProperty age;
    private final StringProperty gender;
    private final ObjectProperty<SportDiscipline> discipline;

    public Athlete(String name, String country, int age, String gender, SportDiscipline discipline) {
        this.name = new SimpleStringProperty(name);
        this.country = new SimpleStringProperty(country);
        this.age = new SimpleIntegerProperty(age);
        this.gender = new SimpleStringProperty(gender);
        this.discipline = new SimpleObjectProperty<>(discipline);
    }

    // Getters and Property methods

    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public String getCountry() {
        return country.get();
    }

    public StringProperty countryProperty() {
        return country;
    }

    public int getAge() {
        return age.get();
    }

    public IntegerProperty ageProperty() {
        return age;
    }

    public String getGender() {
        return gender.get();
    }

    public StringProperty genderProperty() {
        return gender;
    }

    public SportDiscipline getDiscipline() {
        return discipline.get();
    }

    public ObjectProperty<SportDiscipline> disciplineProperty() {
        return discipline;
    }
}
