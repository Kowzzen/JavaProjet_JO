package com.example.view;

import com.example.model.Athlete;
import com.example.model.SportDiscipline;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;

public class AthleteView {
    private VBox view;
    private ObservableList<SportDiscipline> disciplines;
    private ObservableList<Athlete> athletes;

    public AthleteView(ObservableList<SportDiscipline> disciplines, ObservableList<Athlete> athletes) {
        this.disciplines = disciplines;
        this.athletes = athletes;

        view = new VBox(10);
        view.setPadding(new Insets(20));
        view.setStyle("-fx-background-color: #f5f5f5;");

        GridPane form = new GridPane();
        form.setHgap(10);
        form.setVgap(10);
        form.setPadding(new Insets(10));
        form.setStyle("-fx-background-color: #ffffff; -fx-border-color: #cccccc; -fx-border-radius: 5; -fx-background-radius: 5;");

        Label titleLabel = new Label("Ajouter Athlete");
        titleLabel.setFont(new Font(20));
        titleLabel.setPadding(new Insets(0, 0, 20, 0));

        Label nameLabel = new Label("Nom:");
        TextField nameField = new TextField();

        Label countryLabel = new Label("Pays:");
        ComboBox<String> countryComboBox = new ComboBox<>();
        countryComboBox.getItems().addAll("France", "USA", "Chine", "Allemagne", "Japon");

        Label genderLabel = new Label("Genre:");
        ComboBox<String> genderComboBox = new ComboBox<>();
        genderComboBox.getItems().addAll("Homme", "Femme", "Autre");

        Label disciplineLabel = new Label("Discipline:");
        ComboBox<SportDiscipline> disciplineComboBox = new ComboBox<>(disciplines);

        Button addButton = new Button("Ajouter un athlete");
        addButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white;");

        addButton.setOnAction(e -> {
            String name = nameField.getText();
            String country = countryComboBox.getValue();
            String gender = genderComboBox.getValue();
            SportDiscipline discipline = disciplineComboBox.getValue();
            Athlete athlete = new Athlete(name, country, 0, gender, discipline);
            athletes.add(athlete);
        });

        form.add(nameLabel, 0, 0);
        form.add(nameField, 1, 0);
        form.add(countryLabel, 0, 1);
        form.add(countryComboBox, 1, 1);
        form.add(genderLabel, 0, 2);
        form.add(genderComboBox, 1, 2);
        form.add(disciplineLabel, 0, 3);
        form.add(disciplineComboBox, 1, 3);
        form.add(addButton, 1, 4);

        TableView<Athlete> tableView = new TableView<>(athletes);
        tableView.setStyle("-fx-background-color: #ffffff; -fx-border-color: #cccccc; -fx-border-radius: 5; -fx-background-radius: 5;");
        TableColumn<Athlete, String> nameColumn = new TableColumn<>("Nom");
        nameColumn.setCellValueFactory(cellData -> cellData.getValue().nomProperty());

        TableColumn<Athlete, String> countryColumn = new TableColumn<>("Pays");
        countryColumn.setCellValueFactory(cellData -> cellData.getValue().paysProperty());

        TableColumn<Athlete, String> genderColumn = new TableColumn<>("Genre");
        genderColumn.setCellValueFactory(cellData -> cellData.getValue().genderProperty());

        TableColumn<Athlete, String> disciplineColumn = new TableColumn<>("Discipline");
        disciplineColumn.setCellValueFactory(cellData -> cellData.getValue().disciplineProperty().get().nameProperty());

        TableColumn<Athlete, Void> actionColumn = new TableColumn<>("Actions");
        actionColumn.setCellFactory(param -> new TableCell<>() {
            private final Button editButton = new Button("Modifier");
            private final Button deleteButton = new Button("Supprimer");

            {
                editButton.setOnAction(event -> {
                    Athlete athlete = getTableView().getItems().get(getIndex());
                    nameField.setText(athlete.getNom());
                    countryComboBox.setValue(athlete.getPays());
                    genderComboBox.setValue(athlete.getGenre());
                    disciplineComboBox.setValue(athlete.getDiscipline());
                    addButton.setText("Update Athlete");

                    addButton.setOnAction(e -> {
                        athlete.nomProperty().set(nameField.getText());
                        athlete.paysProperty().set(countryComboBox.getValue());
                        athlete.genderProperty().set(genderComboBox.getValue());
                        athlete.disciplineProperty().set(disciplineComboBox.getValue());
                        addButton.setText("Add Athlete");
                        addButton.setOnAction(addEvent -> {
                            String name = nameField.getText();
                            String country = countryComboBox.getValue();
                            String gender = genderComboBox.getValue();
                            SportDiscipline discipline = disciplineComboBox.getValue();
                            Athlete newAthlete = new Athlete(name, country, 0, gender, discipline);
                            athletes.add(newAthlete);
                        });
                        tableView.refresh();
                    });
                });

                deleteButton.setOnAction(event -> {
                    Athlete athlete = getTableView().getItems().get(getIndex());
                    athletes.remove(athlete);
                });
            }

            private final HBox pane = new HBox(editButton, deleteButton);

            @Override
            protected void updateItem(Void item, boolean empty) {
                super.updateItem(item, empty);
                if (empty) {
                    setGraphic(null);
                } else {
                    setGraphic(pane);
                }
            }
        });

        tableView.getColumns().addAll(nameColumn, countryColumn, genderColumn, disciplineColumn, actionColumn);

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
