package Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class connectWithDatabase {

    public static Connection getConnection(){
        // ten driver + url db
        final String JDBC_DRIVER = "org.sqlite.JDBC";
        final String url = "jdbc:sqlite:C:\\Users\\ADMIN\\Desktop\\project_oop\\database\\data.db";

        try{
            Class.forName(JDBC_DRIVER);

            return DriverManager.getConnection(url);
        }
        catch(ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
