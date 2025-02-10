package esprit.candidat.DAO;

import esprit.candidat.models.Candidat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidatRepository extends JpaRepository<Candidat, Integer> {
}
