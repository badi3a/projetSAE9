package esprit.candidat.Controller;

import esprit.candidat.entity.Candidat;
import esprit.candidat.service.CandidatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/condidat")
public class candidatController {


    @Autowired
    private CandidatService cs;



    @GetMapping("/affichage")
    public String affichage(){
       return "hello atef" ;
    }

////////////// Méthode Mme Badiaa :) :) :) :)  //////////////////////////

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List <Candidat>> listCandidat(){
        return new ResponseEntity<>(cs.findAll(), HttpStatus.OK);
    }




    @PostMapping(consumes = MediaType.APPLICATION_XML_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Candidat> createCandidat(@RequestBody Candidat candidat) {
        return new ResponseEntity<>(cs.ajouterCandidat(candidat), HttpStatus.OK);
    }
    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Candidat> updateCandidat(@PathVariable(value = "id") int id,
                                                   @RequestBody Candidat candidat){
        return new ResponseEntity<>(cs.updateCandidat(id, candidat),
                HttpStatus.OK);
    }
    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> deleteCandidat(@PathVariable(value = "id") int id) {
        return new ResponseEntity<>(cs.deleteCandidat(id), HttpStatus.OK);
    }






    /////////// Méthode Mannai Atef ///////////////////////////

//    @PutMapping("/update/{id}")
//    public Candidat updateCandidat(@PathVariable int id, @RequestBody Candidat newCandidat) {
//    return cs.updateCandidat(id,newCandidat);
//    }
//    @PostMapping("/ajouter")
//    public Candidat ajouterCandidat(Candidat candidat){
//        return cs.ajouterCandidat(candidat);
//    }
//    @DeleteMapping("/delete/{id}")
//    public String deleteCandidat(@PathVariable int id){
//        return cs.deleteCandidat(id);
//    }



}
