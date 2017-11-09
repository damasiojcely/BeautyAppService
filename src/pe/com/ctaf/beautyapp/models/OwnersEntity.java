package pe.com.ctaf.beautyapp.models;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OwnersEntity extends BaseEntity {
    public OwnersEntity() {
        super();
        setTableName("owner");
    }

    public OwnersEntity(Connection connection, String tableName) {
        super(connection, tableName);
    }
    public Owner findById(String id, UsersEntity usersEntity) {
        return findByCriteria(
                String.format("WHERE id_own= '%d'", id), usersEntity).get(0);
    }

    public List<Owner> findByCriteria(String criteria, UsersEntity usersEntity) {
        try {
            ResultSet rs = getConnection()
                    .createStatement()
                    .executeQuery(
                            getBaseStatement()
                                    .concat(criteria));
            List<Owner> owners= new ArrayList<>();
            while(rs.next())
                owners.add(Owner.build(rs, usersEntity));

            return owners;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }
    public Owner findByDni(String dni, UsersEntity usersEntity) {
        return findByCriteria(
                String.format("WHERE dni_own= '%s'", dni), usersEntity).get(0);
    }

    public Owner findByName(String name, UsersEntity usersEntity) {
        return findByCriteria(
                String.format("WHERE firstname_own= '%s'", name), usersEntity).get(0);
    }
    public Owner findByLast(String last, UsersEntity usersEntity) {
        return findByCriteria(
                String.format("WHERE lastname_own= '%s'", last), usersEntity).get(0);
    }
    public Owner findByEmanil(String email, UsersEntity usersEntity) {
        return findByCriteria(
                String.format("WHERE email_own= '%s'", email), usersEntity).get(0);
    }
    public Owner findByPhone(String phone, UsersEntity usersEntity) {
        return findByCriteria(
                String.format("WHERE dni_own= '%s'", phone), usersEntity).get(0);
    }

    public List<Owner> findAll(UsersEntity usersEntity) {
        return findByCriteria("", usersEntity);
    }

    public boolean create(Owner owner) {
        return executeUpdate(String.format(
                "INSERT INTO %s(id_own, dni_own,firstname_own,lastname_own, email_own, phone_own, username) VALUES( '%d', '%s', '%a', '%b', '%c','%d','%e')",
                getTableName(),owner.getId(),owner.getDni(),owner.getName(),owner.getLast(),owner.getEmail(),owner.getPhone(),owner.getUser().getUsername()));
    }
    public boolean create(String id, String dni,String name, String last,String email,String phone, User user) {
        return create(new Owner(id,dni,name,last,email,phone, user));
    }

    public boolean update(String id, String dni,String name, String last,String email,String phone, User user) {
        return executeUpdate(String.format(
                "UPDATE %s SET dni_own = '%s', firstname_own = '%d', lastname_own ='%a', email_own = '%b', phone_own= '%c', username= '%d' WHERE id_own = '%e'",
                getTableName(),dni,name,last,email,phone, user,id));
    }

    public boolean update(Owner owner) {
        return update(owner.getId(),owner.getDni(),owner.getName(),owner.getLast(),owner.getEmail(),owner.getPhone(),owner.getUser());
    }

    public boolean erase(String id) {
        return executeUpdate(String.format("DELETE FROM %s WHERE id_own = '%s'",
                getTableName(), id));
    }

    public boolean erase(Owner owner) {
        return executeUpdate(String.format("DELETE FROM %s WHERE id_own = '%s'",
                getTableName(), owner.getId()));
    }

}
