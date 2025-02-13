package esprit.candidat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CandidatService {
    @Autowired
    private CandidatRepository candidatRepository;
    public List<Candidat> findAll() {
        return candidatRepository.findAll();
    }
    public Optional<Candidat> findById(int id) {
            return candidatRepository.findById(id);
        }
    public Candidat save(Candidat candidat) {
        return candidatRepository.save(candidat);
    }
    public void deleteById(int id) {
        candidatRepository.deleteById(id);
    }
    public Optional<Candidat> updateCandidat(int id, Candidat candidatDetails) {
        Optional<Candidat> candidatOptional = candidatRepository.findById(id);

        if (candidatOptional.isPresent()) {
            Candidat candidat = candidatOptional.get();
            candidat.setFirstName(candidatDetails.getFirstName());
            candidat.setLastName(candidatDetails.getLastName());
            candidat.setEmail(candidatDetails.getEmail());

            return Optional.of(candidatRepository.save(candidat)); 
        } else {
            return Optional.empty(); 
        }
    }

    public List<Candidat> findByNom(String nom) {
        return candidatRepository.findByLastName(nom);
    }

}

