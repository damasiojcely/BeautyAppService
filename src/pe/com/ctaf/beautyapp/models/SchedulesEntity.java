package pe.com.ctaf.beautyapp.models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SchedulesEntity extends BaseEntity {

    public SchedulesEntity() {
        super();
        setTableName("schedule");
    }

    public SchedulesEntity(Connection connection, String tableName) { super(connection, tableName); }

    public Schedule findById(String id, StylistsEntity stylistsEntity,
                             ServicesEntity servicesEntity, SalonsEntity salonsEntity) {
        return findByCriteria(
                String.format("WHERE id = '%s'", id), stylistsEntity, servicesEntity, salonsEntity).get(0);
    }

    public List<Schedule> findByCriteria(String criteria, StylistsEntity stylistsEntity,
                                         ServicesEntity servicesEntity, SalonsEntity salonsEntity) {
        try {
            ResultSet rs = getConnection()
                    .createStatement()
                    .executeQuery(
                            getBaseStatement()
                                    .concat(criteria));
            List<Schedule> hours = new ArrayList<>();
            while(rs.next())
                hours.add(Schedule.from(rs, stylistsEntity, servicesEntity, salonsEntity));

            return hours;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }

    public Schedule findByStartAt(String startat, StylistsEntity stylistsEntity,
                                  ServicesEntity servicesEntity, SalonsEntity salonsEntity) {
        return findByCriteria(
                String.format("WHERE start_at = '%s'", startat), stylistsEntity, servicesEntity, salonsEntity).get(0);
    }

    public Schedule findByEndAt(String endat, StylistsEntity stylistsEntity,
                                ServicesEntity servicesEntity, SalonsEntity salonsEntity) {
        return findByCriteria(
                String.format("WHERE end_at = '%s'", endat), stylistsEntity, servicesEntity, salonsEntity).get(0);
    }

    public List<Schedule> findAll(StylistsEntity stylistsEntity, ServicesEntity servicesEntity, SalonsEntity salonsEntity) {
        return findByCriteria("", stylistsEntity, servicesEntity, salonsEntity);
    }

    public boolean create(Schedule schedule) {
        return executeUpdate(String.format(
                "INSERT INTO %s(id, start_at, end_at, discount, stylistid, serviceid, salonid) VALUES" +
                        "('%s', '%s', '%s', %d, '%s', '%s', '%s')",
                getTableName(), schedule.getId(), schedule.getStartAt(), schedule.getEndAt(),schedule.getDiscount(),
                schedule.getStylist().getId(), schedule.getService().getId(), schedule.getSalon().getId()));
    }

    public boolean create(String id, String startat, String endat, float discount, Stylist stylist,
                          Service service, Salon salon) {
        return create(new Schedule(id, startat, endat, discount, stylist, service, salon));
    }

    public boolean update(String id, String startat, String endat, float discount, Stylist stylist,
                          Service service, Salon salon) {
        return executeUpdate(String.format(
                "UPDATE %s SET start_at = '%s', end_at = '%s', discount = '%s' stylistid = '%s', serviceid = '%s', " +
                        "salonid = '%s' WHERE id = '%s'", getTableName(), startat, endat, discount, stylist,
                service, salon, id));
    }

    public boolean update(Schedule schedule) {
        return update(schedule.getId(), schedule.getStartAt(), schedule.getEndAt(), schedule.getDiscount(),
                schedule.getStylist(), schedule.getService(), schedule.getSalon());
    }

    public boolean erase(String id) {
        return executeUpdate(String.format("DELETE FROM %s WHERE id = '%s'",
                getTableName(), id));
    }

    public boolean erase(Schedule schedule) {
        return executeUpdate(String.format("DELETE FROM %s WHERE id = '%s'",
                getTableName(), schedule.getId(), schedule.getStylist(), schedule.getService(), schedule.getSalon()));
    }
}
