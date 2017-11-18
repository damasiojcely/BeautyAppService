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


    public Skill findSkillById(String stylistid, String serviceid){
        if(getConnection() ==null)return  null;
        return (Skill) getSkillsEntity().findById(stylistid,serviceid);

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

    public List<Location> findAllLocations(){
        return getConnection()== null ? null:getLocationsEntity().findAll();
    }

    //de aqui comienza para hacer de todas las tablas

    public User createUser( String id,String username,String password){
        return getConnection() ==null ?
                null:
                getUsersEntity().create(id,username,password);
    }
    public boolean updateUser(String id,String name,String password){
        return  connection ==null ?
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


    public boolean createClient(String id, String dni , String firstName , String lastName, String email , String phone , User user){
        return  getConnection() ==null ?
                null:
                getClientsEntity().create(id,dni,firstName,lastName,email,phone,user);
    }
    public boolean updateClient(String id, String dni , String firstName , String lastName, String email , String phone , User user){
        return  connection ==null ?
                false:
                getClientsEntity().update(id,dni,firstName,lastName,email,phone,user);

    }
    public boolean  updateClient (Client client){
        return  updateClient(client.getId(),client.getDni(),client.getFirstName(),client.getLastName(),client.getEmail(),client.getPhone(),client.getUser());
    }

    public boolean eraseClient(String id){
        return connection ==null ?
                false:
                getClientsEntity().erase(id);
    }
    public Boolean createLocation(String id, String departament , String province , String  district , String address) {
        return getConnection() ==null ?
                null:
                getLocationsEntity().create(id,departament,province,district,address);
    }
    public boolean updateLocation(String id, String departament , String province , String  district , String address){
        return connection== null?
                false:
                getLocationsEntity().update(id,departament,province,district,address);
    }
    public boolean updateLocation(Location location){
        return updateLocation(location.getId(),location.getDepartament(),location.getProvince(),location.getDistrict(),location.getAddress());
    }
    public  boolean eraseLocation(String id){
        return connection ==null ?
                false:
                getLocationsEntity().erase(id);
    }

    public boolean createOwner(String id, String dni , String name , String last, String email , String phone , User user){
        return  getConnection() ==null ?
                null:
                getOwnersEntity().create(id,dni,name,last,email,phone,user);
    }
    public boolean updateOwner(String id, String dni , String name , String last, String email , String phone , User user){
        return  connection ==null ?
                false:
                getOwnersEntity().update(id,dni,name,last,email,phone,user);

    }
    public boolean  updateOwner(Owner owner){
        return  updateOwner(owner.getId(),owner.getDni(),owner.getName(),owner.getLast(),owner.getEmail(),owner.getPhone(),owner.getUser());
    }

    public boolean eraseOwner(String id){
        return connection ==null ?
                false:
                getOwnersEntity().erase(id);
    }

    public boolean createReservation(String id, String reservedat , String requestedfor , Float price , String startat , String endat ,Client client ,Schedule schedule){
        return  getConnection() ==null ?
                null:
                getReservationsEntity().create(id, reservedat , requestedfor ,price , startat , endat ,client , schedule);
    }

    public boolean updateReservation(String id, String reservedat , String requestedfor , Float price , String startat , String endat ,Client client ,Schedule schedule){
        return  connection ==null ?
                false:
                getReservationsEntity().update(id, reservedat , requestedfor ,price , startat , endat ,client , schedule);
    }
    public boolean updateReservation(Reservation reservation){
        return  updateReservation(reservation.getId(),reservation.getReservedat(),reservation.getRequestedfor(),reservation.getPrice(),reservation.getStartat(),reservation.getEndat(),reservation.getClient(),reservation.getSchedule());

    }
    public boolean eraseReservation(String id){
        return connection ==null ?
                false:
                getReservationsEntity().erase(id);
    }

    public boolean createSalon(String id, String name , String phone ,String email, Owner owner ,Location location) {
        return  getConnection() ==null ?
                null:
                getSalonsEntity().create( id,  name ,  phone , email,  owner ,location);
    }
    public boolean updateSalon(String id, String name , String phone ,String email, Owner owner ,Location location) {
        return  connection ==null ?
                false:
                getSalonsEntity().update(id,  name ,  phone , email,  owner ,location);
    }
    public  boolean updateSalon (Salon salon ){
        return updateSalon(salon.getId(),salon.getName(),salon.getPhone(),salon.getEmail(),salon.getOwner(),salon.getLocation());
    }
    public boolean eraseSalon(String id){
        return connection ==null ?
                false:
                getSalonsEntity().erase(id);
    }

    public boolean createSchedule(String id ,String startAt ,String endArt,Float discount,Stylist stylist,Service service ,Salon salon)
    {
        return  getConnection() ==null ?
                null:
                getSchedulesEntity().create( id , startAt , endArt, discount, stylist, service , salon);
    }

    public  boolean updateSchedule(String id ,String startAt ,String endArt,Float discount,Stylist stylist,Service service ,Salon salon){
        return  connection ==null ?
                false:
                getSchedulesEntity().update( id , startAt , endArt, discount, stylist, service , salon);
    }

    public boolean updateSchedule(Schedule schedule){
        return  updateSchedule(schedule.getId(),schedule.getStartAt(),schedule.getEndAt(),schedule.getDiscount(),schedule.getStylist(),schedule.getService(),schedule.getSalon());
    }

    public boolean eraserSchedule(String id){
        return connection ==null ?
                false:
                getSchedulesEntity().erase(id);
    }

    //service
    public boolean createService(String id, String name, float price , String description){
        return  getConnection() ==null ?
                null:
                getServicesEntity().create(id,name ,price,description);
    }
    public boolean updateService(String id, String name, float price , String description){
        return  connection ==null ?
                false:
                getServicesEntity().update(id,name ,price,description);
    }
    public boolean updateService(Service service){
        return  updateService(service.getId(),service.getName(),service.getPrice(),service.getDescription());
    }
    public boolean eraseService(String id){
        return connection ==null ?
                false:
                getServicesEntity().erase(id);
    }
    public boolean createStylist(String id, String dni , String firstName , String lastName, String email , String phone , User user){
        return  getConnection() ==null ?
                null:
                getStylistsEntity().create(id,dni,firstName,lastName,email,phone,user);
    }
    public boolean updateStylist(String id, String dni , String firstName , String lastName, String email , String phone , User user){
        return  connection ==null ?
                false:
                getStylistsEntity().update(id,dni,firstName,lastName,email,phone,user);

    }
    public boolean  updateStylist (Stylist stylist){
        return  updateClient(stylist.getId(),stylist.getDni(),stylist.getFirstName(),stylist.getLastName(),stylist.getEmail(),stylist.getPhone(),stylist.getUser());
    }

    public boolean eraseStylist(String id){
        return connection ==null ?
                false:
                getStylistsEntity().erase(id);
    }

    /**Skill ,falta crear en el skill entity
     public boolean createSkill(String  stylistid ,String serviceid ,Float time){
     return  getConnection() ==null ?
     null:
     getSkillsEntity().create(stylistid ,serviceid ,time);
     }
     public boolean updateSkil(String  stylistid ,String serviceid ,Float time){
     return  connection ==null ?
     false:
     getSkillsEntity().update(stylistid ,serviceid ,time);
     }
     public boolean updateSkill(Skill skill){
     return updateSkil(skill.getStylistid(),skill.getServiceid(),skill.getTime());
     }
     public boolean eraseSkill(String stylistid ,String serviceid ){
     return connection ==null ?
     false:
     getSkillsEntity().erase(stylistid , serviceid );
     }
     **/





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
