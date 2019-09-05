/* package Capstone.STL.Resources.STL.Resources.controllers;


import Capstone.STL.Resources.STL.Resources.models.Agency;
import Capstone.STL.Resources.STL.Resources.models.User;
import Capstone.STL.Resources.STL.Resources.repository.AgencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class AgencyController {

    @Autowired
    private AgencyRepository agencyRepository;


    @RequestMapping(value="/admin/agencyRegistration", method = RequestMethod.GET)
    public ModelAndView agencyRegistration(){
        ModelAndView modelAndView = new ModelAndView();
        Agency agency = new Agency();
        modelAndView.addObject("agency", agency);
        modelAndView.setViewName("admin/agencyRegistration");
        return modelAndView;
    }
/*
    @RequestMapping(value = "/admin/agencyRegistration", method = RequestMethod.POST)
    public ModelAndView createNewAgency(@Valid Agency agency, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        Agency agencyExists = userService.findUserByEmail(user.getEmail());
        if (userExists != null) {
            bindingResult
                    .rejectValue("email", "error.user",
                            "There is already a user registered with the email provided");
        }
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("registration");
        } else {
            userService.saveUser(user);
            modelAndView.addObject("successMessage", "User has been registered successfully");
            modelAndView.addObject("user", new User());
            modelAndView.setViewName("registration");

        }
        return modelAndView;
    }
**

}
*/