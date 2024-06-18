package ca.georgiancollege.java_exercises;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;
import java.nio.file.Path;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.ArrayList;
import java.util.List;

import static ca.georgiancollege.java_exercises.Car.historialDataToComboBox;

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
    private Button update;



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
    public void initialize() throws SQLException {
        output.setText("");
        error.setText("");

        historialDataToComboBox(comboBox);

//        comboBox.getItems().add("Select a car");

        submit.setOnAction(event -> {
            try {


                Car ford1 = new Car(model.getText(), color.getText(), make.getText(),
                        Integer.parseInt(doors.getText()),
                        Integer.parseInt(years.getText()), slider.getValue());


                output.setText(ford1.toString());

                addCarToComboBox(ford1);

                //Estableciendo la imagen de la derecha segun la seleccionada por el usuario
                ford1.setPhoto(photoList.get(photoListIndex));

                Image image = new Image(String.valueOf(getClass().getResource(ford1.getPhoto())));
                if (image.isError()) {
                    error.setText("Image not found.");
                } else {
                    rightPhoto.setImage(image);
                }
//                rightPhoto.setImage(
//                        new Image(String.valueOf(getClass().getResource(ford1.getPhoto()))
//                        )
//                );

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
            int indexMain = comboBox.getSelectionModel().getSelectedIndex();

            Car car = new Car();

            try {
                String carData = car.getCarDataByIndex(indexMain + 1);

                color.setText(car.getColor());
                model.setText(car.getModel());
                make.setText(car.getMake());
                doors.setText(String.valueOf(car.getDoors()));
                years.setText(String.valueOf(car.getYear()));
                slider.setValue(car.getKm());


            } catch (SQLException e) {
                throw new RuntimeException(e);
            }


//            color.setText(selected.getColor());
//            model.setText(selected.getModel());
//            make.setText(selected.getMake());
//            doors.setText(String.valueOf(selected.getDoors()));
//            years.setText(String.valueOf(selected.getYear()));
//            slider.setValue(selected.getKm());
//
//            Image image = new Image(String.valueOf(getClass().getResource(selected.getPhoto())));
//            if (image.isError()) {
//                error.setText("Image not found.");
//            } else {
//                mainPhoto.setImage(image);
//            }
        });

        update.setOnAction(event -> {
            // Obtener el índice seleccionado
            int index = comboBox.getSelectionModel().getSelectedIndex();
            // Obtener los nuevos valores
            String newColor = color.getText();
            String newModel = model.getText();
            String newMake = make.getText();
            int newDoors = Integer.parseInt(doors.getText());
            int newYear = Integer.parseInt(years.getText());
            double newKm = slider.getValue();
            // Crear una instancia de Car y actualizar la fila
            Car car = new Car();
            // Actualizar la fila
            try {
                // Actualizar la fila
               car.updateRow(newModel,newColor,newMake, newDoors, newYear, newKm, index + 1);
//
            } catch (SQLException e) {
                    throw new RuntimeException(e);
            };

        });

        comboBox.setOnAction(event -> {
            System.out.println("On Action");

            int index = comboBox.getSelectionModel().getSelectedIndex();
            // Crear una instancia de Car y obtener los datos por índice
            Car car = new Car();

            try{
                String carData = car.getCarDataByIndex(index + 1);
                output.setText(carData);

                // Actualizar la imagen principal
                mainPhoto.setImage(
                        new Image(String.valueOf(getClass().getResource(car.getPhoto()))
                        )
                );

            }catch(SQLException e){
                e.printStackTrace();
            }
        });



    }

    public void displayCars(){
        for (Car c : carsList){
            System.out.println(c);
        }
        System.out.println("-".repeat(20));

    }



    private void addCarToComboBox(Car car) {
        comboBox.getItems().add(car.getColor() + " : " + car.getModel());
    }

    private void updateComboBoxItem(int index, Car car) {
        comboBox.getItems().set(index, car.getColor() + " : " + car.getModel());
    }








}