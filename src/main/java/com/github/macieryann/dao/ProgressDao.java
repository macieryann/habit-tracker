package com.github.macieryann.dao;

import com.github.macieryann.entity.ProgressEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProgressDao extends JpaRepository<ProgressEntity, Long> {
    @Query("SELECT MAX(p.progressId) FROM ProgressEntity p")
    Long findMaxProgressId();

    @Query("SELECT p FROM ProgressEntity p WHERE p.habit.habitId = :habitId")
    List<ProgressEntity> retrieveProgressByHabitId(@Param("habitId") Long habitId);
}
