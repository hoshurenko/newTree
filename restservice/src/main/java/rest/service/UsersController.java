package rest.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
public class UsersController {
    private final UsersService service;
//    private List<User> users = new CopyOnWriteArrayList<>();

    public UsersController(@Qualifier("database") UsersService service) {
        this.service = service;

    }

    @GetMapping("/users/{id}")
    public User getUser(@PathVariable("id") Integer id) throws SQLException {
        return service.findUserById(id);
    }

    @PostMapping("/users")
    public void postUser(@RequestBody User user) {
        service.createUser(user);
    }

    @GetMapping("/users")
    public List getAllUsers () throws SQLException, ClassNotFoundException {
        return service.getAllUsers();
    }

    @PutMapping("/users/{id}")
    public User putUser (@RequestBody User user, @PathVariable Integer id) {
        service.updateUser(id, user);
        return user;
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser (@PathVariable int id) throws SQLException {

        service.deleteUserById(id);
    }
}