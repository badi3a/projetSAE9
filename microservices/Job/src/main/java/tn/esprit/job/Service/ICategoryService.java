package tn.esprit.job.Service;

import tn.esprit.job.Entity.Category;
import tn.esprit.job.Entity.Job;

import java.util.List;

public interface ICategoryService {
    public Category ajouterCategory(Category category);
    public List<Category> findAll();

    public Category updateCategory(long id, Category newcategory);
    public String deleteCategory(long id);


}
