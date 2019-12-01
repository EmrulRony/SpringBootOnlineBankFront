package com.yas.onlinebankfront.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class Appointment extends BaseEntity {

    private static final long serialVersionUID = 1L;
    @Column(name = "date")
    private Date date;
    @Column(name = "location")
    private String location;
    @Column(name = "description")
    private String description;
    @Column(name = "confirmation")
    private boolean confirmation;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isConfirmation() {
        return confirmation;
    }

    public void setConfirmation(boolean confirmation) {
        this.confirmation = confirmation;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Appointment [confirmation=" + confirmation + ", date=" + date + ", description=" + description
                + ", location=" + location + ", user=" + user + "]";
    }
  
    
}