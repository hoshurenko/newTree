package rest.service;

import java.sql.SQLException;
import java.util.List;

public interface UsersService {
    User findUserById(int id) throws SQLException;
    List<User> getAllUsers() throws ClassNotFoundException, SQLException;
    void createUser(User user);
    void updateUser(int id, User user);
    void deleteUserById (int id) throws SQLException;

}
