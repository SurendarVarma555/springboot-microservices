package com.dailycodebuffer.app.repository;

import com.dailycodebuffer.app.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
