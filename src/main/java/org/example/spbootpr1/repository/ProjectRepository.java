 package org.example.spbootpr1.repository;

import org.example.spbootpr1.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

 public interface ProjectRepository extends JpaRepository<Project, Integer> {


     Optional<Project> findByNameIgnoreCaseAndCode(String name, String code);
 }