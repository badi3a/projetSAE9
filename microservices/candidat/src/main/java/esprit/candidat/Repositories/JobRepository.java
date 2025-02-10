package esprit.candidat.Repositories;

import esprit.candidat.Entities.Candidat;
import esprit.candidat.Entities.Job;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface JobRepository extends CrudRepository<Job, Integer> {
    List<Job> id(int id);
    List<Job> findJobByService(String service);
    List<Job> findJobByIdJob(int idJob);

}
