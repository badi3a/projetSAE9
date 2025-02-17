package tn.esprit.job.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.job.Entity.Job;
import tn.esprit.job.Repository.JobRepository;

import java.util.List;

@Service
public class JobServiceImpl implements IJobService {


    @Autowired
    private JobRepository jobRepository;
    @Override
    public Job ajouterJob(Job job) {
        return jobRepository.save(job);
    }

    @Override
    public List<Job> findAll() {
        return jobRepository.findAll();
    }

    @Override
    public Job updateJob(long id, Job newJob) {
        if (jobRepository.findById(id).isPresent()) {
            Job job = jobRepository.findById(id).get();
            job.setName(newJob.getName());
            job.setAvailable(newJob.getAvailable());
            job.setDescription(newJob.getDescription());
            job.setDate(newJob.getDate());
            return jobRepository.save(job);
        } else
            return null;
    }

    @Override
    public String deleteJob(long id) {
        if (jobRepository.findById(id).isPresent()) {
            jobRepository.deleteById(id);
            return "job supprimé";
        } else
            return "job non supprimé";
    }
}
