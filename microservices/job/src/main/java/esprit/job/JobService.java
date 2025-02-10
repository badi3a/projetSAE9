package esprit.job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class JobService {

    @Autowired
    private JobRepository jobRepository;

    public Iterable<Job> findAll() {return jobRepository.findAll();}

    public List<Job> findJobByIdJob(int idJob ){
        return jobRepository.findJobByIdJob(idJob); }


    public  List<Job>findJobByService(String service)     {
        return  jobRepository.findJobByService( service);  }


    public  Job updateJob(Integer idJob, boolean etat) {
        Job j = (Job) findJobByIdJob(idJob);
        j.setEtat(etat);
        return jobRepository.save(j);
    }


}