package pe.com.ctaf.beautyapp.models;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SalonsEntity extends BaseEntity {


    public SalonsEntity(Connection connection) { super(connection,"salon"); }

    public SalonsEntity() {

    }
    public List<Salon> findAllId(String id, OwnersEntity ownersEntity, LocationsEntity locationsEntity) {
        String criteria = " ownerid = '" + id + "'";
        return this.findByCriteria(criteria, ownersEntity, locationsEntity);
    }


    public List<Salon> findByCriteria(String criteria, OwnersEntity ownersEntity, LocationsEntity locationsEntity) {
        String sql = this.getDefaultQuery() + (criteria.isEmpty() ? "" : " WHERE " + criteria);
        ArrayList salons = new ArrayList();

        try {
            ResultSet rs = this.getConnection().createStatement().executeQuery(sql);
            if (rs == null) {
                return null;
            } else {
                while(rs.next()) {
                    salons.add(Salon.build(rs, ownersEntity, locationsEntity));
                }

                return salons;
            }
        } catch (SQLException var7) {
            var7.printStackTrace();
            return null;
        }
    }


    public List<Salon> findAll(OwnersEntity ownersEntity, LocationsEntity locationsEntity) {
        return this.findByCriteria("", ownersEntity, locationsEntity);
    }


    public Salon findById(String id, OwnersEntity ownersEntity, LocationsEntity locationsEntity){
        try {
            String sql = "id = '" + id + "'";
            return (Salon) this.findByCriteria(sql, ownersEntity, locationsEntity).get(0);
        } catch (Exception var5) {
            var5.printStackTrace();
            return null;
        }
    }

    public boolean add(Salon salon) {
        String sql = "INSERT INTO salon(id, name, phone, email, ownerid, locationid) VALUES(" + salon.getIdAsValue() + ", " + salon.getNameAsValue() +  ", " + salon.getPhoneAsValue()+ " , "+ salon.getEmailAsValue() + ","+ salon.getOwner().getIdAsValue() + ", " + salon.getLocation().getIdAsValue() + ")";
        return this.change(sql);
    }

    public boolean update(Salon salon) {
        String sql = "UPDATE courts SET name = " + salon.getNameAsValue() + ", phone = " + salon.getPhoneAsValue()  + ", email = " + salon.getEmailAsValue() + ", ownerid = " + salon.getOwner().getIdAsValue() + ",locationid = " + salon.getLocation().getIdAsValue() + " WHERE id = " + salon.getIdAsValue();
        return this.change(sql);
    }

    public boolean delete(Salon salon) {
        String sql = "DELETE FROM courts WHERE id = " + salon.getIdAsValue();
        return this.change(sql);
    }



}
