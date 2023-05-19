package com.e_nursing_portal.service;

import com.e_nursing_portal.model.Job;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface JobService  {
    Job saveJob(Job job);
    List<Job> getAllJob();
    Job updateJob(Job job);
    void deleteJob(Long id );
    Job findJob(Long id);
}
