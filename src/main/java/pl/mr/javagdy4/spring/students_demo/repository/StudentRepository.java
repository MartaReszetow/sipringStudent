package pl.mr.javagdy4.spring.students_demo.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.mr.javagdy4.spring.students_demo.model.Student;

import java.util.List;
@Repository
public interface StudentRepository
        extends JpaRepository<Student, Long> {
    List<Student> findAllByLastNameContaining(String phrase);
 //    List<Student> findAllByLastNamEContainingAndAgeBetweenAndGradesAverageBetween(String lastNamePhrase, Integer ageFrom, Integer ageTo, Double averageFrom, Double averageTo);
//    Jedna zmiana literki (powyżej) powoduje że projekt się nie buduje. Jeśli masz wątpliwość, to wykomentuj metody z repository

    List<Student> findAllByLastNameContainingAndAgeBetweenAndGradesAverageBetween(String lastNamePhrase, Integer ageFrom, Integer ageTo, Double averageFrom, Double averageTo);
//    @Query(nativeQuery = true, value = "SELECT * FROM .. ...")
}