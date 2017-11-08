package pe.com.ctaf.beautyapp.models;

import org.glassfish.internal.api.Public;

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
    private String own;
    private String loc;

    public Salon(){

    }

    public Salon(String id, String name, String phone, String email, String own, String loc) {
        this.setId(id);
        this.setName(name);
        this.setPhone(phone);
        this.setEmail(email);
        this.setOwn(own);
        this.setLoc(    loc);
    }


    public String getId() {return id;

    }

    public Salon setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {return name;

    }

    public Salon setName(String name) {
        this.name = name;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public Salon setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getEmail() {return email;

    }

    public Salon setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getOwn() {  return own;

    }

    public Salon setOwn(String own) {
        this.own = own;
        return this;
    }

    public String getLoc() {return loc;

    }

    public Salon setLoc(String loc) {
        this.loc = loc;
        return this;
    }

    public static Salon build (ResultSet  rs ,OwnersEntity ownersEntity ,UbigeosEntity ubigeosEntity){
        try{
            return (new Salon())
                .setId(rs.getString("id_sal"))
                    .setName(rs.getString("name_sal"))
                    .setPhone(rs.getString("phone_sal"))
                    .setEmail(rs.getString("mail_sal"))
                    .setOwn(rs.getString("id_own"))
                    .setLoc(rs.getString("id_loc"));
        }catch (SQLException e){
            e.printStackTrace();
        }
         return null;
    }
}
