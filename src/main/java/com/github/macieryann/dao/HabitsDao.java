package com.github.macieryann.dao;

import com.github.macieryann.entity.HabitsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface HabitsDao extends JpaRepository<HabitsEntity, Long> {
    @Query("SELECT MAX(h.habitId) FROM HabitsEntity h")
    Long findMaxHabitId();
}
