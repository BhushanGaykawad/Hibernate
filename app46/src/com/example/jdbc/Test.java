package com.example.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class Test {

    public static void main(String[] args) {
        Connection con = null;
        CallableStatement cst = null;
        ResultSet rs = null;

        try {
            // Load MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish connection to MySQL database
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "bhushan", "Bhushan@25");

            // Prepare callable statement for stored procedure
            cst = con.prepareCall("{call getEmps(?)}");

            // Set input parameter for salary range
            cst.setFloat(1, 10000);

            // Execute the stored procedure and get the result set
            rs = cst.executeQuery();

            // Print result set
            System.out.println("ENO\tENAME\tESAL\tEADDR");
            System.out.println("--------------------------");

            // Iterate through the result set and print employee details
            while (rs.next()) {
                System.out.print(rs.getInt("ENO") + "\t");
                System.out.print(rs.getString("ENAME") + "\t");
                System.out.print(rs.getFloat("ESAL") + "\t");
                System.out.print(rs.getString("EADDR") + "\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (cst != null) cst.close();
                if (con != null) con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
