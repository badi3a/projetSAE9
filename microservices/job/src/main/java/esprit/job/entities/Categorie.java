package esprit.job.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Categorie {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String description;
    @OneToMany(cascade = CascadeType.ALL, mappedBy="categorie")
    private List<Job> Jobs;

    public Categorie() {
    }

    public Categorie(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public List<Job> getJobs() {
        return Jobs;
    }

    public void setJobs(List<Job> jobs) {
        Jobs = jobs;
    }

    public Long getId() {
        return id;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
