package models;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Hours {
    String id;
    String start;
    String end;
    Stylist stylist;
    Service service;
    Salon salon;

    public Hours() {
    }

    public Hours(String id, String start, String end, Stylist stylist, Service service, Salon salon) {
        this.id = id;
        this.start = start;
        this.end = end;
        this.stylist = stylist;
        this.service = service;
        this.salon = salon;
    }

    public String getId() {
        return id;
    }

    public Hours setId(String id) {
        this.id = id;
        return this;
    }

    public String getStart() {
        return start;
    }

    public Hours setStart(String start) {
        this.start = start;
        return this;
    }

    public String getEnd() {
        return end;
    }

    public Hours setEnd(String end) {
        this.end = end;
        return this;
    }

    public Stylist getStylist() {
        return stylist;
    }

    public Hours setStylist(Stylist stylist) {
        this.stylist = stylist;
        return this;
    }

    public Service getService() {
        return service;
    }

    public Hours setService(Service service) {
        this.service = service;
        return this;
    }

    public Salon getSalon() {
        return salon;
    }

    public Hours setSalon(Salon salon) {
        this.salon = salon;
        return this;
    }

    public static Hours from(ResultSet rs, Stylist stylist, Service service, Salon salon) {
        Hours hours = new Hours();
        try {
            return hours.setId(rs.getString("id_hou"))
                    .setStart(rs.getString("start_hou"))
                    .setEnd(rs.getString("end_hou"))
                    .setStylist(stylistEntity.findById(rs.getString("id_sty"))
                            .setService(servicesEntity.findById(rs.getString("id_serv")))
                            .setSalon(salonsEntity.findById(rs.getString("id_sal"))));

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
