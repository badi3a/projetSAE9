package esprit.candidat.services;

import esprit.candidat.DAO.AddressRepository;
import esprit.candidat.models.Address;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AddressService {
    private final AddressRepository addressRepository;
    public Address addAddress(Address address) {
        return addressRepository.save(address);
    }


    public void deleteAddress(Integer idAddress) {
        addressRepository.deleteById(idAddress);

    }


    public List<Address> getAddress() {
        return addressRepository.findAll();
    }

    public Address getAddressById(Integer id) {
        return addressRepository.findById(id).get();
    }
}
