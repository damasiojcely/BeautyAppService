package pe.com.ctaf.beautyapp.models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsersEntity extends BaseEntity {
    public UsersEntity() {
        super();
        setTableName("user");
    }

    public UsersEntity(Connection connection, String tableName) {
        super(connection, tableName);
    }

    public User findById(String id) {
        return findByCriteria(
                String.format("WHERE id = '%s'", id)).get(0);
    }

    public List<User> findByCriteria(String criteria) {
        try {
            ResultSet rs = getConnection()
                    .createStatement()
                    .executeQuery(
                            getBaseStatement()
                                    .concat(criteria));
            List<User> users = new ArrayList<>();
            while (rs.next())
                users.add(User.from(rs));
            return users;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public User findByUsername(String username) {
        return findByCriteria(
                String.format("WHERE username = '%s'", username)).get(0);
    }

    public List<User> findAll() {return findByCriteria("");}



    public User create(User user) {
        return executeUpdate(String.format(
                "INSERT INTO %s(id, username, password) VALUES('%s', '%s', '%s')",
                getTableName(), user.getId(), user.getUsername(), user.getPassword())) ? user : null;
    }

    private int getMaxId() {
        String sql = "SELECT MAX(id) AS max_id FROM user";
        try {
            ResultSet resultSet = getConnection()
                    .createStatement()
                    .executeQuery(sql);
            return resultSet.next() ?
                    resultSet.getInt("max_id") : 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public User create(String username, String password) {
        return create(String.valueOf(getMaxId()+1), username, password);
    }

    public User create(String id, String username, String password) {return create(new User(id, username, password));}

    public boolean update(String id, String username, String password) {
        return executeUpdate(String.format(
                "UPDATE %s SET username = '%s', SET password = '%s' WHERE id = '%s'",
                getTableName(), username, password, id));
    }

    public boolean update(User user) { return update(user.getId(), user.getUsername(), user.getPassword());}

    public boolean erase(String id) {
        return executeUpdate(String.format("DELETE FROM %s WHERE id = '%s'",
                getTableName(), id));
    }

    public boolean erase(User user) {
        return executeUpdate(String.format("DELETE FROM %s WHERE id = '%s'",
                getTableName(), user.getId()));
    }
}
