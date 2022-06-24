package com.gladikov.pi.app;

import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


import nodes.NodeOne;

public class Application {
	static {

	}

	public static void main(String[] args) throws UnknownHostException {
		
		//Postgres
		String url = "jdbc:postgresql://localhost:5432/mydb";
        String user = "max";
        String password = "hyundai";

        try (Connection con = DriverManager.getConnection(url, user, password);
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery("SELECT VERSION()")) {

            if (rs.next()) {
                System.out.println(rs.getString(1));
            }
            	Long id=new Long(1);
            	String query = "INSERT INTO temp(id, name) VALUES(?, ?)";
                PreparedStatement pst = con.prepareStatement(query)) {
               
               pst.setLong(1, id);
               //pst.setString(2, author);
               pst.executeUpdate();};

                } catch (SQLException ex) {

               Logger lgr = Logger.getLogger(Application.class.getName());
               lgr.log(Level.SEVERE, ex.getMessage(), ex);
           }
		//**********
		
		
		Thread t=new Thread(new NodeOne());
		t.start();
		
		
	}
}
