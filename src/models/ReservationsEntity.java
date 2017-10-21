package models;

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

    public Reservation findById(String id, ClientsEntity clientsEntity, HoursEntity hoursEntity) {
        return findByCriteria(
                String.format("WHERE id_res = '%s'", id), clientsEntity, hoursEntity).get(0);
    }

    public List<Reservation> findByCriteria(String criteria, ClientsEntity clientsEntity, HoursEntity hoursEntity) {
        try {
            ResultSet rs = getConnection()
                    .createStatement()
                    .executeQuery(
                            getBaseStatement()
                                    .concat(criteria));
            List<Reservation> reservations = new ArrayList<>();
            while(rs.next())
                reservations.add(Reservation.from(rs, ClientsEntity clientsEntity, HoursEntity hoursEntity));

            return reservations;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }

    public Reservation findByStart(String start, StylistEntity stylistEntity, ServicesEntity servicesEntity, SalonsEntity salonsEntity) {
        return findByCriteria(
                String.format("WHERE start_hou = '%s'", start), stylistEntity, servicesEntity, salonsEntity).get(0);
    }

    public List<Reservation> findAll(ClientsEntity clientsEntity, HoursEntity hoursEntity) {
        return findByCriteria("", clientsEntity, hoursEntity);
    }

    public boolean create(Reservation reservation) {
        return executeUpdate(String.format(
                "INSERT INTO %s(id_res, datereservation, daterequested, price_res, start_res, end_res, id_cli, id_hou) VALUES('%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s')",
                getTableName(), reservation.getId(), reservation.getDatereservation(), reservation.getDaterequested(), reservation.getPrice(), reservation.getStart(), reservation.getEnd(), reservation.getClient().getId(), reservation.getHours().getId()));
    }

    public boolean create(String id, String datereservation, String daterequested, String price, String start, String end, Client client, Hours hours) {
        return create(new Hours(id, datereservation, daterequested, start, end, client, hours));
    }

    public boolean update(String id, String datereservation, String daterequested, String price, String start, String end, Client client, Hours hours) {
        return executeUpdate(String.format(
                "UPDATE %s SET datereservation = '%s', daterequested = '%s', price_res = '%s', start_res = '%s', end_res = '%s', id_cli = '%s', id_hou = '%s' WHERE id_res = '%s'", getTableName(), datereservation, daterequested, price, start, end, id, client, hours));
    }

    public boolean update(Reservation reservation) {
        return update(reservation.getId(), reservation.getDatereservation(), reservation.getDaterequested(), reservation.getPrice(), reservation.getStart(), reservation.getEnd(), reservation.getClient(), reservation.getHours());
    }

    public boolean erase(String id) {
        return executeUpdate(String.format("DELETE FROM %s WHERE id_res = '%s'",
                getTableName(), id));
    }

    public boolean erase(Reservation reservation) {
        return executeUpdate(String.format("DELETE FROM %s WHERE id_res = '%s'",
                getTableName(), reservation.getId(), reservation.getDatereservation(), reservation.getDaterequested(), reservation.getPrice(), reservation.getStart(), reservation.getEnd(), reservation.getClient(), reservation.getHours()));
    }
}
