package com.gohenry.springbootdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gohenry.springbootdemo.entity.Parent;

@Repository
public interface ChildRepository  extends JpaRepository<Parent, Long>{

}
