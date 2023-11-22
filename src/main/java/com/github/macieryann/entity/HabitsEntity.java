package com.github.macieryann.entity;

import jakarta.persistence.*;

import java.time.Instant;
import java.time.LocalDate;
import java.time.YearMonth;

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
    @Column
    private Instant datetimeModified;
    @Column
    private int habitMonth;
    @Column
    private int habitYear;

    public HabitsEntity() {

    }

    public HabitsEntity(Long habitId, String name, String description, Instant datetimeModified,
                        int habitMonth, int habitYear) {
        this.habitId = habitId;
        this.name = name;
        this.description = description;
        this.datetimeModified = datetimeModified;
        this.habitMonth = habitMonth;
        this.habitYear = habitYear;
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

    public Instant getDatetimeModified() {
        return datetimeModified;
    }

    public void setDatetimeModified(Instant datetimeModified) {
        this.datetimeModified = datetimeModified;
    }

    public int getHabitMonth() {
        return habitMonth;
    }

    public void setHabitMonth(int habitMonth) {
        this.habitMonth = habitMonth;
    }

    public int getHabitYear() {
        return habitYear;
    }

    public void setHabitYear(int habitYear) {
        this.habitYear = habitYear;
    }

}