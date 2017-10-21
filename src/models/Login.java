package models;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Login {
    String username;
    String password;

    public Login(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Login() {
    }

    public String getUsername() {
        return username;
    }

    public Login setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public Login setPassword(String password) {
        this.password = password;
        return this;
    }

    public static Login from(ResultSet rs) {
        try {
            return new Login(
                    rs.getString("username"),
                    rs.getString("password"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
