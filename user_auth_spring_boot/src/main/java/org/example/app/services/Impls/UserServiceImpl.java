package org.example.app.services.Impls;

import org.example.app.entities.User;
import org.example.app.helper.AppConstants;
import org.example.app.repositories.UserRepo;
import org.example.app.services.UserService;
import org.example.app.helper.ResourceNotFoundException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Override
    public User saveUser(User user) {
        String userId = UUID.randomUUID().toString();
        user.setUserId(userId);
        // password encoder
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        // set roles
        user.setRolelist(List.of(AppConstants.ROLE_USER));
        logger.info(user.getProvider().toString());
        return userRepo.save(user);
    }

    @Override
    public Optional<User> getUserById(String id) {
        return userRepo.findById(id);
    }

    @Override
    public Optional<User> updateUser(User user) {
       User user2 =  userRepo.findById(user.getUserId()).orElseThrow(
                () -> new ResourceNotFoundException("User not found"));
       // update user2
        user2.setName(user.getName());
        user2.setEmail(user.getEmail());
        user2.setPassword(user.getPassword());
        user2.setAbout(user.getAbout());
        user2.setPhoneNumber(user.getPhoneNumber());
        user2.setProvider(user.getProvider());
        // save user in database
       User save = userRepo.save(user2);
       return Optional.ofNullable(save);
    }
    @Override
    public void deleteUser(String id) {
        User user2 =  userRepo.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("User not found"));
        userRepo.delete(user2);
    }

    @Override
    public boolean isUSerExist(String userId) {
        User user2 = userRepo.findById(userId).orElse(null);
        return user2 != null;
    }

    @Override
    public boolean isUserExistByUseEmail(String email) {
        return userRepo.findByEmail(email).orElse(null)!=null;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }
}
