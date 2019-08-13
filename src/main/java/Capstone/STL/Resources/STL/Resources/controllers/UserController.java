package Capstone.STL.Resources.STL.Resources.controllers;

import Capstone.STL.Resources.STL.Resources.models.User;
import Capstone.STL.Resources.STL.Resources.models.data.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;


@Controller
@RequestMapping ("user")
public class UserController {

    @Autowired
    private UserDao userDao;

    // @ Request path:  /user
    @RequestMapping (value = "")
    public String index(Model model){
        model.addAttribute("title", "Welcome to the User Landing Page!");
        return "user/index";
    }

    @RequestMapping (value = "login", method = RequestMethod.GET)
    public String displayLoginForm(Model model) {
        model.addAttribute("title", "Log In");
        return "user/login";
    }

    @RequestMapping (value = "login", method = RequestMethod.POST)
    public String processUserLoginForm(@ModelAttribute @Valid User newUser,
                                       Errors errors, Model model) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Please Log In Again: ");
            return "user/login";
        }

        userDao.save(newUser);
        return "user/page";
    }


    @RequestMapping (value = "page", method = RequestMethod.GET)
    public String displayPersonalPage(Model model) {
        model.addAttribute("title", "You are logged in");
        return "user/page";
    }






}
