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
    private User user;

    public Client(){

    }

    public Client(String id, String dni, String firstName, String lastName, String email, String phone, User user) {
        this.id=id ;
        this.dni=dni;
        this.firstName=firstName;
        this.lastName=lastName;
        this.email=email;
        this.phone=phone;
        this.user=user;
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


    public User getUser() { return user; }


    public Client setUser(User user) {
        this.user =user;
        return this;
    }


public static Client build (ResultSet rs, UsersEntity usersEntity){
        try{
            return (new Client())
                    .setId(rs.getString("id"))
                    .setDni(rs.getString("dni"))
                    .setFirstName(rs.getString("first_name"))
                    .setLastName(rs.getString("last_name"))
                    .setEmail(rs.getString("email"))
                    .setPhone(rs.getString("phone"))
                    .setUser(usersEntity.findById(rs.getString("username")));


        }catch (SQLException var3) {
           var3 .printStackTrace();
            return  null;
          }

     }


}
