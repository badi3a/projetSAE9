package esprit.candidat.Controllers;
import esprit.candidat.Entities.Candidat;
import esprit.candidat.Services.CandidatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.swing.text.html.parser.Entity;
import java.util.List;

@RestController
@RequestMapping("/ Candidats")

public class CandidatRestApi {

    //simple web service for testing
    @GetMapping("/ hello Joujou ")
    public String sayHello() {
        return "Hello Joujou ";
    }

    @Autowired
    private CandidatService candidatService;
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity<List <Candidat>> listCandidat(){
        return new ResponseEntity<>(candidatService.findAll(),
                HttpStatus.OK);
    }


    @GetMapping("/{getCandidatById}")
    public ResponseEntity<Candidat> getCandidatById(@PathVariable int id){
        Candidat candidat= (Candidat) candidatService.findById(id);
        return new ResponseEntity<>(candidat,HttpStatus.OK);
    }


    @GetMapping("/{getCandidatByNom}")
    public ResponseEntity<Candidat> getCandidatByNom(@PathVariable String firstName) throws Throwable {
        Candidat candidat = (Candidat) candidatService.findByFirstName(firstName);
        return  new ResponseEntity<>(candidat,HttpStatus.OK);}

//
//
//    @DeleteMapping("/{Delete-Candidat id}")
//    public ResponseEntity<String> deleteCandidat(@PathVariable int id){
//        try {candidatService.deleteCandidatById(id);
//            return new ResponseEntity.ok(" Candidat supprimé avec succés. ");
//        }
//        catch (RuntimeException e ){
//            return ResponseEntity.status(404).body(e.getMessage());}
//    }

//    @PutMapping("/{Update-Candidat id}")
//    public ResponseEntity<Candidat> updateCandidat(@PathVariable int id, @RequestBody Candidat candidat){
//        Candidat updateCandidat = candidatService.updateCandidat(id,candidat);
//        return new ResponseEntity.ok(updateCandidat);
//    }

//    @PostMapping("/add-Candidat")
//    public ResponseEntity<Candidat> addCandidat(@RequestBody Candidat candidat){
//        Candidat newCandidat = candidatService.addCandidat(candidat);
//        return  new ResponseEntity.ok(newCandidat);
//    }
}