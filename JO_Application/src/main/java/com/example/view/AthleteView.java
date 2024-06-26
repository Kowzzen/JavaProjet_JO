package com.example.view;

import com.example.model.Athlete;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class AthleteView {
    private GridPane view;

    public AthleteView() {
        view = new GridPane();
        view.setHgap(10);
        view.setVgap(10);

        Label nameLabel = new Label("Name:");
        TextField nameField = new TextField();
        Label countryLabel = new Label("Country:");
        TextField countryField = new TextField();
        Label ageLabel = new Label("Age:");
        TextField ageField = new TextField();
        Label genderLabel = new Label("Gender:");
        TextField genderField = new TextField();
        Button addButton = new Button("Add Athlete");

        TableView<Athlete> athleteTable = new TableView<>();
        TableColumn<Athlete, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        TableColumn<Athlete, String> countryColumn = new TableColumn<>("Country");
        countryColumn.setCellValueFactory(cellData -> cellData.getValue().countryProperty());
        TableColumn<Athlete, Integer> ageColumn = new TableColumn<>("Age");
        ageColumn.setCellValueFactory(cellData -> cellData.getValue().ageProperty().asObject());
        TableColumn<Athlete, String> genderColumn = new TableColumn<>("Gender");
        genderColumn.setCellValueFactory(cellData -> cellData.getValue().genderProperty());

        athleteTable.getColumns().addAll(nameColumn, countryColumn, ageColumn, genderColumn);

        ObservableList<Athlete> athleteData = FXCollections.observableArrayList();
        athleteTable.setItems(athleteData);

        addButton.setOnAction(e -> {
            String name = nameField.getText();
            String country = countryField.getText();
            int age = Integer.parseInt(ageField.getText());
            String gender = genderField.getText();
            Athlete athlete = new Athlete(name, country, age, gender);
            athleteData.add(athlete);
        });

        view.add(nameLabel, 0, 0);
        view.add(nameField, 1, 0);
        view.add(countryLabel, 0, 1);
        view.add(countryField, 1, 1);
        view.add(ageLabel, 0, 2);
        view.add(ageField, 1, 2);
        view.add(genderLabel, 0, 3);
        view.add(genderField, 1, 3);
        view.add(addButton, 1, 4);
        view.add(athleteTable, 0, 5, 2, 1);
    }

    public GridPane getView() {
        return view;
    }
}
