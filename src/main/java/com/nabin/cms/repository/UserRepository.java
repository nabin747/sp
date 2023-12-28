package com.nabin.cms.repository;

import com.nabin.cms.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author nabin
 */
public interface UserRepository extends JpaRepository<User, Long> {
}
