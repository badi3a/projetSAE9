package tn.esprit.meeting.Service;

import tn.esprit.meeting.Entity.Meeting;

import java.util.List;

public interface IMeetingService {
    public Meeting ajouterMeeting(Meeting meeting);
    public List<Meeting> findAll();

    public Meeting updateMeeting(long id, Meeting newMeeting);
    public String deleteMeeting(long id);


}
