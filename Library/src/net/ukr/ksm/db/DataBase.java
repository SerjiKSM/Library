package net.ukr.ksm.db;


import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DataBase {

    private static Connection connection;

    public static Connection getConnection(){

        try {

           InitialContext initialContext = new InitialContext();

//            DataSource dataSource = (DataSource) initialContext.lookup("java:comp/env/jdbc/MySQLDataSource");
            DataSource dataSource = (DataSource) initialContext.lookup("jdbc/MySQLDataSource");

            // ksm +
            if (connection != null) {
                connection.close();
                connection = null;
            }
            // ksm -

            if (connection == null) {
                connection = dataSource.getConnection();
            }

        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
        }

        return connection;
    }

    // Надо дописать закрытие базы данных

}
