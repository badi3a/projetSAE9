package esprit.job;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

public class Job {
    @Id
    @GeneratedValue
    private int id;
    private String service;
    private boolean etat;

    public Job() {

    }
    public Job(String service, boolean etat) {
        this.service = service;
        this.etat = etat;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public boolean getEtat() {
        return etat;
    }

    public void setEtat(boolean etat) {
        this.etat = etat;
    }
}
