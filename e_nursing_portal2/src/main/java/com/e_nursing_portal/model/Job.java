package com.e_nursing_portal.model;
import javax.persistence.*;

@Entity
@Table(name =  "job")
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private long jobId;
    private String title;
    private String hospital;
    private String educationRequired;

    public long getJobId() {
        return jobId;
    }

    public void setJobId(long jobId) {
        this.jobId = jobId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public String getHospital() {
        return hospital;
    }

    public void setHospital(String hospital) {
        this.hospital = hospital;
    }

    public String getEducationRequired() {
        return educationRequired;
    }

    public void setEducationRequired(String educationRequired) {
        this.educationRequired = educationRequired;
    }
}
