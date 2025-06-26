package org.example.repository;

import org.example.dto.User;
import org.example.entity.UserEntity;
import org.example.enums.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity,Long> {

}
