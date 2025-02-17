package tn.esprit.job.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.job.Entity.Category;
import tn.esprit.job.Service.ICategoryService;
import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {


    @Autowired
    private ICategoryService cs;


    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Category>> listCategory(){
        return new ResponseEntity<>(cs.findAll(), HttpStatus.OK);
    }




    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Category> createCategory(@RequestBody Category category) {
        return new ResponseEntity<>(cs.ajouterCategory(category), HttpStatus.OK);
    }
    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Category> updateCategory(@PathVariable(value = "id") long id,
                                         @RequestBody Category category){
        return new ResponseEntity<>(cs.updateCategory(id, category),
                HttpStatus.OK);
    }
    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> deleteCategory(@PathVariable(value = "id") long id) {
        return new ResponseEntity<>(cs.deleteCategory(id), HttpStatus.OK);
    }



}
