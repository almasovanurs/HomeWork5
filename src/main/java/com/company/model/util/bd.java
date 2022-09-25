package com.company.model.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class bd {
    private static final String  url = "jdbc:postgresql://localhost:5432/dz";
    private static final String  user = "postgres";
    private static final String  password = "Nursuluu11";



    public static Connection connect(){
        Connection conn = null;
        try{
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connect болду postgres серверге кошулду");
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return conn;
    }
    public static void getById(int id){
        String SQLid = " SELECT id " +
                "FROM city " +
                "WHERE id = ?";
        try(Connection connect = connect();
            PreparedStatement statement = connect.prepareStatement(SQLid)){
            statement.setInt(1,(int) id );
            statement.executeUpdate();
            System.out.println("айдишкасы мн чыгаруу");
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }


}
