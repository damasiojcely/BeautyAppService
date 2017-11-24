package pe.com.ctaf.beautyapp.models;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SalonsEntity extends BaseEntity {


    public SalonsEntity(Connection connection) { super(connection,"salon"); }

    public SalonsEntity() {
        super();

    }
    public List<Salon> findAllId(String id, OwnersEntity ownersEntity, LocationsEntity locationsEntity) {
        String criteria = " owner_id = '" + id + "'";
        return findByCriteria(criteria, ownersEntity, locationsEntity);
    }


    public List<Salon> findByCriteria(String criteria, OwnersEntity ownersEntity, LocationsEntity locationsEntity) {
        String sql = getDefaultQuery() + (criteria.isEmpty() ? "" : " WHERE " + criteria);
        List<Salon> salons = new ArrayList<>();

        try {
            ResultSet rs = getConnection().createStatement().executeQuery(sql);
            if (rs == null) return null;
            while (rs.next()) salons.add(Salon.build(rs,ownersEntity,locationsEntity));
            return salons;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }


    public List<Salon> findAll(OwnersEntity ownersEntity, LocationsEntity locationsEntity) {
        return findByCriteria("", ownersEntity, locationsEntity);
    }


    public Salon findById(String id, OwnersEntity ownersEntity, LocationsEntity locationsEntity){
        try {
            String sql = "id = '" + id + "'";
            return findByCriteria(sql, ownersEntity, locationsEntity).get(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean add(Salon salon) {
        String sql = "INSERT INTO salon(id, name, phone, email, owner_id, location_id) VALUES(" + salon.getIdAsValue() + ", " + salon.getNameAsValue() +  ", " + salon.getPhoneAsValue()+ " , "+ salon.getEmailAsValue() + ","+ salon.getOwner().getIdAsValue() + ", " + salon.getLocation().getIdAsValue() + ")";
        return change(sql);
    }

    public boolean update(Salon salon) {
        String sql = "UPDATE salon SET name = " + salon.getNameAsValue() + ", phone = " + salon.getPhoneAsValue()  + ", email = " + salon.getEmailAsValue() + ", owner_id = " + salon.getOwner().getIdAsValue() + ",location_id = " + salon.getLocation().getIdAsValue() + " WHERE id = " + salon.getIdAsValue();
        return change(sql);
    }

    public boolean delete(Salon salon) {
        String sql = "DELETE FROM salon WHERE id = " + salon.getIdAsValue();
        return change(sql);
    }



}
