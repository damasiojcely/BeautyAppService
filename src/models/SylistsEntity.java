package models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SylistsEntity extends  BaseEntity {

    public SylistsEntity(Connection connection){
        super(connection,"stylist");
    }

    public SylistsEntity(){super();
    }
    List<Sylist> findAll() {
        return findByCriteria("");
    }
    public  Sylist findById(int id ){
        String criteria ="id_sty="+
                String.valueOf(id);
        return findByCriteria(criteria).get(0);
    }
    public Sylist findByName(String name){
        String criteria="firstname_sty = '" +
                name + " '";
        return findByCriteria(criteria).get(0);
    }
    public List<Sylist> findByName(){
        String criteria="true ORDER BY firstname_sty";
        return findByCriteria(criteria);
    }

    public List<Sylist>findByCriteria(String criteria){
        String sql=
                //getDefaultQuery() +
                criteria ==" " ? "" : "WHERE "  + criteria;

        List<Sylist> sylists =new ArrayList<>();
        try{
            ResultSet resultSet =getConnection()
                    .createStatement()
                    .executeQuery(sql);
            if(resultSet ==null)return null;
            while(resultSet.next()){
                sylists.add((new Sylist())
                        .setId(resultSet.getString("id_sty"))
                        .setFirstName(resultSet.getString("firstname_sty"))
                        .setLastName(resultSet.getString("lastname_sty")));

            }
            return sylists;


        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return null;




    }


}