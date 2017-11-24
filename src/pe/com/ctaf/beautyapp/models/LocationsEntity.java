package pe.com.ctaf.beautyapp.models;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LocationsEntity extends BaseEntity{


    public LocationsEntity(Connection connection) {
        super(connection,"location");
    }


    public LocationsEntity() { super(); }

    public List<Location> findByCriteria(String criteria) {
        String sql = getDefaultQuery() + (criteria.equalsIgnoreCase("") ? "" : " WHERE " + criteria);
        List<Location> locations = new ArrayList<>();
        try {
            ResultSet resultSet = getConnection()
                    .createStatement()
                    .executeQuery(sql);
            if (resultSet == null) return null;
            while (resultSet.next()) {
                locations.add(Location.build(resultSet));
            }
            return locations;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    List<Location>findAll(){
        return findByCriteria("");
    }

    public Location findById(String id){
        String criteria = " id = '" + id + "'";
        return findByCriteria(criteria).get(0);
    }


}
