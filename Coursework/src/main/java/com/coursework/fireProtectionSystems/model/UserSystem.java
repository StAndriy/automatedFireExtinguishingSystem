package com.coursework.fireProtectionSystems.model;


import javax.persistence.*;
import java.io.Serializable;

@Entity
public class UserSystem implements Serializable {
    @Id
    @Column(nullable = false, updatable = false)
    private Long id;
    private String fullName;
    private String information;
    private String photoUrl;
    private String location;
    private String email;
    private Long idProtectionSystem;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }


    public Long getIdProtectionSystem() {
        return idProtectionSystem;
    }

    public void setIdProtectionSystem(Long idProtectionSystem) {
        this.idProtectionSystem = idProtectionSystem;
    }
}
