package com.example.controller;

import com.example.model.CountryMedalTable;
import com.example.model.Result;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Button;
import javafx.scene.control.cell.PropertyValueFactory;

public class MedalTableController {
    @FXML
    private TableView<CountryMedalTable> medalTable;
    @FXML
    private TableColumn<CountryMedalTable, String> countryColumn;
    @FXML
    private TableColumn<CountryMedalTable, Integer> goldColumn;
    @FXML
    private TableColumn<CountryMedalTable, Integer> silverColumn;
    @FXML
    private TableColumn<CountryMedalTable, Integer> bronzeColumn;
    @FXML
    private TableColumn<CountryMedalTable, Integer> pointsColumn;
    @FXML
    private Button reportButton;

    private ObservableList<CountryMedalTable> medalData = FXCollections.observableArrayList();

    @FXML
    private void initialize() {
        // Initialize the columns.
        countryColumn.setCellValueFactory(new PropertyValueFactory<>("pays"));
        goldColumn.setCellValueFactory(new PropertyValueFactory<>("or"));
        silverColumn.setCellValueFactory(new PropertyValueFactory<>("argent"));
        bronzeColumn.setCellValueFactory(new PropertyValueFactory<>("bronze"));
        pointsColumn.setCellValueFactory(new PropertyValueFactory<>("points"));

        // Set data to the table
        medalTable.setItems(medalData);
    }

    public void setMedalData(ObservableList<CountryMedalTable> medalData) {
        this.medalData = medalData;
        medalTable.setItems(medalData);
    }

    public void updateMedalData(ObservableList<Result> results) {
        for (Result result : results) {
            String country = result.getAthlete().getPays();
            CountryMedalTable medalTableEntry = medalData.stream()
                    .filter(entry -> entry.getPays().equals(country))
                    .findFirst()
                    .orElseGet(() -> {
                        CountryMedalTable newEntry = new CountryMedalTable(country, 0, 0, 0);
                        medalData.add(newEntry);
                        return newEntry;
                    });

            switch (result.getMedal()) {
                case "Or":
                    medalTableEntry.addOr();
                    break;
                case "Argent":
                    medalTableEntry.addArgent();
                    break;
                case "Bronze":
                    medalTableEntry.addBronze();
                    break;
            }
        }
    }

    @FXML
    private void handleGenerateReport() {
        generateReport();
    }

    private void generateReport() {
        StringBuilder report = new StringBuilder();
        report.append("Rapport des Médailles par Pays:\n");
        for (CountryMedalTable entry : medalData) {
            report.append("Pays: ").append(entry.getPays())
                    .append(", Or: ").append(entry.getOr())
                    .append(", Argent: ").append(entry.getArgent())
                    .append(", Bronze: ").append(entry.getBronze())
                    .append(", Points: ").append(entry.getPoints())
                    .append("\n");
        }
        System.out.println(report.toString());
    }
}
