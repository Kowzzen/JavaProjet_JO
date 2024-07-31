package com.example.view;

import com.example.model.SportEvent;
import com.example.model.SportDiscipline;
import com.example.model.Athlete;
import com.example.controller.MainAppController;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;

import java.time.LocalDate;

public class EventView {
    private VBox view;
    private ObservableList<SportDiscipline> disciplines;
    private ObservableList<Athlete> athletes;
    private ObservableList<SportEvent> events;
    private MainAppController mainAppController;

    public EventView(ObservableList<SportDiscipline> disciplines, ObservableList<Athlete> athletes, ObservableList<SportEvent> events, MainAppController mainAppController) {
        this.disciplines = disciplines;
        this.athletes = athletes;
        this.events = events;
        this.mainAppController = mainAppController;

        view = new VBox(10);
        view.setPadding(new Insets(20));
        view.setStyle("-fx-background-color: #f5f5f5;");

        GridPane form = new GridPane();
        form.setHgap(10);
        form.setVgap(10);
        form.setPadding(new Insets(10));
        form.setStyle("-fx-background-color: #ffffff; -fx-border-color: #cccccc; -fx-border-radius: 5; -fx-background-radius: 5;");

        Label titleLabel = new Label("Ajouter un nouvel Evénement");
        titleLabel.setFont(new Font(20));
        titleLabel.setPadding(new Insets(0, 0, 20, 0));

        Label eventNameLabel = new Label("Nom de l'Evénement:");
        TextField eventNameField = new TextField();

        Label eventDisciplineLabel = new Label("Discipline:");
        ComboBox<SportDiscipline> eventDisciplineComboBox = new ComboBox<>(disciplines);

        Label eventDateLabel = new Label("Date:");
        DatePicker eventDateField = new DatePicker();

        Label eventTimeLabel = new Label("Heure:");
        TextField eventTimeField = new TextField();

        Label eventLocationLabel = new Label("Lieu:");
        TextField eventLocationField = new TextField();

        Label eventParticipantsLabel = new Label("Participant:");
        ComboBox<Athlete> eventParticipantsComboBox = new ComboBox<>(athletes);

        Button addButton = new Button("Ajouter l'Evénement");
        addButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white;");

        addButton.setOnAction(e -> {
            String name = eventNameField.getText();
            SportDiscipline discipline = eventDisciplineComboBox.getValue();
            LocalDate date = eventDateField.getValue();
            String time = eventTimeField.getText();
            String location = eventLocationField.getText();
            Athlete participant = eventParticipantsComboBox.getValue();

            SportEvent event = new SportEvent(name, discipline.getName(), date, time, location, participant.getNom(), "");
            events.add(event);
        });

        form.add(eventNameLabel, 0, 0);
        form.add(eventNameField, 1, 0);
        form.add(eventDisciplineLabel, 0, 1);
        form.add(eventDisciplineComboBox, 1, 1);
        form.add(eventDateLabel, 0, 2);
        form.add(eventDateField, 1, 2);
        form.add(eventTimeLabel, 0, 3);
        form.add(eventTimeField, 1, 3);
        form.add(eventLocationLabel, 0, 4);
        form.add(eventLocationField, 1, 4);
        form.add(eventParticipantsLabel, 0, 5);
        form.add(eventParticipantsComboBox, 1, 5);
        form.add(addButton, 1, 6);

        TableView<SportEvent> tableView = new TableView<>(events);
        tableView.setStyle("-fx-background-color: #ffffff; -fx-border-color: #cccccc; -fx-border-radius: 5; -fx-background-radius: 5;");
        TableColumn<SportEvent, String> nameColumn = new TableColumn<>("Nom de l'Evenement");
        nameColumn.setCellValueFactory(cellData -> cellData.getValue().nomProperty());

        TableColumn<SportEvent, String> disciplineColumn = new TableColumn<>("Discipline");
        disciplineColumn.setCellValueFactory(cellData -> cellData.getValue().disciplineProperty());

        TableColumn<SportEvent, LocalDate> dateColumn = new TableColumn<>("Date");
        dateColumn.setCellValueFactory(cellData -> cellData.getValue().dateProperty());

        TableColumn<SportEvent, String> timeColumn = new TableColumn<>("Heure");
        timeColumn.setCellValueFactory(cellData -> cellData.getValue().timeProperty());

        TableColumn<SportEvent, String> locationColumn = new TableColumn<>("Lieu");
        locationColumn.setCellValueFactory(cellData -> cellData.getValue().locationProperty());

        TableColumn<SportEvent, String> participantsColumn = new TableColumn<>("Participant");
        participantsColumn.setCellValueFactory(cellData -> cellData.getValue().participantsProperty());

        tableView.getColumns().addAll(nameColumn, disciplineColumn, dateColumn, timeColumn, locationColumn, participantsColumn);

        Button homeButton = new Button("Accueil");
        homeButton.setOnAction(e -> mainAppController.handleAccueil());
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
