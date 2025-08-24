package com.hakangul.entities;
import java.util.Date;
import java.util.List;

import org.hibernate.annotations.ManyToAny;
import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;



@Entity
@Table(name = "students")
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "first_name", nullable = false)
    private String firstName;
    @Column(name = "last_name", nullable = false)
    private String lastName;
    
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Column(name = "birth_of_date", nullable = true)
    private Date birthOfDate;

    @ManyToAny
    @JoinTable(
        name= "student_course", 
        joinColumns= @JoinColumn(name = "student_id"), //joinColumns ile ilişkili tabloda student_id adında bir sütun oluşturur
        inverseJoinColumns= @JoinColumn(name="course_id")) // inverseJoinColumns ile ilişkili tabloda course_id adında bir sütun oluşturur
    private  List<Course> courses;

}
