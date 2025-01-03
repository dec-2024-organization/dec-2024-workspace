package com.demo.spring_rest_jpa_demo3.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.spring_rest_jpa_demo3.dao.entity.AuthorEntity;

@Repository
public interface AuthorRepository extends JpaRepository<AuthorEntity, Integer>{

}
