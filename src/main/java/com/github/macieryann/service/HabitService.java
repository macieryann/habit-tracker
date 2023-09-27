package com.github.macieryann.service;

import com.github.macieryann.dao.HabitDao;
import com.github.macieryann.entity.HabitEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HabitService {
    private final HabitDao habitDao;

    @Autowired
    public HabitService(HabitDao habitDao) {
        this.habitDao = habitDao;
    }

    public HabitEntity saveHabit(HabitEntity habit) {
        return habitDao.save(habit);
    }

    // ... other service methods ...
}
