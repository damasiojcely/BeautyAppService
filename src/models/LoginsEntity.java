package models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LoginsEntity extends BaseEntity {
    public LoginsEntity() {
        super();
        setTableName("login");
    }

    public LoginsEntity(Connection connection, String tableName) {
        super(connection, tableName);
    }

    public Login findById(String id) {
        return findByCriteria(
                String.format("WHERE username = '%s'", id)).get(0);
    }

    public List<Login> findByCriteria(String criteria) {
        try {
            ResultSet rs = getConnection()
                    .createStatement()
                    .executeQuery(
                            getBaseStatement()
                            .concat(criteria));
            List<Login> logins = new ArrayList<>();
            while (rs.next())
                logins.add(Login.from(rs));
            return logins;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Login findByPassword(String password) {
        return findByCriteria(
                String.format("WHERE password = '%s'", password)).get(0);
    }

    public List<Login> findAll() {return findByCriteria("");}

    public Login create(Login login) {
        return executeUpdate(String.format(
                "INSERT INTO %s(username, password) VALUES('%s','%s')",
                getTableName(), login.getUsername(), login.getPassword())) ?
                login : null;
    }

    public Login create(String username, String password) {return create(new Login(username, password));}

    public boolean update(String username, String password) {
        return executeUpdate(String.format(
                "UPDATE %s SET password = '%s' WHERE username = '%s'", getTableName(), username, password));
    }

    public boolean update(Login login) { return update(login.getUsername(), login.getPassword());}

    public boolean erase(String username) {
        return executeUpdate(String.format("DELETE FROM %s WHERE username = '%s'",
                getTableName(), username));
    }

    public boolean erase(Login login) {
        return executeUpdate(String.format("DELETE FROM %s WHERE username = '%s'",
                getTableName(), login.getUsername()));
    }
}
