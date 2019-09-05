package Capstone.STL.Resources.STL.Resources.service;


import Capstone.STL.Resources.STL.Resources.models.Agency;
import Capstone.STL.Resources.STL.Resources.repository.AgencyRepository;
import Capstone.STL.Resources.STL.Resources.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("agencyService")
public class AgencyService {

    private final AgencyRepository agencyRepository;
    private UserRepository userRepository;


    @Autowired
    public AgencyService(AgencyRepository agencyRepository) {
        this.agencyRepository = agencyRepository;

    }

    public Agency findAgencyByAgency(String agency) {
        return agencyRepository.findByAgency(agency);
    }

    public void saveAgency(Agency agency) {
        agencyRepository.save(agency);
    }

}