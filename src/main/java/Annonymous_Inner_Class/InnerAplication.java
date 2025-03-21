package Annonymous_Inner_Class;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class InnerAplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(InnerAplication.class.getResource(
                "Annonymous_Inner_Class.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Inner time!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }


}