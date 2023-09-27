package com.github.macieryann.dao;

import com.github.macieryann.entity.HabitEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HabitDao extends JpaRepository<HabitEntity, Long> {
    // Define custom query methods as needed
}
