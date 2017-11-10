package pe.com.ctaf.beautyapp.models;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServicesEntity extends BaseEntity {

    public ServicesEntity() {
        super();
        setTableName("service");
    }

    public ServicesEntity(Connection connection, String tableName) {
        super(connection, tableName);
    }
    public Service findById(String id) {
        return findByCriteria(
                String.format("WHERE id = '%d'", id)).get(0);
    }

    public List<Service> findByCriteria(String criteria) {
        try {
            ResultSet rs = getConnection()
                    .createStatement()
                    .executeQuery(
                            getBaseStatement()
                                    .concat(criteria));
            List<Service> services = new ArrayList<>();
            while(rs.next())
                services.add(Service.build(rs));

            return services;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }
    public Service findByName(String name) {
        return findByCriteria(
                String.format("WHERE name= '%s'", name)).get(0);
    }

    public Service findByPrice(float price){
        return  findByCriteria(String.format("WHERE price = '%s'", price)).get(0);
    }
    public Service findByDescription(String description){
        return  findByCriteria(String.format("WHERE description= '%s'", description)).get(0);
    }

    public List<Service> findAll() {
        return findByCriteria("");
    }

    public List<Service> findAllWithServices() {
        return findByCriteria("id IN (SELECT DISTINCT id FROM service)");
    }

    public boolean create(Service service) {
        return executeUpdate(String.format(
                "INSERT INTO %s(id, name,price,description) VALUES( '%d', '%s', %a, '%b')",
                getTableName(),service.getId(), service.getName(),service.getPrice(), service.getDescription()));
    }
    public boolean create(String id, String name,float price, String description) {
        return create(new Service(id, name, price,description));
    }

    public boolean update(String id, String name, float price, String description) {
        return executeUpdate(String.format(
                "UPDATE %s SET name = '%s', price = '%d', description= '%a' WHERE id= '%s'",
                  getTableName(), name,price,description,id));
    }

    public boolean update(Service service) {
        return update(service.getId(),service.getName(),service.getPrice(),service.getDescription());
    }

    public boolean erase(String id) {
        return executeUpdate(String.format("DELETE FROM %s WHERE id= '%s'",
                getTableName(), id));
    }

    public boolean erase(Service service) {
        return executeUpdate(String.format("DELETE FROM %s WHERE id= '%s'",
                getTableName(), service.getId()));
    }



}
