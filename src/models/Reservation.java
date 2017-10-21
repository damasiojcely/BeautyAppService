package models;


import com.sun.deploy.util.SessionState;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Reservation {
    String id;
    String datereservation;
    String daterequested;
    String price;
    String Start;
    String End;
    Client client;
    Hours hours;


    public Reservation() {
    }

    public Reservation(String id, String datereservation, String daterequested, String price, String start, String end, Client client, Hours hours) {
        this.id = id;
        this.datereservation = datereservation;
        this.daterequested = daterequested;
        this.price = price;
        this.Start = start;
        this.End = end;
        this.client = client;
        this.hours = hours;
    }

    public String getId() {
        return id;
    }

    public Reservation setId(String id) {
        this.id = id;
        return this;
    }

    public String getDatereservation() {
        return datereservation;
    }

    public Reservation setDatereservation(String datereservation) {
        this.datereservation = datereservation;
        return this;
    }

    public String getDaterequested() {
        return daterequested;
    }

    public Reservation setDaterequested(String daterequested) {
        this.daterequested = daterequested;
        return this;
    }

    public String getPrice() {
        return price;
    }

    public Reservation setPrice(String price) {
        this.price = price;
        return this;
    }

    public String getStart() {
        return Start;
    }

    public Reservation setStart(String start) {
        this.Start = start;
        return this;
    }

    public String getEnd() {
        return End;
    }

    public Reservation setEnd(String end) {
        this.End = end;
        return this;
    }

    public Client getClient() {
        return client;
    }

    public Reservation setClient(Client client) {
        this.client = client;
        return this;
    }

    public Hours getHours() {
        return hours;
    }

    public Reservation setHours(Hours hours) {
        this.hours = hours;
        return this;
    }

    public static Reservation from(ResultSet rs, Client client, Hours hours) {
        Reservation reservation = new Reservation();
        try {
            return reservation.setId(rs.getString("id_res"))
                    .setDatereservation(rs.getString("datereservation"))
                    .setDaterequested(rs.getString("daterequested"))
                    .setPrice(rs.getString("price_res"))
                    .setStart(rs.getString("start_res"))
                    .setEnd(rs.getString("end_res"))
                    .setClient(clientsEntity.findById(rs.getString("id_cli"))
                    .setHours(hoursEntity.findById(rs.getString("id_hou"))));

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
