package pl.mr.javagdy4.spring.students_demo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.mr.javagdy4.spring.students_demo.model.Student;
import pl.mr.javagdy4.spring.students_demo.service.StudentService;

import java.util.Optional;

@Controller
@RequestMapping(path = "/student")
public class StudentController {
    // kontroler  zakaz bezpośredniego odwoływania się do bazy danych.

    // mamy 2 typy Studentów : defaultStudent albo defultMaxStudent. Możemy albo wpisać ich po nazwie
    // jak chcemy wpisać jednego, albo możmey użyć jakeijkolwiek nazwy "z dupy" jeżeli w Pliku konfiguracyjnym
    // byby tylko jeden Student (on automatycznie,jako że jest to bean i znalazłby jednego predefionowanego Studenta
    // wpisłby go z automatu, nie potrzebując dokładnej nazwy)
    private final StudentService studentService;
    private final Student defaultMaxStudent;
    @Autowired // @RequiredArgsConstructor

    public StudentController(StudentService studentService, Student defaultMaxStudent) {
        this.studentService = studentService;
        this.defaultMaxStudent = defaultMaxStudent;
    }

    // http://localhost:8080/student
    @GetMapping("")
    public String getStudents(Model model){
        model.addAttribute("listOfStudents", studentService.findAll());
        return "student_list";
    }




    // ############ FORMULARZ
    //    public String getForm(Model model, Student student){ // ponieważ Student jest POJO, to stworzy to nową instancję i ją wstrzyknie
//        model.addAttribute("addedStudent", student);
    @GetMapping("/form")
    public String getForm(Model model) { // ponieważ Student jest POJO, to stworzy to nową instancję i ją wstrzyknie
        model.addAttribute("addedStudent", defaultMaxStudent);
//    @GetMapping("/form")
//    public String getForm(Model model) { // ponieważ Student jest POJO, to stworzy to nową instancję i ją wstrzyknie
//        model.addAttribute("addedStudent", new Student());
        return "student_form";
    }




    @PostMapping("")
    public String submitStudent(Student student) {
        studentService.save(student);
        return "redirect:/student"; // przekierowanie
    }
    // #######################################################################################
    // DO UZUPEŁNIENIA JUTRO / DLA CHĘNTYCH W DOMU (metoda delete i get by id - details)
    // http://localhost:8080/student/5


    @GetMapping("/{id}")
    public String getStudent(Model model, @PathVariable(name = "id") Long id) {
        Optional<Student> studentOptional = studentService.find(id);
        if (studentOptional.isPresent()) {
            model.addAttribute("studentWithDetailedInfo", studentOptional.get());
            return "student_details";
        }
        return "redirect:/student";
    }


    // ############ USUWANIE
    @GetMapping("/delete/{id}")
    public String removeStudent(@PathVariable(name = "id") Long id) {
        studentService.delete(id);
        return "redirect:/student";
    }


    // ############ EDYCJA
    @GetMapping("/edit/{id}")
    public String editStudent(Model model, @PathVariable(name = "id") Long id) {
        Optional<Student> studentOptional = studentService.find(id);
        if (studentOptional.isPresent()) {
            model.addAttribute("addedStudent", studentOptional.get());
            return "student_form";
        }
        return "redirect:/student";
    }


}