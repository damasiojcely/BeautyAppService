package pe.com.ctaf.beautyapp.models;


import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by  Damasio user on 19/10/2017.
 */

public class Client {

    private String id;
    private String dni;
    private String  firstName;
    private String lastName;
    private String email;
    private String phone;
    private  String username;

    public Client(String id, String dni, String firstName, String lastName, String email, String phone ,String username) {
        this.setId(id);
        this.setDni(dni);
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setEmail(email);
        this.setPhone(phone);
        this.setUsername(username);
    }
    public Client(){

    }

    public String getId() {return id; }

    public Client setId(String id) {
        this.id = id;
        return this;
    }

    public String getDni() { return dni; }

    public Client setDni(String dni) {
        this.dni = dni;
        return  this;

    }

    public String getFirstName() {return firstName; }

    public Client setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {return lastName; }

    public Client setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getEmail() { return email; }

    public Client setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPhone() {return phone; }

    public Client setPhone(String phone) {
        this.phone = phone;
        return  this;
    }
    public String getUsername() {  return username;


    }

    public Client setUsername(String username) {
        this.username = username;
        return  this;
    }

public static  Client build(ResultSet resultSet){
        try{
            return (new Client())
                    .setId(resultSet.getString("id_cli"))
                    .setDni(resultSet.getString("dni_cli"))
                    .setFirstName(resultSet.getString("firstname_cli"))
                    .setLastName(resultSet.getString("lastname_cli"))
                    .setEmail(resultSet.getString("email_cli"))
                    .setPhone(resultSet.getString("phone_cli"))
                    .setUsername(resultSet.getString("username"));


        }catch (SQLException e) {
           e .printStackTrace();
    }
        return  null;
}

}
