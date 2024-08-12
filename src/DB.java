package src;

import java.sql.*;

public class DB {
    final static String DB_URL="jdbc:mysql://mysql-3f454d7-fistfire794-c94a.g.aivencloud.com:26764/defaultdb?ssl-mode=REQUIRED",USR="avnadmin",PASS="AVNS_jHAKAxReY16EczUhnFS";

    public static Connection getConn(){
        Connection conn = null;
        try{
            conn = DriverManager.getConnection(DB_URL,USR,PASS);
            if(conn!=null){
                System.out.println("Connected to MySQL!");
                return  conn;
            }
            else {
                System.out.println("Not connected to DB!");
            }
        } catch (Exception e){
            System.out.println("Some error occurred : "+e.getMessage());
        }
        return conn;
    }

    //CRUD
    public static void createdb(String dbName, Connection conn){
        String query = "CREATE DATABASE "+dbName;
        try(Statement st = conn.createStatement()){
            st.executeUpdate(query);
            System.out.println("Database " + dbName + " created successfully.");
        } catch (SQLException e){
            System.out.println("Error creating database: " + e.getMessage());
        }
    }

    public void createTable(String query, Connection conn) {
        try (Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(query);
            System.out.println("Table created successfully.");
        } catch (SQLException e) {
            System.out.println("Error creating table: " + e.getMessage());
        }
    }
    public static void insertData(String query, Connection conn) {
        try (Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(query);
            System.out.println("Data inserted successfully.");
        } catch (SQLException e) {
            System.out.println("Error inserting data: " + e.getMessage());
        }
    }

    public static void readData(String query, Connection conn) {
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            ResultSetMetaData rsmd = rs.getMetaData();
            int columnCount = rsmd.getColumnCount();

            while (rs.next()) {
                for (int i = 1; i <= columnCount; i++) {
                    String columnName = rsmd.getColumnName(i);
                    String columnValue = rs.getString(i);
                    System.out.println(columnName + ": " + columnValue);
                }
                System.out.println("-----");
            }
        } catch (SQLException e) {
            System.out.println("Error reading data: " + e.getMessage());
        }
    }

    public static void updateData(String query, Connection conn) {
        try (Statement stmt = conn.createStatement()) {
            int rowsAffected = stmt.executeUpdate(query);
            System.out.println("Updated " + rowsAffected + " row(s) successfully.");
        } catch (SQLException e) {
            System.out.println("Error updating data: " + e.getMessage());
        }
    }
}
