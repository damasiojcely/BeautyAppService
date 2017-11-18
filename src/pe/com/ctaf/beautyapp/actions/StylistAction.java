package pe.com.ctaf.beautyapp.actions;

import com.opensymphony.xwork2.ActionSupport;
import pe.com.ctaf.beautyapp.models.User;

public class StylistAction extends ActionSupport {
    private String id;
    private String dni;
    private String firstname;
    private String lastname;
    private String email;
    private String phone;
    private User user;

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

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    public String execute(){
        return SUCCESS;
    }
}
