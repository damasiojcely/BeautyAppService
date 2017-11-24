package pe.com.ctaf.beautyapp.models;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class Reservation {
    private int id;
    private Date reserdate;
    private Date resertime;
    private float price;
    private Client client;
    private Salon salon;

    public Reservation() {
    }

    public Reservation(int id, Date reserdate, Date resertime, float price, Client client, Salon salon) {
        this.id = id;
        this.reserdate = reserdate;
        this.resertime = resertime;
        this.price = price;
        this.client = client;
        this.salon = salon;
    }

    public int getId() {
        return id;
    }

    public String getIdAsString() {
        return String.valueOf(getId());
    }

    public Reservation setId(int id) {
        this.id = id;
        return this;
    }

    public Date getReserdate() {
        return reserdate;
    }

    public String getReserdateAsValue() { return "'" + getReserdate() + "'";}

    public Reservation setReserdate(Date reserdate) {
        this.reserdate = reserdate;
        return this;
    }

    public Date getResertime() {
        return resertime;
    }

    public String getResertimeAsValue() { return "'" + getResertime()+ "'";}

    public Reservation setResertime(Date resertime) {
        this.resertime = resertime;
        return this;
    }

    public float getPrice() {return price;}

    public String getPriceAsString(){return String.valueOf(getPrice());}

    public Reservation setPrice(float price) {
        this.price = price;
        return this;
    }

    public Client getClient() {
        return client;
    }
    public String getClientAsValue() {return "'" + getClient()+"'";}

    public Reservation setClient(Client client) {
        this.client = client;
        return this;
    }

    public Salon getSalon() {
        return salon;
    }
    public String getSalonAsValue() {return "'" + getSalon()+"'";}

    public Reservation setSalon(Salon salon) {
        this.salon = salon;
        return this;
    }

    public static Reservation build(ResultSet resultSet,
                                    ClientsEntity clientsEntity,
                                    SalonsEntity salonsEntity,
                                    OwnersEntity ownersEntity,
                                    LocationsEntity locationsEntity){
        try{
            return (new Reservation())
                    .setId(resultSet.getInt("id"))
                    .setReserdate(resultSet.getDate("reser_date"))
                    .setResertime(resultSet.getDate("reser_time"))
                    .setPrice(resultSet.getFloat("price"))
                    .setClient(clientsEntity.findById(resultSet.getString("client_id")))
                    .setSalon(salonsEntity.findById(resultSet.getString("salon_id"),ownersEntity,locationsEntity));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
