package esprit.meeting.DAO;

import esprit.meeting.models.Meeting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "meeting")
public interface MeetingRepository extends JpaRepository<Meeting,Integer> {
}
