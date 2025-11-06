package com.kaylee.application.SpringApplication.repository;

import com.kaylee.application.SpringApplication.model.Workout;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkoutRepository extends JpaRepository<Workout, Long> {
}