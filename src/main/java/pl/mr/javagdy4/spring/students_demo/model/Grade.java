package pl.mr.javagdy4.spring.students_demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import javax.persistence.*;
import java.time.LocalDateTime;
@Entity()
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Grade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double value;
    @Enumerated(EnumType.STRING)
    private GradeSubject subject;
    @CreationTimestamp
    private LocalDateTime timeCreated;
    @ManyToOne()
    @EqualsAndHashCode.Exclude
    private Student student;
}