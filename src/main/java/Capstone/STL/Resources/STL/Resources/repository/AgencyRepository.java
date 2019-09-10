package Capstone.STL.Resources.STL.Resources.repository;


import Capstone.STL.Resources.STL.Resources.models.Agency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("agencyRepository")
public interface AgencyRepository extends JpaRepository<Agency, Long> {
    Agency findByTitle(String title);
}