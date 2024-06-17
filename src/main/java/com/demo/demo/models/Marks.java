package com.demo.demo.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@OnDelete(action = OnDeleteAction.CASCADE)
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name="marks")
public class Marks {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name="subject", length = 100)
    private String subject;

    @Column(name="marks")
    private int marks;

    @OneToOne
    @JoinColumn(name="student_id", nullable = false)
    private Student student;
}
