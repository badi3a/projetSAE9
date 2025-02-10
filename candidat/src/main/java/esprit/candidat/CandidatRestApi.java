package esprit.candidat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/candidats")
public class CandidatRestApi {

    @Autowired
    private CandidatService candidatService;

    // ✅ 1. TEST : Dire "Hello World"
    @GetMapping("/hello")
    public String sayHello() {
        return "Hello World";
    }

    // ✅ 2. Afficher tous les candidats
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Candidat>> listCandidat() {
        return new ResponseEntity<>(candidatService.getAllCandidats(), HttpStatus.OK);
    }

    // ✅ 3. Ajouter un candidat
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Candidat> addCandidat(@RequestBody Candidat candidat) {
        Candidat newCandidat = candidatService.addCandidat(candidat);
        return new ResponseEntity<>(newCandidat, HttpStatus.CREATED);
    }

    // ✅ 4. Afficher un candidat par ID
    @GetMapping("/{id}")
    public ResponseEntity<Candidat> getCandidatById(@PathVariable int id) {
        Optional<Candidat> candidat = candidatService.getCandidatById(id);
        return candidat.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // ✅ 5. Modifier un candidat
    @PutMapping("/{id}")
    public ResponseEntity<Candidat> updateCandidat(@PathVariable int id, @RequestBody Candidat candidat) {
        try {
            Candidat updatedCandidat = candidatService.updateCandidat(id, candidat);
            return new ResponseEntity<>(updatedCandidat, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // ✅ 6. Supprimer un candidat
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCandidat(@PathVariable int id) {
        try {
            candidatService.deleteCandidat(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
