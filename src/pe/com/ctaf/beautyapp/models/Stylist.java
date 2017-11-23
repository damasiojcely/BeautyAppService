package pe.com.ctaf.beautyapp.models;



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
    private Owner owner;



    public Stylist(){

    }

    public Stylist(String id, String dni, String firstName, String lastName, String email , String phone,Owner owner ) {
        this.id=id;
        this.dni=dni;
        this.firstName=firstName;
        this.lastName=lastName;
        this.email=email;
        this.phone=phone;
        this.owner=owner;

    }

    public String getId() {return this.id; }

    public String getIdAsValue() {
        return "'" + this.getId() + "'";
    }
    public Stylist setId(String id) {
        this.id = id;
        return  this;
    }

    public String getDni() {return this.dni;

    }
    public String getDniAsValue() {
        return "'" + this.getDni() + "'";
    }

    public Stylist setDni(String dni) {
        this.dni = dni;
        return  this;
    }

    public String getFirstName() { return this.firstName; }

    public String getFirstNameAsValue() {
        return "'" + this.getFirstName() + "'";
    }

    public Stylist setFirstName(String firstName) {
        this.firstName = firstName;
        return  this;
    }

    public String getLastName() {
        return this.lastName;
    }
    public String getLastNameAsValue() {
        return "'" + this.getLastName() + "'";
    }

    public Stylist setLastName(String lastName) {
        this.lastName = lastName;
        return  this;
    }

    public String getEmail() { return this.email; }
    public String getEmailAsValue() {
        return "'" + this.getEmail() + "'";
    }

    public Stylist setEmail(String email) {
        this.email = email;
        return  this;
    }

    public String getPhone() {return this.phone; }
    public String getPhoneAsValue() {
        return "'" + this.getPhone() + "'";
    }
    public Stylist setPhone(String phone) {
        this.phone = phone;
        return  this;
    }
    public Owner getOwner() {
        return this.owner;
    }

    public Stylist setOwner(Owner owner) {
        this.owner = owner;
        return this;
    }


    public static Stylist build(ResultSet rs,OwnersEntity ownersEntity){
        try{
            return (new Stylist())
                    .setId(rs.getString("id"))
                    .setDni(rs.getString("dni"))
                    .setFirstName(rs.getString("firstname"))
                    .setLastName(rs.getString("lastname"))
                    .setEmail(rs.getString("email"))
                    .setPhone(rs.getString("phone"))
                    .setOwner(ownersEntity.findById(rs.getString("ownerid")));


        }catch (SQLException var7){
            var7.printStackTrace();
            return  null;
        }

    }


}
