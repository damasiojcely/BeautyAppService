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
                String.format("WHERE id_serv = '%d'", id)).get(0);
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
                String.format("WHERE name_serv = '%s'", name)).get(0);
    }

    public Service findByPrice(int price){
        return  findByCriteria(String.format("WHERE name_serv = '%s'", price)).get(0);
    }
    public Service findByDescription(String description){
        return  findByCriteria(String.format("WHERE description_serv= '%s'", description)).get(0);
    }
    public Service findByDiscount(int discount){
        return  findByCriteria(String.format("WHERE name_serv = '%s'", discount)).get(0);
    }
    public List<Service> findAll() {
        return findByCriteria("");
    }

    public List<Service> findAllWithServices() {
        return findByCriteria("id_serv IN (SELECT DISTINCT id_serv FROM service)");
    }

    public boolean create(Service service) {
        return executeUpdate(String.format(
                "INSERT INTO %s(id_serv, name_serv,price_serv,description_serv) VALUES( '%d', '%s', %a, '%b')",
                getTableName(),service.getId(), service.getName(),service.getPrice(), service.getDescription()));
    }
    public boolean create(String id, String name,float price, String description) {
        return create(new Service(id, name, price,description));
    }

    public boolean update(String id, String name, float price, String description) {
        return executeUpdate(String.format(
                "UPDATE %s SET name_serv = '%s', price_serv = '%d', description_serv = '%a' WHERE id_serv = '%s'",
                  getTableName(), name,price,description,id));
    }

    public boolean update(Service service) {
        return update(service.getId(),service.getName(),service.getPrice(),service.getDescription());
    }

    public boolean erase(String id) {
        return executeUpdate(String.format("DELETE FROM %s WHERE id_serv = '%s'",
                getTableName(), id));
    }

    public boolean erase(Service service) {
        return executeUpdate(String.format("DELETE FROM %s WHERE id_serv = '%s'",
                getTableName(), service.getId()));
    }



}
