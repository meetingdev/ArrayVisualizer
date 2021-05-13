package main;

import javafx.application.Application;

import javafx.stage.Stage;

public class Main extends Application {
    public static ArrayVisualizer arrayVisualizer;
    @Override
    public void start(Stage stage) throws Exception {
        arrayVisualizer = new ArrayVisualizer();
    }
}
