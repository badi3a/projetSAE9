package esprit.candidat;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/candidats")
public class CandidatRestApi {

    private final CandidatService candidatService;

    public CandidatRestApi(CandidatService candidatService) {
        this.candidatService = candidatService;
    }

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello World";
    }

//    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping("/affichage")
    public ResponseEntity<List<Candidat>> listCandidat() {
        return ResponseEntity.ok(candidatService.findAll());
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Candidat> findById(@PathVariable int id) {
        Optional<Candidat> candidatOptional = candidatService.findById(id);
        return candidatOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/nom/{nom}")
    public ResponseEntity<List<Candidat>> findByNom(@PathVariable String nom) {
        List<Candidat> candidats = candidatService.findByNom(nom);
        return candidats.isEmpty() ? ResponseEntity.notFound().build() : ResponseEntity.ok(candidats);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Candidat> createCandidat(@RequestBody Candidat candidat) {
        Candidat savedCandidat = candidatService.save(candidat);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCandidat);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Candidat> updateCandidat(@PathVariable int id, @RequestBody Candidat candidatDetails) {
        Optional<Candidat> candidatOptional = candidatService.findById(id);

        if (candidatOptional.isPresent()) {
            Candidat candidat = candidatOptional.get();
            candidat.setFirstName(candidatDetails.getFirstName());
            candidat.setLastName(candidatDetails.getLastName());
            candidat.setEmail(candidatDetails.getEmail());

            Candidat updatedCandidat = candidatService.save(candidat);
            return ResponseEntity.ok(updatedCandidat);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCandidat(@PathVariable int id) {
        Optional<Candidat> candidatOptional = candidatService.findById(id);
        if (candidatOptional.isPresent()) {
            candidatService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
