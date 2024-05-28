package com.example.controller;

import com.example.view.AthleteView;
import com.example.view.DisciplineView;
import com.example.view.EventView;
import com.example.view.ResultView;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;

public class MainAppController {

    @FXML
    private AnchorPane mainAnchorPane;

    @FXML
    private void handleAthleteView() {
        mainAnchorPane.getChildren().clear();
        AthleteView athleteView = new AthleteView();
        mainAnchorPane.getChildren().add(athleteView.getView());
    }

    @FXML
    private void handleDisciplineView() {
        mainAnchorPane.getChildren().clear();
        DisciplineView disciplineView = new DisciplineView();
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
    private void handleMenuAction1() {
        // Ajoutez ici le code pour gérer l'action 1
        System.out.println("Action 1");
    }

    @FXML
    private void handleMenuAction2() {
        // Ajoutez ici le code pour gérer l'action 2
        System.out.println("Action 2");
    }
}
