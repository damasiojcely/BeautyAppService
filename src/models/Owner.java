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
    private Login username;

    public Owner() {
    }

    public Owner(String id, String dni, String name, String last, String email, String phone, Login username) {
        this.id = id;
        this.dni = dni;
        this.name = name;
        this.last = last;
        this.email = email;
        this.phone = phone;
        this.username = username;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Login getUsername() {
        return username;
    }

    public void setUsername(Login username) {
        this.username = username;
    }

    public static Owner from(ResultSet rs,LoginsEntity loginsEntity) {
        Owner owner = new Owner();
        try {
            return owner.setId(rs.getString("id_own"))
                    .setDni(rs.getString("dni_own"))
                    .setName(rs.getString("firstname_own"))
                    .setLast(rs.getString("lastname_own"))
                    .setEmail(rs.getString("email_own"))
                    .setPhone(rs.getString("phone_own"));
                    .setUsername(loginsEntity.findByUsername(rs.getUsername("username")));


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}