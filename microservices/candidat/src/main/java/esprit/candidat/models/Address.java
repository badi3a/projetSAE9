package esprit.candidat.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
@Entity
public class Address {

    @Id
    @GeneratedValue
    private int id;
    private String street;
    private int houseNumber;
    private int zipCode;
    @OneToOne(mappedBy = "address")
    private Candidat candidat;


    public Address() {
    }

    public Address( String street, int houseNumber, int zipCode) {

        this.street = street;
        this.houseNumber = houseNumber;
        this.zipCode = zipCode;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(int houseNumber) {
        this.houseNumber = houseNumber;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }
}
