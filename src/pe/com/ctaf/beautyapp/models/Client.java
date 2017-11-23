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
    private  String password ;
    private String phone;



    public Client(String id, String dni, String firstName, String lastName, String email,String password, String phone) {
        this.setId(id) ;
        this.setDni(dni);
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setEmail(email);
        this.setPassword(password);
        this.setPhone(phone);

    }

    public Client() {

    }

    public String getId() {return this.id; }
    public String getIdAsValue() {
        return "'" + this.getId() + "'";
    }

    public Client setId(String id) {
        this.id = id;
        return this;
    }

    public String getDni() { return this.dni; }

    public String getDniAsValue() {
        return "'" + this.getDni() + "'";
    }

    public Client setDni(String dni) {
        this.dni = dni;
        return  this;

    }

    public String getFirstName() {return this.firstName; }

    public String getFirstNameAsValue() {
        return "'" + this.getFirstName() + "'";
    }

    public Client setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {return this.lastName; }

    public String getLastNameAsValue() {
        return "'" + this.getLastName() + "'";
    }

    public Client setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getEmail() { return this.email; }

    public String getEmailAsValue() {
        return "'" + this.getEmail() + "'";
    }


    public Client setEmail(String email) {
        this.email = email;
        return this;
    }


    public String getPassword() {
        return this.password;
    }
    public String getPasswordAsValue() {
        return "'" + this.getPassword() + "'";
    }

    public Client setPassword(String password) {
        this.password = password;
        return  this;
    }


    public String getPhone() {return this.phone; }
    public String getPhoneAsValue() {
        return "'" + this.getPhone() + "'";
    }


    public Client setPhone(String phone) {
        this.phone = phone;
        return  this;
    }



    public static Client build (ResultSet rs){
        try{
            return (new Client())
                    .setId(rs.getString("id"))
                    .setDni(rs.getString("dni"))
                    .setFirstName(rs.getString("firstname"))
                    .setLastName(rs.getString("lastname"))
                    .setEmail(rs.getString("email"))
                    .setPassword(rs.getString("password"))
                    .setPhone(rs.getString("phone"));



        }catch (SQLException var3) {
            var3 .printStackTrace();
            return  null;
        }

    }


}
