package com.example.GB_JAVA_SpringCore_HW5_STRONG.repository;

import com.example.GB_JAVA_SpringCore_HW5_STRONG.models.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
}
