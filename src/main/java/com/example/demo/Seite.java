package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class Seite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int age;
    private LocalDate geburtsdatum;
    private String favColor;
    private String hobby;
    private String favFood;
    private String dreamJob;

    public Seite(String name, int age, LocalDate geburtsdatum,
                 String favColor, String hobby, String favFood, String dreamJob) {
        this.name = name;
        this.age = age;
        this.geburtsdatum = geburtsdatum;
        this.favColor = favColor;
        this.hobby = hobby;
        this.favFood = favFood;
        this.dreamJob = dreamJob;
    }

    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public LocalDate getGeburtsdatum() { return geburtsdatum; }
    public void setGeburtsdatum(LocalDate geburtsdatum) { this.geburtsdatum = geburtsdatum; }

    public String getFavColor() { return favColor; }
    public void setFavColor(String favColor) { this.favColor = favColor; }

    public String getHobby() { return hobby; }
    public void setHobby(String hobby) { this.hobby = hobby; }

    public String getFavFood() { return favFood; }
    public void setFavFood(String favFood) { this.favFood = favFood; }

    public String getDreamJob() { return dreamJob; }
    public void setDreamJob(String dreamJob) { this.dreamJob = dreamJob; }
}
