package Capstone.STL.Resources.STL.Resources.service;


import Capstone.STL.Resources.STL.Resources.models.Agency;
import Capstone.STL.Resources.STL.Resources.repository.AgencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("agencyService")
public class AgencyService {

    private AgencyRepository agencyRepository;


    @Autowired
    public AgencyService(AgencyRepository agencyRepository) {
        this.agencyRepository = agencyRepository;

    }

    public Agency findAgencyByTitle(String title) {
        return agencyRepository.findByTitle(title);
    }

    public void saveAgency(Agency agency) {
        agencyRepository.save(agency);
    }

    public List<Agency> findAll() {return agencyRepository.findAll();}

    public Agency get(Integer id) {return agencyRepository.findById(id).get();}

    public void delete(Integer id) {agencyRepository.deleteById(id);}


}