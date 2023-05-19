package com.e_nursing_portal.repository;

import com.e_nursing_portal.model.Nurse;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface NurseRepository extends JpaRepository<Nurse,String> {
}
