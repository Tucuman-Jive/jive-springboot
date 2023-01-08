package rocks.zipcode.Jive.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rocks.zipcode.Jive.entities.User;
import rocks.zipcode.Jive.repositories.UserRepository;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User getUserById(Long idUser) {
        return userRepository.findById(idUser).get();
    }

    public void saveUser(User user) {
        userRepository.save(user);
    }

    public void deleteUserById(Long idUser) {
        userRepository.deleteById(idUser);
    }
}
