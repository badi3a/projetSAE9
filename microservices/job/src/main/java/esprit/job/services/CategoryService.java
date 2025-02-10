package esprit.job.services;

import esprit.job.DAO.CategoryRepository;
import esprit.job.models.Category;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;
    public Category addCategory(Category category) {
        return categoryRepository.save(category);
    }


    public void deleteCategory(Integer idCategory) {
        categoryRepository.deleteById(idCategory);

    }


    public List<Category> getCategory() {
        return categoryRepository.findAll();
    }

    public Category getCategoryById(Integer id) {
        return categoryRepository.findById(id).get();
    }
}
