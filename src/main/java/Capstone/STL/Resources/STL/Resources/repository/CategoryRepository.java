package Capstone.STL.Resources.STL.Resources.repository;


import Capstone.STL.Resources.STL.Resources.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("categoryRepository")
public interface CategoryRepository extends JpaRepository<Category, Integer > {
    Category findByName (String name);
}
