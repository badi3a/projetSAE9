package esprit.job.controllers;

import esprit.job.entities.Categorie;
import esprit.job.services.CategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("categorie")
public class CategorieController {
    @Autowired
    private CategorieService categorieService;
    @GetMapping("/get-all")
    public ResponseEntity<List<Categorie>> getAllCategorie() {
        return new ResponseEntity<>(categorieService.getAllCategorie(), HttpStatus.OK);
    }
    @GetMapping("/get-by-id")
    public ResponseEntity<Categorie> getCategorieById(@RequestParam("id") Long id) {
        return new ResponseEntity<>(categorieService.getCategorieById(id), HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<Categorie> addCategorie(@RequestBody Categorie cat) {
        return new ResponseEntity<>(categorieService.addCategorie(cat), HttpStatus.CREATED);
    }
    @PutMapping("/update")
    public ResponseEntity<Categorie> updateCategorie(@RequestBody Categorie cat) {
        return new ResponseEntity<>(categorieService.updateCategorie(cat), HttpStatus.OK);
    }
    @DeleteMapping("/delete-by-id")
    public ResponseEntity deleteCategorie(@RequestParam("id") Long id) {
        categorieService.deleteCategorie(id);
        return new ResponseEntity<>("Successfully deleted",HttpStatus.OK);
    }
}
