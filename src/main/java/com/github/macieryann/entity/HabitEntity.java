package com.github.macieryann.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "habits")
public class HabitEntity {
    //CREATE TABLE habits (
    //    habit_id SERIAL PRIMARY KEY,
    //    user_id INT REFERENCES users(user_id),
    //    name VARCHAR(255) NOT NULL
    //);
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long habitId;
    @Column(nullable = false)
    private String name;
//    @ManyToOne
//    @JoinColumn(name = "user_id")
//    private UserEntity user;

    public HabitEntity() {

    }

    public HabitEntity(Long habitId, String name) {
        this.habitId = habitId;
        this.name = name;
    }

    public Long getHabitId() {
        return habitId;
    }

    public void setHabitId(Long habitId) {
        this.habitId = habitId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}