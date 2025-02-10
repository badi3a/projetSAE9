package esprit.job.DAO;

import esprit.job.models.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "job")
public interface JobRepository extends JpaRepository<Job,Integer> {
}
