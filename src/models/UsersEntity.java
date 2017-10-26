package models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsersEntity extends BaseEntity {
    public UsersEntity() {
        super();
        setTableName("login");
    }

    public UsersEntity(Connection connection, String tableName) {
        super(connection, tableName);
    }

    public User findById(String id) {
        return findByCriteria(
                String.format("WHERE username = '%s'", id)).get(0);
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

    public User findByPassword(String password) {
        return findByCriteria(
                String.format("WHERE password = '%s'", password)).get(0);
    }

    public List<User> findAll() {return findByCriteria("");}

    public User create(User user) {
        return executeUpdate(String.format(
                "INSERT INTO %s(username, password) VALUES('%s','%s')",
                getTableName(), user.getUsername(), user.getPassword())) ?
                user : null;
    }

    public User create(String username, String password) {return create(new User(username, password));}

    public boolean update(String username, String password) {
        return executeUpdate(String.format(
                "UPDATE %s SET password = '%s' WHERE username = '%s'", getTableName(), username, password));
    }

    public boolean update(User user) { return update(user.getUsername(), user.getPassword());}

    public boolean erase(String username) {
        return executeUpdate(String.format("DELETE FROM %s WHERE username = '%s'",
                getTableName(), username));
    }

    public boolean erase(User user) {
        return executeUpdate(String.format("DELETE FROM %s WHERE username = '%s'",
                getTableName(), user.getUsername()));
    }
}
