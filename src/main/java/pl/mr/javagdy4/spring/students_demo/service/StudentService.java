package pl.mr.javagdy4.spring.students_demo.service;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.mr.javagdy4.spring.students_demo.model.Student;
import pl.mr.javagdy4.spring.students_demo.repository.StudentRepository;

import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;
    public List<Student> findAll() {
        return studentRepository.findAll();
    }
    public Optional<Student> find(Long id) {
        return studentRepository.findById(id);
    }
    public void save(Student student) {
        studentRepository.save(student);
    }
    public void delete(Long id){
        studentRepository.deleteById(id);
    }
}