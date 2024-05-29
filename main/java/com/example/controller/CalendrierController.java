package com.example.controller;

import com.example.model.SportEvent;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class CalendrierController {
    @FXML
    private TableView<SportEvent> tableView;
    @FXML
    private TableColumn<SportEvent, String> colDate;
    @FXML
    private TableColumn<SportEvent, String> colHeure;
    @FXML
    private TableColumn<SportEvent, String> colDiscipline;
    @FXML
    private TableColumn<SportEvent, String> colLieu;
    @FXML
    private TableColumn<SportEvent, String> colParticipants;
    @FXML
    private TableColumn<SportEvent, String> colResultats;

    private ObservableList<SportEvent> eventList;

    @FXML
    private void initialize() {
        colDate.setCellValueFactory(cellData -> cellData.getValue().dateProperty());
        colHeure.setCellValueFactory(cellData -> cellData.getValue().timeProperty());
        colDiscipline.setCellValueFactory(cellData -> cellData.getValue().disciplineProperty());
        colLieu.setCellValueFactory(cellData -> cellData.getValue().locationProperty());
        colParticipants.setCellValueFactory(cellData -> cellData.getValue().participantsProperty());
        colResultats.setCellValueFactory(cellData -> cellData.getValue().resultsProperty());
    }

    public void setEventList(ObservableList<SportEvent> eventList) {
        this.eventList = eventList;
        tableView.setItems(eventList);
    }
}
