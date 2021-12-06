package com.sowmya.librarysystem.dao;

import com.sowmya.librarysystem.users.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

     User findByUsername(String username);

}
