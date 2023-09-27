package com.github.macieryann.dao;

import com.github.macieryann.entity.HabitProgressEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HabitProgressDao extends JpaRepository<HabitProgressEntity, Long> {
    // Define custom query methods as needed
}
