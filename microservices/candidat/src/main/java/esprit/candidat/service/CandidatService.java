package esprit.candidat.service;

import esprit.candidat.entity.Candidat;
import esprit.candidat.repo.CandidatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandidatService {
    @Autowired
    private CandidatRepository candidateRepository;



    public List<Candidat> findAll(){
       return candidateRepository.findAll();
    }
//solution Mme Badiaa
    public Candidat updateCandidat(int id, Candidat newCandidat) {
        if (candidateRepository.findById(id).isPresent()) {
            Candidat candidat = candidateRepository.findById(id).get();
            candidat.setFirstName(newCandidat.getFirstName());
            candidat.setLastName(newCandidat.getLastName());
            candidat.setEmail(newCandidat.getEmail());
            return candidateRepository.save(candidat);
        } else
            return null;
    }
    public String deleteCandidat(int id) {
        if (candidateRepository.findById(id).isPresent()) {
            candidateRepository.deleteById(id);
            return "candidat supprimé";
        } else
            return "candidat non supprimé";
    }


    public Candidat ajouterCandidat(Candidat candidat){
        return candidateRepository.save(candidat);
    }
}







