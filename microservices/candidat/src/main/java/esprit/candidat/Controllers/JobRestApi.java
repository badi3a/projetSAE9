package esprit.candidat.Controllers;
import esprit.candidat.Entities.Job;
import esprit.candidat.Services.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Job")
public class JobRestApi {

@Autowired
    private JobService jobService;


    @GetMapping
    public ResponseEntity<Iterable<Job>> findAll() {
         return new ResponseEntity<>(jobService.findAll(),
                HttpStatus.OK);}

    @GetMapping("/find by id/{id}")
    public ResponseEntity<Job> findJobByIdJob(@PathVariable Integer idJob) {
        return ResponseEntity.ok((Job) jobService.findJobByIdJob(idJob)); }


    @GetMapping("/find by service/{service}")
    public ResponseEntity<Job> findJobByService(@PathVariable String service) {
        return ResponseEntity.ok((Job) jobService.findJobByService(service));
    }

    @PutMapping("/{id}/etat")
    public ResponseEntity<Job> updateJob(@PathVariable Integer id,
                                         @RequestParam Boolean etat) {
        return ResponseEntity.ok(jobService.updateJob(id, etat));
    }

}
