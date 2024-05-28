package com.example.view;

import com.example.model.SportDiscipline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

public class DisciplineView {
    private GridPane view;

    public DisciplineView() {
        view = new GridPane();
        view.setHgap(10);
        view.setVgap(10);

        Label disciplineLabel = new Label("Discipline:");
        TextField disciplineField = new TextField();
        Button addButton = new Button("Add Discipline");

        TableView<SportDiscipline> disciplineTable = new TableView<>();
        TableColumn<SportDiscipline, String> disciplineColumn = new TableColumn<>("Discipline");
        disciplineColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());

        disciplineTable.getColumns().add(disciplineColumn);

        ObservableList<SportDiscipline> disciplineData = FXCollections.observableArrayList();
        disciplineTable.setItems(disciplineData);

        addButton.setOnAction(e -> {
            String name = disciplineField.getText();
            SportDiscipline discipline = new SportDiscipline(name);
            disciplineData.add(discipline);
        });

        view.add(disciplineLabel, 0, 0);
        view.add(disciplineField, 1, 0);
        view.add(addButton, 1, 1);
        view.add(disciplineTable, 0, 2, 2, 1);
    }

    public GridPane getView() {
        return view;
    }
}
