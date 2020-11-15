package pl.mr.javagdy4.spring.students_demo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.mr.javagdy4.spring.students_demo.model.Grade;
import pl.mr.javagdy4.spring.students_demo.model.Student;
import pl.mr.javagdy4.spring.students_demo.repository.GradeRepository;
import pl.mr.javagdy4.spring.students_demo.repository.StudentRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GradeService {
    private final GradeRepository gradeRepository;
    private final StudentRepository studentRepository;
    public Optional<Student> findById(Long studentId) {
        return studentRepository.findById(studentId);
    }
    public Optional<Grade> findGradeById(Long gradeId) {
        return gradeRepository.findById(gradeId);
    }
    public void save(Grade grade) {
        gradeRepository.save(grade);
    }
    public void deleteById(Long id){
        gradeRepository.deleteById(id);
    }
}