package net.ukr.ksm.beans;

import net.ukr.ksm.db.DataBase;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AuthorList {

    private ArrayList<Author> authorArrayList = new ArrayList<Author>();

    private ArrayList<Author> getAuthors(){

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try{
        connection = DataBase.getConnection();
        statement = connection.createStatement();
        resultSet = statement.executeQuery("select * from author ORDER BY fio");
        //resultSet = statement.executeQuery("select * from author");

        while (resultSet.next()) {
            Author author = new Author();
            author.setName(resultSet.getString("fio"));
            authorArrayList.add(author);
        }

       }catch (SQLException ex){
           Logger.getLogger(AuthorList.class.getName()).log(Level.SEVERE, null, ex);
       } finally {
            try{
                if(connection != null) connection.close();
                if(statement != null) statement.close();
                if(resultSet != null) resultSet.close();
            }catch (SQLException ex){
                Logger.getLogger(AuthorList.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return authorArrayList;

    }

    public ArrayList<Author> getAuthorArrayList(){

        if (!authorArrayList.isEmpty()) {
            return authorArrayList;
        } else {
            return getAuthors();
        }

    }

}
