package models;
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
    public Owner findById(String id, LoginsEntity loginsEntity) {
        return findByCriteria(
                String.format("WHERE id_own= '%d'", id),loginsEntity).get(0);
    }

    public List<Owner> findByCriteria(String criteria, LoginsEntity loginsEntity) {
        try {
            ResultSet rs = getConnection()
                    .createStatement()
                    .executeQuery(
                            getBaseStatement()
                                    .concat(criteria));
            List<Owner> owners= new ArrayList<>();
            while(rs.next())
                owners.add(Owner.from(rs,loginsEntity));

            return owners;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }
    public Owner findByDni(String dni, LoginsEntity loginsEntity) {
        return findByCriteria(
                String.format("WHERE dni_own= '%s'", dni),loginsEntity).get(0);
    }

    public Owner findByName(String name, LoginsEntity loginsEntity) {
        return findByCriteria(
                String.format("WHERE firstname_own= '%s'", name),loginsEntity).get(0);
    }
    public Owner findByLast(String last, LoginsEntity loginsEntity) {
        return findByCriteria(
                String.format("WHERE lastname_own= '%s'", last),loginsEntity).get(0);
    }
    public Owner findByEmanil(String email, LoginsEntity loginsEntity) {
        return findByCriteria(
                String.format("WHERE email_own= '%s'", email),loginsEntity).get(0);
    }
    public Owner findByPhone(String phone, LoginsEntity loginsEntity) {
        return findByCriteria(
                String.format("WHERE dni_own= '%s'", phone),loginsEntity).get(0);
    }

    public List<Owner> findAll(LoginsEntity loginsEntity) {
        return findByCriteria("", loginsEntity);
    }

    public boolean create(Owner owner) {
        return executeUpdate(String.format(
                "INSERT INTO %s(id_own, dni_own,firstname_own,lastname_own, email_own, phone_own, username) VALUES( '%d', '%s', '%a', '%b', '%c','%d','%e')",
                getTableName(),owner.getId(),owner.getDni(),owner.getName(),owner.getLast(),owner.getEmail(),owner.getPhone(),owner.getUsername()));
    }
    public boolean create(String id, String dni,String name, String last,String email,String phone, Login login) {
        return create(new Owner(id,dni,name,last,email,phone,login));
    }

    public boolean update(String id, String dni,String name, String last,String email,String phone, Login login) {
        return executeUpdate(String.format(
                "UPDATE %s SET dni_own = '%s', firstname_own = '%d', lastname_own ='%a', email_own = '%b', phone_own= '%c', username= '%d' WHERE id_own = '%e'",
                getTableName(),dni,name,last,email,phone,login,id));
    }

    public boolean update(Owner owner) {
        return update(owner.getId(),owner.getDni(),owner.getName(),owner.getLast(),owner.getEmail(),owner.getPhone(),owner.getUsername());
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
