package pe.com.ctaf.beautyapp.models;

import java.sql.Connection;
import java.util.List;

public class BeautyappDataStore {
    private Connection connection;
    private  SalonsEntity salonsEntity;
    private ClientsEntity clientsEntity;
    private LocationsEntity locationsEntity;
    private StylistsEntity stylistsEntity;
    private  UsersEntity usersEntity;
    private OwnersEntity ownersEntity;
    private ServicesEntity servicesEntity;
    private SchedulesEntity schedulesEntity;
    private ReservationsEntity reservationsEntity;
    private SkillsEntity skillsEntity;

    public BeautyappDataStore(Connection connection) {
        this.connection = connection;
    }

    public BeautyappDataStore() {
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }


}
