package com.korit.senicare.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.korit.senicare.entity.NurseEntity;
import java.util.List;


@Repository
public interface NurseRepository extends JpaRepository<NurseEntity, String> {

    boolean existsByUserId(String userId);
    boolean existsByTelNumber(String telNumber);

    NurseEntity findByUserId(String userId);

}
