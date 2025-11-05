package SpringApplication.src.main.java.com.kaylee.application.SpringApplication.controller;

import SpringApplication.src.main.java.com.kaylee.application.SpringApplication.model.Workout;
import SpringApplication.src.main.java.com.kaylee.application.SpringApplication.service.WorkoutService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/workouts")
public class WorkoutController {
    private final WorkoutService workoutService;

    public WorkoutController(WorkoutService workoutService) {
        this.workoutService = workoutService;
    }

    @GetMapping
    public List<Workout> getAllWorkouts() {
        return workoutService.getAllWorkouts();
    }

    @PostMapping
    public Workout addWorkout(@RequestBody Workout workout) {
        return workoutService.addWorkout(workout);
    }
}
