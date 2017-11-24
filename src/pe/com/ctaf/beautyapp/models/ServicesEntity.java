package pe.com.ctaf.beautyapp.models;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServicesEntity extends BaseEntity{


    public ServicesEntity(Connection connection) {
        super(connection, "service");
    }

    public ServicesEntity() {
        super();
    }

    List<Service> findAll(SalonsEntity salonsEntity,OwnersEntity ownersEntity,LocationsEntity locationsEntity) {
        return findByCriteria("",salonsEntity,ownersEntity,locationsEntity);
    }

    public Service findById(String id,SalonsEntity salonsEntity,OwnersEntity ownersEntity,LocationsEntity locationsEntity) {
        String criteria = " id = '" + id + "'";
        return findByCriteria(criteria,salonsEntity,ownersEntity,locationsEntity).get(0);
    }

    public Service findByName(String name,SalonsEntity salonsEntity,OwnersEntity ownersEntity,LocationsEntity locationsEntity) {
        String criteria = " name = '" +name + "'";
        return findByCriteria(criteria,salonsEntity,ownersEntity,locationsEntity).get(0);
    }

    public List<Service> findAllOrderByName(SalonsEntity salonsEntity,OwnersEntity ownersEntity,LocationsEntity locationsEntity) {
        String criteria = "true ORDER BY name";
        return findByCriteria(criteria,salonsEntity,ownersEntity,locationsEntity);
    }



    public List<Service> findServiceByOwner(String criteria,SalonsEntity salonsEntity,OwnersEntity ownersEntity,LocationsEntity locationsEntity) {
        String sql = " SELECT s.* from owner o , salon sa , service s where s.salon_id=sa.id and sa.owner_id=o.id and o.id="+"'"+criteria+"'" ;
        List<Service> services = new ArrayList<>();
        try {
            ResultSet resultSet = getConnection()
                    .createStatement()
                    .executeQuery(sql);
            if(resultSet == null) return null;
            while(resultSet.next()) {
                services.add(Service.build(resultSet,salonsEntity,ownersEntity,locationsEntity));
            }
            return services;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }




    public List<Service> findByCriteria(String criteria,SalonsEntity salonsEntity,OwnersEntity ownersEntity,LocationsEntity locationsEntity) {
        String sql = getDefaultQuery() +
                (criteria.equalsIgnoreCase("") ? "" : " WHERE " + criteria) ;
        List<Service> services = new ArrayList<>();
        try {
            ResultSet resultSet = getConnection()
                    .createStatement()
                    .executeQuery(sql);
            if(resultSet == null) return null;
            while(resultSet.next()) {
                services.add(Service.build(resultSet,salonsEntity,ownersEntity,locationsEntity));
            }
            return services;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean add(Service service) {
        String sql = "INSERT INTO service (id,name,price,salon_id) " +
                "VALUES(" + service.getIdAsValue() + ", " + service.getNameAsValue()+" ,"+
                service.getPriceAsString() + ", "+ service.getSalon().getIdAsValue()+ ")";
        return change(sql);
    }

    public boolean delete(Service service) {
        String sql = "DELETE FROM service WHERE id = " + service.getIdAsValue();
        return change(sql);
    }


    public boolean update(Service service) {
        String sql = " UPDATE service SET name = " + service.getNameAsValue() +
                ", price = " + service.getPriceAsString()+
                ", salon_id = " + service.getSalon().getIdAsValue()+
                " WHERE id = " + service.getIdAsValue();
        return change(sql);
    }


}