package com.example.controller;

import com.example.model.SportDiscipline;
import com.example.model.SportEvent;
import com.example.view.AthleteView;
import com.example.view.DisciplineView;
import com.example.view.EventView;
import com.example.view.ResultView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

import java.io.IOException;

public class MainAppController {

    @FXML
    private AnchorPane mainAnchorPane;
    private ObservableList<SportEvent> eventList = FXCollections.observableArrayList();
    private ObservableList<SportDiscipline> disciplineList = FXCollections.observableArrayList();

    @FXML
    private void initialize() {
        // Ajouter quelques disciplines par défaut
        disciplineList.addAll(
                new SportDiscipline("Football"),
                new SportDiscipline("Basketball"),
                new SportDiscipline("Tennis")
        );
    }

    @FXML
    private void handleAthleteView() {
        mainAnchorPane.getChildren().clear();
        AthleteView athleteView = new AthleteView(disciplineList);
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
        EventView eventView = new EventView();
        mainAnchorPane.getChildren().add(eventView.getView());
    }

    @FXML
    private void handleResultView() {
        mainAnchorPane.getChildren().clear();
        ResultView resultView = new ResultView();
        mainAnchorPane.getChildren().add(resultView.getView());
    }

    @FXML
    private void handleViewMedalTable() {
        // Ajoutez ici le code pour gérer la vue du tableau des médailles
        System.out.println("Tableau des médailles");
    }

    @FXML
    private void handleAccueil() {
        // Ajoutez ici le code pour retourner à l'accueil
        System.out.println("Accueil");
    }

    @FXML
    private void handleCalendrierView() {
        mainAnchorPane.getChildren().clear();
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/com/example/view/CalendrierView.fxml"));
            BorderPane calendrierView = loader.load();

            // Get the controller for CalendrierView
            CalendrierController controller = loader.getController();
            controller.setEventList(eventList);

            mainAnchorPane.getChildren().add(calendrierView);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method to add events
    public void addEvent(SportEvent event) {
        eventList.add(event);
    }

    @FXML
    private void handleMenuAction2() {
        // Ajoutez ici le code pour gérer l'action 2
        System.out.println("Action 2");
    }
}
