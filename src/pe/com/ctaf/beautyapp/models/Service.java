package pe.com.ctaf.beautyapp.models;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Service {
    private String id;
    private String name;
    private float price;
    private String description;


    public Service() {
    }

    public Service (String id, String name, float price, String description) {
        this.id= id;
        this.name=name;
        this.price=price;
        this.description=description;

    }

    public String getId() {
        return id;
    }



    public Service setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public String getNameAsValue() { return "'" + getName() + "'";}

    public Service setName(String name) {
        this.name = name;
        return this;
    }

    public float getPrice() {
        return price;
    }

    public String getPriceAsString() {
        return String.valueOf(getPrice());
    }

    public Service setPrice(float price) {
        this.price = price;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public String getDescriptionAsValue() { return "'" + getDescription() + "'";}

    public Service setDescription(String description) {
        this.description = description;
        return this;
    }

    public static Service build (ResultSet rs) {

        try {
            return (new Service())
                    .setId(rs.getString("id_serv"))
                    .setName(rs.getString("name_serv"))
                    .setPrice(rs.getFloat("price_serv"))
                    .setDescription(rs.getString("description"));



        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


}
