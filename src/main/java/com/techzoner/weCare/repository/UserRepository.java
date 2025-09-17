package com.techzoner.weCare.repository;

import com.techzoner.weCare.utilites.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,String> {
}
