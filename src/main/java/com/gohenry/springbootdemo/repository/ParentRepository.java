package com.gohenry.springbootdemo.repository;

import org.springframework.stereotype.Repository;

import com.gohenry.springbootdemo.entity.Parent;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ParentRepository extends JpaRepository<Parent, Long>{

}
