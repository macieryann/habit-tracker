package com.github.macieryann.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "habits")
public class HabitsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long habitId;
    @Column(nullable = false)
    private String name;
    @Column
    private String description;

    public HabitsEntity() {

    }

    public HabitsEntity(Long habitId, String name, String description) {
        this.habitId = habitId;
        this.name = name;
        this.description = description;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}