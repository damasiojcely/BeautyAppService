package pe.com.ctaf.beautyapp.models;


import java.sql.ResultSet;
import java.sql.SQLException;

public class Reservation {
    private String id;
    private String reservedat;
    private String requestedfor;
    private float price;
    private String startat;
    private String endat;
    private Client client;
    private Schedule schedule;

    public Reservation(String id, String reservedat, String requestedfor,
                       float price, String startat, String endat, Client client, Schedule schedule) {
        this.id = id;
        this.reservedat = reservedat;
        this.requestedfor = requestedfor;
        this.price = price;
        this.startat = startat;
        this.endat = endat;
        this.client = client;
        this.schedule = schedule;
    }

    public Reservation() {
    }


    public String getId() {
        return id;
    }

    public Reservation setId(String id) {
        this.id = id;
        return this;
    }

    public String getReservedat() {
        return reservedat;
    }

    public Reservation setReservedat(String reservedat) {
        this.reservedat = reservedat;
        return this;
    }

    public String getRequestedfor() {
        return requestedfor;
    }

    public Reservation setRequestedfor(String requestedfor) {
        this.requestedfor = requestedfor;
        return this;
    }

    public float getPrice() {
        return price;
    }

    public Reservation setPrice(float price) {
        this.price = price;
        return this;
    }

    public String getStartat() {
        return startat;
    }

    public Reservation setStartat(String startat) {
        this.startat = startat;
        return this;
    }

    public String getEndat() {
        return endat;
    }

    public Reservation setEndat(String endat) {
        this.endat = endat;
        return this;
    }

    public Client getClient() {
        return client;
    }

    public Reservation setClient(Client client) {
        this.client = client;
        return this;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public Reservation setSchedule(Schedule schedule) {
        this.schedule = schedule;
        return this;
    }

    public static Reservation from(ResultSet rs, ClientsEntity clientsEntity, SchedulesEntity schedulesEntity) {
        Reservation reservation = new Reservation();
        try {
            return reservation.setId(rs.getString("id"))
                    .setReservedat(rs.getString("reservedat"))
                    .setRequestedfor(rs.getString("requestedfor"))
                    .setPrice(rs.getFloat("price"))
                    .setStartat(rs.getString("start_at"))
                    .setEndat(rs.getString("end_at"))
                    .setClient(clientsEntity.findById(rs.getString("clientid")))
                    .setSchedule(schedulesEntity.findById(rs.getString("scheduleid")));

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
