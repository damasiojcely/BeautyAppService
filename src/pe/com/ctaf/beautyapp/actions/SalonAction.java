package pe.com.ctaf.beautyapp.actions;

import com.opensymphony.xwork2.ActionSupport;
import pe.com.ctaf.beautyapp.models.Location;
import pe.com.ctaf.beautyapp.models.Owner;

public class SalonAction extends ActionSupport {
    private String id;
    private String name;
    private String phone;
    private String email;
    private Owner owner;
    private Location location;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String execute(){
        return SUCCESS;
    }
}
