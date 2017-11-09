package pe.com.ctaf.beautyapp.models;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Skill {
    private String stylistid;
    private String serviceid;
    private float time;

    public Skill(String stylistid, String serviceid, float time) {
        this.setStylistid(stylistid);
        this.setServiceid(serviceid);
        this.setTime(time);
    }

    public Skill() {
    }

    public String getStylistid() {
        return stylistid;
    }

    public Skill setStylistid(String stylistid) {
        this.stylistid = stylistid;
        return this;
    }

    public String getServiceid() {
        return serviceid;
    }

    public Skill setServiceid(String serviceid) {
        this.serviceid = serviceid;
        return this;
    }

    public float getTime() {
        return time;
    }

    public Skill setTime(float time) {
        this.time = time;
        return this;
    }

    public static Skill build (ResultSet rs) {

        try {
            return (new Skill())
                    .setStylistid(rs.getString("stylistid"))
                    .setServiceid(rs.getString("serviceid"))
                    .setTime(rs.getFloat("timeof"));

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
