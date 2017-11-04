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
        this.setId(id);
        this.setDepartament(departament);
        this.setProvince(province);
        this.setDistrict(district);
        this.setAddress(address);
    }


    public String getId() {
        return id;
    }

    public Location setId(String id) {
        this.id = id;
        return this;
    }

    public String getDepartament() {
        return departament;
    }

    public Location setDepartament(String depart) {
        this.departament = depart;
        return this;
    }

    public String getProvince() {
        return province;
    }

    public Location setProvince(String province) {
        this.province = province;
        return this;
    }

    public String getDistrict() {
        return district;
    }

    public Location setDistrict(String district) {
        this.district = district;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public Location setAddress(String address) {
        this.address = address;
        return this;
    }
    public static Location build (ResultSet rs) {

        try {
            return (new Location())
                    .setId(rs.getString("id_loc"))
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
