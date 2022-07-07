package com.ncs.empconsole.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ncs.empconsole.model.Project;

public interface ProjectRepository extends JpaRepository<Project, Integer>, CustomProjectRepository{

}
