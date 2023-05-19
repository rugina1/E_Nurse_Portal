package com.e_nursing_portal.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Nurse {
    @Id
    private String id;
    private String name;
    private String email;
    private String tel;
    private String dpt;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dob;

    private String image;

    private String doc;

    public Nurse() {
    }

    public Nurse(String id, String name, String email, String tel, String dpt, Date dob, String image, String doc) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.tel = tel;
        this.dpt = dpt;
        this.dob = dob;
        this.image = image;
        this.doc = doc;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getDpt() {
        return dpt;
    }

    public void setDpt(String dpt) {
        this.dpt = dpt;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDoc() {
        return doc;
    }

    public void setDoc(String doc) {
        this.doc = doc;
    }
}
