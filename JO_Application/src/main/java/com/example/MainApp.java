package com.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import com.example.view.AthleteView;
import com.example.view.DisciplineView;
import com.example.view.EventView;
import com.example.view.ResultView;

public class MainApp extends Application {

    private Stage primaryStage;
    private BorderPane rootLayout;

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Olympics Management");

        initRootLayout();
        showAthleteOverview();
    }

    public void initRootLayout() {
        rootLayout = new BorderPane();

        MenuBar menuBar = new MenuBar();
        Menu menuFile = new Menu("File");
        MenuItem exitMenuItem = new MenuItem("Exit");
        exitMenuItem.setOnAction(e -> System.exit(0));
        menuFile.getItems().add(exitMenuItem);

        Menu menuView = new Menu("View");
        MenuItem athleteMenuItem = new MenuItem("Manage Athletes");
        athleteMenuItem.setOnAction(e -> showAthleteOverview());
        MenuItem disciplineMenuItem = new MenuItem("Manage Disciplines");
        disciplineMenuItem.setOnAction(e -> showDisciplineOverview());
        MenuItem eventMenuItem = new MenuItem("Manage Events");
        eventMenuItem.setOnAction(e -> showEventOverview());
        MenuItem resultMenuItem = new MenuItem("Manage Results");
        resultMenuItem.setOnAction(e -> showResultOverview());
        menuView.getItems().addAll(athleteMenuItem, disciplineMenuItem, eventMenuItem, resultMenuItem);

        menuBar.getMenus().addAll(menuFile, menuView);

        rootLayout.setTop(menuBar);

        Scene scene = new Scene(rootLayout, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void showAthleteOverview() {
        AthleteView athleteView = new AthleteView();
        rootLayout.setCenter(athleteView.getView());
    }

    public void showDisciplineOverview() {
        DisciplineView disciplineView = new DisciplineView();
        rootLayout.setCenter(disciplineView.getView());
    }

    public void showEventOverview() {
        EventView eventView = new EventView();
        rootLayout.setCenter(eventView.getView());
    }

    public void showResultOverview() {
        ResultView resultView = new ResultView();
        rootLayout.setCenter(resultView.getView());
    }

    public static void main(String[] args) {
        launch(args);
    }
}
