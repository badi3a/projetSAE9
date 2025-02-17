package tn.esprit.application.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.application.Entity.Application;
import tn.esprit.application.Repository.ApplicationRepository;

import java.util.List;

@Service
public class ApplicationServiceImpl implements IApplicationService {


    @Autowired
    ApplicationRepository ar;
    @Override
    public Application ajouterApplication(Application application) {
        return ar.save(application);
    }

    @Override
    public List<Application> findAll() {
        return ar.findAll();
    }

    @Override
    public Application updateApplication(long id, Application newApplication) {
        if (ar.findById(id).isPresent()) {
            Application application = ar.findById(id).get();
            application.setMotivation(newApplication.getMotivation());
            application.setApplicationDate(newApplication.getApplicationDate());
            return ar.save(application);
        } else
            return null;
    }

    @Override
    public String deleteApplication(long id) {
        if (ar.findById(id).isPresent()) {
            ar.deleteById(id);
            return "application supprimé";
        } else
            return "application non supprimé";
    }



}
