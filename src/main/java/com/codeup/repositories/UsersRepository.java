package com.codeup.repositories;

import com.codeup.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository  // optional
public interface UsersRepository extends CrudRepository<User, Long> {
    public User findByUsername(String username);
}