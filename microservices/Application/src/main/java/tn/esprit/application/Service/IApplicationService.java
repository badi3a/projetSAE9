package tn.esprit.application.Service;

import tn.esprit.application.Entity.Application;

import java.util.List;

public interface IApplicationService {

    public Application ajouterApplication(Application application);
    public List<Application> findAll();

    public Application updateApplication(long id, Application newApplication);
    public String deleteApplication(long id);

}
