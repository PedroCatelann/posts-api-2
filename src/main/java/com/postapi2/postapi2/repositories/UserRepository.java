package com.postapi2.postapi2.repositories;

import com.postapi2.postapi2.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
