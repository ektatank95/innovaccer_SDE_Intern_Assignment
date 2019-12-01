package com.abc.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
public class GuestAndHostInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String guestName;
    private String guestEmail;
    private Long guestPhone;
    private LocalDateTime checkInTime;
    private LocalDateTime checkOutTime;
    private String hostName;
    private String hostEmail;
    private String hostPhone;
    private LocalDateTime currentTimeNoted=  LocalDateTime.now();



    public GuestAndHostInfo(Integer id, String guestName, String guestEmail, Long guestPhone, LocalDateTime checkInTime,  LocalDateTime checkOutTime, String hostName, String hostEmail, String hostPhone, Date currentTimeNoted) {
        this.id = id;
        this.guestName = guestName;
        this.guestEmail = guestEmail;
        this.guestPhone = guestPhone;
        this.checkInTime = checkInTime;
        this.checkOutTime = checkOutTime;
        this.hostName = hostName;
        this.hostEmail = hostEmail;
        this.hostPhone = hostPhone;
        this.currentTimeNoted = LocalDateTime.now();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGuestName() {
        return guestName;
    }

    public void setGuestName(String guestName) {
        this.guestName = guestName;
    }

    public String getGuestEmail() {
        return guestEmail;
    }

    public void setGuestEmail(String guestEmail) {
        this.guestEmail = guestEmail;
    }

    public Long getGuestPhone() {
        return guestPhone;
    }

    public void setGuestPhone(Long guestPhone) {
        this.guestPhone = guestPhone;
    }

    public LocalDateTime getCheckInTime() {
        return checkInTime;
    }

    public void setCheckInTime(LocalDateTime checkInTime) {
        this.checkInTime = checkInTime;
    }

    public LocalDateTime getCheckOutTime() {
        return checkOutTime;
    }

    public void setCheckOutTime(LocalDateTime checkOutTime) {
        this.checkOutTime = checkOutTime;
    }

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public String getHostEmail() {
        return hostEmail;
    }

    public void setHostEmail(String hostEmail) {
        this.hostEmail = hostEmail;
    }

    public String getHostPhone() {
        return hostPhone;
    }

    public void setHostPhone(String hostPhone) {
        this.hostPhone = hostPhone;
    }

    public LocalDateTime getCurrentTime() {
        return currentTimeNoted;
    }

    public void setCurrentTime(LocalDateTime currentTimeNoted) {
        this.currentTimeNoted = currentTimeNoted;
    }
}
