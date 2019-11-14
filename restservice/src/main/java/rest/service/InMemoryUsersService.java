package rest.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Component
@Qualifier("inMemory")
public class InMemoryUsersService implements UsersService{
    private List<User> users = new CopyOnWriteArrayList<>();
    public InMemoryUsersService (){
        users.add(new User()
                .setName("Zero")
                .setAge(14));
        users.add(new User()
                .setName("One")
                .setAge(52));
        users.add(new User()
                .setName("Second")
                .setAge(44));
    }
    @Override
    public User findUserById(int id) {
        return users.get(id);
    }

    @Override
    public List<User> getAllUsers() {
        return users;
    }

    @Override
    public void createUser(User user) {
        users.add(user);
    }

    @Override
    public void updateUser(int id, User user) {
        users.set(id, user);
    }

    @Override
    public void deleteUserById(int id) {
        users.remove(id);
    }
}
