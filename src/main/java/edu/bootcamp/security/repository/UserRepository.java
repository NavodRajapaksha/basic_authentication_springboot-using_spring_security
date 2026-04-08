package edu.bootcamp.security.repository;

import edu.bootcamp.security.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface UserRepository extends JpaRepository<UserModel,Integer> {
    List<UserModel> findByEmail(String username);
}
