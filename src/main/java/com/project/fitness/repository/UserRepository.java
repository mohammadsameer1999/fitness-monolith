package com.project.fitness.repository;

import com.project.fitness.model.Activity;
import com.project.fitness.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
