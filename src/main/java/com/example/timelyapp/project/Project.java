package com.example.timelyapp.project;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String start;
    private String stop;
    private String duration;

    public Project() {
    }

    public Project(int id, String name, String start, String stop, String duration) {
        this.id = id;
        this.name = name;
        this.start = start;
        this.stop = stop;
        this.duration = duration;
    }

    public Project(String name, String start, String stop, String duration) {
        this.name = name;
        this.start = start;
        this.stop = stop;
        this.duration = duration;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getStop() {
        return stop;
    }

    public void setStop(String stop) {
        this.stop = stop;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", start='" + start + '\'' +
                ", stop='" + stop + '\'' +
                ", duration='" + duration + '\'' +
                '}';
    }
}
