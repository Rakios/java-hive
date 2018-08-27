/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

        
/**
 *
 * @author B705578
 */
public class hive {
  
   private static String driverName = "org.apache.hive.jdbc.HiveDriver";
    public static void main(String[] args) throws SQLException {
        // TODO code application logic here
	
    try {
        //Conect
        Class.forName(driverName);
        Connection con = DriverManager.getConnection("jdbc:hive2://localhost/default", 
                "user", "Password");
	Statement stmt = con.createStatement();
	 
        
        // show tables
	String tableName = "sample_07";
	String query= "SELECT * FROM " + tableName ;
	ResultSet res = stmt.executeQuery(query);
		
		System.out.println("Running: " + query);
		while (res.next()) {
			System.out.println(res.getString(1));
			System.out.println(res.getString(2));
			System.out.println(res.getString(3));
		}
	 
	res.close();
	stmt.close();
	con.close();
			
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			
		}
		
	
	
	}
	
	
	
	
		
		// show tables
		/*
		String sql = "show tables '" + tableName + "'";
		System.out.println("Running: " + sql);
		res = stmt.executeQuery(sql);
		if (res.next()) {
			System.out.println(res.getString(1));
		}
 		*/
		
	    // describe table
		/*
	    sql = "describe " + tableName;
	    System.out.println("Running: " + sql);
	    res = stmt.executeQuery(sql);
	    while (res.next()) {
	      System.out.println(res.getString(1) + "\t" + res.getString(2) + "\t" + res.getString(2));
	    }
	    */
		
	    // load data into table
	    // NOTE: filepath has to be local to the hive server
	    // NOTE: /home/user/input.txt is a ctrl-A separated file with three fields per line
	    /*
	    String filepath = "\\Users\\B705578\\Documents";
	    sql = "load data local inpath '" + filepath + "' into table " + tableName;
	    System.out.println("Running: " + sql);
	    res = stmt.executeQuery(sql);
	    
		sql = "select * from sample_07 ";
		res = stmt.executeQuery(sql);
		// show tables
		System.out.println("Running: " + sql);
		res = stmt.executeQuery(sql);
		while (res.next()) {
			System.out.println(res.getString(1));
			System.out.println(res.getString(2));
			System.out.println(res.getString(3));
		}
		*/
        
        
    }
    

