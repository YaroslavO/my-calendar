package com.yaroslav.entitys;

import javax.persistence.*;

/**
 * Created by employee on 5/27/15.
 */
@Entity
@Table (name = "exam")
public class Exam {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_exam")
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "rating")
    private double rating;

    @ManyToOne(fetch = FetchType.LAZY)
    private Student student;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
}

