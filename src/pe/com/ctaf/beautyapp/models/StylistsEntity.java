package pe.com.ctaf.beautyapp.models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StylistsEntity extends BaseEntity {

    public StylistsEntity(){
        super();
        setTableName("stylist");
    }

    public StylistsEntity(Connection connection, String tableName){super(connection,tableName); }
    public Stylist findById(String id, UsersEntity usersEntity){
        return findByCriteria(
                String.format("WHERE id= ' %s' ",id),usersEntity).get(0);
    }

    public List<Stylist> findByCriteria(String  criteria, UsersEntity usersEntity){
        try{
            ResultSet rs = getConnection()
                    .createStatement()
                    .executeQuery(
                            getBaseStatement()
                                    .concat(criteria));
            List<Stylist> stylists =new ArrayList<>();
            while(rs.next())
                stylists.add(Stylist.build(rs,usersEntity));

            return stylists;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  null;
    }

    public Stylist findByDni(String dni, UsersEntity usersEntity) {
        return findByCriteria(
                String.format("WHERE dni= '%s'", dni), usersEntity).get(0);
    }

    public Stylist findByName(String firstName, UsersEntity usersEntity) {
        return findByCriteria(
                String.format("WHERE first_name= '%s'", firstName), usersEntity).get(0);
    }
    public Stylist findByLast(String lastName, UsersEntity usersEntity) {
        return findByCriteria(
                String.format("WHERE last_name= '%s'", lastName), usersEntity).get(0);
    }
    public Stylist findByEmail(String email, UsersEntity usersEntity) {
        return findByCriteria(
                String.format("WHERE email= '%s'", email), usersEntity).get(0);
    }
    public Stylist findByPhone(String phone, UsersEntity usersEntity) {
        return findByCriteria(
                String.format("WHERE phone= '%s'", phone), usersEntity).get(0);
    }

    public List<Stylist> findAll(UsersEntity usersEntity) {
        return findByCriteria("", usersEntity);
    }

    public boolean create(Stylist stylist) {
        return executeUpdate(String.format(
                "INSERT INTO %s(id, dni,first_name,last_name, email, phone, username) VALUES( '%s', '%s', '%s', '%s', '%s','%s','%e')",
                getTableName(), stylist.getId(), stylist.getDni(), stylist.getFirstName(), stylist.getLastName(), stylist.getEmail(), stylist.getPhone(), stylist.getUser().getUsername()));
    }
    public boolean create(String id, String dni,String name, String last,String email,String phone, User user) {
        return create(new Stylist(id,dni,name,last,email,phone,user));
    }

    public boolean update(String id, String dni,String firstName, String lastName,String email,String phone, User user) {
        return executeUpdate(String.format(
                "UPDATE %s SET dni = '%s', first_name= '%s', last_name ='%s', email = '%s', phone= '%s', username= '%e' WHERE id = '%s'",
                getTableName(),dni,firstName,lastName,email,phone, user,id));
    }



    public boolean update(Stylist stylist) {
        return update(stylist.getId(), stylist.getDni(), stylist.getFirstName(), stylist.getLastName(), stylist.getEmail(), stylist.getPhone(), stylist.getUser());
    }

    public boolean erase(String id) {
        return executeUpdate(String.format("DELETE FROM %s WHERE id= '%s'",
                getTableName(), id));
    }

    public boolean erase(Stylist stylist) {
        return executeUpdate(String.format("DELETE FROM %s WHERE id = '%s'",
                getTableName(), stylist.getId(),stylist.getUser()));
    }



}
