package esprit.application.DAO;

import esprit.application.models.Application;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ApplicationRepository extends JpaRepository<Application,Integer> {
}
