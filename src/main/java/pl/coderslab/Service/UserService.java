package pl.coderslab.Service;

import pl.coderslab.model.Suplement;
import pl.coderslab.model.User;

import java.util.List;

public interface UserService {

    User save(User u);
    User update(User u);
    List<User> findAll();
    User findByName(String name);
    User findById(Long id);
    void deleteUser(Long id);


}
