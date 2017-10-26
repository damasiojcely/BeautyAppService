package models;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Location {
    private String id;
    private String departament;
    private String province;
    private String district;
    private String address;

    public Location() {
    }

    public Location(String id, String departament, String province, String district, String address) {
        this.id = id;
        this.departament = departament;
        this.province = province;
        this.district = district;
        this.address = address;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDepartament() {
        return departament;
    }

    public void setDepartament(String depart) {
        this.departament = depart;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public static Location from(ResultSet rs) {
        Location location = new Location();
        try {
            return location.setId(rs.getString("id_loc"))
                    .setDepartament(rs.getString("departament_loc"))
                    .setProvince(rs.getString("province_loc"))
                    .setDistrict(rs.getString("district_loc"))
                    .setAddress(rs.getString("address_loc"));


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
