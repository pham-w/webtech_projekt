package com.example.demo;

import java.time.LocalDate;

public class Seite {
        private String name;
        private int age;
        private LocalDate geburtsdatum;
        private String favoriteColor;
        private String hobby;
        private String favoriteFood;
        private String dreamJob;

        public Seite(String name, int age, LocalDate geburtsdatum, String favoriteColor, String hobby, String favoriteFood, String dreamJob) {
            this.name = name;
            this.age = age;
            this.geburtsdatum = geburtsdatum;
            this.favoriteColor = favoriteColor;
            this.hobby = hobby;
            this.favoriteFood = favoriteFood;
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
        public String getFavoriteColor() {
            return favoriteColor;
        }

        public void setFavoriteColor(String favoriteColor) {
            this.favoriteColor = favoriteColor;
        }

        public String getHobby() {
            return hobby;
        }

        public void setHobby(String hobby) {
            this.hobby = hobby;
        }

        public String getFavoriteFood() {
            return favoriteFood;
        }

        public void setFavoriteFood(String favoriteFood) {
            this.favoriteFood = favoriteFood;
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
                "Lieblingsfarbe: " + favoriteColor + "\n" +
                "Hobby: " + hobby + "\n" +
                "Lieblingsessen: " + favoriteFood + "\n" +
                "Traumberuf: " + dreamJob;
}

}
