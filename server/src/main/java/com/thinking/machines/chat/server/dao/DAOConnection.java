package com.thinking.machines.chat.server.dao;
import java.sql.*;
public class DAOConnection
{
public static String driver;
public static String connectionString;
public static String username;
public static String password;
public static Connection getConnection()
{
try
{
Class.forName(driver);
Connection connection=DriverManager.getConnection(connectionString,username,password);
return connection;
}
catch(SQLException sqlException)
{
//later we will change it
System.out.println(sqlException);
return null;
}
catch(ClassNotFoundException cnfe)
{
System.out.println(cnfe);
return null;
}

}
}