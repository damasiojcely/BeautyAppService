package models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StylistsEntity extends  BaseEntity {

    public StylistsEntity(Connection connection){
        super(connection,"stylist");
    }

    public StylistsEntity(){super();
    }
    List<Stylist> findAll() {
        return findByCriteria("");
    }
    public Stylist findById(String id ){
        String criteria ="id_sty="+
                String.valueOf(id);
        return findByCriteria(criteria).get(0);
    }
    public Stylist findByName(String name){
        String criteria="firstname_sty = '" +
                name + " '";
        return findByCriteria(criteria).get(0);
    }
    public List<Stylist> findByName(){
        String criteria="true ORDER BY firstname_sty";
        return findByCriteria(criteria);
    }

    public List<Stylist>findByCriteria(String criteria){
        String sql=
                //getDefaultQuery() +
                criteria ==" " ? "" : "WHERE "  + criteria;

        List<Stylist> stylists =new ArrayList<>();
        try{
            ResultSet resultSet =getConnection()
                    .createStatement()
                    .executeQuery(sql);
            if(resultSet ==null)return null;
            while(resultSet.next()){
                stylists.add((new Stylist())
                        .setId(resultSet.getString("id_sty"))
                        .setFirstName(resultSet.getString("firstname_sty"))
                        .setLastName(resultSet.getString("lastname_sty")));

            }
          return stylists;


        }
     catch (SQLException e){
            e.printStackTrace();
        }
        return null;




    }


}
