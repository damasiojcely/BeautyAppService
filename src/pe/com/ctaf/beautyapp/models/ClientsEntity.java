
package pe.com.ctaf.beautyapp.models;

import javax.print.DocFlavor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClientsEntity extends BaseEntity {

    public ClientsEntity(Connection connection){super(connection,"client"); }

    public ClientsEntity(){
        super();

    }

    public Client findIdByEmailPassword(String email,String password){
        String criteria=" email = ' " + email +" ' and password = ' "+ password +" '";
        return findByCriteria(criteria).get(0);
    }

    public List<Client>findAllById(String id){
        String  criteria= " id = '"+id+" '";
        return  findByCriteria(criteria);
    }
    public boolean findByEmailPass(String email,String password){
        boolean s =false;

        try {
            PreparedStatement ps= getConnection().prepareStatement(getDefaultQuery()+ "where email=? and password=?");
            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            s = rs.next();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return s;
    }

    public List<Client> findByCriteria(String  criteria){
        String sql = getDefaultQuery() + (criteria.isEmpty() ? "" : " WHERE " + criteria);
        List<Client> clients = new ArrayList<>();
        try{
            ResultSet rs = getConnection().createStatement().executeQuery(sql);
            if(rs==null) return null;
            while (rs.next()){
                clients.add(Client.build(rs));
            }
            return clients;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  null;

    }
    List<Client>findAll(){return findByCriteria("");}

    public Client findById(String id) {
        String criteria = " id = '" + id + "'";
        return findByCriteria(criteria).get(0);
    }

    public Client findByFisrtName(String firstName) {
        String criteria = " first_name = '" + firstName + "'";
        return findByCriteria(criteria).get(0);
    }

    public Client findByLastName(String lastName) {
        String criteria = " last_name = '" + lastName + "'";
        return findByCriteria(criteria).get(0);

    }

    public List<Client> findClientByOwner(String criteria) {
        String sql = " SELECT c.* from owner o , salon s , reservation r , client c where c.id=r.client_id and r.salon_id=s.id and s.owner_id=o.id and o.id="+"'"+criteria+"'" ;
        List<Client> clients = new ArrayList<>();
        try {
            ResultSet resultSet = getConnection()
                    .createStatement()
                    .executeQuery(sql);
            if(resultSet == null) return null;
            while(resultSet.next()) {
                clients.add(Client.build(resultSet));
            }
            return clients;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean add(Client client) {
        String sql = "INSERT INTO client (id,dni,first_name, last_name, email, password,phone) VALUES(" + client.getIdAsValue() + ", "+ client.getDniAsValue() + ", " + client.getFirstNameAsValue() + " ," + client.getLastNameAsValue() + ", " + client.getEmailAsValue() + ", " + client.getPasswordAsValue() +  ", " + client.getPhoneAsValue() + ")";
        return change(sql);
    }

    public boolean delete(Client client) {
        return change("DELETE FROM client WHERE id = " + client.getIdAsValue());
    }

    public boolean update(Client client) {
        return change("UPDATE client SET dni = " + client.getDniAsValue() + ",first_name = " + client.getFirstNameAsValue() + ", last_name = " + client.getLastNameAsValue() + ", email = " + client.getEmailAsValue() + ", password = " + client.getPasswordAsValue() + ", phone = " + client.getPhoneAsValue()  + " WHERE id = " + client.getIdAsValue());
    }



    public boolean updatePass(Client client) {
        String sql = "UPDATE client SET WHERE password = " +  client.getPasswordAsValue() + " WHERE id = " + client.getIdAsValue();
        return change(sql);
    }




}

