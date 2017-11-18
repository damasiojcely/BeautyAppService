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
    public List<Skill> findAllSkills(){return dataStore.findAllSkills();}

    public Client findClientById(String id){
      return dataStore.findClientById(id);
    }
    public Location findLocationById(String id){
        return dataStore.findSLocationById(id);
    }
    public Owner findOwnerById(String id){
        return dataStore.findOwnerById(id);
    }
    public Reservation findReservationById(String id){
        return dataStore.findReservationById(id);
    }
    public Salon findSalonById(String id){
        return dataStore.findSalonById(id);
    }
    public Schedule findScheduleById(String id){
        return dataStore.findScheduleById(id);
    }
    public Service findServiceById(String id){
        return dataStore.findServiceById(id);
    }
    public Stylist findStylistById(String id){
        return dataStore.findStylistById(id);
    }
    public User findUserById(String id){
        return dataStore.findUserById(id);
    }
    public Skill findSkillById(String id1, String id2){
        return dataStore.findSkillById(id1,id2);
    }
    public boolean updateClient(String id, String name, String dni, String last, String email, String phone, User user) {
        return dataStore.updateClient(id,dni,name,last,email,phone,user);
    }
    public boolean updateLocation(String id,String departament, String province, String dist, String address ){
        return dataStore.updateLocation(id,departament,province,dist,address);
    }
    public boolean updateOwner(String id, String dni,String name, String last, String email, String phone, User user){
        return dataStore.updateOwner(id,dni,name,last,email,phone,user);
    }
    public boolean updateReservation(String id, String reda,String refor, float price, String sta, String end, Client client, Schedule schedule){
        return dataStore.updateReservation(id,reda,refor,price,sta,end,client,schedule);
    }
    public boolean updateSalon(String id, String name, String phone, String email, Owner owner, Location location){
        return dataStore.updateSalon(id,name,phone,email,owner,location);
    }
    public boolean updateSchedule(String id, String sta, String end, float dis, Stylist stylist, Service service, Salon salon){
        return dataStore.updateSchedule(id,sta,end,dis,stylist,service,salon);
    }
    public boolean updateService(String id, String name,float price, String descri){
        return dataStore.updateService(id, name,price,descri);
    }
    public boolean updateStylist(String id, String dni, String name, String last, String email, String phone,User user){
        return dataStore.updateStylist(id,dni,name,last,email,phone,user);
    }
    public boolean updateUser(String id, String user, String pass){
        return dataStore.createUser(id,user,pass);
    }
    public boolean createClient(String id, String name, String dni, String last, String email, String phone, User user) {
        return dataStore.createClient(id,dni,name,last,email,phone,user);
    }
    public boolean createLocation(String id,String departament, String province, String dist, String address ){
        return dataStore.createLocation(id,departament,province,dist,address);
    }
    public boolean createOwner(String id, String dni,String name, String last, String email, String phone, User user){
        return dataStore.createOwner(id,dni,name,last,email,phone,user);
    }
    public boolean createReservation(String id, String reda,String refor, float price, String sta, String end, Client client, Schedule schedule){
        return dataStore.createReservation(id,reda,refor,price,sta,end,client,schedule);
    }
    public boolean createSalon(String id, String name, String phone, String email, Owner owner, Location location){
        return dataStore.createSalon(id,name,phone,email,owner,location);
    }
    public boolean createSchedule(String id, String sta, String end, float dis, Stylist stylist, Service service, Salon salon){
        return dataStore.createSchedule(id,sta,end,dis,stylist,service,salon);
    }
    public boolean createService(String id, String name,float price, String descri){
        return dataStore.createService(id, name,price,descri);
    }
    public boolean createStylist(String id, String dni, String name, String last, String email, String phone,User user){
        return dataStore.createStylist(id,dni,name,last,email,phone,user);
    }
    public boolean createUser(String id, String user, String pass){
        return dataStore.createUser(id,user,pass);
    }
    public boolean eraseClient(String id){
        return dataStore.eraseClient(id);
    }
    public boolean eraseLocation(String id){
        return dataStore.eraseLocation(id);
    }
    public boolean eraseOwner(String id){
        return dataStore.eraseOwner(id);
    }
    public boolean eraseReservation(String id){
        return dataStore.eraseReservation(id);
    }
    public boolean eraseSalom(String id){
        return dataStore.eraseSalon(id);
    }
    public boolean eraseSchedule(String id){
        return dataStore.eraserSchedule(id);
    }
    public boolean eraseService(String id){
        return dataStore.eraseService(id);
    }
    public boolean eraseStylist(String id){
        return dataStore.eraseStylist(id);
    }
    public boolean eraseUser(String id){
        return dataStore.eraseUser(id);
    }

}
