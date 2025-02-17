package tn.esprit.notification.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.notification.Entity.Notification;
import tn.esprit.notification.Service.INotificationService;

import java.util.List;

@RestController
@RequestMapping("/notification")
public class NotificationController {


    @Autowired
    private INotificationService ns;


    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Notification>> listNotification(){
        return new ResponseEntity<>(ns.findAll(), HttpStatus.OK);
    }




    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Notification> createNotification(@RequestBody Notification notification) {
        return new ResponseEntity<>(ns.ajouterNotification(notification), HttpStatus.OK);
    }
    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Notification> updateNotification(@PathVariable(value = "id") long id,
                                         @RequestBody Notification notification){
        return new ResponseEntity<>(ns.updateNotification(id, notification),
                HttpStatus.OK);
    }
    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> deleteNotification(@PathVariable(value = "id") long id) {
        return new ResponseEntity<>(ns.deleteNotification(id), HttpStatus.OK);
    }

}
