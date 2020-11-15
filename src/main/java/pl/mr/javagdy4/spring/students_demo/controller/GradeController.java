package pl.mr.javagdy4.spring.students_demo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.mr.javagdy4.spring.students_demo.model.Grade;
import pl.mr.javagdy4.spring.students_demo.model.GradeSubject;
import pl.mr.javagdy4.spring.students_demo.model.Student;
import pl.mr.javagdy4.spring.students_demo.service.GradeService;


import java.util.Optional;

@Controller
@RequestMapping("/grade")
@RequiredArgsConstructor
public class GradeController {
    private final GradeService gradeService;
    //############## FORM ##############\\

    @GetMapping("/form")
    public String getGradeForm(Model model, @RequestParam("studentId") Long studentId){
        model.addAttribute("addedGrade", new Grade());
        model.addAttribute("allSubjects", GradeSubject.values());
        model.addAttribute("studentId", studentId);
        return "grade_form";
    }

    @PostMapping("")
    public String submitFormData(Grade grade, @RequestParam("studentIdParam") Long studentId){
        Optional<Student> studentOptional = gradeService.findById(studentId);
        if(studentOptional.isPresent()) {
            Student student = studentOptional.get();
            grade.setStudent(student);
            gradeService.save(grade);
        }
        return "redirect:/student/" + studentId;
    }


    //############## DELETE ##############\\
    //############## GET ##############\\
    //############## LIST = STUDENT DETAILS = DONE ##############\\
}