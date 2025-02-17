package tn.esprit.meeting.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.meeting.Entity.Meeting;

public interface MeetingRepository extends JpaRepository<Meeting,Long> {
}
