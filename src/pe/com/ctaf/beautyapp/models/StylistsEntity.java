package pe.com.ctaf.beautyapp.models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StylistsEntity extends BaseEntity {

    public StylistsEntity(Connection connection){super(connection,"stylist"); }

    public StylistsEntity(){

    }

    public List<Stylist> findAll(OwnersEntity ownersEntity) {
        return this.findByCriteria("", ownersEntity);
    }

    public Stylist findById(String id, OwnersEntity ownersEntity) {
        String criteria = " id = '" + id + "'";
        return (Stylist) this.findByCriteria(criteria, ownersEntity).get(0);
    }

    public List<Stylist> findAllId(String id,OwnersEntity ownersEntity) {
        String criteria = " owner_id = '" + id + "'";
        return this.findByCriteria(criteria, ownersEntity);
    }


    public List<Stylist> findByCriteria(String criteria, OwnersEntity ownersEntity) {
        String sql = this.getDefaultQuery() + (criteria.isEmpty() ? "" : " WHERE " + criteria);
        ArrayList stylists = new ArrayList();

        try {
            ResultSet rs = getConnection().createStatement().executeQuery(sql);
            if(rs == null) return null;
            while(rs.next()) stylists.add(Stylist.build(rs, ownersEntity));
            return stylists;
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return stylists;
    }


    public List<Stylist> findByOwner(Owner owner, OwnersEntity ownersEntity) {
        String criteria = "owner_id = " + owner.getIdAsValue();
        return this.findByCriteria(criteria, ownersEntity);
    }

    public List<Stylist> findAllOrderByFirstName(OwnersEntity ownersEntity, boolean isAscending) {
        return this.findByCriteria("true ORDER BY first_name" + (isAscending ? "" : " DESC"), ownersEntity);
    }

    public List<Stylist> findAllOrderByLastName(OwnersEntity ownersEntity, boolean isAscending) {
        return this.findByCriteria("true ORDER BY last_name" + (isAscending ? "" : " DESC"), ownersEntity);
    }


    public boolean add(Stylist stylist) {
        String sql = "INSERT stylist (id,dni,first_name, last_name, email,phone, owner_id) VALUES(" + stylist.getIdAsValue()+ ", "+ stylist.getDniAsValue()  + ", " + stylist.getFirstNameAsValue() + ", " + stylist.getLastNameAsValue() + ", " + stylist.getEmailAsValue() + ", " +stylist.getPhoneAsValue() + ", "+ stylist.getOwner().getIdAsValue() + ")";
        return this.change(sql);
    }

    public boolean update(Stylist stylist) {
        String sql = "UPDATE stylist SET dni = " + stylist.getDniAsValue() + ",first_name = " + stylist.getFirstNameAsValue() + ", last_name = " + stylist.getLastNameAsValue() + ", email = " + stylist.getEmailAsValue() + ", phone = " + stylist.getPhoneAsValue()+ ", owner_id = " + stylist.getOwner().getIdAsValue() + " WHERE id = " + stylist.getIdAsValue();
        return this.change(sql);
    }

    public boolean delete(Stylist stylist) {
        String sql = "DELETE FROM stylist WHERE id = " + stylist.getIdAsValue();
        return this.change(sql);
    }

    public boolean delete(String id) {
        String sql = "DELETE FROM stylist WHERE id = '" + id + "'";
        return this.change(sql);
    }

}


