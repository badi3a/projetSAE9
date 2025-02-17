package tn.esprit.job.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.job.Entity.Category;
import tn.esprit.job.Entity.Job;
import tn.esprit.job.Repository.CategoryRepository;
import tn.esprit.job.Repository.JobRepository;

import java.util.List;

@Service
public class CategoryServiceImpl implements ICategoryService {


    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Category ajouterCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category updateCategory(long id, Category newcategory) {
        if (categoryRepository.findById(id).isPresent()) {
            Category category = categoryRepository.findById(id).get();
            category.setName(newcategory.getName());
            category.setDescription(newcategory.getDescription());

            return categoryRepository.save(category);
        } else
            return null;
    }

    @Override
    public String deleteCategory(long id) {
        if (categoryRepository.findById(id).isPresent()) {
            categoryRepository.deleteById(id);
            return "category supprimé";
        } else
            return "category non supprimé";
    }
}
