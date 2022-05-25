package com.coursework.fireProtectionSystems.model;


import javax.persistence.*;
import java.io.Serializable;

@Entity
public class ProtectionSystem implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String homeAddress;
    private String systemType;
    private int tankVolume;
    private int tankFullness;
    private String phone;
    private String status;
    private String imageUrl;

    @Column(nullable = false, updatable = false)
    private String protectionSystemCode;


    public ProtectionSystem(){}

    public ProtectionSystem(String homeAddress, String systemType, int tankVolume, int tankFullness, String phone, String status, String imageUrl, String protectionSystemCode) {
        this.homeAddress = homeAddress;
        this.systemType = systemType;
        this.tankVolume = tankVolume;
        this.tankFullness = tankFullness;
        this.phone = phone;
        this.status = status;
        this.imageUrl = imageUrl;
        this.protectionSystemCode = protectionSystemCode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    public String getSystemType() {
        return systemType;
    }

    public void setSystemType(String systemType) {
        this.systemType = systemType;
    }

    public int getTankVolume() {
        return tankVolume;
    }

    public void setTankVolume(int tankVolume) {
        this.tankVolume = tankVolume;
    }

    public int getTankFullness() {
        return tankFullness;
    }

    public void setTankFullness(int tankFullness) {
        this.tankFullness = tankFullness;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getProtectionSystemCode() {
        return protectionSystemCode;
    }

    public void setProtectionSystemCode(String protectionSystemCode) {
        this.protectionSystemCode = protectionSystemCode;
    }


    @Override
    public String toString() {
        return "ProtectionSystem{" +
                "id=" + id +
                ", homeAddress='" + homeAddress + '\'' +
                ", systemType='" + systemType + '\'' +
                ", tankVolume=" + tankVolume +
                ", tankFullness=" + tankFullness +
                ", phone='" + phone + '\'' +
                ", status='" + status + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", protectionSystemCode='" + protectionSystemCode + '\'' +
                '}';
    }
}
