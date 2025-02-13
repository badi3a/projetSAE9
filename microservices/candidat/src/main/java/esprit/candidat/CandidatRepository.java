package esprit.candidat;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CandidatRepository extends JpaRepository<Candidat, Integer> {
    List<Candidat> findByLastName(String lastName);

}
