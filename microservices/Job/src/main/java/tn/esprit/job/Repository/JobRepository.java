package tn.esprit.job.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.job.Entity.Job;

public interface JobRepository extends JpaRepository<Job,Long> {
}
