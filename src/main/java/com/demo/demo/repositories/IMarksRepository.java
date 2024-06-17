package com.demo.demo.repositories;

import com.demo.demo.models.Marks;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface IMarksRepository extends JpaRepository<Marks, UUID> {
}
