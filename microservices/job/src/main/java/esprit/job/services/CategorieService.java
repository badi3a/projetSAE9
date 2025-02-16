package esprit.job.services;

import esprit.job.entities.Categorie;
import esprit.job.repositorys.CategorieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategorieService {

    @Autowired
    private CategorieRepository categorieRepository;

    public List<Categorie> getAllCategorie(){return categorieRepository.findAll();}
    public Categorie getCategorieById(Long id){return categorieRepository.findById(id).get();}
    public  Categorie addCategorie(Categorie categorie){return categorieRepository.save(categorie);}
    public Categorie updateCategorie(Categorie categorie){return categorieRepository.save(categorie);}
    public void deleteCategorie(Long id){categorieRepository.deleteById(id);}
}
