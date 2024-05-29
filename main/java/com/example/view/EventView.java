package com.example.view;

import com.example.model.SportEvent;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

public class EventView {
    private GridPane view;

    public EventView() {
        view = new GridPane();
        view.setHgap(10);
        view.setVgap(10);

        Label eventNameLabel = new Label("Event Name:");
        TextField eventNameField = new TextField();

        Label eventDisciplineLabel = new Label("Discipline:");
        TextField eventDisciplineField = new TextField();

        Label eventDateLabel = new Label("Date:");
        TextField eventDateField = new TextField();

        Label eventTimeLabel = new Label("Time:");
        TextField eventTimeField = new TextField();

        Label eventLocationLabel = new Label("Location:");
        TextField eventLocationField = new TextField();

        Label eventParticipantsLabel = new Label("Participants:");
        TextField eventParticipantsField = new TextField();

        Label eventResultsLabel = new Label("Results:");
        TextField eventResultsField = new TextField();

        Button addButton = new Button("Add Event");

        TableView<SportEvent> eventTable = new TableView<>();
        TableColumn<SportEvent, String> eventNameColumn = new TableColumn<>("Event Name");
        eventNameColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());

        TableColumn<SportEvent, String> eventDisciplineColumn = new TableColumn<>("Discipline");
        eventDisciplineColumn.setCellValueFactory(cellData -> cellData.getValue().disciplineProperty());

        TableColumn<SportEvent, String> eventDateColumn = new TableColumn<>("Date");
        eventDateColumn.setCellValueFactory(cellData -> cellData.getValue().dateProperty());

        TableColumn<SportEvent, String> eventTimeColumn = new TableColumn<>("Time");
        eventTimeColumn.setCellValueFactory(cellData -> cellData.getValue().timeProperty());

        TableColumn<SportEvent, String> eventLocationColumn = new TableColumn<>("Location");
        eventLocationColumn.setCellValueFactory(cellData -> cellData.getValue().locationProperty());

        TableColumn<SportEvent, String> eventParticipantsColumn = new TableColumn<>("Participants");
        eventParticipantsColumn.setCellValueFactory(cellData -> cellData.getValue().participantsProperty());

        TableColumn<SportEvent, String> eventResultsColumn = new TableColumn<>("Results");
        eventResultsColumn.setCellValueFactory(cellData -> cellData.getValue().resultsProperty());

        eventTable.getColumns().addAll(eventNameColumn, eventDisciplineColumn, eventDateColumn, eventTimeColumn, eventLocationColumn, eventParticipantsColumn, eventResultsColumn);

        ObservableList<SportEvent> eventData = FXCollections.observableArrayList();
        eventTable.setItems(eventData);

        addButton.setOnAction(e -> {
            String name = eventNameField.getText();
            String discipline = eventDisciplineField.getText();
            String date = eventDateField.getText();
            String time = eventTimeField.getText();
            String location = eventLocationField.getText();
            String participants = eventParticipantsField.getText();
            String results = eventResultsField.getText();
            SportEvent event = new SportEvent(name, discipline, date, time, location, participants, results);
            eventData.add(event);
        });

        view.add(eventNameLabel, 0, 0);
        view.add(eventNameField, 1, 0);
        view.add(eventDisciplineLabel, 0, 1);
        view.add(eventDisciplineField, 1, 1);
        view.add(eventDateLabel, 0, 2);
        view.add(eventDateField, 1, 2);
        view.add(eventTimeLabel, 0, 3);
        view.add(eventTimeField, 1, 3);
        view.add(eventLocationLabel, 0, 4);
        view.add(eventLocationField, 1, 4);
        view.add(eventParticipantsLabel, 0, 5);
        view.add(eventParticipantsField, 1, 5);
        view.add(eventResultsLabel, 0, 6);
        view.add(eventResultsField, 1, 6);
        view.add(addButton, 1, 7);
        view.add(eventTable, 0, 8, 2, 1);
    }

    public GridPane getView() {
        return view;
    }
}
