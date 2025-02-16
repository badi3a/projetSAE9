package esprit.job.repositorys;

import esprit.job.entities.Job;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface JobRepository extends CrudRepository<Job, Integer> {
    List<Job> id(int idJob);
    List<Job> findJobByService(String service);
    List<Job> findJobByIdJob(int idJob);

}
