package esprit.job.entities;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Job {
    @Id
    @GeneratedValue
    private int idJob;
    private String Service;
    private Boolean Etat;
    @ManyToOne
    private Categorie categorie;

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public int getIdJob() {return idJob;}

    public void setIdJob(int idJob) {this.idJob = idJob;}

    public String getService() {return Service;}

    public void setService(String service) {Service = service;}

    public Boolean getEtat() {return Etat;}

    public void setEtat(Boolean etat) {Etat = etat;}

    public Job() {}
    public Job(int idJob, String service, Boolean etat) {
        this.idJob = idJob;
        Service = service;
        Etat = etat;}

}