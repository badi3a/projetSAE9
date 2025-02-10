package esprit.candidat.services;

import esprit.candidat.models.Candidat;
import esprit.candidat.DAO.CandidatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandidatService {
    @Autowired
    private CandidatRepository candidatRepository;
    public List<Candidat> findAll() {
        return candidatRepository.findAll();
    }
}
