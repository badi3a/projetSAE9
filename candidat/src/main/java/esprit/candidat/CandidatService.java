package esprit.candidat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CandidatService {

    @Autowired
    private CandidatRepository candidatRepository;

    // ✅ Ajouter un candidat
    public Candidat addCandidat(Candidat candidat) {
        return candidatRepository.save(candidat);
    }

    // ✅ Afficher tous les candidats
    public List<Candidat> getAllCandidats() {
        return candidatRepository.findAll();
    }

    // ✅ Afficher un candidat par ID
    public Optional<Candidat> getCandidatById(int id) {
        return candidatRepository.findById(id);
    }

    // ✅ Modifier un candidat
    public Candidat updateCandidat(int id, Candidat newCandidat) {
        return candidatRepository.findById(id).map(candidat -> {
            candidat.setFirstName(newCandidat.getFirstName());
            candidat.setLastName(newCandidat.getLastName());
            candidat.setEmail(newCandidat.getEmail());
            return candidatRepository.save(candidat);
        }).orElseThrow(() -> new RuntimeException("Candidat non trouvé"));
    }

    // ✅ Supprimer un candidat
    public void deleteCandidat(int id) {
        candidatRepository.deleteById(id);
    }
}
