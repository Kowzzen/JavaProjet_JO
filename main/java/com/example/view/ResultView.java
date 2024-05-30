package com.example.view;

import com.example.model.Athlete;
import com.example.model.Result;
import com.example.model.SportEvent;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;

public class ResultView {
    private VBox view;
    private ObservableList<Athlete> athletes;
    private ObservableList<SportEvent> events;
    private ObservableList<Result> results;

    public ResultView(ObservableList<Athlete> athletes, ObservableList<SportEvent> events, ObservableList<Result> results) {
        this.athletes = athletes;
        this.events = events;
        this.results = results;

        view = new VBox(10);
        view.setPadding(new Insets(20));
        view.setStyle("-fx-background-color: #f5f5f5;");

        GridPane form = new GridPane();
        form.setHgap(10);
        form.setVgap(10);
        form.setPadding(new Insets(10));
        form.setStyle("-fx-background-color: #ffffff; -fx-border-color: #cccccc; -fx-border-radius: 5; -fx-background-radius: 5;");

        Label titleLabel = new Label("Ajouter Un Résultat");
        titleLabel.setFont(new Font(20));
        titleLabel.setPadding(new Insets(0, 0, 20, 0));

        Label athleteLabel = new Label("Athlete:");
        ComboBox<Athlete> athleteComboBox = new ComboBox<>(athletes);

        Label eventLabel = new Label("Evénement:");
        ComboBox<SportEvent> eventComboBox = new ComboBox<>(events);

        Label medalLabel = new Label("Medaille:");
        ComboBox<String> medalComboBox = new ComboBox<>();
        medalComboBox.getItems().addAll( "Or", "Argent", "Bronze");

        Button addButton = new Button("Ajouter Résultats");
        addButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white;");

        addButton.setOnAction(e -> {
            Athlete athlete = athleteComboBox.getValue();
            SportEvent event = eventComboBox.getValue();
            String medal = medalComboBox.getValue();
            Result result = new Result(athlete, event, medal);
            results.add(result);
        });

        form.add(athleteLabel, 0, 0);
        form.add(athleteComboBox, 1, 0);
        form.add(eventLabel, 0, 1);
        form.add(eventComboBox, 1, 1);
        form.add(medalLabel, 0, 2);
        form.add(medalComboBox, 1, 2);
        form.add(addButton, 1, 3);

        TableView<Result> tableView = new TableView<>(results);
        tableView.setStyle("-fx-background-color: #ffffff; -fx-border-color: #cccccc; -fx-border-radius: 5; -fx-background-radius: 5;");
        TableColumn<Result, String> athleteColumn = new TableColumn<>("Athlete");
        athleteColumn.setCellValueFactory(cellData -> cellData.getValue().athleteProperty().get().nomProperty());

        TableColumn<Result, String> eventColumn = new TableColumn<>("Evénement");
        eventColumn.setCellValueFactory(cellData -> cellData.getValue().eventProperty().get().nomProperty());

        TableColumn<Result, String> medalColumn = new TableColumn<>("Medaille");
        medalColumn.setCellValueFactory(cellData -> cellData.getValue().medalProperty());

        tableView.getColumns().addAll(athleteColumn, eventColumn, medalColumn);

        Button homeButton = new Button("Accueil");
        homeButton.setStyle("-fx-background-color: #2196F3; -fx-text-fill: white;");

        HBox centeredForm = new HBox(form);
        centeredForm.setAlignment(Pos.CENTER);

        HBox centeredTableView = new HBox(tableView);
        centeredTableView.setAlignment(Pos.CENTER);

        view.getChildren().addAll(titleLabel, centeredForm, centeredTableView, homeButton);
        view.setAlignment(Pos.CENTER);
    }

    public VBox getView() {
        return view;
    }
}
