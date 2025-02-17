package tn.esprit.job.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.job.Entity.Category;

public interface CategoryRepository extends JpaRepository<Category,Long> {
}
