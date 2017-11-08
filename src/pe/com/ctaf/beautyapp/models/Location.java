package pe.com.ctaf.beautyapp.models;
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
        this.id=id;
        this.departament=departament;
        this.province=province;
        this.district=district;
        this.address=address;
    }


    public String getId() {
        return id;
    }

    public String getIdAsValue() { return "'" + getId() + "'";}

    public Location setId(String id) {
        this.id = id;
        return this;
    }

    public String getDepartament() {
        return departament;
    }

    public String getDepartamentAsValue() { return "'" + getDepartament() + "'";}

    public Location setDepartament(String departament) {
        this.departament = departament;
        return this;
    }

    public String getProvince() {
        return province;
    }

    public String getProvinceAsValue() { return "'" + getProvince() + "'";}

    public Location setProvince(String province) {
        this.province = province;
        return this;
    }

    public String getDistrict() {
        return district;
    }

    public String getDistrictAsValue() { return "'" + getDistrict() + "'";}

    public Location setDistrict(String district) {
        this.district = district;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public String getAddressAsValue() { return "'" + getAddress() + "'";}

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
