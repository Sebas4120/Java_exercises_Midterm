package ca.georgiancollege.java_exercises;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;
import java.nio.file.Path;
import java.sql.SQLException;
import java.util.ArrayList;

public class CarController extends BaseController{

    @FXML
    private TextField color;

    @FXML
    private TextField doors;

    @FXML
    private Label error;

    @FXML
    private TextField make;

    @FXML
    private TextField model;

    @FXML
    private Label output;

    @FXML
    private TextField years;

    @FXML
    private ComboBox<String> comboBox;

    @FXML
    private Button submit;


    @FXML
    private Button arrowLeft;

    @FXML
    private Slider slider;

    @FXML
    private Button arrow;

    @FXML
    private ImageView rightPhoto;
    @FXML
    private ImageView mainPhoto;

    @FXML
    private Button edit;

    private ArrayList<Car> carsList = new ArrayList<>();

    private ArrayList<String> photoList = new ArrayList<>();

    private int photoListIndex;



//___________________________________________________________________________________
    public CarController(String title, String viewFile) {
        super(title, viewFile);
    }

    @FXML
    public void initialize() {
        output.setText("");
        error.setText("");


        submit.setOnAction(event -> {
            try {


                Car ford1 = new Car(model.getText(), color.getText(), make.getText(),
                        Integer.parseInt(doors.getText()),
                        Integer.parseInt(years.getText()), slider.getValue());


                output.setText(ford1.toString());



                //Estableciendo la imagen de la derecha segun la seleccionada por el usuario
                ford1.setPhoto(photoList.get(photoListIndex));

                rightPhoto.setImage(
                        new Image(String.valueOf(getClass().getResource(ford1.getPhoto()))
                        )
                );

                error.setText("");
                model.setText("");
                color.setText("");
                make.setText("");
                doors.setText("");
                years.setText("");

                //Agregamos los datos del auto a la lista y esta lista es la que agregamos al
                // combobox
                carsList.add(ford1);
                //Aqui abajooo
                addingToComboBox(ford1);

                displayCars();

            } catch (NumberFormatException a) {
                error.setText(a.getMessage());
            } catch (IllegalArgumentException e) {
                error.setText(e.getMessage());
                System.out.println(e.getMessage());
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        });
//Imagenessss
        String path = getClass().getResource("photos").getPath();
        System.out.println(path);

        try {
            Path p =
                    Path.of(getClass().getResource("photos").toURI());

            for(File filePath: p.toFile().listFiles()){
                if(filePath.getName().contains("default")){
                    continue;
                } else if (filePath.getName().contains("edit")){
                    continue;

                }else if (filePath.getName().contains("app")){
                    continue;
                }

                photoList.add("photos/" + filePath.getName());
                System.out.println(filePath.getName());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

//        >
        arrow.setOnAction(event ->{

            String text = ((Button) event.getSource()).getText();
            System.out.println(text);

            if (photoListIndex >= photoList.size() - 1) {
                    photoListIndex = 0;
            } else {
                    photoListIndex += 1;
            }

        System.out.println(photoList.get(photoListIndex));
         mainPhoto.setImage(new Image(String.valueOf(getClass().getResource(photoList.get(photoListIndex)))));
        });

//        <
        arrowLeft.setOnAction(event ->{
            String text = ((Button) event.getSource()).getText();
            System.out.println(text);

            if (photoListIndex <= 0) {
                photoListIndex = photoList.size() - 1;
            } else {
                photoListIndex -= 1;
            }

            System.out.println(photoList.get(photoListIndex));
            mainPhoto.setImage(new Image(String.valueOf(getClass().getResource(photoList.get(photoListIndex)))));

        });

        edit.setOnAction(event -> {
          int index = comboBox.getSelectionModel().getSelectedIndex();

            Car selected = carsList.get(index);

            color.setText(selected.getColor());
            model.setText(selected.getModel());
            make.setText(selected.getMake());
            doors.setText(selected.getDoors() + "");
            years.setText(selected.getYear() + "");
            slider.setValue(selected.getKm());

            mainPhoto.setImage(
                    new Image(String.valueOf(getClass().getResource(selected.getPhoto()))
                    )
            );
        });

    }



    @FXML
    void onChange(ActionEvent event) {
        int index = comboBox.getSelectionModel().getSelectedIndex();

        output.setText(carsList.get(index).toString());

        System.out.println("On Change");
    }



    public void displayCars(){
        for (Car c : carsList){
            System.out.println(c);
        }
        System.out.println("-".repeat(20));

    }

    public void addingToComboBox(Car car){
        comboBox.getItems().add(car.getMake() + " -> " + car.getModel());
    }




}