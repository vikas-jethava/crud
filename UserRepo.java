package com.vikas.JpaManyToMany.Repository;

import com.vikas.JpaManyToMany.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User,Long> {
//    Optional<User> findByUserName(String username);
}
