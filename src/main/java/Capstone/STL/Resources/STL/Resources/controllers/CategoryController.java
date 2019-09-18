package Capstone.STL.Resources.STL.Resources.controllers;


import Capstone.STL.Resources.STL.Resources.models.AddCategoryItemForm;
import Capstone.STL.Resources.STL.Resources.models.Agency;
import Capstone.STL.Resources.STL.Resources.models.Category;
import Capstone.STL.Resources.STL.Resources.repository.CategoryRepository;
import Capstone.STL.Resources.STL.Resources.service.AgencyService;
import Capstone.STL.Resources.STL.Resources.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "admin/category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    AgencyService agencyService;

    @RequestMapping(value = "")
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("title", "Categories");
        modelAndView.addObject("categories", categoryService.findAll());
        modelAndView.setViewName("admin/category/index");
        return modelAndView;
    }

    @RequestMapping(value="add", method = RequestMethod.GET)
    public ModelAndView add(@Valid Category category, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("title", "Add Category");
        modelAndView.addObject("category", category);
        modelAndView.setViewName("admin/category/add");
        return modelAndView;
    }

    @RequestMapping(value="add", method = RequestMethod.POST)
    public ModelAndView addCategory(@Valid Category category, BindingResult bindingResult){
        ModelAndView modelAndView = new ModelAndView();

        if (bindingResult.hasErrors()) {
            modelAndView.addObject("title", "Add Category");
            modelAndView.setViewName("admin/category/add");
            return modelAndView;
        }

        categoryService.saveCategory(category);
        modelAndView.setViewName("redirect:view/" + category.getId());
        return modelAndView;
    }

    @RequestMapping(value = "view/{categoryId}", method = RequestMethod.GET)
    public ModelAndView viewCategory(@PathVariable int categoryId) {
        ModelAndView modelAndView = new ModelAndView();

        Category category = categoryService.get(categoryId);
        modelAndView.addObject("title", category.getName());
        modelAndView.addObject("agencies", category.getAgencies());
        modelAndView.addObject("categoryId", category.getId());
        modelAndView.setViewName("admin/category/view");
        return modelAndView;
    }

    @RequestMapping(value = "add-item/{categoryId}", method = RequestMethod.GET)
    public ModelAndView addItem(@PathVariable int categoryId) {
        ModelAndView modelAndView = new ModelAndView();

        Category category = categoryService.get(categoryId);

        AddCategoryItemForm form = new AddCategoryItemForm(
                agencyService.findAll(),
                category);

        modelAndView.addObject("title", "Add an agency to " + category.getName());
        modelAndView.addObject("form", form);
        modelAndView.setViewName("admin/category/add-item");
        return modelAndView;
    }

    @RequestMapping(value = "add-item", method = RequestMethod.POST)
    public ModelAndView addItem(@ModelAttribute @Valid AddCategoryItemForm form, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();

        if (bindingResult.hasErrors()) {
            modelAndView.addObject("form", form);
            modelAndView.setViewName("admin/category/add-item");
            return modelAndView;
        }

        Agency theAgency = agencyService.get(form.getAgencyId());
        Category theCategory = categoryService.get(form.getCategoryId());
        theCategory.addItem(theAgency);
        categoryService.saveCategory(theCategory);

        modelAndView.setViewName("redirect:/admin/category/view/" + theCategory.getId());

        return modelAndView;
    }

}
