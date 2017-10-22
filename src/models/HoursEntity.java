package models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HoursEntity extends BaseEntity {

    public HoursEntity() {
        super();
        setTableName("hours");
    }

    public HoursEntity(Connection connection, String tableName) { super(connection, tableName); }

    public Hours findById(String id, StylistEntity stylistEntity, ServicesEntity servicesEntity, SalonsEntity salonsEntity) {
        return findByCriteria(
                String.format("WHERE id_hou = '%s'", id), stylistEntity, servicesEntity, salonsEntity).get(0);
    }

    public List<Hours> findByCriteria(String criteria, StylistEntity stylistEntity, ServicesEntity servicesEntity, SalonsEntity salonsEntity) {
        try {
            ResultSet rs = getConnection()
                    .createStatement()
                    .executeQuery(
                            getBaseStatement()
                                    .concat(criteria));
            List<Hours> hours = new ArrayList<>();
            while(rs.next())
                hours.add(Hours.from(rs, stylistEntity, servicesEntity, salonsEntity));

            return hours;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }

    public Hours findByStart(String start, StylistEntity stylistEntity, ServicesEntity servicesEntity, SalonsEntity salonsEntity) {
        return findByCriteria(
                String.format("WHERE start_hou = '%s'", start), stylistEntity, servicesEntity, salonsEntity).get(0);
    }

    public List<Hours> findAll(StylistEntity stylistEntity, ServicesEntity servicesEntity, SalonsEntity salonsEntity) {
        return findByCriteria("", stylistEntity, servicesEntity, salonsEntity);
    }

    public boolean create(Hours hours) {
        return executeUpdate(String.format(
                "INSERT INTO %s(id_hou, start_hou, end_hou, id_sty, id_serv, d_sal) VALUES('%s', '%s', '%s', '%s', '%s')",
                getTableName(), hours.getId(), hours.getStart(), hours.getEnd(), hours.getSylist().getId(), hours.getService().getId(), hours.getSalon().getId()));
    }

    public boolean create(String id, String start, String end, Sylist sylist, Service service, Salon salon) {
        return create(new Hours(id, start, end, sylist, service, salon));
    }

    public boolean update(String id, String start, String end, Sylist sylist, Service service, Salon salon) {
        return executeUpdate(String.format(
                "UPDATE %s SET start_hou = '%s', end_hou = '%s', id_sty = '%s', id_serv = '%s', id_sal = '%s' WHERE id_hou = '%s'", getTableName(), start, end, id, stylistEntity, servicesEntity, salonsEntity));
    }

    public boolean update(Hours hours) {
        return update(hours.getId(), hours.getStart(), hours.getEnd(), hours.getSylist(), hours.getService(), hours.getSalon());
    }

    public boolean erase(String id) {
        return executeUpdate(String.format("DELETE FROM %s WHERE id_hou = '%s'",
                getTableName(), id));
    }

    public boolean erase(Hours hours) {
        return executeUpdate(String.format("DELETE FROM %s WHERE id_hou = '%s'",
                getTableName(), hours.getId(), hours.getSylist(), hours.getService(), hours.getSalon()));
    }
}
