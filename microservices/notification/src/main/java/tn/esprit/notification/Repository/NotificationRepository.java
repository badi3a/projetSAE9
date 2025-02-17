package tn.esprit.notification.Repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import tn.esprit.notification.Entity.Notification;

public interface NotificationRepository extends MongoRepository<Notification,Long> {
}
