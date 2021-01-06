package com.aim.movie;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
//import com.aim.movie.util.MySQL;

public class App2 {
    public static String URL = "jdbc:mysql://localhost:3306/movie";
    private static final String USER = "root";
    private static final String PASS = "B!ddy828#love";

    public static void main(String[] args) {
        try {

            Scanner input = new Scanner(System.in);
            System.out.print("Please enter a movie title: ");
            String movieTitle = input.nextLine();
            input.close();

            StringBuilder sql2 = new StringBuilder();
            sql2.append("SELECT movie_name, first_name, last_name ");
            sql2.append("FROM movies m ");
            sql2.append("JOIN directors d ON d.director_id = m.director_id ");
            sql2.append("JOIN ratings r ON r.rating_id = m.rating_id");
            sql2.append("JOIN genres g ON g.genre_id = m.genre_id");
            sql2.append("WHERE m.movie_name = '" + movieTitle + "';");

            //System.out.println("Movie Title: " + movieTitle);

            Connection connection = DriverManager.getConnection(URL, USER, PASS);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql2.toString());

            while(resultSet.next()) {
                String movieName = resultSet.getString("movie_name");
                System.out.println("Movie Title: " + movieName);

                String directorFirstName = resultSet.getString("first_name");
                String directorLastName = resultSet.getString("last_name");
                System.out.println("Director's Name: " + directorFirstName + " " + directorLastName);
        }
    }catch (SQLException e) {
        e.printStackTrace();
        System.out.println("\nSQL (copy the SQL statement below and run it if you're having problems): \n" + sql2.toString + "\n");
    }
    }

}
