package com.e_nursing_portal.service.implementation;
import com.e_nursing_portal.model.Job;
import com.e_nursing_portal.repository.JobRepository;
import com.e_nursing_portal.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class JobServiceImpl implements JobService  {
    @Autowired
    private JobRepository jobRepository;

    @Override
    public Job saveJob(Job job) {
        return jobRepository.save(job);
    }

    @Override
    public List<Job> getAllJob() {
        return jobRepository.findAll() ;
    }

    @Override
    public Job updateJob(Job job) {
        return jobRepository.save(job);
    }

    @Override
    public void deleteJob(Long id) {
        jobRepository.deleteById(id);

    }

    @Override
    public Job findJob(Long id) {
        return jobRepository.findById(id).get();
    }
}
