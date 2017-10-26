package models;

import java.sql.Connection;
import java.util.List;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.SQLException;

public class ClientEntity  extends BaseEntity{

    public ClientEntity(Connection connection){super (connection,"client"); }
    public ClientEntity(){super(); }
    List<Client> findAll() {return findByCriteria(""); }

     public Client findById(int id){
        String criteria="id_cli="+
                String.valueOf(id);
        return findByCriteria (criteria).get(0);
     }
     public Client findByName(String name){
         String criteria="firstname_cli = ' "+
                 name + " '";
         return findByCriteria(criteria).get(0);
     }

    public List<Client>findAllOrderByName(){
         String criteria="true ORDER BY firstname_cli";
         return findByCriteria(criteria);
    }
    public List<Client>findByCriteria(String criteria){
       String sql=
               //aqui falta  getDefaultQuery()+
                criteria ==" " ? "" : "WHERE "  + criteria;
        List<Client> clients =new ArrayList<>();
        try{
            ResultSet resultSet =getConnection()
                    .createStatement()
                    .executeQuery(sql);
            if(resultSet ==null)return null;
            while(resultSet.next()){
                clients.add(new Client()
                .setId(resultSet.getString("id_cli"))
                 .setFirstName(resultSet.getString("firstname_cli"))
                        .setLastName(resultSet.getString("lastname_cli")));

            }
            return clients;

            }catch (SQLException e){
            e.printStackTrace();
        }
        return null;

        }



}
