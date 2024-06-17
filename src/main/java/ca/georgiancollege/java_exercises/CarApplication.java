package ca.georgiancollege.java_exercises;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.Stage;


import java.io.IOException;

public class CarApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
//        FXMLLoader fxmlLoader = new FXMLLoader(CarApplication.class.getResource
//                ("car-view.fxml"));
//        Scene scene = new Scene(fxmlLoader.load());
//        stage.setTitle("Car time!");
//        stage.setScene(scene);
//        stage.show();

            CarController controller = new CarController("Car time!", "car");
            controller.setStage(stage);
            controller.openPage();
    }

    public static void main(String[] args) {
        launch();
    }
}