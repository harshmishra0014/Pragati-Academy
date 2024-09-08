package com.pragati;

import java.util.Scanner;
import java.sql.*;

public class PragatiMain {
	static Scanner sc = new Scanner(System.in);
	static PragatiMain obj = new PragatiMain();

	public static void main(String[] args) {
		if (obj.login()){
			System.out.println("*********** LOGIN SUCCESSFUL ***********");
			obj.afterLogin();
		}
		else
			System.out.println("ALERT: Invalid credentials, check username and password.");
	}

	private void afterLogin() {
		System.out.println("1 -> Class Manager");
		System.out.println("2 -> Student Manager");
		System.out.println("3 -> Admin Manager");
		System.out.println("Enter Your Choice: ");
		int choice = sc.nextInt();
		switch(choice){
			case 1:
				obj.classManager();
				break;
			case 2:
				obj.studentManager();
				break;
			case 3:
				obj.adminManager();
				break;
			default:
				System.out.println("ALERT: Invalid choice.");
		}
	}

	private void classManager() {
		System.out.println("********* Welcome to Class Manager *********");
	}

	private void adminManager() {
		LoginManager lm = new LoginManager();
		System.out.println("********* Welcome to Admin Manager *********");
		System.out.println("1 -> Create new user");
		System.out.println("2 -> Delete existing user");
		System.out.println("Enter your choice: ");
		int choice = sc.nextInt();
		switch (choice){
			case 1: {
				System.out.println("Enter username to be added:");
				String username = sc.next();
				System.out.println("Enter password for " + username + ":");
				String password = sc.next();
				try {
					lm.createUser(username, password);
				} catch (SQLException e) {
					throw new RuntimeException(e);
				}
				break;
			}
			case 2: {
				System.out.println("Enter user to be deleted");
				String username = sc.next();
				System.out.println("Enter password for " + username + ":");
				String password = sc.next();
                try {
                    lm.deleteUser(username, password);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
			}
			default:
				System.out.println("ALERT: Invalid choice.");
		}
	}

	private void studentManager() {
		System.out.println("********* Welcome to Student Manager *********");
	}

	private boolean login() {
		System.out.println("*********** LOGIN WINDOW ***********");
		System.out.println("Enter Username: ");
		String username = sc.next();
		System.out.println("Enter Password: ");
		String password = sc.next();
		LoginManager lm = new LoginManager();
        try {
            return lm.validateUser(username, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
