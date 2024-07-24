package Com.atm.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import Com.atm.entity.User;

public interface UserRepository  extends JpaRepository<User, Integer>{


	Optional<User> findByUsername(String username);
    
}