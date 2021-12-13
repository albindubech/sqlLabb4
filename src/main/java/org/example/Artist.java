package org.example;

import javax.persistence.*;

@Entity
class Artist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String firstName;
    private String lastName;
    private Gender gender;
    private String genre;
    private int age;

    Gender getGender() {
        return gender;
    }

    void setGender(Gender gender) {
        this.gender = gender;
    }

    Artist(String firstName, String lastName, Gender gender, String genre, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.genre = genre;
        this.age = age;
    }

    public Artist() {

    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    int getId() {
        return id;
    }

    void setId(int id) {
        this.id = id;
    }

    String getFirstName() {
        return firstName;
    }

    void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    String getLastName() {
        return lastName;
    }

    void setLastName(String lastName) {
        this.lastName = lastName;
    }

    String getGenre() {
        return genre;
    }

    void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Artist{" +
               "id = " + id +
               ", firstName = '" + firstName + '\'' +
               ", lastName = '" + lastName + '\'' +
               ", gender = " + gender +
               ", genre = '" + genre + '\'' +
               ", age = " + age +
               '}';
    }
}