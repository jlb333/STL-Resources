package Capstone.STL.Resources.STL.Resources.repository;

import Capstone.STL.Resources.STL.Resources.models.User;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;


@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
