package ca.georgiancollege.java_exercises;

import java.sql.SQLException;
import java.util.Objects;

public class Car extends BaseModel{

    private String model, color, make,photo;
    private int doors, year;

    private float engine;

    private double km;

    public Car(){

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

    //Tener un historial de autos que se han creado en el combobox


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
