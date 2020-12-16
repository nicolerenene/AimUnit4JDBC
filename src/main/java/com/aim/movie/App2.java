package com.aim.movie;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class App2 {
    public static String URL = "jdbc:mysql://localhost:3306/movie";
    private static final String USER = "root";
    private static final String PASS = "B!ddy828#love";

    public static void main(String[] args) {
        try {
        Connection connection = DriverManager.getConnection(URL, USER, PASS);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM movies;");

        while(resultSet.next()) {
            String movieTitle = resultSet.getString("movie_name");
            System.out.println("Movie Title: " + movieTitle);
        }
    }catch (Exception e) {
        e.printStackTrace();
    }
    }

}
