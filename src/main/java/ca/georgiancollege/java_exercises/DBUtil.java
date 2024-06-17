package ca.georgiancollege.java_exercises;

import java.sql.*;

public class DBUtil {
    //Connection String
    //Username
    //password
    //database

    private String connectionString, username , password, database;
    private String table;

    protected Connection connection;
    protected Statement statement;
    protected PreparedStatement preparedStatement;


    public DBUtil (String database){
        this.database = database;
        connectionString = "jdbc:mysql://database-1.cpiiw6m2micq.us-east-2.rds.amazonaws.com:3306";
        username = "admin";
        password = "Narangita412.";

        try{
            connection = DriverManager.getConnection
                    (connectionString + "/" + database,username,password);
        }catch (Exception e){
            System.err.println(e);
        }
    }

    public DBUtil(String database, String table){
        this(database);
        setTable(table);
    }

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }

    //Paso 2
    public void queryExec(String sql) throws Exception{
        statement = connection.createStatement();
        statement.execute(sql);
    }

    public ResultSet queryResult (String sql) throws SQLException{
        preparedStatement = connection.prepareStatement(sql);
        return preparedStatement.executeQuery();

    }

}
