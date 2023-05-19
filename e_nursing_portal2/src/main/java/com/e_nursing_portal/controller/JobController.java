package com.e_nursing_portal.controller;
import com.e_nursing_portal.model.Job;
import com.e_nursing_portal.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class JobController {
    @Autowired
    private JobService jobService;
    @GetMapping("/index")
    public String ViewHome(Model model){
        model.addAttribute("jobList",jobService.getAllJob());
        return "index1";
    }

    @GetMapping("/viwPage")
    public String getSavePage(Model model){
        model.addAttribute("job",new Job());
        return "saveJob";
    }
    @GetMapping("/index2")
    public String updateJobPage(Model model){
        model.addAttribute("job",new Job());
        return "updateJob";
    }

    @GetMapping("/index3")
    public String userJobList(Model model){
        model.addAttribute("job",jobService.getAllJob());
        return "userJobListPage";
    }

    @PostMapping("/index/updateJob/{jobId}")
    public String updatejob(@PathVariable String jobId, @ModelAttribute("job") Job job, Model model)
    {
        Long ids=Long.parseLong(jobId);
        Job existingJob=jobService.findJob(ids);
        if(existingJob!=null){
            existingJob.setTitle(job.getTitle());
            existingJob.setHospital(job.getHospital());
            existingJob.setEducationRequired(job.getEducationRequired());
            jobService.updateJob(existingJob);
            return "redirect:/index?success";
        }

        return "redirect:/index?error";
    }

    @GetMapping("/index/{jobId}")
    public String deleteNurse(@PathVariable String jobId)
    {
        Long ids=Long.parseLong(jobId);
        jobService.deleteJob(ids);
        return "redirect:/index?success";
    }


    @PostMapping("/saveJob")
    public String registerJob(@ModelAttribute("job") Job job){
        Job job1 = jobService.saveJob(job);
        if(job1 != null){
            return "redirect:/viwPage?success";
        }
        return "redirect:/viwPage?error";
    }


}
