package SpringApplication.src.main.java.com.kaylee.application.SpringApplication.service;

import SpringApplication.src.main.java.com.kaylee.application.SpringApplication.model.Workout;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WorkoutService {
    private List<Workout> workouts = new ArrayList<>();

    public List<Workout> getAllWorkouts() {
        return workouts;
    }

    public Workout addWorkout(Workout workout) {
        workouts.add(workout);
        return workout;
    }
}