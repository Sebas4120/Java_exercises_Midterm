module ca.georgiancollege.java_exercises {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens ca.georgiancollege.java_exercises to javafx.fxml;
    exports ca.georgiancollege.java_exercises;

//    opens Annonymous_Inner_Class to javafx.fxml;
//    exports Annonymous_Inner_Class;
}