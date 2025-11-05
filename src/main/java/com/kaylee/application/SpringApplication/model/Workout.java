package SpringApplication.src.main.java.com.kaylee.application.SpringApplication.model;

public class Workout {
    private Long id;
    private String name;
    private int duration; // in minutes
    private String date;

    public Workout() {
    }

    public Workout(Long id, String name, int duration, String date) {
        this.id = id;
        this.name = name;
        this.duration = duration;
        this.date = date;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

}
