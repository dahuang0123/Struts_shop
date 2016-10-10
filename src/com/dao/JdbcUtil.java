package com.dao;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;


public class JdbcUtil{
    public static final String driver = "com.mysql.jdbc.Driver";
    public static final String url = "jdbc:mysql://127.0.0.1:3306/test";
    public static final String password = "87520852";
    public static final String username = "root";
    static{
        try {
           Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection(){
        Connection connection = null;
        try {
            connection = (Connection) DriverManager.getConnection(url,username,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
    public void Release(ResultSet rs,Statement stmt,Connection conn){
            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(stmt!=null){
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(conn!=null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
    }
    public static void release(Object o){
        try{
            if(o instanceof ResultSet){
                ((ResultSet)o).close();
            }else if(o instanceof Statement){
                ((Statement)o).close();
            }else if(o instanceof Connection){
                ((Connection)o).close();
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}

