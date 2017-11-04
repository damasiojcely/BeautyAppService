package models;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Schedule {
    private String id;
    private String startAt;
    private String endAt;
    private float discount;
    private Stylist stylist;
    private Service service;
    private Salon salon;

    public Schedule(String id, String startAt, String endAt, float discount, Stylist stylist, Service service, Salon salon) {
        this.id = id;
        this.startAt = startAt;
        this.endAt = endAt;
        this.discount = discount;
        this.stylist = stylist;
        this.service = service;
        this.salon = salon;
    }

    public Schedule() {
    }

    public String getId() {
        return id;
    }

    public Schedule setId(String id) {
        this.id = id;
        return this;
    }

    public String getStartAt() {
        return startAt;
    }

    public Schedule setStartAt(String startAt) {
        this.startAt = startAt;
        return this;
    }

    public String getEndAt() {
        return endAt;
    }

    public Schedule setEndAt(String endAt) {
        this.endAt = endAt;
        return this;
    }

    public float getDiscount() {
        return discount;
    }

    public Schedule setDiscount(float discount) {
        this.discount = discount;
        return this;
    }

    public Stylist getStylist() {
        return stylist;
    }

    public Schedule setStylist(Stylist stylist) {
        this.stylist = stylist;
        return this;
    }

    public Service getService() {
        return service;
    }

    public Schedule setService(Service service) {
        this.service = service;
        return this;
    }

    public Salon getSalon() {
        return salon;
    }

    public Schedule setSalon(Salon salon) {
        this.salon = salon;
        return this;
    }

    public static Schedule from(ResultSet rs, StylistsEntity stylistsEntity, ServicesEntity servicesEntity,
                                SalonsEntity salonsEntity) {
        Schedule schedule = new Schedule();
        try {
            return schedule.setId(rs.getString("id"))
                    .setStartAt(rs.getString("start_at"))
                    .setEndAt(rs.getString("end_at"))
                    .setDiscount(rs.getFloat("discount"))
                    .setStylist(stylistsEntity.findById(rs.getString("stylistid")))
                    .setService(servicesEntity.findById(rs.getString("serviceid")))
                    .setSalon(salonsEntity.findById(rs.getString("salonid"))));

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
