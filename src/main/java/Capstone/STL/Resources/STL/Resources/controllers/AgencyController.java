package Capstone.STL.Resources.STL.Resources.controllers;


import Capstone.STL.Resources.STL.Resources.models.Agency;
import Capstone.STL.Resources.STL.Resources.repository.AgencyRepository;
import Capstone.STL.Resources.STL.Resources.service.AgencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


import javax.validation.Valid;

@Controller
public class AgencyController<agencies> {

    @Autowired
    private AgencyService agencyService;

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

    @RequestMapping(value = "/admin/agencyRegistration", method = RequestMethod.POST)
    public ModelAndView createNewAgency(@Valid Agency agency, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        Agency agencyExists = agencyService.findAgencyByTitle(agency.getTitle());
        if (agencyExists != null) {
            bindingResult
                    .rejectValue("title", "error.agency",
                            "There is already an agency with with name");
        }
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("admin/agencyRegistration");
        } else {
            agencyService.saveAgency(agency);
            modelAndView.addObject("successMessage", "Agency has been successfully added");
            modelAndView.addObject("agency", new Agency());
            modelAndView.setViewName("admin/agencyRegistration");

        }
        return modelAndView;
    }

    @RequestMapping(value="/admin/edit/{id}", method = RequestMethod.GET)
    public ModelAndView agencyEdit(@PathVariable("id") Integer id){
        Agency agency = agencyRepository.findById(id).get();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("agency", agency);
        modelAndView.setViewName("admin/edit");
        return modelAndView;
    }

    @RequestMapping(value="/admin/edit/{id}", method = RequestMethod.POST)
    public ModelAndView processAgencyEdit(@PathVariable("id") Integer id, @Valid Agency agency, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            ModelAndView modelAndView = new ModelAndView();
            agency.setId(id);
            modelAndView.setViewName("admin/edit");
            return modelAndView;
        }

        agencyService.saveAgency(agency);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("admin/home");
        return modelAndView;
    }

}