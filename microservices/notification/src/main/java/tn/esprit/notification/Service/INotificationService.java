package tn.esprit.notification.Service;

import tn.esprit.notification.Entity.Notification;

import java.util.List;

public interface INotificationService {

    public Notification ajouterNotification(Notification notification);
    public List<Notification> findAll();

    public Notification updateNotification(long id, Notification newNotif);
    public String deleteNotification(long id);





}
