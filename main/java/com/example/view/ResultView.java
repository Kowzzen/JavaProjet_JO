package com.example.view;

import com.example.model.Result;
import com.example.model.Athlete;
import com.example.model.SportDiscipline;
import com.example.model.SportEvent;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

public class ResultView {
    private GridPane view;

    public ResultView() {
        view = new GridPane();
        view.setHgap(10);
        view.setVgap(10);

        Label athleteLabel = new Label("Athlete:");
        TextField athleteField = new TextField();
        Label eventLabel = new Label("Event:");
        TextField eventField = new TextField();
        Label scoreLabel = new Label("Score:");
        TextField scoreField = new TextField();
        Button addButton = new Button("Add Result");

        TableView<Result> resultTable = new TableView<>();
        TableColumn<Result, String> athleteColumn = new TableColumn<>("Athlete");
        athleteColumn.setCellValueFactory(cellData -> cellData.getValue().athleteProperty().get().nameProperty());
        TableColumn<Result, String> eventColumn = new TableColumn<>("Event");
        eventColumn.setCellValueFactory(cellData -> cellData.getValue().eventProperty().get().nameProperty());
        TableColumn<Result, Integer> scoreColumn = new TableColumn<>("Score");
        scoreColumn.setCellValueFactory(cellData -> cellData.getValue().scoreProperty().asObject());

        resultTable.getColumns().addAll(athleteColumn, eventColumn, scoreColumn);

        ObservableList<Result> resultData = FXCollections.observableArrayList();
        resultTable.setItems(resultData);

        addButton.setOnAction(e -> {
            String athleteName = athleteField.getText();
            String eventName = eventField.getText();
            int score = Integer.parseInt(scoreField.getText());

            // Créez un SportDiscipline factice pour l'exemple
            SportDiscipline fakeDiscipline = new SportDiscipline("Discipline");

            Athlete athlete = new Athlete(athleteName, "", 0, "", fakeDiscipline);
            SportEvent event = new SportEvent(eventName, "", "", "", "", "", "");
            Result result = new Result(athlete, event, score);
            resultData.add(result);
        });

        view.add(athleteLabel, 0, 0);
        view.add(athleteField, 1, 0);
        view.add(eventLabel, 0, 1);
        view.add(eventField, 1, 1);
        view.add(scoreLabel, 0, 2);
        view.add(scoreField, 1, 2);
        view.add(addButton, 1, 3);
        view.add(resultTable, 0, 4, 2, 1);
    }

    public GridPane getView() {
        return view;
    }
}
