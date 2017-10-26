package models;

import java.sql.ResultSet;
import java.sql.SQLException;

public class User {
    String username;
    String password;

    public User(String username, String password) {

        this.username = username;
        this.password = password;
    }

    public User() {
    }

    public String getUsername() {
        return username;
    }

    public User setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public static User from(ResultSet rs) {
        try {
            return new User(
                    rs.getString("username"),
                    rs.getString("password"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
