package models;


import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by  Damasio user on 19/10/2017.
 */

public class Stylist {
   private String id;
   private String dni;
   private String firstName;
   private String lastName;
   private String email;
   private String phone;
   private String especialty;
   private String username;


    public Stylist(String id, String dni, String firstName, String lastName, String email, String phone, String especialty , String username) {
        this.setId(id);
        this.setDni(dni);
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setEmail(email);
        this.setPhone(phone);
        this.setEspecialty(especialty);
        this.setUsername(username);
    }


     public Stylist(){

     }

    public String getId() {return id;

    }

    public Stylist setId(String id) {
        this.id = id;
        return  this;
    }

    public String getDni() {return dni;

    }

    public Stylist setDni(String dni) {
        this.dni = dni;
        return  this;
    }

    public String getFirstName() { return firstName;

    }

    public Stylist setFirstName(String firstName) {
        this.firstName = firstName;
        return  this;
    }

    public String getLastName() {
        return lastName;
    }

    public Stylist setLastName(String lastName) {
        this.lastName = lastName;
        return  this;
    }

    public String getEmail() { return email;

    }

    public Stylist setEmail(String email) {
        this.email = email;
        return  this;
    }

    public String getPhone() {return phone;
    }


    public Stylist setPhone(String phone) {
        this.phone = phone;
        return  this;
    }

    public String getEspecialty() {  return especialty;


    }

    public Stylist setEspecialty(String especialty) {
        this.especialty = especialty;
        return  this;
    }

    public String getUsername() {  return username;


    }

    public Stylist setUsername(String username) {
        this.username = username;
        return  this;
    }
    public static Stylist build (ResultSet resultSet){
         try{
             return (new Stylist())
                     .setId(resultSet.getString("id_sty"))
                     .setDni(resultSet.getString("dni_sty"))
                     .setFirstName(resultSet.getString("firstname:sty"))
                     .setLastName(resultSet.getString("lastname_sty"))
                     .setEmail(resultSet.getString("email_sty"))
                     .setPhone(resultSet.getString("phone_sty"))
                     .setEspecialty(resultSet.getString("especialty_sty"))
                     .setUsername(resultSet.getString("username"));

         }catch (SQLException e){
             e.printStackTrace();
     }
         return  null;
    }
}
