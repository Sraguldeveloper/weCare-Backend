package com.techzoner.weCare.repository;

import com.techzoner.weCare.utilites.Coach;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoachRepository extends JpaRepository<Coach,String> {
}
