package com.demo.demo.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.Date;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@OnDelete(action = OnDeleteAction.CASCADE)
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name="students", uniqueConstraints = {@UniqueConstraint(columnNames = {"email"})})
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name="name", length = 100)
    private String name;

    @Column(name="email", unique= true, length = 100)
    private String email;

    @Column(name="year")
    private Date year;

    @Column(name="school", length = 100)
    private String school;

    @Column(name="age")
    private int age;

    @OneToOne
    @JoinColumn(name="user_id", nullable = false)
    private User user;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at")
    private Date createdAt = new Date();

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_at")
    private Date updatedAt;

    public Student(String name, String email, Date year, String school, int age, User user) {
        this.name = name;
        this.email = email;
        this.year = year;
        this.school = school;
        this.age = age;
        this.user = user;
    }

}
