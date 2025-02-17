package tn.esprit.job.Controller;

import jakarta.ws.rs.Path;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.job.Entity.Job;
import tn.esprit.job.Service.IJobService;

import java.util.List;

@RestController
@RequestMapping("/job")
public class JobController {


    @Autowired
    private IJobService js;

@GetMapping("/affichage")
   // @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
   // @Path("/affichage")
    public ResponseEntity<List<Job>> listJob(){
        return new ResponseEntity<>(js.findAll(), HttpStatus.OK);
    }




  //  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @PostMapping("/ajouter")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Job> createJob(@RequestBody Job job) {
        return new ResponseEntity<>(js.ajouterJob(job), HttpStatus.OK);
    }
  //  @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @PutMapping("/update/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Job> updateJob(@PathVariable(value = "id") long id,
                                                   @RequestBody Job job){
        return new ResponseEntity<>(js.updateJob(id, job),
                HttpStatus.OK);
    }
  //  @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> deleteJob(@PathVariable(value = "id") long id) {
        return new ResponseEntity<>(js.deleteJob(id), HttpStatus.OK);
    }


}
