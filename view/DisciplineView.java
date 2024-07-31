package com.example.view;

import com.example.model.SportDiscipline;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;

public class DisciplineView {
    private VBox view;
    private ObservableList<SportDiscipline> disciplines;

    public DisciplineView(ObservableList<SportDiscipline> disciplines) {
        this.disciplines = disciplines;

        view = new VBox(10);
        view.setPadding(new Insets(20));
        view.setStyle("-fx-background-color: #f5f5f5;");

        GridPane form = new GridPane();
        form.setHgap(10);
        form.setVgap(10);
        form.setPadding(new Insets(10));
        form.setStyle("-fx-background-color: #ffffff; -fx-border-color: #cccccc; -fx-border-radius: 5; -fx-background-radius: 5;");

        Label titleLabel = new Label("Ajouter une nouvelle discipline");
        titleLabel.setFont(new Font(20));
        titleLabel.setPadding(new Insets(0, 0, 20, 0));

        Label nameLabel = new Label("Nom discipline:");
        TextField nameField = new TextField();

        Button addButton = new Button("Ajouter une discipline");
        addButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white;");

        addButton.setOnAction(e -> {
            String name = nameField.getText();
            SportDiscipline discipline = new SportDiscipline(name);
            disciplines.add(discipline);
        });

        form.add(nameLabel, 0, 0);
        form.add(nameField, 1, 0);
        form.add(addButton, 1, 1);

        TableView<SportDiscipline> tableView = new TableView<>(disciplines);
        tableView.setStyle("-fx-background-color: #ffffff; -fx-border-color: #cccccc; -fx-border-radius: 5; -fx-background-radius: 5;");
        TableColumn<SportDiscipline, String> nameColumn = new TableColumn<>("Nom de la Discipline");
        nameColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());

        tableView.getColumns().add(nameColumn);

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
