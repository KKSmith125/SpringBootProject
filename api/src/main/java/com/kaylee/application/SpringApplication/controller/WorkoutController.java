package com.kaylee.application.SpringApplication.controller;

import com.kaylee.application.SpringApplication.model.Workout;
import com.kaylee.application.SpringApplication.repository.WorkoutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/workouts")
public class WorkoutController {
    @Autowired
    private WorkoutRepository workoutRepository;

    @GetMapping
    public List<Workout> getAllWorkouts() {
        return workoutRepository.findAll();
    }

    @GetMapping("/{id}")
    public Workout getWorkoutById(@PathVariable Long id) {
        return workoutRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Workout addWorkout(@RequestBody Workout workout) {
        return workoutRepository.save(workout);
    }

    @PutMapping("/{id}")
    public Workout updateWorkout(@PathVariable Long id, @RequestBody Workout workoutDetails) {
        Optional<Workout> optionalWorkout = workoutRepository.findById(id);
        if (optionalWorkout.isPresent()) {
            Workout workout = optionalWorkout.get();
            workout.setName(workoutDetails.getName());
            workout.setDuration(workoutDetails.getDuration());
            workout.setDate(workoutDetails.getDate());
            return workoutRepository.save(workout);
        } else {
            return null;
        }
    }

    @DeleteMapping("/{id}")
    public void deleteWorkout(@PathVariable Long id) {
        workoutRepository.deleteById(id);
    }
}