package models;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Owner {
    private String id;
    private String dni;
    private String name;
    private String last;
    private String email;
    private String phone;
    private String username;

    public Owner() {
    }

    public Owner(String id, String dni, String name, String last, String email, String phone, String username) {
        this.setId(id);
        this.setDni(dni);
        this.setName(name);
        this.setLast(last);
        this.setEmail(email);
        this.setPhone(phone);
        this.setUsername(username);
    }


    public String getId() {
        return id;
    }

    public Owner setId(String id) {
        this.id = id;
        return this;
    }

    public String getDni() {
        return dni;
    }

    public Owner setDni(String dni) {
        this.dni = dni;
        return this;
    }

    public String getName() {
        return name;
    }

    public Owner setName(String name) {
        this.name = name;
        return this;
    }

    public String getLast() {
        return last;
    }

    public Owner setLast(String last) {
        this.last = last;
        return  this;
    }

    public String getEmail() {
        return email;
    }

    public Owner setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public Owner setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public Owner setUsername(String username) {
        this.username = username;
        return this;
    }

    public static Owner build (ResultSet rs) {

        try {
            return (new Owner())
                    .setId(rs.getString("id_own"))
                    .setDni(rs.getString("dni_own"))
                    .setName(rs.getString("firstname_own"))
                    .setLast(rs.getString("lastname_own"))
                    .setEmail(rs.getString("email_own"))
                    .setPhone(rs.getString("phone_own"))
                    .setUsername(rs.getString("username"));


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
