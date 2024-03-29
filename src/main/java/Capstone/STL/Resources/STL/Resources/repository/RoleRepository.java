package Capstone.STL.Resources.STL.Resources.repository;


import Capstone.STL.Resources.STL.Resources.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("roleRepository")
public interface RoleRepository extends JpaRepository<Role, Integer> {
    Role findByRole(String role);
}
