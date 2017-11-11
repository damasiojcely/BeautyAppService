package pe.com.ctaf.beautyapp.models;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class BeautyappService {
    private Connection connection;
    private BeautyappDataStore dataStore;

    public BeautyappService()

    {
        try {
            InitialContext context= new InitialContext();
            dataStore = new BeautyappDataStore();
            connection = ((DataSource)context
                           .lookup("jdbc/MySQLDataSource"))
                           .getConnection();
            dataStore.setConnection(connection);
        }catch (NamingException e){
            e.printStackTrace();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public Connection getConnection(){
        return connection;
    }
    public void setConnection(Connection connection){
        this.connection=connection;
    }
    public BeautyappDataStore getDataStore(){
        return  dataStore;
    }
    public void  setDataStore(BeautyappDataStore dataStore){
        this.dataStore=dataStore;
    }

    public List<Client> findAllClients(){
        return  dataStore.findAllClients();
    }
    public List<Location> findAllLocations(){
      return  dataStore.findAllLocations();
    }
    public List<Owner> findAllOwners(){
        return  dataStore.findAllOwners();
    }
    public List<Reservation> findAllReservations(){return dataStore.findAllReservations();}
    public List<Salon> findAllSalons(){return  dataStore.findAllSalons();}
    public List<Schedule> findAllSchedules(){return dataStore.findAllSchedules();}
    public List<Service> findAllServices(){return dataStore.findAllServices();}
    public List<Stylist> findAllStylists(){return dataStore.findAllStylists();}
    public List<User> findAllUsers(){return dataStore.findAllUsers();}

    public Client findClientById(String id){
      return dataStore.findClientById(id);
    }



}
