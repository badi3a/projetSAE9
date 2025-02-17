package tn.esprit.application.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.application.Entity.Application;
import tn.esprit.application.Service.IApplicationService;

import java.util.List;

@RestController
@RequestMapping("/application")
public class ApplicationController {


    @Autowired
    private IApplicationService applicationService;


    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Application>> listApplication(){
        return new ResponseEntity<>(applicationService.findAll(), HttpStatus.OK);
    }




    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Application> createApplication(@RequestBody Application application) {
        return new ResponseEntity<>(applicationService.ajouterApplication(application), HttpStatus.OK);
    }
    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Application> updateApplication(@PathVariable(value = "id") long id,
                                                 @RequestBody Application application){
        return new ResponseEntity<>(applicationService.updateApplication(id, application),
                HttpStatus.OK);
    }
    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> deleteApplication(@PathVariable(value = "id") long id) {
        return new ResponseEntity<>(applicationService.deleteApplication(id), HttpStatus.OK);
    }

}
