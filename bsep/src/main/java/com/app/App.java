package com.app;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ibatis.common.jdbc.ScriptRunner;

/**
 * Hello world!
 *
 */
@SpringBootApplication
public class App 
{
    public static void main( String[] args ) throws SQLException, ClassNotFoundException
    {
        //System.out.println( "Hello World!" );
    	String aSQLScriptFilePath = "src/main/resources/script.sql";
    	
    	// Create MySql Connection
    	Class.forName("com.mysql.jdbc.Driver");
    	Connection con = DriverManager.getConnection(
    		"jdbc:mysql://localhost:3306/bsep2017?useSSL=false", "root", "root");

    	try {
    		// Initialize object for ScripRunner
    		ScriptRunner sr = new ScriptRunner(con, false, false);

    		// Give the input file to Reader
    		Reader reader = new BufferedReader(
    	                      new FileReader(aSQLScriptFilePath));

    		// Exctute script
    		sr.runScript(reader);

    		} catch (Exception e) {
    				System.err.println("Failed to Execute" + aSQLScriptFilePath
    						+ " The error is " + e.getMessage());
    		}
    	
    	SpringApplication.run(App.class, args);
    }
}
