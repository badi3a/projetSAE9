package tn.esprit.meeting.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.meeting.Entity.Meeting;
import tn.esprit.meeting.Service.IMeetingService;

import java.util.List;

@RestController
@RequestMapping("/meeting")
public class MeetingController {



    @Autowired
    private IMeetingService ms;


    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Meeting>> listMeeting(){
        return new ResponseEntity<>(ms.findAll(), HttpStatus.OK);
    }




    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Meeting> createMeeting(@RequestBody Meeting meeting) {
        return new ResponseEntity<>(ms.ajouterMeeting(meeting), HttpStatus.OK);
    }
    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Meeting> updateMeeting(@PathVariable(value = "id") long id,
                                         @RequestBody Meeting meeting){
        return new ResponseEntity<>(ms.updateMeeting(id, meeting),
                HttpStatus.OK);
    }
    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> deleteMeeting(@PathVariable(value = "id") long id) {
        return new ResponseEntity<>(ms.deleteMeeting(id), HttpStatus.OK);
    }

}
