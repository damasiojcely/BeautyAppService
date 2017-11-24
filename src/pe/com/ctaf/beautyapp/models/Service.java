package pe.com.ctaf.beautyapp.models;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Service {
    private String id;
    private String name;
    private float price;
    private Salon salon;


    public Service() {
    }

    public Service (String id, String name, float price, Salon salon) {
        this.id= id;
        this.name=name;
        this.price=price;
        this.salon=salon;

    }

    public String getId() {
        return id;
    }

    public String getIdAsValue(){return "'" + getId() + "'";}



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

    public Salon getSalon() {
        return salon;
    }

    public String getSalonAsValue() { return "'" + getSalon() + "'";}

    public Service setSalon(Salon salon) {
        this.salon = salon;
        return this;
    }

    public static Service build (ResultSet rs,SalonsEntity salonsEntity,OwnersEntity ownersEntity, LocationsEntity locationsEntity) {

        try {
            return (new Service())
                    .setId(rs.getString("id"))
                    .setName(rs.getString("name"))
                    .setPrice(rs.getFloat("price"))
                    .setSalon(salonsEntity.findById(rs.getString("salon_id"),ownersEntity,locationsEntity));

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


}
