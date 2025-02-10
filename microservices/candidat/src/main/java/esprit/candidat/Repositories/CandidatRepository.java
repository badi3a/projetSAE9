package esprit.candidat.Repositories;
import esprit.candidat.Entities.Candidat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CandidatRepository extends JpaRepository<Candidat, Integer> {
    List<Candidat> id(int id);
     List<Candidat> findByFirstName(String firstName);
    List<Candidat> findById(int id);


}
