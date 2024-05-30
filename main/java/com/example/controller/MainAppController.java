package com.example.controller;

import com.example.model.*;
import com.example.view.AthleteView;
import com.example.view.DisciplineView;
import com.example.view.EventView;
import com.example.view.ResultView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class MainAppController {

    @FXML
    private AnchorPane mainAnchorPane;
    private ObservableList<SportEvent> eventList = FXCollections.observableArrayList();
    private ObservableList<SportDiscipline> disciplineList = FXCollections.observableArrayList();
    private ObservableList<Athlete> athleteList = FXCollections.observableArrayList();
    private ObservableList<Result> resultList = FXCollections.observableArrayList();

    @FXML
    private void initialize() {
        // Ajoutation de quelques disciplines par défaut
        disciplineList.addAll(
                new SportDiscipline("Football"),
                new SportDiscipline("Basketball"),
                new SportDiscipline("Tennis"),
                new SportDiscipline("Athletisme"),
                new SportDiscipline("Natation"),
                new SportDiscipline("Cyclisme"),
                new SportDiscipline("Gymnastique"),
                new SportDiscipline("Escrime")
        );

        // Ajoutation de quelques athlètes par défaut
        athleteList.addAll(
                new Athlete("Usain Bolt", "Jamaïque", 34, "Homme", new SportDiscipline("Athletisme")),
                new Athlete("Michael Phelps", "USA", 35, "Homme", new SportDiscipline("Natation")),
                new Athlete("Neymar Jr", "Brésil", 23, "Homme", new SportDiscipline("Football")),
                new Athlete("Simone Biles", "USA", 24, "Femme", new SportDiscipline("Gymnastique")),
                new Athlete("Katie Ledecky", "USA", 23, "Femme", new SportDiscipline("Natation")),
                new Athlete("Chris Froome", "Royaume-Uni", 36, "Homme", new SportDiscipline("Cyclisme")),
                new Athlete("Yelena Isinbayeva", "Russie", 38, "Femme", new SportDiscipline("Athletisme")),
                new Athlete("Rafael Nadal", "Espagne", 34, "Homme", new SportDiscipline("Tennis")),
                new Athlete("Novak Djokovic", "Serbie", 33, "Homme", new SportDiscipline("Tennis")),
                new Athlete("Roger Federer", "Suisse", 39, "Homme", new SportDiscipline("Tennis"))
        );

        // Ajoutation de quelques événements par défaut
        eventList.addAll(
                new SportEvent("Olympic 100m", "Athletisme", LocalDate.of(2024, 7, 24), "10:00", "Stade de France", "Usain Bolt", "Or"),
                new SportEvent("Olympic 200m", "Athletisme", LocalDate.of(2024, 7, 25), "12:00", "Stade de France", "Usain Bolt", "Or"),
                new SportEvent("Olympic 400m", "Athletisme", LocalDate.of(2024, 7, 26), "14:00", "Stade de France", "Yelena Isinbayeva", "Argent"),
                new SportEvent("Olympic 1500m Nage libre", "Natation", LocalDate.of(2024, 7, 27), "10:00", "Piscine Olympique", "Katie Ledecky", "Or"),
                new SportEvent("Olympic 4x100m Natation Relai", "Natation", LocalDate.of(2024, 7, 28), "11:00", "Piscine Olympique", "Michael Phelps", "Or"),
                new SportEvent("Olympic Tennis", "Tennis", LocalDate.of(2024, 7, 29), "15:00", "Court Central", "Novak Djokovic", "Or"),
                new SportEvent("Olympic Gymnastiqued", "Gymnastique", LocalDate.of(2024, 7, 30), "13:00", "Salle de Gymnastique", "Simone Biles", "Or"),
                new SportEvent("Olympic Course Homme", "Cyclisme", LocalDate.of(2024, 7, 31), "09:00", "Circuit de Cyclisme", "Chris Froome", "Or"),
                new SportEvent("Olympic Final BasketBall Homme", "Basketball", LocalDate.of(2024, 8, 1), "18:00", "Stade de Basketball", "Equipe USA", "Or"),
                new SportEvent("Olympic Final Football Homme", "Football", LocalDate.of(2024, 8, 2), "20:00", "Stade Olympique", "Neymar Jr", "Or")
        );
    }

    @FXML
    private void handleAthleteView() {
        mainAnchorPane.getChildren().clear();
        AthleteView athleteView = new AthleteView(disciplineList, athleteList);
        mainAnchorPane.getChildren().add(athleteView.getView());
    }

    @FXML
    private void handleDisciplineView() {
        mainAnchorPane.getChildren().clear();
        DisciplineView disciplineView = new DisciplineView(disciplineList);
        mainAnchorPane.getChildren().add(disciplineView.getView());
    }

    @FXML
    private void handleEventView() {
        mainAnchorPane.getChildren().clear();
        EventView eventView = new EventView(disciplineList, athleteList, eventList, this);
        mainAnchorPane.getChildren().add(eventView.getView());
    }

    @FXML
    private void handleResultView() {
        mainAnchorPane.getChildren().clear();
        ResultView resultView = new ResultView(athleteList, eventList, resultList);
        mainAnchorPane.getChildren().add(resultView.getView());
    }

    @FXML
    private void handleViewMedalTable() {
        mainAnchorPane.getChildren().clear();
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/jo_application/MedalTableView.fxml"));
            AnchorPane medalTableView = loader.load();

            MedalTableController controller = loader.getController();
            controller.updateMedalData(resultList);

            mainAnchorPane.getChildren().add(medalTableView);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void handleAccueil() {
        mainAnchorPane.getChildren().clear();
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/jo_application/MainAppView.fxml"));
            AnchorPane accueilView = loader.load();
            mainAnchorPane.getChildren().add(accueilView);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method to add events
    public void addEvent(SportEvent event) {
        eventList.add(event);
    }

    private Map<String, Integer> calculatePoints() {
        Map<String, Integer> pointsMap = new HashMap<>();

        for (Result result : resultList) {
            String country = result.getAthlete().getPays();

            CountryMedalTable medalTableEntry = new CountryMedalTable(country, 0, 0, 0);

            int points = medalTableEntry.getPoints();

            pointsMap.put(country, pointsMap.getOrDefault(country, 0) + points);
        }

        return pointsMap.entrySet()
                .stream()
                .sorted((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new
                ));
    }
}
