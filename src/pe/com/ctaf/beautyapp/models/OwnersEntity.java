package pe.com.ctaf.beautyapp.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OwnersEntity extends BaseEntity{


    public OwnersEntity(Connection connection) {
        super(connection,"owner");
    }

    public OwnersEntity() { super();   }

    List<Owner>findAll(){
        return findByCriteria("");
    }

    public Owner findById(String id){
        String criteria =  " id = '" + id + "'";
        return findByCriteria(criteria).get(0);
    }


    public Owner findByFisrtName(String firstName){
        String criteria = " first_name = '" + firstName + "'";
        return findByCriteria(criteria).get(0);
    }


    public Owner findyIdByEmailPassword(String email,String password){
        String criteria= " email = '"+email+"' and password = '"+password+"'";
        return findByCriteria(criteria).get(0);
    }

    public List<Owner> findAllById(String id) {
        String criteria = " id = '"+ id+"'";
        return findByCriteria(criteria);
    }


    public boolean findByEmailPass(String email,String password) {
        boolean s =false;
        try{
            PreparedStatement ps =getConnection().prepareStatement(getDefaultQuery() + " where email=? and password=?" );
            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet rs =ps.executeQuery();
            s = rs.next();
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        return s;
    }


    public List<Owner>findByCriteria(String criteria){
        String sql = getDefaultQuery() + (criteria.isEmpty() ? "" : " WHERE " + criteria);
        List<Owner> owners = new ArrayList<>();
        try {
            ResultSet resultSet = getConnection()
                    .createStatement()
                    .executeQuery(sql);
            if(resultSet== null) return null;
            while(resultSet.next()){
                owners.add(Owner.build(resultSet));
            }
            return owners;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Owner findByLastName(String lastName){
        String criteria = " last_name = '" + lastName + "'";
        return findByCriteria(criteria).get(0);
    }

    public boolean add(Owner owner) {
        String sql = "INSERT INTO owner (id, dni, first_name, last_name, email, password, phone) " +
                "VALUES(" +owner.getIdAsValue()+ ", " +owner.getDniAsValue()+ " ," +owner.getFirstNameAsValue()+", " +owner.getLastNameAsValue()+ ", " +owner.getEmailAsValue()+ ", " +
                owner.getPasswordAsValue()+ ", " +owner.getPhoneAsValue()+ ")";
        return change(sql);
    }

    public boolean delete(Owner owner){

        return change("DELETE FROM owner WHERE id = " + owner.getIdAsValue());
    }

    public  boolean update(Owner owner){
        return change("UPDATE owner SET dni = " + owner.getDniAsValue()+ "first_name = " + owner.getFirstNameAsValue() + ", last_name = " + owner.getLastNameAsValue() +
                ", email = " + owner.getEmailAsValue()+ ", password = " + owner.getPasswordAsValue() + ", phone = " + owner.getPhoneAsValue()+ " WHERE id = " +owner.getIdAsValue());
    }

    public boolean updatePass(Owner owner) {
        String sql = "UPDATE owner SET WHERE password = " + owner.getPasswordAsValue()+
                " WHERE id = " + owner.getIdAsValue();
        return change(sql);
    }

}
