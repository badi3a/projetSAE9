package esprit.job.DAO;

import esprit.job.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "job")

public interface CategoryRepository extends JpaRepository<Category,Integer> {
}
