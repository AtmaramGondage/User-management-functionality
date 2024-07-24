package Com.atm.service;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Com.atm.entity.User;
import Com.atm.exception.UserNotFoundException;
import Com.atm.repository.UserRepository;
@Service
public class UserServiceimpl implements  UserService{
	

     @Autowired
	private UserRepository userRepository;

     public User createUser(User user) {
         return userRepository.save(user);
     }

     public void deleteUser(Integer id) {
         if (userRepository.existsById(id)) {
             userRepository.deleteById(id);
         } else {
             throw new UserNotFoundException("User with ID " + id + " not found.");
         }
     }

     public List<User> getAllUsers() {
         return userRepository.findAll();
     }

     public Optional<User> getUserByUsername(String username) {
         return userRepository.findByUsername(username);
     }
 
     
	
}