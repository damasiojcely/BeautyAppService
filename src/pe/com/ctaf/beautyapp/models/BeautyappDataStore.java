package pe.com.ctaf.beautyapp.models;

import java.sql.Connection;
import java.util.List;

public class BeautyappDataStore {
    private  Connection connection;
    private  SalonsEntity salonsEntity;
    private ClientsEntity clientsEntity;
    private LocationsEntity locationsEntity;
    private StylistsEntity stylistsEntity;
    private  UsersEntity usersEntity;
    private OwnersEntity ownersEntity;
    private ServicesEntity servicesEntity;
    private SchedulesEntity schedulesEntity;
    private ReservationsEntity reservationsEntity;
    private  SkillsEntity skillsEntity;


    public BeautyappDataStore(Connection connection){ this.setConnection(connection); }

    public  BeautyappDataStore(){

    }

    public User findUserById(String id){
        if(getConnection() ==null)return null;
        return getUsersEntity().findById(id);
    }

    public Client findClientById(String id){
        if(getConnection() ==null) return  null;
        return  getClientsEntity().findById(id,getUsersEntity());
    }
    public Stylist findStylistById(String id){
        if(getConnection() ==null)return  null;
        return  getStylistsEntity().findById(id,getUsersEntity());
    }
    public Owner findOwnerById(String id){
        if(getConnection() ==null)return  null;
        return  getOwnersEntity().findById(id,getUsersEntity());
    }
    public Salon findSalonById(String id){
        if(getConnection() ==null)return  null;
        return  getSalonsEntity().findById(id,getOwnersEntity(),getLocationsEntity(),getUsersEntity());
    }
    public Location findSLocationById(String id){
        if(getConnection() ==null)return  null;
        return  getLocationsEntity().findById(id);
    }
    public Reservation findReservationById(String id){
        if(getConnection() ==null)return  null;
        return  getReservationsEntity().findById(id,getClientsEntity(),getSchedulesEntity(),getUsersEntity(),getStylistsEntity(),getServicesEntity(),getSalonsEntity(),getOwnersEntity(),getLocationsEntity());
    }
    public Schedule findScheduleById(String id){
        if(getConnection() ==null)return  null;
        return  getSchedulesEntity().findById(id,getStylistsEntity(),getServicesEntity(),getSalonsEntity(),getUsersEntity(),getOwnersEntity(),getLocationsEntity());
    }
    public Service findServiceById(String id){
        if(getConnection() ==null)return  null;
        return  getServicesEntity().findById(id);
    }
    //Aqui falta como poner las dos  llaves primaria de  la tabla skill
    public Skill findSkillById(String stylistid, String serviceid){
        if(getConnection() ==null)return  null;
        return  getSkillsEntity().findById(stylistid,serviceid);
    }
    public List<User> findAllUsers(){
        return  getConnection() ==null ? null:getUsersEntity().findAll();
    }
    public List<Client> findAllClients(){
        return  getConnection() ==null ?  null:getClientsEntity().findAll(getUsersEntity());
    }
    public List<Stylist> findAllStylists(){
        return  getConnection() ==null ? null:getStylistsEntity().findAll(getUsersEntity());
    }
    public List<Owner> findAllOwners(){
        return getConnection() ==null  ? null:getOwnersEntity().findAll(getUsersEntity());
    }
    public List<Salon> findAllSalons(){
        return getConnection() ==null  ? null:getSalonsEntity().findAll(getOwnersEntity(),getLocationsEntity(),getUsersEntity());
    }
    public List<Reservation> findAllReservations(){
        return getConnection() ==null ? null:getReservationsEntity().findAll(getClientsEntity(),getSchedulesEntity(),getUsersEntity(),getStylistsEntity(),getServicesEntity(),getSalonsEntity(),getOwnersEntity(),getLocationsEntity());
    }
    public List<Schedule> findAllSchedules(){
        return getConnection() == null ? null:getSchedulesEntity().findAll(getStylistsEntity(),getServicesEntity(),getSalonsEntity(),getUsersEntity(),getOwnersEntity(),getLocationsEntity());
    }
    public List<Service> findAllServices(){
        return getConnection() ==null  ?null:getServicesEntity().findAll();
    }
    //Aqui falta como poner las dos  llaves primaria de  la tabla skill
    public List<Skill> findAllSkills(){

        return getConnection() ==null ? null:getSkillsEntity().findAll();
    }
    public User createUser(String username,String password){
        return getConnection() ==null ?
                null:
                getUsersEntity().create(username,password);
    }
    public boolean updateUser(String id,String name,String password){
        return  getConnection() ==null ?
                false:
                getUsersEntity().update(id,name,password);
    }
    public boolean updateUser(User user){
        return  updateUser(user.getId(),user.getUsername(),user.getPassword());
    }

    public boolean eraseUser(String id){
        return connection ==null ?
                false:
                getUsersEntity().erase(id);
    }

    //falta hacer de  todas las tablas esta parte como e hecho para el user create,update,erase
    /**public  Service createService(String name,int price ,String description){
     return getConnection() ==null ?
     null:
     getServicesEntity().create(name,price,description);

     }
     //solo estoy haciendo d elos que no tiene  dependencias de llaves foraneas
     public Client createClient(String dni ,String firstName ,String lastName,String email ,String phone ,User user){
     return  getConnection() ==null ?
     null:
     getClientsEntity().create(dni,firstName,lastName,email,phone,user);
     }

     //solo estoy haciendo d elos que no tiene  dependencias de llaves foraneas

     */

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) { this.connection = connection; }

    public SalonsEntity getSalonsEntity() {
        if(salonsEntity ==null){
            salonsEntity = new SalonsEntity();
            salonsEntity.setConnection(connection);

        }
        return salonsEntity;
    }

    public void setSalonsEntity(SalonsEntity salonsEntity) {
        this.salonsEntity = salonsEntity;
    }

    public ClientsEntity getClientsEntity() {
        if(clientsEntity ==null){
            clientsEntity=new ClientsEntity();
            clientsEntity.setConnection(connection);
        }

        return clientsEntity;
    }

    public void setClientsEntity(ClientsEntity clientsEntity) {
        this.clientsEntity = clientsEntity;
    }

    public LocationsEntity getLocationsEntity() {
        if(locationsEntity==null){
            locationsEntity= new LocationsEntity();
            locationsEntity.setConnection(connection);
        }
        return locationsEntity;
    }

    public void setLocationsEntity(LocationsEntity locationsEntity) {
        this.locationsEntity = locationsEntity;
    }

    public StylistsEntity getStylistsEntity() {
        if(stylistsEntity==null){
            stylistsEntity=new StylistsEntity();
            stylistsEntity.setConnection(connection);
        }
        return stylistsEntity;
    }

    public void setStylistsEntity(StylistsEntity stylistsEntity) {
        this.stylistsEntity = stylistsEntity;
    }

    public UsersEntity getUsersEntity() {
        if(usersEntity ==null){
            usersEntity =new UsersEntity();
            usersEntity.setConnection(connection);
        }

        return usersEntity;
    }

    public void setUsersEntity(UsersEntity usersEntity) {
        this.usersEntity = usersEntity;
    }

    public OwnersEntity getOwnersEntity() {
        if(ownersEntity==null){
            ownersEntity=new OwnersEntity();
            ownersEntity.setConnection(connection);
        }
        return ownersEntity;
    }

    public void setOwnersEntity(OwnersEntity ownersEntity) {
        this.ownersEntity = ownersEntity;
    }

    public ServicesEntity getServicesEntity() {
        if(servicesEntity== null){
            servicesEntity=new ServicesEntity();
            servicesEntity.setConnection(connection);
        }
        return servicesEntity;
    }

    public void setServicesEntity(ServicesEntity servicesEntity) {
        this.servicesEntity = servicesEntity;
    }

    public SchedulesEntity getSchedulesEntity() {
        if(schedulesEntity== null){
            schedulesEntity=new SchedulesEntity();
            schedulesEntity.setConnection(connection);
        }
        return schedulesEntity;
    }

    public void setSchedulesEntity(SchedulesEntity schedulesEntity) {
        this.schedulesEntity = schedulesEntity;
    }

    public ReservationsEntity getReservationsEntity() {
        if(reservationsEntity ==null){
            reservationsEntity = new ReservationsEntity();
            reservationsEntity.setConnection(connection);
        }
        return reservationsEntity;
    }

    public void setReservationsEntity(ReservationsEntity reservationsEntity) {
        this.reservationsEntity = reservationsEntity;
    }

    public SkillsEntity getSkillsEntity() {
        if(skillsEntity == null){
            skillsEntity =new SkillsEntity();
            skillsEntity.setConnection(connection);
        }
        return skillsEntity;
    }

    public void setSkillsEntity(SkillsEntity skillsEntity) {
        this.skillsEntity = skillsEntity;
    }

}
