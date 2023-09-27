package com.github.macieryann.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "habit_progress")
public class HabitProgressEntity {
    //CREATE TABLE habit_progress (
    //    progress_id SERIAL PRIMARY KEY,
    //    habit_id INT REFERENCES habits(habit_id),
    //    datetime_modified TIMESTAMP NOT NULL,
    //    completion_status DECIMAL
    //);
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "progress_id")
    private Long progressId;
    @ManyToOne
    @JoinColumn(name = "habit_id")
    private HabitEntity habit;
    @Column(name = "datetime_modified")
    private Date datetimeModified;
    @Column(name = "completion_status")
    private Double completionStatus;

    public HabitProgressEntity(Long progressId, HabitEntity habit, Date datetimeModified, Double completionStatus) {
        this.progressId = progressId;
        this.habit = habit;
        this.datetimeModified = datetimeModified;
        this.completionStatus = completionStatus;
    }

    public Long getProgressId() {
        return progressId;
    }

    public void setProgressId(Long progressId) {
        this.progressId = progressId;
    }

    public HabitEntity getHabit() {
        return habit;
    }

    public void setHabit(HabitEntity habit) {
        this.habit = habit;
    }

    public Date getDatetimeModified() {
        return datetimeModified;
    }

    public void setDatetimeModified(Date datetimeModified) {
        this.datetimeModified = datetimeModified;
    }

    public Double getCompletionStatus() {
        return completionStatus;
    }

    public void setCompletionStatus(Double completionStatus) {
        this.completionStatus = completionStatus;
    }

}
