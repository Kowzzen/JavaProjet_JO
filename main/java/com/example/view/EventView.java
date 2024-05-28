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
        Button addButton = new Button("Add Event");

        TableView<SportEvent> eventTable = new TableView<>();
        TableColumn<SportEvent, String> eventNameColumn = new TableColumn<>("Event Name");
        eventNameColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        TableColumn<SportEvent, String> eventDisciplineColumn = new TableColumn<>("Discipline");
        eventDisciplineColumn.setCellValueFactory(cellData -> cellData.getValue().disciplineProperty());

        eventTable.getColumns().addAll(eventNameColumn, eventDisciplineColumn);

        ObservableList<SportEvent> eventData = FXCollections.observableArrayList();
        eventTable.setItems(eventData);

        addButton.setOnAction(e -> {
            String name = eventNameField.getText();
            String discipline = eventDisciplineField.getText();
            SportEvent event = new SportEvent(name, discipline);
            eventData.add(event);
        });

        view.add(eventNameLabel, 0, 0);
        view.add(eventNameField, 1, 0);
        view.add(eventDisciplineLabel, 0, 1);
        view.add(eventDisciplineField, 1, 1);
        view.add(addButton, 1, 2);
        view.add(eventTable, 0, 3, 2, 1);
    }

    public GridPane getView() {
        return view;
    }
}
