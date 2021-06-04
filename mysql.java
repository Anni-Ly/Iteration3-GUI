package dk.diku.systemudvikling2021;

import java.sql.*;

public class mysql {
    public static void main (String[] args) {
        String url = "jdbc:mysql://127.0.0.1:3306/?user=root";
        String password = "Qjf68dpe";


        String query = "SELECT * FROM CoronaNet.Testt";

        try (Connection con = DriverManager.getConnection(url, null, password);
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(query)) {

            while(rs.next()) {
                int id = rs.getInt(1);
                String teststed = rs.getString(2);
                String testtype = rs.getString(3);
                String testresultater = rs.getString(4);
                String coronavariant = rs.getString (5);
                int postnr = rs.getInt(6);
                Date dato = rs.getDate (7);
                System.out.println("id: " + id + " | teststed: " + teststed + " | testtype: " + testtype + " |testresultater " + testresultater + " | coronavariant:" + coronavariant + " | postnr" + postnr + " | dato: " + dato);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
