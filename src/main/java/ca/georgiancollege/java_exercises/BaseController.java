package ca.georgiancollege.java_exercises;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public abstract class BaseController {

    private Stage stage;
    private String viewFile, title;

    public void setStage(Stage stage){
        this.stage = stage;
    }

    public BaseController(){}

    //CON ESTO ENLAZAMOS EL CONTROLLER CON EL VIEW CORRESPONDIENTE
    //In order to instantiate a BaseController object, we need to pass in a title and a viewFile
    public BaseController(String title, String viewFile){
        this.title = title;
        this.viewFile = viewFile;
    }

    public void  openPage() throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(CarApplication.class.
                getResource("/ca/georgiancollege/java_exercises/"+ viewFile +"-view.fxml"));

//        System.out.println(getClass().getResource("/ca/georgiancollege/demoassignment1/" + viewFile + "-view.fxml"));
        //"this" is refering To an object of this class

        //Esta línea de código establece el controlador para el archivo
        // FXML que se está cargando. En otras palabras, le dice al
        // FXMLLoader que utilice la instancia actual de BaseController
        // como el controlador para el archivo FXML que se está cargando.
        fxmlLoader.setController(this);

        Scene scene = new Scene(fxmlLoader.load());
        if(stage == null)
            setStage(new Stage());

        stage.setTitle(title);
        stage.setScene(scene);
        stage.show();


    }
}
