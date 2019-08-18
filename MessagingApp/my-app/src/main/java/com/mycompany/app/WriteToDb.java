package com.mycompany.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class WriteToDb {

    public static void main(String[] argv)
    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys","root","myRootPwd");
            Statement stat = connection.createStatement();
            ResultSet rs = stat.executeQuery("SELECT * FROM sys.fish");
            while(rs.next())
            {
                System.out.println(rs.getInt(1) +  " " + rs.getString(2));
            }
            stat.close();
            connection.close();
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }
}
