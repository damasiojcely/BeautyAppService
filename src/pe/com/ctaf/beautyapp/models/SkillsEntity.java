package pe.com.ctaf.beautyapp.models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class SkillsEntity extends BaseEntity {

    public SkillsEntity() {
        super();
    }

    public SkillsEntity(Connection connection) {
        super(connection,"skill");
    }

    public List<Skill> findById(String stylistId, String serviceid){
        return findByCriteria(String.format("WHERE stylistid = '%s' AND serviceid = '%s'", stylistId, serviceid));}

    public List<Skill> findByCriteria(String criteria) {
        try {
            ResultSet rs = getConnection()
                    .createStatement()
                    .executeQuery(
                            getBaseStatement()
                                    .concat(criteria));
            List<Skill> skills= new ArrayList<>();
            while(rs.next())
                skills.add(Skill.build(rs));

            return skills;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }
    public Skill findByTime(float time) {
        return findByCriteria(
                String.format("WHERE timeof= '%s'", time)).get(0);
    }
    public List<Skill> findAll() {
        return findByCriteria(" ");
    }
}
