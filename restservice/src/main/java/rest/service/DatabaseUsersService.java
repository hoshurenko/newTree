package rest.service;

import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.PreDestroy;
import java.sql.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Component
@Qualifier("database")
public class DatabaseUsersService implements UsersService{
    static final String JDBC_DRIVER = "org.postgresql.Driver";
    static final String DB_URL = "jdbc:postgresql://localhost/test";
    static final String USER = "postgres";
    static final String PASS = "njkzrj19621989";

    private final Connection connection;

    public DatabaseUsersService(){
        try {
            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, USER, PASS);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @PreDestroy
    public void close() throws SQLException {
        connection.close();
    }

    @Override
    public User findUserById(int id) throws SQLException {
        List<User> users = new ArrayList<>();
        try {
            ResultSet resultSet = connection
                    .createStatement()
                    .executeQuery("select * from users order by id asc");
            while(resultSet.next()){

                users.add(new User()
                        .setName(resultSet.getString("name"))
                        .setId(resultSet.getInt("id"))
                        .setAge(resultSet.getInt("age")));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return users.get(id - 1);
    }

    @Override
    public List<User> getAllUsers() throws SQLException {
        List<User> users = new ArrayList<>();
        try {
            ResultSet resultSet = connection
                    .createStatement()
                    .executeQuery("select * from users order by id asc");
            while(resultSet.next()){
                users.add(new User()
                        .setName(resultSet.getString("name"))
                        .setId(resultSet.getInt("id"))
                        .setAge(resultSet.getInt("age")));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return users;
    }

    @Override
    public void createUser(User user) {
        try (PreparedStatement statement = connection.prepareStatement("insert into users (id, name, age) values (?, ?, ?)")){
            statement.setInt(1, user.getId());
            statement.setString(2,user.getName());
            statement.setInt(3, user.getAge());
            statement.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void updateUser(int id, User user) {
        try (PreparedStatement statement = connection.prepareStatement("update users set name = ?, age = ? where id = ?")){
            statement.setString(1, user.getName());
            statement.setInt(2, user.getAge());
            statement.setInt(3, id);
            statement.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteUserById(int id){
        try (PreparedStatement statement = connection.prepareStatement("delete from users where id = ?")){
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (Exception e) {
           throw new RuntimeException(e);
        }

    }
}
