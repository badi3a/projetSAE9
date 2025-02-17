package esprit.candidat.Controller;

import esprit.candidat.entity.Address;
import esprit.candidat.entity.Candidat;
import esprit.candidat.service.AddressService;
import esprit.candidat.service.CandidatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping
public class addressController {
    @Autowired
    private AddressService addressService;





//////////////////// Méthode Mme Badiaa :) :) :) :)  //////////////////////////

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Address>> listAddress(){
        return new ResponseEntity<>(addressService.findAll(), HttpStatus.OK);
    }




    @PostMapping(consumes = MediaType.APPLICATION_XML_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Address> createAddress(@RequestBody Address address) {
        return new ResponseEntity<>(addressService.ajouterAddress(address), HttpStatus.OK);
    }



    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Address> updateAddress(@PathVariable(value = "id") int id,
                                                   @RequestBody Address adresse){
        return new ResponseEntity<>(addressService.updateAddress(id, adresse),
                HttpStatus.OK);
    }



    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> deleteAddress(@PathVariable(value = "id") int id) {
        return new ResponseEntity<>(addressService.deleteAddress(id), HttpStatus.OK);
    }



}
