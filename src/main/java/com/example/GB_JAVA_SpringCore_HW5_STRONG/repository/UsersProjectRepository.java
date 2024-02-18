package com.example.GB_JAVA_SpringCore_HW5_STRONG.repository;

import com.example.GB_JAVA_SpringCore_HW5_STRONG.models.UsersProject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsersProjectRepository extends JpaRepository<UsersProject, Long> {
    void deleteByUserIdAndProjectId(Long userId, Long projectId);
    List<UsersProject> findByProjectId(Long projectId);
    List<UsersProject> findByUserId(Long userId);
}
