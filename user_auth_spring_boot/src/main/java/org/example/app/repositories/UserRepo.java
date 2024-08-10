package org.example.app.repositories;

import org.example.app.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, String> {
    // extra db methods
    // custom query methods
    // custom finder methods
    Optional<User> findByEmail(String email);
}
