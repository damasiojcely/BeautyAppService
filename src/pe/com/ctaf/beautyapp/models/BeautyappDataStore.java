package pe.com.ctaf.beautyapp.models;
import com.sun.org.apache.regexp.internal.RE;
import java.sql.Connection;
import java.util.List;

public class BeautyappDataStore {
    private Connection connection;
    private SalonsEntity salonsEntity;
    private OwnersEntity ownersEntity;
    private ClientsEntity clientsEntity;
    private StylistsEntity stylistsEntity;
    private ReservationsEntity reservationsEntity;
    private ServicesEntity servicesEntity;
    private LocationsEntity locationsEntity;


    public BeautyappDataStore(Connection connection) {
        this.connection= connection;    }

    public BeautyappDataStore() {
    }

    public Connection getConnection() {
        return connection;
    }

    public BeautyappDataStore setConnection(Connection connection) {
        this.connection = connection;
        return this;
    }

    private SalonsEntity getSalonsEntity() {
        if(salonsEntity==null){
            salonsEntity = new SalonsEntity(getConnection());
        }
        return salonsEntity;
    }

    public List<Salon> findAllSalons(){ return getSalonsEntity().findAll(getOwnersEntity(),getLocationsEntity()); }

    private OwnersEntity getOwnersEntity() {
        if(ownersEntity==null){
            ownersEntity = new OwnersEntity(getConnection());
        }
        return ownersEntity;
    }

    public List<Owner> findAllOwners(){
        return getOwnersEntity().findAll();
    }

    public List<Owner> finAllByIdOwners(String id){return getOwnersEntity().findAllById(id);}

    private ClientsEntity getClientsEntity() {
        if(clientsEntity==null){
            clientsEntity = new ClientsEntity(getConnection());
        }
        return clientsEntity;
    }

    public List<Client> findAllClients(){
        return getClientsEntity().findAll();
    }

    public StylistsEntity getStylistsEntity() {
        if(stylistsEntity==null){
            stylistsEntity = new StylistsEntity(getConnection());
        }
        return stylistsEntity;
    }

    public List<Stylist> findAllStylists(){
        return getStylistsEntity().findAll(getOwnersEntity());
    }


    private ReservationsEntity getReservationsEntity() {
        if(reservationsEntity==null){
            reservationsEntity = new ReservationsEntity(getConnection());
        }
        return reservationsEntity;
    }

    public List<Reservation> findAllReservations(){
        return getReservationsEntity().findAll(getClientsEntity(),getSalonsEntity(),getOwnersEntity(),getLocationsEntity());
    }

    private ServicesEntity getServicesEntity() {
        if(servicesEntity==null){
            servicesEntity = new ServicesEntity(getConnection());
        }
        return servicesEntity;
    }

    public List<Service> findAllServices(){
        return getServicesEntity().findAll(getSalonsEntity(),getOwnersEntity(),getLocationsEntity());
    }

    private LocationsEntity getLocationsEntity() {
        if(locationsEntity==null){
            locationsEntity = new LocationsEntity(getConnection());
        }
        return locationsEntity;
    }

    public List<Location> findAllLocations() { return getLocationsEntity().findAll(); }


    public Owner findOwnerIdByEmail(String email,String password){
        return getOwnersEntity().findyIdByEmailPassword(email,password);
    }

    public Client findClientById(String id){
        return getClientsEntity().findById(id);
    }

    public boolean updateClient(Client client){ return getClientsEntity().update(client); }

    public Reservation findReservationById(String id){ return getReservationsEntity().findById(id,getClientsEntity(),getSalonsEntity(),getOwnersEntity(),getLocationsEntity()); }

    public boolean updateReservation(Reservation reservation){ return getReservationsEntity().update(reservation); }

    public Salon findSalonById(String id){return getSalonsEntity().findById(id,getOwnersEntity(),getLocationsEntity());}

    public boolean updateSalon(Salon salon){return getSalonsEntity().update(salon);}

    public Owner findOwnerById(String id){return getOwnersEntity().findById(id);}

    public boolean updateOwner(Owner owner){return getOwnersEntity().update(owner);}

    public Stylist findStylistById(String id){ return getStylistsEntity().findById(id,getOwnersEntity()); }

    public boolean updateStylist(Stylist stylist){return getStylistsEntity().update(stylist);}

    public Service findServiceById(String id){ return getServicesEntity().findById(id,getSalonsEntity(),getOwnersEntity(),getLocationsEntity()); }

    public boolean updateService(Service service){return getServicesEntity().update(service);}

    public boolean addSalon(Salon salon){return getSalonsEntity().add(salon);}

    public boolean addOwner(Owner owner){return getOwnersEntity().add(owner);}

    public boolean addClient(Client client){return getClientsEntity().add(client);}

    public boolean addStylist(Stylist stylist){return getStylistsEntity().add(stylist);}

    public boolean addReservation(Reservation reservation){return getReservationsEntity().add(reservation);}

    public boolean addService(Service service){return getServicesEntity().add(service);}

    public Client findClientIdByEmail(String email,String password){
        return getClientsEntity().findIdByEmailPassword(email,password);
    }

    public List<Client> findAllByIdClients(String id){return  getClientsEntity().findAllById(id);}


    public List<Service> findAllByServiceOwner(String id){
        return getServicesEntity().findServiceByOwner(id,getSalonsEntity(),getOwnersEntity(),getLocationsEntity());
    }

    public List<Reservation> findAllByReservationOwner(String id){
        return getReservationsEntity().findReservationByOwner(id,getClientsEntity(),getSalonsEntity(),getOwnersEntity(),getLocationsEntity());
    }


    public List<Stylist> findAllStylistById(String id){return getStylistsEntity().findAllId(id,getOwnersEntity());}

    public List<Salon> findAllCourtsByOwner(String id){return getSalonsEntity().findAllId(id,getOwnersEntity(),getLocationsEntity());}

    public List<Reservation> findAllReservationsById(String id){return getReservationsEntity().findAllById(id,getClientsEntity(),
            getSalonsEntity(),getOwnersEntity(),getLocationsEntity());}


    public List<Client> findAllClientByOwner(String id){return getClientsEntity().findClientByOwner(id);}


    public boolean findOwnerByEmail(String email,String password){ return getOwnersEntity().findByEmailPass(email,password); }

    public boolean findClientByEmail(String email,String password){return getClientsEntity().findByEmailPass(email,password);}


    public boolean deleteSalon(Salon salon){ return getSalonsEntity().delete(salon);}

    public boolean deleteOwner(Owner owner){ return getOwnersEntity().delete(owner);}

    public boolean deleteClient(Client client){return getClientsEntity().delete(client); }

    public boolean deleteStylist(Stylist stylist){return getStylistsEntity().delete(stylist);}

    public boolean deleteReservation(Reservation reservation){return getReservationsEntity().delete(reservation);}

    public boolean deleteService(Service service){return getServicesEntity().delete(service);}

}
