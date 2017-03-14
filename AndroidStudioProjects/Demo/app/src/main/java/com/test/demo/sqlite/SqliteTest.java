package com.test.demo.sqlite;

import com.test.demo.retrofit.RetrofitActivity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Li Zhi
 * 2017/3/11.
 */

public class SqliteTest {
    public static void main(String[] args){
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            String sql = "select * from meizu;";
            String table_sql = "create table meizu(id integer primary key autoincrement,name text not null);";
            String insert_sql = "insert into meizu('name') values('lizhi')";
            String insert_sql_1 = "insert into meizu('name') values('xinyue');";
            connection = connection();
            statement = createStatement(connection);
            createTable(statement, table_sql);
            insertData(statement, insert_sql);
            insertData(statement, insert_sql_1);
            resultSet = executeQuery(statement, sql);
            showResult(resultSet);
        }finally {
            try {
                if(resultSet != null){
                    resultSet.close();
                }
                if(statement != null){
                    statement.close();
                }
                if(connection != null){
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


    }

    private static void createTable(Statement statement,String sql){
        try {
            statement.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void insertData(Statement statement, String sql){
        try {
            statement.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static Connection connection(){
        Connection connection = null;
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:company.db");
            System.out.println("Opened database successfully");
            return connection;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static Statement createStatement(Connection connection){
        if(connection == null){
            return null;
        }
        try {
            Statement statement = connection.createStatement();
            return statement;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static ResultSet executeQuery(Statement statement, String sql){
        if(statement == null){
            return null;
        }
        try {
            ResultSet resultSet = statement.executeQuery(sql);
            return resultSet;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static void showResult(ResultSet resultSet){
        if(resultSet == null){
            return;
        }
        try {
            while (resultSet.next()){
                System.out.print(resultSet.getInt("id") + " : ");
                System.out.println(resultSet.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
