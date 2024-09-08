package com.pragati;

import java.sql.*;

public class LoginManager {
    private final String table = "users";
    Connection con = MakeConnectionDB.connect();

    protected boolean validateUser(String username, String password) throws SQLException{
        String query = "select password from users where username = '" + username + "'";
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);
        rs.next();
        String userPassword = rs.getString(1);
        return (password.equals(userPassword));
    }

    protected boolean createUser(String username, String password) throws SQLException{
        String query = "Insert into users values (?, ?)";

        PreparedStatement pst = con.prepareStatement(query);
        pst.setString(1, username);
        pst.setString(2, password);
        int i = pst.executeUpdate();
        pst.close();
        con.close();
        return (i != 0);
    }

    protected boolean deleteUser(String username, String password) throws SQLException{
        String query = "delete from users where username = (?)";
        int i = 0;
        if(validateUser(username, password)){
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, username);
            i = pst.executeUpdate();
            pst.close();
            con.close();
        }
        return i != 0;
    }
}
