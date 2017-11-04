package models;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Service {
    private String id;
    private String name;
    private int price;
    private String description;
    private int discount;

    public Service() {
    }

    public Service(String id, String name, int price, String description, int discount) {
        this.setId(id);
        this.setName(name);
        this.setPrice(price);
        this.setDescription(description);
        this.setDiscount(discount);
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

    public Service setName(String name) {
        this.name = name;
        return this;
    }

    public int getPrice() {
        return price;
    }

    public Service setPrice(int price) {
        this.price = price;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Service setDescription(String description) {
        this.description = description;
        return this;
    }

    public int getDiscount() {
        return discount;
    }

    public Service setDiscount(int discount) {
        this.discount = discount;
        return this;
    }
    public static Service build (ResultSet rs) {

        try {
            return (new Service())
                    .setId(rs.getString("id_serv"))
                    .setName(rs.getString("name_serv"))
                    .setPrice(rs.getInt("price_serv"))
                    .setDescripcion(rs.getString("description_serv"))
                    .setDiscount(rs.getInt("discount_serv"));


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
