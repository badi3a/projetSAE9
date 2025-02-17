package tn.esprit.notification.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.notification.Entity.Notification;
import tn.esprit.notification.Repository.NotificationRepository;

import java.util.List;

@Service
public class NotificationServiceImpl implements INotificationService{

    @Autowired
    NotificationRepository notificationRepository;


    @Override
    public Notification ajouterNotification(Notification notification) {
        return notificationRepository.save(notification);
    }

    @Override
    public List<Notification> findAll() {
        return notificationRepository.findAll();
    }

    @Override
    public Notification updateNotification(long id, Notification newNotif) {
        if (notificationRepository.findById(id).isPresent()) {
            Notification notif = notificationRepository.findById(id).get();
            notif.setContent(newNotif.getContent());
            notif.setDate(newNotif.getDate());
            notif.setSender(newNotif.getSender());
            notif.setRecepient(newNotif.getRecepient());
            return notificationRepository.save(notif);
        } else
            return null;
    }

    @Override
    public String deleteNotification(long id) {
        if (notificationRepository.findById(id).isPresent()) {
            notificationRepository.deleteById(id);
            return "notification supprimé";
        } else
            return "notification non supprimé";
    }






}
