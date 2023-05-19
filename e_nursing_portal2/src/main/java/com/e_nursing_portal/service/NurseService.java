package com.e_nursing_portal.service;



import com.e_nursing_portal.model.Nurse;
import org.springframework.data.domain.Page;


import java.util.List;

public interface NurseService {
    // method signature
    // return value , method name;
    Nurse registerNurse(Nurse nur);
    Nurse updateNurse(Nurse nur);
    void deleteNurse(String nur);
    List<Nurse> nurseList();
    Nurse findNurseByNurseId(String nur);

    Page<Nurse> pagenateStudent(int pageNo, int pageSize);
}
