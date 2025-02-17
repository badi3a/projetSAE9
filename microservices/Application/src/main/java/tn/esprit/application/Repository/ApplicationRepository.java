package tn.esprit.application.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.application.Entity.Application;

public interface ApplicationRepository extends JpaRepository<Application,Long> {
}
