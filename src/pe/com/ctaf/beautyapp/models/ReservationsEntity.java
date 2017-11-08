package pe.com.ctaf.beautyapp.models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReservationsEntity extends BaseEntity {
    public ReservationsEntity() {
        super();
        setTableName("reservation");
    }

    public ReservationsEntity(Connection connection, String tableName) {
        super(connection, tableName);
    }

    public Reservation findById(String id, ClientsEntity clientsEntity, SchedulesEntity schedulesEntity) {
        return findByCriteria(
                String.format("WHERE id = '%s'", id), clientsEntity, schedulesEntity).get(0);
    }

    public List<Reservation> findByCriteria(String criteria, ClientsEntity clientsEntity, SchedulesEntity schedulesEntity) {
        try {
            ResultSet rs = getConnection()
                    .createStatement()
                    .executeQuery(
                            getBaseStatement()
                                    .concat(criteria));
            List<Reservation> reservations = new ArrayList<>();
            while(rs.next())
                reservations.add(Reservation.from(rs, clientsEntity, schedulesEntity));

            return reservations;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }

    public Reservation findByStartAt(String startat, ClientsEntity clientsEntity, SchedulesEntity schedulesEntity) {
        return findByCriteria(
                String.format("WHERE start_at = '%s'", startat), clientsEntity, schedulesEntity).get(0);
    }

    public Reservation findByEndAt(String endat, ClientsEntity clientsEntity, SchedulesEntity schedulesEntity) {
        return findByCriteria(
                String.format("WHERE end_at = '%s'", endat), clientsEntity, schedulesEntity).get(0);
    }

    public Reservation findReservedAt(String reservedat, ClientsEntity clientsEntity, SchedulesEntity schedulesEntity) {
        return findByCriteria(
                String.format("WHERE reservedat = '%s'", reservedat), clientsEntity, schedulesEntity).get(0);
    }

    public Reservation findRequestedFor(String requestedfor, ClientsEntity clientsEntity, SchedulesEntity schedulesEntity) {
        return findByCriteria(
                String.format("WHERE requestedfor = '%s'", requestedfor), clientsEntity, schedulesEntity).get(0);
    }

    public List<Reservation> findAll(ClientsEntity clientsEntity, SchedulesEntity schedulesEntity) {
        return findByCriteria("", clientsEntity, schedulesEntity);
    }

    public boolean create(Reservation reservation) {
        return executeUpdate(String.format(
                "INSERT INTO %s(id, reservedat, requestedfor, price, start_at, end_at, clientid, scheduleid) " +
                        "VALUES('%s', '%s', '%s', %d, '%s', '%s', '%s', '%s')",
                getTableName(), reservation.getId(), reservation.getReservedat(), reservation.getRequestedfor(),
                reservation.getPrice(), reservation.getStartat(), reservation.getEndat(),
                reservation.getClient().getId(), reservation.getSchedule().getId()));
    }

    public boolean create(String id, String reservedat, String requestedfor, float price, String startat, String endat,
                          Client client, Schedule schedule) {
        return create(new Reservation(id, reservedat, requestedfor, price, startat, endat, client, schedule));
    }

    public boolean update(String id, String reservedat, String requestedfor, float price, String startat, String endat,
                          Client client, Schedule schedule) {
        return executeUpdate(String.format(
                "UPDATE %s SET reservedat = '%s', requestedfor = '%s', price = '%s', start_at = '%s', end_at = '%s', " +
                        "clientid = '%s', scheduleid = '%s' WHERE id = '%s'", getTableName(), reservedat, requestedfor,
                price, startat, endat, client, schedule, id));
    }

    public boolean update(Reservation reservation) {
        return update(reservation.getId(), reservation.getReservedat(), reservation.getRequestedfor(),
                reservation.getPrice(), reservation.getStartat(), reservation.getEndat(), reservation.getClient(),
                reservation.getSchedule());
    }

    public boolean erase(String id) {
        return executeUpdate(String.format("DELETE FROM %s WHERE id = '%s'",
                getTableName(), id));
    }

    public boolean erase(Reservation reservation) {
        return executeUpdate(String.format("DELETE FROM %s WHERE id = '%s'",
                getTableName(), reservation.getId(), reservation.getClient(), reservation.getSchedule()));
    }
}
