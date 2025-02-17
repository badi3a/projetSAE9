package esprit.candidat.service;

import esprit.candidat.entity.Address;
import esprit.candidat.entity.Candidat;
import esprit.candidat.repo.AddressRepository;
import esprit.candidat.repo.CandidatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AddressService {
    @Autowired
    private AddressRepository addressRepository;



    public List<Address> findAll(){
        return addressRepository.findAll();
    }
    //solution Mme Badiaa
    public Address updateAddress(int id, Address address2) {
        if (addressRepository.findById(id).isPresent()) {
            Address address = addressRepository.findById(id).get();
            address.setStreet(address2.getStreet());
            address.setHouseNumber(address2.getHouseNumber());
            address.setZipCode(address2.getZipCode());
            return addressRepository.save(address);
        } else
            return null;
    }
    public String deleteAddress(int id) {
        if (addressRepository.findById(id).isPresent()) {
            addressRepository.deleteById(id);
            return "addresse supprimé";
        } else
            return "assresse non supprimé";
    }


    public Address ajouterAddress(Address address){
        return addressRepository.save(address);
    }
}


