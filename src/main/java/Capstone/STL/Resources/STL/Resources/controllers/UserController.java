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

    @RequestMapping (value ="signup", method = RequestMethod.GET)
    public String displaySignupForm (Model model) {
        model.addAttribute("title", "Create Account");
        model.addAttribute(new User());
        return "user/signup";
    }

    @RequestMapping (value ="signup", method = RequestMethod.POST)
    public String processUserSignupForm (@ModelAttribute @Valid User newUser,
                                         Errors errors, String verify, Model model) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Please try again: ");
            return "user/signup";
        }

        if (newUser.getPassword().equals(verify)) {
            userDao.save(newUser);
            newUser.getId();
            model.addAttribute("user", newUser);
            return "user/page";
        }

        model.addAttribute("title", "Please try again: ");
        model.addAttribute("user", newUser);
        model.addAttribute("errormessage", "Passwords must match");
        return "user/signup";
    }

    @RequestMapping (value = "login", method = RequestMethod.GET)
    public String displayLoginForm(Model model) {
        model.addAttribute("title", "Log In");
        //I don't want to send a new user- instead I want to send??
        model.addAttribute(new User());
        return "user/login";
    }

    @RequestMapping (value = "login", method = RequestMethod.POST)
    public String processUserLoginForm(@ModelAttribute @Valid User user,
                                       Errors errors, String verify, Model model) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Please Log In Again: ");
            model.addAttribute("user", user);
            return "user/login";
        }

        /*
        work on implementing user login functionality
         */
        return "user/page";
    }


    @RequestMapping (value = "page", method = RequestMethod.GET)
    public String displayPersonalPage(Model model) {
        model.addAttribute("title", "You are logged in");
        return "user/page";
    }






}
