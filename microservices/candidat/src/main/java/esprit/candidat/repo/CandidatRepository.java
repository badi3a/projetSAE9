package esprit.candidat.repo;

import esprit.candidat.entity.Candidat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidatRepository extends JpaRepository<Candidat,Integer> {
}
