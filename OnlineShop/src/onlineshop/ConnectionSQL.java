package onlineshop;

import java.sql.*;

public class ConnectionSQL {
    java.sql.Connection conn;
    public java.sql.Connection getConSQL(){
        try{
            // using SQL Management Studio
            String url = "jdbc:sqlserver://localhost:1433;"
                    + "databaseName=db_olshop;user=yourusername;password=yourpassword";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(url);
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        return conn;
    }
}
