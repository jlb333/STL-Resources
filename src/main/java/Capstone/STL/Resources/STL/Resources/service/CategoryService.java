package Capstone.STL.Resources.STL.Resources.service;

import Capstone.STL.Resources.STL.Resources.models.Category;
import Capstone.STL.Resources.STL.Resources.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("categoryService")
public class CategoryService {

    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryService (CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Category findByName(String name) {return categoryRepository.findByName(name); }

    public void saveCategory(Category category) {categoryRepository.save(category); }

    public List<Category> findAll() {return categoryRepository.findAll(); }

    public Category get(Integer id) {return categoryRepository.findById(id).get();}

    public void delete(Integer id) {categoryRepository.deleteById(id);}

}
