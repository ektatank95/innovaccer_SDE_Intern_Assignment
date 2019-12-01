package com.abc.controller;

import com.abc.entity.GuestAndHostInfo;
import com.abc.model.ScheduleEmailRequest;
import com.abc.repository.GuestAndHostInfoRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class GuestAndHostInfoController {



    private GuestAndHostInfoRepository guestAndHostInfoRepository;
    private EmailJobSchedulerController emailJobSchedulerController;
    private ZoneId timeZone = ZoneId.of("Asia/Kolkata");
    private static final String DATE_FORMATTER= "dd-MM-yyyy HH:mm:ss a";

    public GuestAndHostInfoController(GuestAndHostInfoRepository guestAndHostInfoRepository, EmailJobSchedulerController emailJobSchedulerController) {
        this.guestAndHostInfoRepository = guestAndHostInfoRepository;
        this.emailJobSchedulerController = emailJobSchedulerController;
    }

    @PostMapping("/saveGuestAndHostInfo")
    void addguestAndHostInfo(@RequestBody GuestAndHostInfo guestAndHostInfo) {
        System.out.println("Saving Guest Information in database");
        GuestAndHostInfo guestAndHostInfoResponse = guestAndHostInfoRepository.save(guestAndHostInfo);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMATTER);

        if (guestAndHostInfoResponse!=null)
        {
            String checkIntime = guestAndHostInfo.getCheckInTime().format(formatter);
            String checkOuttime = guestAndHostInfo.getCheckOutTime().format(formatter);

            String visitorsubject="Visitor Details";
            String visitorbody= "Dear "+ guestAndHostInfo.getHostName()+   ","    + "\r\n\n"+
                    "Please Find visitor details as mentioned below." +"\r\n\n"+
                    "Visitor Name : "+ guestAndHostInfo.getGuestName()+"\r\n"+
                    "Visitor Email : "+ guestAndHostInfo.getGuestEmail()+"\r\n"+
                    "Visitor Phone Number : "+ guestAndHostInfo.getGuestPhone()+"\r\n"+
                    "Check-in Time : "+checkIntime+"\r\n"+
                    "Check-out Time : "+ checkOuttime+"\r\n\n"+
                "Thanks and Regards, " +"\r\n" + "EntryMangementTeam";

            // send a mail from Entry Mangement Team to host regarding details of Visitor

            emailJobSchedulerController.scheduleEmail(new ScheduleEmailRequest(guestAndHostInfoResponse.getHostEmail(),visitorsubject,visitorbody,guestAndHostInfo.getCheckInTime(),timeZone));

            // send a mail from Entry Mangement Team to Visitor regarding details of visit and host entertained him

            String hostsubject="Details of Your Visit";
            String hostbody= "Dear "+ guestAndHostInfo.getGuestName()  +","     +"\r\n\n"+
                    "Please Find  details of your last visit  as mentioned below" +"\r\n\n"+
                    "Visitor Name : "+ guestAndHostInfo.getGuestName()+"\r\n"+
                    "Visitor Phone Number : "+ guestAndHostInfo.getGuestPhone()+"\r\n"+
                    "Check-in Time : "+ checkIntime+"\r\n"+
                    "Check-out Time : "+ checkOuttime+"\r\n"+
                    "Host Name: "+ guestAndHostInfo.getHostName()+"\r\n\n"+
                    "Thanks and Regards, "+"\r\n"+ "EntryMangementTeam";

            emailJobSchedulerController.scheduleEmail(new ScheduleEmailRequest(guestAndHostInfoResponse.getGuestEmail(),hostsubject,hostbody,guestAndHostInfo.getCheckOutTime(),timeZone));

        }
    }
}