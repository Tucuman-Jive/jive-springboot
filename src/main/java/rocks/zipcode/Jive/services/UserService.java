package rocks.zipcode.Jive.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rocks.zipcode.Jive.entities.UserEntity;
import rocks.zipcode.Jive.repositories.UserRepository;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }

    public UserEntity getUserById(Long id) {
        return userRepository.findById(id).get();
    }

    public void saveUser(UserEntity user) {
        userRepository.save(user);
    }

    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }

    public void deleteAllUsers() {
        userRepository.deleteAll();
    }


    public UserEntity update(Long id, UserEntity newUserEntity) {
        UserEntity userEntity = userRepository.findById(id).get();
        userEntity.setUserName(newUserEntity.getUserName());
        userEntity.setPassword(newUserEntity.getPassword());
        return userRepository.save(userEntity);
    }
}
