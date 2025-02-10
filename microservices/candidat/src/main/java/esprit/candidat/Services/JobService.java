package esprit.candidat.Services;
import esprit.candidat.Entities.Candidat;
import esprit.candidat.Entities.Job;
import esprit.candidat.Repositories.JobRepository;
import org.bouncycastle.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class JobService {

    @Autowired
    private JobRepository jobRepository;

    public Iterable<Job> findAll() {return jobRepository.findAll();}

    public List<Job> findJobByIdJob(int id ){
        return jobRepository.findJobByIdJob(id); }


    public  List<Job>findJobByService(String service)     {
        return  jobRepository.findJobByService( service);  }


public  Job updateJob(Integer id, boolean etat) {
        Job j = (Job) findJobByIdJob(id);
        j.setEtat(etat);
        return jobRepository.save(j);
}


}
