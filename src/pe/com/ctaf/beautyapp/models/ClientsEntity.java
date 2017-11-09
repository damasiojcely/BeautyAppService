package pe.com.ctaf.beautyapp.models;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClientsEntity extends BaseEntity {

     public ClientsEntity(){
         super();
         setTableName("client");
     }

    public ClientsEntity(Connection connection, String tableName){super(connection,tableName); }
    public Client findById(String id, UsersEntity usersEntity){
        return findByCriteria(
        String.format("WHERE id= ' %s' ",id),usersEntity).get(0);
    }

    public List<Client>findByCriteria(String  criteria, UsersEntity usersEntity){
        try{
            ResultSet rs = getConnection()
                    .createStatement()
                    .executeQuery(
                            getBaseStatement()
                             .concat(criteria));
            List<Client>clients=new ArrayList<>();
            while(rs.next())
                clients.add(Client.build(rs,usersEntity));
            return  clients;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  null;
    }

    public Client findByDni(String dni, UsersEntity usersEntity) {
        return findByCriteria(
                String.format("WHERE dni= '%s'", dni), usersEntity).get(0);
    }

    public Client findByName(String firstName, UsersEntity usersEntity) {
        return findByCriteria(
                String.format("WHERE first_name= '%s'", firstName), usersEntity).get(0);
    }
    public Client findByLast(String lastName, UsersEntity usersEntity) {
        return findByCriteria(
                String.format("WHERE last_name= '%s'", lastName), usersEntity).get(0);
    }
    public Client findByEmanil(String email, UsersEntity usersEntity) {
        return findByCriteria(
                String.format("WHERE email= '%s'", email), usersEntity).get(0);
    }
    public Client findByPhone(String phone, UsersEntity usersEntity) {
        return findByCriteria(
                String.format("WHERE phone= '%s'", phone), usersEntity).get(0);
    }

    public List<Client> findAll(UsersEntity usersEntity) {
        return findByCriteria("", usersEntity);
    }

    public boolean create(Client client) {
        return executeUpdate(String.format(
                "INSERT INTO %s(id, dni,first_name,last_name, email, phone, username) VALUES( '%s', '%s', '%s', '%s', '%s','%s','%e')",
                getTableName(),client.getId(),client.getDni(),client.getFirstName(),client.getLastName(),client.getEmail(),client.getPhone(),client.getUser().getUsername()));
    }
    public boolean create(String id, String dni,String name, String last,String email,String phone, User user) {
        return create(new Client(id,dni,name,last,email,phone,user));
    }

    public boolean update(String id, String dni,String firstName, String lastName,String email,String phone, User user) {
        return executeUpdate(String.format(
                "UPDATE %s SET dni = '%s', first_name= '%s', last_name ='%s', email = '%s', phone= '%s', username= '%e' WHERE id = '%s'",
                getTableName(),dni,firstName,lastName,email,phone, user,id));
    }



    public boolean update(Client client) {
        return update(client.getId(),client.getDni(),client.getFirstName(),client.getLastName(),client.getEmail(),client.getPhone(),client.getUser());
    }

    public boolean erase(String id) {
        return executeUpdate(String.format("DELETE FROM %s WHERE id= '%s'",
                getTableName(), id));
    }

    public boolean erase(Client client) {
        return executeUpdate(String.format("DELETE FROM %s WHERE id = '%s'",
                getTableName(), client.getId(),client.getUser()));
    }


    
}
