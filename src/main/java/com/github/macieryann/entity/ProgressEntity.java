package com.github.macieryann.entity;

import jakarta.persistence.*;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "habit_progress")
public class ProgressEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "progress_id")
    private Long progressId;

    @ManyToOne
    @JoinColumn(name = "habit_id")
    private HabitsEntity habit;

    @Column(name = "datetime_modified")
    private Instant datetimeModified;

    @Column(name = "completed")
    private Boolean completed;

    @Column(name = "habit_date")
    @Temporal(TemporalType.DATE)
    private LocalDate habitDate;

    public ProgressEntity() {

    }

    public ProgressEntity(Long progressId, HabitsEntity habit, Instant datetimeModified, Boolean completed, LocalDate habitDate) {
        this.progressId = progressId;
        this.habit = habit;
        this.datetimeModified = datetimeModified;
        this.completed = completed;
        this.habitDate = habitDate;
    }

    public Long getProgressId() {
        return progressId;
    }

    public void setProgressId(Long progressId) {
        this.progressId = progressId;
    }

    public HabitsEntity getHabit() {
        return habit;
    }

    public void setHabit(HabitsEntity habit) {
        this.habit = habit;
    }

    public Instant getDatetimeModified() {
        return datetimeModified;
    }

    public void setDatetimeModified(Instant datetimeModified) {
        this.datetimeModified = datetimeModified;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    public LocalDate getHabitDate() {
        return habitDate;
    }

    public void setHabitDate(LocalDate habitDate) {
        this.habitDate = habitDate;
    }

}
