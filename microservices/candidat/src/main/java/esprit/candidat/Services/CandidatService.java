package esprit.candidat.Services;

import esprit.candidat.Entities.Candidat;
import esprit.candidat.Repositories.CandidatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
//
//public void deleteCandidatById (int id){
//        if (candidatRepository.existsById(id)){
//            candidatRepository.deleteById(id); }
//        else throw new RuntimeException("Candidat not found");
//     }


@Service
public class CandidatService {
    @Autowired
    private CandidatRepository candidatRepository;

    public List<Candidat> findAll() {return candidatRepository.findAll();}

    public  Iterable<Candidat>findById(int id ){
        return candidatRepository.findById(id); }


    public  List<Candidat>findByFirstName(String firstName) throws Throwable {
        return  candidatRepository.findByFirstName(firstName);  }

//
//    public Candidat updateCandidat(int id , Candidat candidatDetails) {
//        List<Candidat> candidat = candidatRepository.findById(id);
//        if (candidatDetails.getFirstName() != null) candidat.setFirstName(candidatDetails.getFirstName());
//        if (candidatDetails.getLastName() != null) candidat.setLastName(candidatDetails.getLastName());
//        if (candidatDetails.getEmail() != null) candidat.setEmail(candidatDetails.getEmail());
//        return candidatRepository.save(candidat);
//    }

public void deleteCandidatById (int id){
    if (candidatRepository.existsById(id)){ candidatRepository.deleteById(id); }
    else throw new RuntimeException("Candidat not found");
}

public Candidat addCandidat (Candidat candidatDetails) {
   return   candidatRepository.save(candidatDetails);
 }

}