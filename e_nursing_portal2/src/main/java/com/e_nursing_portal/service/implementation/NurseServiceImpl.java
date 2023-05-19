package com.e_nursing_portal.service.implementation;

import com.e_nursing_portal.model.Nurse;
import com.e_nursing_portal.repository.NurseRepository;
import com.e_nursing_portal.service.NurseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NurseServiceImpl implements NurseService {

    @Autowired
    NurseRepository nurseRepository;

    @Override
    public Nurse registerNurse(Nurse nur) {
        return nurseRepository.save(nur);
    }

    @Override
    public Nurse updateNurse(Nurse nur) {
        return nurseRepository.save(nur);
    }

    @Override
    public void deleteNurse(String nur) {
nurseRepository.deleteById(nur);
    }

    @Override
    public List<Nurse> nurseList() {
        return nurseRepository.findAll();
    }

    @Override
    public Nurse findNurseByNurseId(String nur) {
        return nurseRepository.findById(nur).get();
    }

    @Override
    public Page<Nurse> pagenateStudent(int pageNo, int pageSize) {
        Pageable pageable= PageRequest.of(pageNo -1,pageSize);
        return this.nurseRepository.findAll(pageable);
    }


}