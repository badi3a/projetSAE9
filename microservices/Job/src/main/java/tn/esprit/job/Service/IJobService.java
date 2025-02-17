package tn.esprit.job.Service;

import tn.esprit.job.Entity.Job;

import java.util.List;

public interface IJobService {

    public Job ajouterJob(Job job);
    public List<Job> findAll();

    public Job updateJob(long id, Job newJob);
    public String deleteJob(long id);



}
