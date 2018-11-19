package pl.coderslab.Service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.coderslab.Service.UserService;
import pl.coderslab.model.User;
import pl.coderslab.repository.UserRepository;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User save(User u) {
        return userRepository.save(u);
    }

    @Override
    public User update(User u) {
        return userRepository.save(u);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findByName(String name) {
        return userRepository.findByName(name);
    }

    public User findByUserPesel(String userPesel) {
        return userRepository.findByPesel(userPesel);
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public void deleteUser(Long id) {

        userRepository.delete(id);
    }


}
