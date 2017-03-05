package net.ukr.ksm.beans;

import net.ukr.ksm.db.DataBase;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BookList {

    private ArrayList<Book> bookArrayList = new ArrayList<Book>();

    private ArrayList<Book> getBooks(String str) {

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = DataBase.getConnection();
            statement = connection.createStatement();
//            resultSet = statement.executeQuery("select * from book ORDER BY name");
            resultSet = statement.executeQuery(str);

            while (resultSet.next()) {
                Book book = new Book();
                book.setId(resultSet.getLong("id"));
                book.setName(resultSet.getString("name"));
                book.setGenre(resultSet.getString("genre"));
                book.setIsbn(resultSet.getString("isbn"));
                book.setAuthor(resultSet.getString("author"));
                book.setPageCount(resultSet.getInt("page_count"));
                book.setPublishDate(resultSet.getDate("publish_year"));
                book.setPublisher(resultSet.getString("publisher"));
               // book.setImage(new ImageIcon(resultSet.getBytes("image")).getImage());
                book.setImage(resultSet.getBytes("image"));

                bookArrayList.add(book);
            }

        } catch (SQLException ex) {
            Logger.getLogger(AuthorList.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (resultSet != null) {
                    resultSet.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(AuthorList.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        System.out.println(bookArrayList);
        return bookArrayList;

    }

    public ArrayList<Book> getAllBooks() {

        if (!bookArrayList.isEmpty()) {
            return bookArrayList;
        } else {
            return getBooks("select * from book ORDER BY name");
        }

    }

    public ArrayList<Book> getBooksByGenre(long id) {

        return getBooks("select b.id, b.name, b.isbn, b.page_count, b.publish_year, b.image, \n" +
                "p.name as publisher, a.fio as author, g.name as genre from book b \n" +
                "inner join author a on b.author_id = a.id\n" +
                "inner join genre g on b.genre_id = g.id \n" +
                "inner join publisher p on b.publisher_id = p.id \n" +
                "where genre_id = " + id + " order by b.name limit 0,5 ");
    }

}
