package net.slipp.model;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>{
//	User findByEmailAndUserId(String email, String userId);
//	User findByEmail
}
