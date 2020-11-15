package pl.mr.javagdy4.spring.students_demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.mr.javagdy4.spring.students_demo.model.Grade;

@Repository
public interface GradeRepository extends JpaRepository<Grade, Long> {

}
