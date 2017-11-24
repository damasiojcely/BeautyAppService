package pe.com.ctaf.beautyapp.models;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by  Damasio user on 19/10/2017.
 */
public class Salon {
    private String id;
    private String name;
    private String phone;
    private String email;
    private Owner owner;
    private Location location;

    public Salon(){

    }

    public Salon(String id, String name, String phone, String email, Owner owner, Location location) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.owner = owner;
        this.location = location;
    }


    public String getId() {return this.id;

    }
    public String getIdAsValue() {
        return "'" + this.getId() + "'";
    }

    public Salon setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {return this.name;

    }
    public String getNameAsValue() {
        return "'" + this.getName() + "'";
    }
    public Salon setName(String name) {
        this.name = name;
        return this;
    }

    public String getPhone() {
        return this.phone;
    }

    public String getPhoneAsValue() {
        return "'" + this.getPhone() + "'";
    }
    public Salon setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getEmail() {return this.email; }
    public String getEmailAsValue() {
        return "'" + this.getEmail() + "'";
    }
    public Salon setEmail(String email) {
        this.email = email;
        return this;
    }

    public Owner getOwner() {  return this.owner; }
    public String getOwnerAsValue() {
        return "'" + this.getOwner() + "'";
    }

    public Salon setOwner(Owner owner) {
        this.owner = owner;
        return this;
    }

    public Location getLocation () {return this.location; }
    public String getLocationAsValue() { return "'" + this.getLocation() + "'"; }

    public Salon setLocation(Location location) {
        this.location = location;
        return this;
    }

    public static Salon build (ResultSet  rs , OwnersEntity ownersEntity , LocationsEntity locationsEntity){
        try{
            return (new Salon())
                    .setId(rs.getString("id"))
                    .setName(rs.getString("name"))
                    .setPhone(rs.getString("phone"))
                    .setEmail(rs.getString("email"))
                    .setOwner(ownersEntity.findById(rs.getString("owner_id")))
                    .setLocation(locationsEntity.findById(rs.getString("location_id")));
        }catch (SQLException var4){
            var4.printStackTrace();
            return null;
        }

    }
}
