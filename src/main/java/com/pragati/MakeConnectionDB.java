package com.pragati;

import java.io.FileNotFoundException;
import java.sql.*;
import java.io.File;
import java.io.IOException;
import java.io.FileReader;
import java.util.Scanner;

public class MakeConnectionDB {
	protected static Connection connect() {
		try {
			String dbUrl = "jdbc:postgresql://localhost:5432/PragatiAcademy";
			String driver = "org.postgresql.Driver";
			String username = "postgres";
            String password = null;
            File file = new File("pswd/passwordDB.txt");
            try {
                Scanner sc = new Scanner(file);
                while(sc.hasNextLine()){
                    password = sc.nextLine();

                }
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }

			Class.forName(driver);
			Connection conn = DriverManager.getConnection(dbUrl, username, password);

			if(conn.isClosed()) {
				System.out.println("Connection is closed");
			}
			else {
				return conn;
			}
		} catch(Exception e) {
			System.out.println("EXCEPTION OCCURRED IN MAKECONNECTIONDB " + e);
		}

		return null;
	}
}
