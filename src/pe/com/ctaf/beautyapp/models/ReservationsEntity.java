package pe.com.ctaf.beautyapp.models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReservationsEntity extends BaseEntity {
    public ReservationsEntity(Connection connection) {
        super( connection,"reservation");
    }

    public ReservationsEntity() {
        super();
    }



    public List<Reservation> findAllById(String id,ClientsEntity clientsEntity,SalonsEntity salonsEntity,
                                         OwnersEntity ownersEntity,LocationsEntity locationsEntity) {
        String criteria = " organizer_id = '"+id+"'";
        return findByCriteria(criteria,clientsEntity,salonsEntity,ownersEntity,locationsEntity);
    }



    public List<Reservation> findAll(ClientsEntity clientsEntity,SalonsEntity salonsEntity,
                                     OwnersEntity ownersEntity,LocationsEntity locationsEntity){
        return findByCriteria("",clientsEntity,salonsEntity,ownersEntity,locationsEntity);
    }

    public Reservation findById(String id,
                                ClientsEntity clientsEntity,SalonsEntity salonsEntity,
                                OwnersEntity ownersEntity,LocationsEntity locationsEntity){
        String criteria = "id = " + "'" + id + "'";
        return findByCriteria(criteria,clientsEntity,salonsEntity,ownersEntity,locationsEntity).get(0);
    }


    public List<Reservation> findReservationByOwner(String criteria,ClientsEntity clientsEntity,SalonsEntity salonsEntity,
                                                    OwnersEntity ownersEntity,LocationsEntity locationsEntity) {
        String sql = " SELECT r.* from owner o , salon s , reservation r where r.salon_id=s.id and s.owner_id=o.id and o.id="+"'"+criteria+"'" ;
        List<Reservation> reservations = new ArrayList<>();
        try {
            ResultSet resultSet = getConnection()
                    .createStatement()
                    .executeQuery(sql);
            if(resultSet == null) return null;
            while(resultSet.next()) {
                reservations.add(Reservation.build(resultSet,clientsEntity,salonsEntity,ownersEntity,locationsEntity));
            }
            return reservations;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    public List<Reservation> findByCriteria(
            String criteria,ClientsEntity clientsEntity,SalonsEntity salonsEntity,
            OwnersEntity ownersEntity,LocationsEntity locationsEntity){

        String sql = getDefaultQuery() + (criteria.isEmpty() ? "" : " WHERE " + criteria);
        List<Reservation> reservations = new ArrayList<>();

        try {
            ResultSet resultSet = getConnection().createStatement().executeQuery(sql);
            if(resultSet == null) return null;
            while(resultSet.next()) {
                reservations.add(Reservation.build(resultSet,clientsEntity,salonsEntity,ownersEntity,locationsEntity));
            }
            return reservations;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }

    public  boolean add(Reservation reservation) {
        return change("INSERT INTO reservation(id,reser_date,reser_time,price,client_id,salon_id)" +
                "VALUES (" + reservation.getIdAsString() + ", " +
                reservation.getReserdateAsValue() + ", "  + reservation.getResertimeAsValue()+ ", " + ", " + reservation.getPriceAsString() + ", " +
                reservation.getClient().getIdAsValue()+ ", " +reservation.getSalon().getIdAsValue()+
                " )" );
    }


    public boolean delete(Reservation reservation){

        return change("DELETE FROM reservation WHERE id = " + reservation.getIdAsString());
    }

    public  boolean update(Reservation reservation){
        return change("UPDATE reservation SET reser_date = " + reservation.getReserdateAsValue() +
                ", reser_time = " + reservation.getResertimeAsValue()+", price = "+ reservation.getPriceAsString() +
                ", client_id = " + reservation.getClient().getIdAsValue() +
                ", salon_id = " + reservation.getSalon().getIdAsValue() +
                " WHERE id = " + reservation.getIdAsString());
    }


}
