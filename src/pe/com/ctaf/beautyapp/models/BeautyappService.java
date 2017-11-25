package pe.com.ctaf.beautyapp.models;
import javax.naming.InitialContext;
import javax.swing.plaf.synth.Region;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class BeautyappService {
    private Connection connection;
    private BeautyappDataStore dataStore;

    public BeautyappService(InitialContext ctx) {
        try {
            connection = ((DataSource) ctx.lookup("jdbc/MySQLDataSource"))
                    .getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }
    public BeautyappService(){
        try{
            InitialContext ctx = new InitialContext();
            connection = ((DataSource) ctx.lookup("jdbc/MySQLDataSource")).getConnection();
        } catch (NamingException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Connection getConnection() {
        return connection;
    }

    private BeautyappDataStore getDataStore() {
        if(dataStore == null) {
            dataStore = new BeautyappDataStore(getConnection());
        }
        return dataStore;
    }

    public List<Owner> getOwners(){
        return getDataStore().findAllOwners();
    }

    public List<Owner> getOwnersById(String id){return getDataStore().finAllByIdOwners(id);}


    public List<Stylist> getStylistByOwner(String id){return getDataStore().findAllStylistsById(id);}


    public List<Salon> getSalonByOwner(String id){return getDataStore().findAllSalonsByOwner(id);}


    public List<Reservation> getReservationByOrganizer(String id){return getDataStore().findAllReservationsById(id);}

 /*   public List<Organizer> getOrganizerByOwner(String id){return getDataStore().findAllOrganizerByOwner(id);}*/



    public List<Service> getServiceByOwner(String id){return getDataStore().findAllByServiceOwner(id);}

    public List<Reservation> getReservationByOwner(String id){return getDataStore().findAllByReservationOwner(id);}

    public List<Client> getClientByOwner(String id){return getDataStore().findAllClientByOwner(id);}

    public Owner getOwnerIdByEmail(String email,String password){return getDataStore().findOwnerIdByEmail(email,password);}



    public List<Salon> getSalons(){
        return getDataStore().findAllSalons();
    }

    public List<Client> getClients(){
        return getDataStore().findAllClients();
    }

    public List<Stylist> getStylists(){
        return getDataStore().findAllStylists();
    }

    public List<Reservation> getReservations() {return getDataStore().findAllReservations();}

    public List<Service> getServices(){
        return getDataStore().findAllServices();
    }

    public List<Location> getLocations() {
        return getDataStore().findAllLocations();
    }
    public Client getClientById(String id){
        return getDataStore().findClientById(id);
    }

    public boolean updateClient(Client client){
        return getDataStore().updateClient(client);
    }

    public Reservation getReservationById(String id){
        return getDataStore().findReservationById(id);
    }

    public boolean updateReservation(Reservation reservation){
        return getDataStore().updateReservation(reservation);
    }

    public Salon getSalonById(String id){return getDataStore().findSalonById(id);}

    public boolean updateSalon(Salon salon){return getDataStore().updateSalon(salon);}

    public Owner getOwnerById(String id){return getDataStore().findOwnerById(id);}

    public boolean updateOwner(Owner owner){return getDataStore().updateOwner(owner);}

    public Stylist getStylistById(String id){return getDataStore().findStylistById(id);}

    public boolean updateStylist(Stylist stylist){return getDataStore().updateStylist(stylist);}


    public Service getServiceById(String id){return getDataStore().findServiceById(id);}
    public boolean updateService(Service service){return getDataStore().updateService(service);}

    public boolean addSalon(Salon salon){return getDataStore().addSalon(salon); }

    public boolean addOwner(Owner owner){return getDataStore().addOwner(owner);}

    public boolean addClient(Client client){return getDataStore().addClient(client); }

    public boolean addStylist(Stylist stylist){return getDataStore().addStylist(stylist);}

    public boolean addReservation(Reservation reservation){return getDataStore().addReservation(reservation); }

    public boolean addService(Service service){return getDataStore().addService(service);}

    public boolean getOwnerByEmail(String email,String password){
        return getDataStore().findOwnerByEmail(email,password);
    }

    public boolean getClientByEmail(String email,String password){
        return getDataStore().findClientByEmail(email,password);
    }

    public List<Client> getClientsById(String id){return getDataStore().findAllByIdClients(id);}

    public Client getClientIdByEmail(String email,String password){return getDataStore().findClientIdByEmail(email,password);}


    public boolean deleteSalon(Salon salon){return getDataStore().deleteSalon(salon);}

    public boolean deleteOwner(Owner owner){return getDataStore().deleteOwner(owner);}

    public boolean deleteClient(Client client){return getDataStore().deleteClient(client);}

    public boolean deleteStylist(Stylist stylist){ return getDataStore().deleteStylist(stylist);}

    public boolean deleteReservation(Reservation reservation){return getDataStore().deleteReservation(reservation);}

    public boolean deleteService(Service service){return getDataStore().deleteService(service);}

}
