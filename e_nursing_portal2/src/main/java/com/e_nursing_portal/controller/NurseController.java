package com.e_nursing_portal.controller;
import com.e_nursing_portal.model.Job;
import com.e_nursing_portal.model.Nurse;
import com.e_nursing_portal.service.JobService;
import com.e_nursing_portal.service.NurseService;
import com.e_nursing_portal.service.implementation.NurseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.swing.*;
import java.util.List;
import java.util.Scanner;

@Controller
public class NurseController {

    @Autowired
    NurseServiceImpl nurseService;
    @Autowired
    JobService jobService;
    @GetMapping("/home")
    public String homePage(Model model){
        return findPaginated(1,model);
    }

    @GetMapping("/registration1")
    public String registerNursePage(Model model){
        Nurse nur = new Nurse();
        model.addAttribute("nurse", nur);
        return "registrar";
    }

    @PostMapping("/register")
    public String registerNurseInDb(@ModelAttribute("nur") Nurse theNurse){
        Nurse savedNurse = nurseService.registerNurse(theNurse);
        if(savedNurse != null){
            return "redirect:/registration1?success";
        }
        return "redirect:/registration1?error";
    }

    @GetMapping("/registrationJob")
    public String JobPage(Model model){
        Job job = new Job();
        model.addAttribute("job", job);
        return "adminRegistration";
    }

    @PostMapping("/registerJob")
    public String registerNurseInDb(@ModelAttribute("job") Job job){
        Job job1 = jobService.saveJob(job);
        if(job1 != null){
            return "redirect:/registrationJob?success";
        }
        return "redirect:/registrationJob?error";
    }

    @GetMapping("/home/update/{id}")
    public String editNurse(@PathVariable String id, Model model){
        model.addAttribute("nurse", nurseService.findNurseByNurseId(id));
        return "update";
    }

      @PostMapping("/home/{id}")
    public String updateNurse(@PathVariable String id,@ModelAttribute("nurse") Nurse nurse, Model model)
      {
          Nurse existingNurse=nurseService.findNurseByNurseId(id);
          existingNurse.setTel(nurse.getTel());
          existingNurse.setId(nurse.getId());
          existingNurse.setName(nurse.getName());
          existingNurse.setEmail(nurse.getEmail());
          existingNurse.setDpt(nurse.getDpt());
          nurseService.updateNurse(existingNurse);
           return "redirect:/home";
      }

    @GetMapping("/home/{id}")
    public String deleteNurse(@PathVariable String id)
    {
        nurseService.deleteNurse(id);
        return "redirect:/home";
    }

    @GetMapping("/page/{pageNo}")
    public String findPaginated(@PathVariable(value = "pageNo") int pageNo,Model model){
        int pageSize=5;
        Page<Nurse> page=nurseService.pagenateStudent(pageNo,pageSize);
        List<Nurse> nursesList=page.getContent();
        model.addAttribute("currentPage",pageNo);
        model.addAttribute("totalPage",page.getTotalPages());
        model.addAttribute("totalItems",page.getTotalElements());
        model.addAttribute("listNurses",nursesList);
        return "home-page";
    }

    @GetMapping ("/search")
    public String searchMethod(Model model){
        model.addAttribute("search",new Nurse());
        return "findOne";
    }
    @GetMapping ("/searchUser1")
    public String searchMethod1(Model model){
        model.addAttribute("search1",new Nurse());
        return "userSearch";
    }

    @PostMapping("/searchUser1")
    public String geNurse1(@ModelAttribute("search1") Nurse nurse, Model model) {

        if (nurse.getId() != null) {
            Nurse nurse1 = nurseService.findNurseByNurseId(nurse.getId());
            if (nurse1 != null) {
                model.addAttribute("nurse1", nurse1);
                return "userSearch";
            }
        }

        model.addAttribute("error","It is not found");
        return "redirect:/search1";
    }
    @PostMapping("/search")
    public String geNurse(@ModelAttribute("search") Nurse nurse, Model model){

        if(nurse.getId()!=null){
            Nurse nurse1=nurseService.findNurseByNurseId(nurse.getId());
            if (nurse1!=null) {
                model.addAttribute("nurse1",nurse1);
                return "findOne";
            }
        }
        model.addAttribute("error","It is not found");
        return "redirect:/search";

    }
}
