package tn.esprit.meeting.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.meeting.Entity.Meeting;
import tn.esprit.meeting.Repository.MeetingRepository;

import java.util.List;

@Service
public class MeetingService implements IMeetingService{


    @Autowired
    MeetingRepository meetingRepository;

    @Override
    public Meeting ajouterMeeting(Meeting meeting) {
        return meetingRepository.save(meeting);
    }

    @Override
    public List<Meeting> findAll() {
        return meetingRepository.findAll();
    }

    @Override
    public Meeting updateMeeting(long id, Meeting newMeeting) {
        if (meetingRepository.findById(id).isPresent()) {
            Meeting meeting = meetingRepository.findById(id).get();
            meeting.setLink(newMeeting.getLink());
            meeting.setReference(newMeeting.getReference());
            meeting.setStatus(newMeeting.getStatus());
            return meetingRepository.save(meeting);
        } else
            return null;
    }

    @Override
    public String deleteMeeting(long id) {
        if (meetingRepository.findById(id).isPresent()) {
            meetingRepository.deleteById(id);
            return "meeting supprimé";
        } else
            return "meeting non supprimé";
    }
    }










