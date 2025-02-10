package esprit.candidat.Controller;

import esprit.candidat.models.Address;
import esprit.candidat.models.Candidat;
import esprit.candidat.services.AddressService;
import esprit.candidat.services.CandidatService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class CandidatRestApi {
    private CandidatService candidatService;

    @PostMapping(path = "/addCandidat")
    public ResponseEntity<Candidat> addCandidat(@RequestBody Candidat candidat) {
        try {
            Candidat candidatAdded = candidatService.addCandidat(candidat);
            return ResponseEntity.status(HttpStatus.CREATED).body(candidatAdded);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }


    @GetMapping(path = "/listAddress")
    public ResponseEntity<List<Candidat>> addressList() {
        List<Candidat> candidatList = candidatService.getCandidat();
        if (candidatList.isEmpty())
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        return ResponseEntity.ok(candidatList);
    }

    @GetMapping(path = "/candidatById/{id}")
    public Candidat getCandidatById(@PathVariable Integer id) {
        return candidatService.getCandidatById(id);
    }

    @DeleteMapping(path = "deleteBy/{id}")
    public ResponseEntity<String> deleteCandidat(@PathVariable Integer id) {

        candidatService.deleteCandidat(id);
        return ResponseEntity.ok("candidat with id : " + id + " was deleted successfully");


    }
}
