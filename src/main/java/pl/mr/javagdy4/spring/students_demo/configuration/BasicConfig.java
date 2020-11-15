package pl.mr.javagdy4.spring.students_demo.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.mr.javagdy4.spring.students_demo.model.Student;

import java.time.LocalDate;
import java.util.HashSet;

@Configuration
public class BasicConfig {
    @Value("${form.student.default.birthdate.year}")
    private Integer birthDateYear;
    @Value("${form.student.default.birthdate.month}")
    private Integer birthDateMonth;
    @Value("${form.student.default.birthdate.day}")
    private Integer birthDateDay;
    @Value("${form.student.default.firstName}")
    private String defaultFirstName;
    @Value("${form.student.default.lastName}")
    private String defaultLastName;
    @Value("${form.student.default.graduated}")
    private Boolean defaultGraduated;
    @Value("${form.student.default.homedist}")
    private Double defaultHomeDist;
    @Bean(name = "defaultStudent")
    public Student getDefaultFormValues(){
        return new Student(
                null,
                defaultFirstName,
                defaultLastName,
                defaultGraduated,
                defaultHomeDist,
                LocalDate.of(birthDateYear, birthDateMonth, birthDateDay),
                null,
                null,
                new HashSet<>()
        );
    }
    @Bean(name = "defaultMaxStudent")
    public Student getMaxFormValues(){
        return new Student(
                null,
                "Turbo Max",
                "Mega Hiper",
                defaultGraduated,
                0.01,
                LocalDate.of(1, 1, 1),
                null,
                null,
                new HashSet<>()
        );
    }
}
