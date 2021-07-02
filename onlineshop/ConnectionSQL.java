package onlineshop;

import java.sql.*;

public class ConnectionSQL {
    java.sql.Connection conn;
    public java.sql.Connection getConSQL(){
        try{
            String url = "jdbc:sqlserver://localhost:1433;"
                    + "databaseName=db_olshop;user=sa;password=shandy122002";
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
