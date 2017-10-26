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
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.discount = discount;
    }

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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }
    public static Service from(ResultSet rs) {
        Service service = new Service();
        try {
            return service.setId(rs.getString("id_serv"))
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
