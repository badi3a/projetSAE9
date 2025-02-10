package esprit.job;

import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface JobRepository extends CrudRepository<Job, Integer> {
    List<Job> id(int idJob);
    List<Job> findJobByService(String service);
    List<Job> findJobByIdJob(int idJob);

}
