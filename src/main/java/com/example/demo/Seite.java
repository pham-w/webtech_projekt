package com.example.demo;

import java.time.LocalDate;

public class Seite {
        private String name;
        private int age;
        private LocalDate geburtsdatum;
        private String favColor;
        private String hobby;
        private String favFood;
        private String dreamJob;

        public Seite(String name, int age, LocalDate geburtsdatum, String favColor, String hobby, String favFood, String dreamJob) {
            this.name = name;
            this.age = age;
            this.geburtsdatum = geburtsdatum;
            this.favColor = favColor;
            this.hobby = hobby;
            this.favFood = favFood;
            this.dreamJob = dreamJob;
        }

        // Getter und Setter
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public LocalDate getGeburtsdatum() {
            return geburtsdatum;
        }
        public void setGeburtsdatum(LocalDate geburtsdatum) {
            this.geburtsdatum = geburtsdatum;
        }
        public String getFavColor() {
            return favColor;
        }

        public void setFavColor(String favColor) {
            this.favColor = favColor;
        }

        public String getHobby() {
            return hobby;
        }

        public void setHobby(String hobby) {
            this.hobby = hobby;
        }

        public String getFavFood() {
            return favFood;
        }

        public void setFavFood(String favFood) {
            this.favFood = favFood;
        }

        public String getDreamJob() {
            return dreamJob;
        }

        public void setDreamJob(String dreamJob) {
            this.dreamJob = dreamJob;
        }

    public String getProfile() {
        return "Name: " + name + "\n" +
                "Alter: " + age + "\n" +
                "Lieblingsfarbe: " + favColor + "\n" +
                "Hobby: " + hobby + "\n" +
                "Lieblingsessen: " + favFood + "\n" +
                "Traumberuf: " + dreamJob;
}

}
