package esprit.notification.DAO;

import esprit.notification.models.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "notification")
public interface NotificationRepository extends JpaRepository<Notification,Integer> {
}
