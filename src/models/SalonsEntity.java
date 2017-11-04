package models;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SalonsEntity extends  BaseEntity {
    public  SalonsEntity(Connection connection){
        super(connection,"salon");
    }
    public SalonsEntity(){
        super();
    }
    public List<Salon> findByCriteria(String criteria,OwnersEntity ownersEntity,UbigeosEntity ubigeosEntity){
        String sql=getDefaultQuery()+(criteria.isEmpty() ?" " :"WHERE" + criteria);
        List<Salon> salons =new ArrayList<>();
        try{
            ResultSet rs= getConnection().createStatement().executeQuery(sql);
            if(rs==null)return null;
            while (rs.next()) salons.add(Salon.build(rs,ownersEntity,ubigeosEntity));
            return  salons;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return  salons;
    }
    public List<Salon> findAll(OwnersEntity ownersEntity ,UbigeosEntity ubigeosEntity){
        return findByCriteria("",ownersEntity,ubigeosEntity);

    }
    public Salon findById(String id,OwnersEntity ownersEntity,UbigeosEntity ubigeosEntity){
        try{
            String sql="id="+String.valueOf(id);
            return findByCriteria(sql , ownersEntity,ubigeosEntity).get(0);
        }catch (Exception e){
            e.printStackTrace();
        }
        return  null;
    }
        public  boolean add(Salon salon){


        String sql="INSERT INTO salon(id_sal ,name_sal,phone_sal,email_sal,id_own,id_loc )VALUES(" +
                salon.getId() + " ," +
                salon.getName() +","+
                salon.getPhone()+" ,"+
                salon.getEmail()+" ," +
                salon.getOwn()+" ,"+
                salon.getLoc()+" ,"+ ")";

        return  change(sql);
    }




}
