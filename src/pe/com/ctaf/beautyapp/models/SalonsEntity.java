package pe.com.ctaf.beautyapp.models;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SalonsEntity extends  BaseEntity {
    public SalonsEntity() {
        super();
        setTableName("salon");
    }

    public SalonsEntity(Connection connection, String tableName) { super(connection, tableName); }

    public Salon findById(String id,OwnersEntity ownersEntity,LocationsEntity locationsEntity) {
        return findByCriteria(
                String.format("WHERE id = '%s'", id), ownersEntity, locationsEntity).get(0);
    }

    public List<Salon> findByCriteria(String criteria, OwnersEntity ownersEntity,LocationsEntity locationsEntity) {
        try {
            ResultSet rs = getConnection()
                    .createStatement()
                    .executeQuery(
                            getBaseStatement()
                                    .concat(criteria));
            List<Salon> salons = new ArrayList<>();
            while(rs.next())
                salons.add(Salon.build(rs, ownersEntity,locationsEntity));

            return salons;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }

    public Salon findByName(String name,OwnersEntity ownersEntity,LocationsEntity locationsEntity) {
        return findByCriteria(
                String.format("WHERE name= '%s'", name), ownersEntity,locationsEntity).get(0);
    }

    public Salon findByPhone(String phone, OwnersEntity ownersEntity, LocationsEntity locationsEntity) {
        return findByCriteria(
                String.format("WHERE end_at = '%s'", phone), ownersEntity,locationsEntity).get(0);
    }

    public Salon findByEmail(String email, OwnersEntity ownersEntity, LocationsEntity locationsEntity) {
        return findByCriteria(
                String.format("WHERE end_at = '%s'", email), ownersEntity,locationsEntity).get(0);
    }

    public List<Salon> findAll( OwnersEntity ownersEntity, LocationsEntity locationsEntity) {
        return findByCriteria("",ownersEntity,locationsEntity);
    }

    public boolean create(Salon salon) {
        return executeUpdate(String.format(
                "INSERT INTO %s(id, name, phone, email, ownerid, locationid) VALUES" +
                        "('%s', '%s', '%s', %s, '%s', '%d', '%f')",
                getTableName(), salon.getId(), salon.getName(), salon.getPhone(),salon.getEmail(),
                salon.getOwner().getId(), salon.getLocation().getId()));
    }

    public boolean create(String id, String name, String phone,String email, Owner owner,Location location) {
        return create(new Salon(id, name, phone, email, owner, location));
    }

    public boolean update(String id, String name, String phone,String email, Owner owner,Location location) {
        return executeUpdate(String.format(
                "UPDATE %s SET name = '%s', phone = '%s', email= '%s', " +
                        "ownerid = '%d', locationid = '%f' WHERE id = '%s'", getTableName(),name, phone, email, owner, location, id));
    }

    public boolean update(Salon salon) {
        return update(salon.getId(), salon.getName(), salon.getPhone(), salon.getEmail(),
                salon.getOwner(),salon.getLocation());
    }

    public boolean erase(String id) {
        return executeUpdate(String.format("DELETE FROM %s WHERE id = '%s'",
                getTableName(), id));
    }

    public boolean erase(Salon salon) {
        return executeUpdate(String.format("DELETE FROM %s WHERE id = '%s'",
                getTableName(), salon.getId(), salon.getOwner(), salon.getLocation()));
    }
}
