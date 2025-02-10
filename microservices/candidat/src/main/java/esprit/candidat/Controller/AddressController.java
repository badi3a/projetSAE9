package esprit.candidat.Controller;

import esprit.candidat.models.Address;
import esprit.candidat.services.AddressService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class AddressController {

    private AddressService addressService;

    @PostMapping(path = "/addAddress")
    public ResponseEntity<Address> addAddress(@RequestBody Address address) {
        try {
            Address addressAdded = addressService.addAddress(address);
            return ResponseEntity.status(HttpStatus.CREATED).body(addressAdded);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }


    @GetMapping(path = "/listAddress")
    public ResponseEntity<List<Address>> addressList() {
        List<Address> addressList = addressService.getAddress();
        if (addressList.isEmpty())
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        return ResponseEntity.ok(addressList);
    }

    @GetMapping(path = "/addressById/{id}")
    public Address getAddressById(@PathVariable Integer id) {
        return addressService.getAddressById(id);
    }

    @DeleteMapping(path = "deleteBy/{id}")
    public ResponseEntity<String> deleteAddress(@PathVariable Integer id) {

            addressService.deleteAddress(id);
            return ResponseEntity.ok("address with id : " + id + " was deleted successfully");


    }
}

