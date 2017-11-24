package pe.com.ctaf.beautyapp.models;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Owner {
    private String id;
    private String dni;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phone;

    public Owner() {
    }

    public Owner(String id,String dni, String firstName, String lastName,
                 String email, String password,String phone)
    {
        this.setId(id);
        this.setDni(dni);
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setEmail(email);
        this.setPassword(password);
        this.setPhone(phone);

    }

    public String getId() { return id; }

    public String getIdAsValue(){ return "'" + getId() + "'";}

    public Owner setId(String id) {
        this.id = id;
        return  this;
    }

    public String getDni() { return dni; }

    public String getDniAsValue(){ return  "'" + getDni() + "'";}

    public Owner setDni(String dni) {
        this.dni = dni;
        return this;
    }

    public String getFirstName() { return firstName; }

    public String getFirstNameAsValue(){ return "'" + getFirstName() + "'";}

    public Owner setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() { return lastName; }

    public String getLastNameAsValue(){ return "'" + getLastName() + "'";}

    public Owner setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getEmail() { return email; }

    public String getEmailAsValue(){ return "'" + getEmail() + "'";}

    public Owner setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() { return password; }

    public String getPasswordAsValue(){ return "'" + getPassword() + "'";}

    public Owner setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getPhone() {  return phone; }

    public String getPhoneAsValue(){return "'" + getPhone() + "'";}

    public Owner setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public static Owner build(ResultSet resultSet){
        try {
            return (new Owner())
                    .setId(resultSet.getString("id"))
                    .setDni(resultSet.getString("dni"))
                    .setFirstName(resultSet.getString("first_name"))
                    .setLastName(resultSet.getString("last_name"))
                    .setEmail(resultSet.getString("email"))
                    .setPassword(resultSet.getString("password"))
                    .setPhone(resultSet.getString("phone"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
