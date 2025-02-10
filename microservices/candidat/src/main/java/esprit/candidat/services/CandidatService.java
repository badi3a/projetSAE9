package esprit.candidat.services;

import esprit.candidat.models.Address;
import esprit.candidat.models.Candidat;
import esprit.candidat.DAO.CandidatRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CandidatService {
   private final CandidatRepository candidatRepository;

    public Candidat addCandidat(Candidat candidat) {
        return candidatRepository.save(candidat);
    }


    public void deleteCandidat(Integer idCandidat) {
        candidatRepository.deleteById(idCandidat);

    }


    public List<Candidat> getCandidat() {
        return candidatRepository.findAll();
    }

    public Candidat getCandidatById(Integer id) {
        return candidatRepository.findById(id).get();
    }
}
