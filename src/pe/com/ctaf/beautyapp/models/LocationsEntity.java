package pe.com.ctaf.beautyapp.models;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LocationsEntity extends BaseEntity {

    public LocationsEntity(Connection connection, String tableName) {
        super(connection, tableName);
    }

    public LocationsEntity() {
        super();
        setTableName("location");
    }
    public Location findById(String id) {
        return findByCriteria(
                String.format("WHERE id_serv = '%d'", id)).get(0);
    }

    public List<Location> findByCriteria(String criteria) {
        try {
            ResultSet rs = getConnection()
                    .createStatement()
                    .executeQuery(
                            getBaseStatement()
                                    .concat(criteria));
            List<Location> locations = new ArrayList<>();
            while(rs.next())
                locations.add(Location.build(rs));

            return locations;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }
    public Location findByDespartament(String departament) {
        return findByCriteria(
                String.format("WHERE departament_loc= '%s'", departament)).get(0);
    }

    public Location findByProvince(String province){
        return  findByCriteria(String.format("WHERE province_loc = '%s'", province)).get(0);
    }
    public Location findByDistrict(String district){
        return  findByCriteria(String.format("WHERE district_loc= '%s'", district)).get(0);
    }
    public Location findByAddress(String address){
        return  findByCriteria(String.format("WHERE address_loc = '%s'", address)).get(0);
    }
    public List<Location> findAll() {
        return findByCriteria("");
    }

    public List<Location> findAllWithLocations() {
        return findByCriteria("id_loc IN (SELECT DISTINCT id_loc FROM location)");
    }

    public boolean create(Location location) {
        return executeUpdate(String.format(
                "INSERT INTO %s(id_loc, departament_loc,province_loc,district_loc,address_loc) VALUES( '%d', '%s', '%a', '%b', '%c')",
                getTableName(),location.getId(),location.getDepartament(),location.getProvince(),location.getDistrict(),location.getAddress()));
    }
    public boolean create(String id, String departament,String province, String district,String address) {
        return create(new Location(id,departament,province,district,address));
    }

    public boolean update(String id, String departament,String province, String district,String address) {
        return executeUpdate(String.format(
                "UPDATE %s SET departament_loc = '%s', province_loc = '%d', district_loc ='%a', address_loc= '%b' WHERE id_loc = '%s'",
                getTableName(), departament,province,district,address,id));
    }

    public boolean update(Location location) {
        return update(location.getId(),location.getDepartament(),location.getProvince(),location.getDistrict(),location.getAddress());
    }

    public boolean erase(String id) {
        return executeUpdate(String.format("DELETE FROM %s WHERE id_loc = '%s'",
                getTableName(), id));
    }

    public boolean erase(Location location) {
        return executeUpdate(String.format("DELETE FROM %s WHERE id_loc = '%s'",
                getTableName(), location.getId()));
    }
}
