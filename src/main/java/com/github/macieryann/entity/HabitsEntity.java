package com.github.macieryann.entity;

import jakarta.persistence.*;

import java.time.Instant;
import java.sql.Date;

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
    private Date habitStartDate;
    @Column
    private Date habitEndDate;

    public HabitsEntity() {

    }

    public HabitsEntity(Long habitId, String name, String description, Instant datetimeModified, Date habitStartDate, Date habitEndDate) {
        this.habitId = habitId;
        this.name = name;
        this.description = description;
        this.datetimeModified = datetimeModified;
        this.habitStartDate = habitStartDate;
        this.habitEndDate = habitEndDate;
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

    public Date getHabitStartDate() {
        return habitStartDate;
    }

    public void setHabitStartDate(Date habitStartDate) {
        this.habitStartDate = habitStartDate;
    }

    public Date getHabitEndDate() {
        return habitEndDate;
    }

    public void setHabitEndDate(Date habitEndDate) {
        this.habitEndDate = habitEndDate;
    }
}