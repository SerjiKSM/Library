package net.ukr.ksm.beans;


import net.ukr.ksm.db.DataBase;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GenreList {

    private ArrayList<Genre> genreArrayList = new ArrayList<Genre>();

    private ArrayList<Genre> getGenres(){

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try{
            connection = DataBase.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select * from genre ORDER BY name");

            while (resultSet.next()) {
                Genre genre = new Genre();
                genre.setId(resultSet.getLong("id"));
                genre.setName(resultSet.getString("name"));
                genreArrayList.add(genre);
            }

        }catch (SQLException ex){
            Logger.getLogger(AuthorList.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try{
                if(connection != null) {
                    connection.close();
                }
                if(statement != null) {
                    statement.close();
                }
                if(resultSet != null) {
                    resultSet.close();
                }
            }catch (SQLException ex){
                Logger.getLogger(AuthorList.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return genreArrayList;

    }

    public ArrayList<Genre> getGenreArrayList(){

        if (!genreArrayList.isEmpty()) {
            return genreArrayList;
        } else {
            return getGenres();
        }

    }


}
