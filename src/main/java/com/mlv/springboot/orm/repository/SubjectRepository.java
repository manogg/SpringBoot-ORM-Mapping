package com.mlv.springboot.orm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mlv.springboot.orm.entity.Subjects;

@Repository
public interface SubjectRepository extends JpaRepository<Subjects, Integer>{

	List<Subjects> findByFeesLessThan(double fees);

}
