package ca.georgiancollege.java_exercises;

import javafx.scene.control.ComboBox;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

public class Car extends BaseModel{

    private String model, color, make,photo;
    private int doors, year;

    private String carDataByIndex;

    private float engine;

    private double km;

    public Car(){

    }

    public Car(String model, String color) {
        setModel(model);
        setColor(color);
    }

    public void Validation(String title, String label){
        if(label.trim().isEmpty()){
            throw new IllegalArgumentException( title + " is empty, please fill it out");
        }
    }

    public void Validation(String title, int label){
        if(label==0){
            throw new IllegalArgumentException ( title + " cannot be 0, please fill it out");
        }
    }

    public void Validation(String title, double label){
        if(label==0.0){
            throw new IllegalArgumentException ( title + " cannot be 0, please fill it out");
        }
    }

    public Car(String model, String color, String make, int doors, int year, double km) throws SQLException {
        setModel(model);
        setColor(color);
        setMake(make);
        setDoors(doors);
        setYear(year);
        setKm(km);

        insertRow();
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        Validation("Model",model);
        this.model = model;
    }

    public String getColor() {

        return color;
    }

    public void setColor(String color) {
        Validation("Color",color);
        this.color = color;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        Validation("Make",make);
        this.make = make;
    }

    public int getDoors() {
        return doors;
    }

    public void setDoors(int doors) {
        Validation("Doors",doors);
        this.doors = doors;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        Validation("Year",year);
        this.year = year;
    }

    public double getKm() {
        return km;
    }

    public void setKm(double km) {
        this.km = km;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
    public float getEngine() {
        return engine;
    }

    public void setEngine(float engine) {
        this.engine = engine;
    }

    //METHODS

    public boolean driving (float howLong){
        if (howLong>15.5){
            return true;
        }
        return false;
    }

    public boolean goingBack(String direction){
        return Objects.equals(direction, "Back");
    }

    public boolean isDoorOpen(int howManyDoorsOpen){

        return howManyDoorsOpen>0;
    }

    //Insertar los datos que ingresa el usuario a mi tabla de base de datos
    private void insertRow()throws SQLException{
        preparedStatement = connection.prepareStatement("insert into " + getTable()+
                " (model, color, make, doors, year, km) " +
                "values (?, ?, ?, ?, ?, ?)" );

        preparedStatement.setString(1, model);
        preparedStatement.setString(2, color);
        preparedStatement.setString(3, make);
        preparedStatement.setInt(4, doors);
        preparedStatement.setInt(5, year);
        preparedStatement.setDouble(6, km);
        preparedStatement.execute();
    }


    public String getCarDataByIndex (int index) throws SQLException {
        String query = "Select * from carData where id = ?";

        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, index);

        ResultSet resultSet = preparedStatement.executeQuery();

        if(resultSet.next()){
            model = resultSet.getString("model");
            color = resultSet.getString("color");
            make = resultSet.getString("make");
            doors = resultSet.getInt("doors");
            year = resultSet.getInt("year");
            km = resultSet.getDouble("km");
        }
        String result = model + "\n" + color + "\n" + make + "\n" + doors + "\n" + year + "\n" + km;
        return result;
    }

    public void updateRow(String model, String color, String make, int doors, int year,
                          double km,
                          int id) throws SQLException {
        // Construir la consulta SQL correcta con las columnas especificadas
        String query = "UPDATE carData SET model = ?, color = ?, make = ?, doors = ?, year = ?, " +
                "km = ? WHERE id = ?";

        // Preparar la declaración con parámetros
        preparedStatement = connection.prepareStatement(query);

        // Establecer los valores de los parámetros
        preparedStatement.setString(1, model);
        preparedStatement.setString(2, color);
        preparedStatement.setString(3, make);
        preparedStatement.setInt(4, doors);
        preparedStatement.setInt(5, year);
        preparedStatement.setDouble(6, km);
        preparedStatement.setInt(7, id);

        // Ejecutar la actualización
        preparedStatement.executeUpdate();
    }

    public static void historialDataToComboBox(ComboBox<String> comboBox) throws SQLException {

        String sql = "select COLOR,MODEL from carData ";

        ResultSet resultSet = new BaseModel().queryResult(sql);

        while (resultSet.next()){
            String color = resultSet.getString("COLOR");
            String model = resultSet.getString("MODEL");

            Car car = new Car(model,color);
            comboBox.getItems().add((resultSet.getString("COLOR")) + " : "
                    + (resultSet.getString("MODEL")));

        }

    }


    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\n' +
                ", color='" + color + '\n' +
                ", make='" + make + '\n' +
                ", doors=" + doors + '\n' +
                ", year=" + year + '\n' +
                ", Km=" + km + '\n' +
                '}';
    }
}
