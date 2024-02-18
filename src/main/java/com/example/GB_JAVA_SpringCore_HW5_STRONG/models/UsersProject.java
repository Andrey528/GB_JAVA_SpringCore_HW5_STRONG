package com.example.GB_JAVA_SpringCore_HW5_STRONG.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "usersProjects")
public class UsersProject extends EntityWithRelation {
    private Long projectId;
    private Long userId;
}
